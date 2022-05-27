package com.sampleconnection.dao;

import java.util.ArrayList;
import java.util.List;

import com.sampleconnection.api.Student;

public interface StudentDao {
	
  void insert(Student student);
  void insert(ArrayList<Student> students);
  boolean deleteByRollNo(int rollNo);
  List<Student> findAllStudents();
  Student findStudentByRollNo(int rollNo);

}
