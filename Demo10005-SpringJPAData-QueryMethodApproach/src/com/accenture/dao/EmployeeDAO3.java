package com.accenture.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.accenture.entity.EmployeeEntityBean;



public interface EmployeeDAO3 extends CrudRepository<EmployeeEntityBean, Integer>{
	
	// select k from EmployeeEntityBean k where k.salary >= ?1
	List<EmployeeEntityBean> findBySalaryGreaterThanEqual(double salary);
	
	// select k from EmployeeEntityBean k where k.salary >= ?1 order by k.id desc
	List<EmployeeEntityBean> findBySalaryGreaterThanEqualOrderByIdDesc(double salary);
	
	// select k from EmployeeEntityBean k where k.name like %?1% order by k.salary desc
	List<EmployeeEntityBean> findByNameContainingOrderBySalaryDesc (String pattern);
	
	
	List<EmployeeEntityBean> findBySalaryGreaterThanEqualAndRole(Double param1, String param2);
	
	List<EmployeeEntityBean> findBySalaryBetween(Double param1, Double param2);
	
}

