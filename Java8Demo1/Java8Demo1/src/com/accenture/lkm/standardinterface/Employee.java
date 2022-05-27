package com.accenture.lkm.standardinterface;

public class Employee {
	public void printDetails(int empId,String empName) {
		System.out.println(empId+empName);
	}
	public void printCity(String city) {
		System.out.println(city);
	}
	public Integer returnSomething() {
		return 10;
	}
	public Double calcAnnSalary(Double sal) {
		return sal*12;
	}
}
