package com.accenture.lkm.bussiness.bean;



import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import com.accenture.lkm.validation.EmployeeValidatorVal;

public class Employee {
	@EmployeeValidatorVal(message="{Employee.EmployeeValidatorValMessage}")
	@NotEmpty(message="{NotEmpty.employee.name}") //cannot use not null for String as it returns "" from the page
	private String employeeName;
	
	
	private Integer employeeId;
	
	@Range(min=10,max=100000,message="{Range.employee.salary}")
	private double salary;
	
	@NotNull(message="{NotEmpty.employee.dept}")
	private Integer departmentCode;

	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String employeeName, Integer employeeId, double salary,
			Integer departmentCode) {
		super();
		this.employeeName = employeeName;
		this.employeeId = employeeId;
		this.salary = salary;
		this.departmentCode = departmentCode;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Integer getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(Integer departmentCode) {
		this.departmentCode = departmentCode;
	}

	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", employeeId="
				+ employeeId + ", salary=" + salary + ", departmentCode="
				+ departmentCode + "]";
	}
	
	
}
