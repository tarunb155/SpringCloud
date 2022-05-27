package com.accenture.lkm.web.controller;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.lkm.bussiness.bean.Employee;
import com.accenture.lkm.dao.EmployeeDAO;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeDAO employeeDAO;
	
	@Async("threadPoolTaskExecutorMSD")
	@RequestMapping(value = "emp/controller/getDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CompletableFuture<ResponseEntity<List<Employee>>> getEmployeeDetails() {
		
		CompletableFuture<ResponseEntity<List<Employee>>> res=null;
		System.out.println("Controller Thread name1: "+Thread.currentThread());
		
		CompletableFuture<Collection<Employee>> interRespListEmployee=employeeDAO.getAllEmployee();
		
		res=
		interRespListEmployee.thenApplyAsync(redeemedList->
			{	System.out.println("Controller Redeemed Thread: "+Thread.currentThread());
				return new ResponseEntity(redeemedList,HttpStatus.OK);
			});
	
		System.out.println("Controller Thread name3: "+Thread.currentThread());	
		return res;
	}

	@RequestMapping(value = "emp/controller/getDetailsById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployeeDetailByEmployeeId(@PathVariable("id") int myId) {
		Employee employee = employeeDAO.getEmployeeDetailsById(myId);

		if (employee != null) {
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} else {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/emp/controller/addEmp", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
		int count=employeeDAO.addEmployee(employee);
		return new ResponseEntity<String>("Employee added successfully with id:" + count,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/emp/controller/updateEmp", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> updateEmployee(@RequestBody  Employee employee) {
		System.out.println(">>>"+employee);
		if (employeeDAO.getEmployeeDetailsById(employee.getEmployeeId()) == null) {
			Employee employee2 = null;
			return new ResponseEntity<Employee>(employee2,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Employee updated = employeeDAO.updateEmployee(employee);
		return new ResponseEntity<Employee>(updated, HttpStatus.OK);
	}

	@RequestMapping(value = "/emp/controller/deleteEmp/{id}", method = RequestMethod.DELETE,
	produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") int myId) {
		if (employeeDAO.getEmployeeDetailsById(myId) == null) {
			Employee employee2 = null;
			return new ResponseEntity<Employee>(employee2,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Employee employee = employeeDAO.removeEmployee(myId);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
}