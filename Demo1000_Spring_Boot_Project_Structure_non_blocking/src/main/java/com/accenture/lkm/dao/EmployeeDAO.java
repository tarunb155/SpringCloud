package com.accenture.lkm.dao;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.accenture.lkm.bussiness.bean.Employee;

@Repository
public class EmployeeDAO {
	
	static public Map<Integer, Employee> mapOfEmloyees = new LinkedHashMap<Integer, Employee>();
	static int count=10004;
	static
	{
		mapOfEmloyees.put(10001, new Employee("Jack",10001,12345.6,1001));
		mapOfEmloyees.put(10002, new Employee("Justin",10002,12355.6,1002));
		mapOfEmloyees.put(10003, new Employee("Eric",10003,12445.6,1003));
	}

	@Async("threadPoolTaskExecutorMSD")
	public CompletableFuture<Collection<Employee>> getAllEmployee(){
		System.out.println("DAO Thread name 1: "+Thread.currentThread());
		Collection<Employee> list =mapOfEmloyees.values();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("DAO Thread name2: "+Thread.currentThread());
		return CompletableFuture.supplyAsync(()->list);			
	}
	
	public Employee getEmployeeDetailsById(int id){
		return mapOfEmloyees.get(id);
	}
	
	public Integer addEmployee(Employee employee){
		count++;
		employee.setEmployeeId(count);
		mapOfEmloyees.put(count, employee);
		return count;
	}
	
	public Employee updateEmployee (Employee employee){
		mapOfEmloyees.put(employee.getEmployeeId(), employee);
		return employee;
	}
	
	public Employee removeEmployee (int id){
		Employee emp= mapOfEmloyees.remove(id);
		return emp;
	}
	
}