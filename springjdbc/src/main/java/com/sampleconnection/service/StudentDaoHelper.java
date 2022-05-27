package com.sampleconnection.service;

import java.util.ArrayList;
import java.util.List;

import com.sampleconnection.api.Student;
import com.sampleconnection.dao.StudentDao;
import com.sampleconnection.dao.StudentDaoImpl;

public class StudentDaoHelper {
	
	public void setUpStudentTable()
	{
		
		Student student1= new Student();
		student1.setRollNo(2);
		student1.setName("Akshay");
		student1.setAddress("Kolkata");
		
		Student student2= new Student();
		student2.setRollNo(3);
		student2.setName("Almer");
		student2.setAddress("Mumbai");
		
		
		Student student3= new Student();
		student3.setRollNo(4);
		student3.setName("Ashwin");
		student3.setAddress("Chennai");
		
		ArrayList<Student> studentList=new ArrayList<Student>();
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
		StudentDao studentDao= new StudentDaoImpl();
		studentDao.insert(studentList);
		
	}

	public void printStudentDetails(List<Student> students)
	{
		for(Student tempStudent : students)
		{
			System.out.println(tempStudent);
		}
	}
	public void printStudentDetails(Student student)
	{
	
			System.out.println(student);
		
	}
}
