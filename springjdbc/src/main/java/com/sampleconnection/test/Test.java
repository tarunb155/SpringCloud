package com.sampleconnection.test;

import java.util.List;

import com.sampleconnection.api.Student;
import com.sampleconnection.dao.StudentDao;
import com.sampleconnection.dao.StudentDaoImpl;
import com.sampleconnection.service.StudentDaoHelper;

public class Test {

	public static void main(String[] args) {

		Student student1 = new Student();
		student1.setRollNo(6);
		student1.setName("Priya");
		student1.setAddress("Hyderabad");

		StudentDao studentDao = new StudentDaoImpl();
		studentDao.insert(student1);
//		Boolean isDeleted=studentDao.deleteByRollNo(2);
//		if(isDeleted)
//		{
//			System.out.println("The rollNo got deleted");
//		}

		StudentDaoHelper studentDaoHelper = new StudentDaoHelper();
		// studentDaoHelper.setUpStudentTable();

		List<Student> studentList = studentDao.findAllStudents();
		studentDaoHelper.printStudentDetails(studentList);

		Student student = studentDao.findStudentByRollNo(2);
		studentDaoHelper.printStudentDetails(student);

	}

}
