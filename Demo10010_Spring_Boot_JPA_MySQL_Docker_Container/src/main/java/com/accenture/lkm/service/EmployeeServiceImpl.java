package com.accenture.lkm.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.Employee;
import com.accenture.lkm.dao.EmployeeDAO;
import com.accenture.lkm.entity.EmployeeEntity;
@Service
public class EmployeeServiceImpl {

	@Autowired
	private EmployeeDAO employeeDAO;

	public int addEmployee(Employee employee) {

		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employee, employeeEntity);
		//Implementation of the DAO method will be provided  by the run time proxy
		EmployeeEntity emp= (EmployeeEntity)employeeDAO.save(employeeEntity);
		return emp.getEmployeeId();
	}

	public Collection<Employee> getEmployeeDetails(){
		//Implementation of the DAO method will be provided  by the run time proxy
		Collection<EmployeeEntity> collec =employeeDAO.findAll();
		List<Employee> listEmployee = new ArrayList<Employee> ();
		for (EmployeeEntity employeeEntity : collec) {
			Employee employee=new Employee();
			BeanUtils.copyProperties(employeeEntity, employee);
			listEmployee.add(employee);
		}
		return listEmployee;
	}
	
	public Employee getEmployeeDetailByEmployeeId(int employeeId){
		Employee employee =null;
		//Implementation of the DAO method will be provided  by the run time proxy
		EmployeeEntity employeeEntity= employeeDAO.getOne(employeeId);
		if(employeeEntity!=null){
			employee= new Employee();
			BeanUtils.copyProperties(employeeEntity, employee);
		}
		return employee;
	}
	public Employee deleteEmployee(int employeeId){
		Employee employee =null;
		//Implementation of the DAO method will be provided  by the run time proxy
		EmployeeEntity employeeEntity= employeeDAO.getOne(employeeId);
		if(employeeEntity!=null){
			//Implementation of the DAO method will be provided  by the run time proxy
			employeeDAO.delete(employeeEntity);
			employee= new Employee();
			BeanUtils.copyProperties(employeeEntity, employee);
		}
		return employee;
	}
	
	public Employee updateEmployee(Employee employee){
		Employee employee2 =null;
		//Implementation of the DAO method will be provided  by the run time proxy
		EmployeeEntity employeeEntity= employeeDAO.getOne(employee.getEmployeeId());
		if(employeeEntity!=null){
			//update operation
			BeanUtils.copyProperties(employee, employeeEntity);
			//Implementation of the DAO method will be provided  by the run time proxy
			employeeDAO.save(employeeEntity);
			//copying the properties back to EmployeeDTO Object 
			employee2= new Employee();
			BeanUtils.copyProperties(employeeEntity, employee2);
		}
		return employee2;
	}	
}
