package com.accenture.lkm.dao;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.accenture.lkm.bussiness.bean.Student;

@Repository
public class StudentDAO {
	
	public static Map<Integer, Student> mapOfStudents = new LinkedHashMap<Integer, Student>();
	static int count=10003;
	static{
		mapOfStudents.put(10001, new Student("Jack",10001,23,"CSE"));
		mapOfStudents.put(10002, new Student("Justin",10002,25,"EEE"));
		mapOfStudents.put(10003, new Student("Eric",10003,22,"ECE"));
	}
	
	public Collection<Student> getAllStudent(){
		return mapOfStudents.values();			
	}
	
	public Student getStudentDetailsById(int id){
		return mapOfStudents.get(id);
	}
	
	public Integer addStudent(Student student){
		count++;
		student.setStudentId(count);
		mapOfStudents.put(count, student);
		return count;
	}
	
	public Student updateStudent (Student student){
		mapOfStudents.put(student.getStudentId(), student);
		return student;
	}
	
	public Student removeStudent (int id){
		Student emp= mapOfStudents.remove(id);
		return emp;
	}	
}