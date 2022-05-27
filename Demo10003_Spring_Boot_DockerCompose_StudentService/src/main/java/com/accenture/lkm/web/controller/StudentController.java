package com.accenture.lkm.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.lkm.bussiness.bean.Student;
import com.accenture.lkm.dao.StudentDAO;

@RestController
public class StudentController {

	@Autowired
	private StudentDAO studentDAO;
	
	@RequestMapping(value = "student/controller/getDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Student>> getStudentDetails() {
		List<Student> listStudent = new ArrayList<Student>(studentDAO.getAllStudent());
		return new ResponseEntity<List<Student>>(listStudent,HttpStatus.OK);
	}

	@RequestMapping(value = "student/controller/getDetailsById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> getStudentDetailByStudentId(@PathVariable("id") int myId) {
		Student student = studentDAO.getStudentDetailsById(myId);
		if (student != null) {
			return new ResponseEntity<Student>(student, HttpStatus.OK);
		} else {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "student/controller/addStudent", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<String> addStudent(@RequestBody Student student) {
		int count=studentDAO.addStudent(student);
		return new ResponseEntity<String>("Student added successfully with id:" + count,HttpStatus.CREATED);
	}

	@RequestMapping(value = "student/controller/updateStudent", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> updateStudent(@RequestBody  Student student) {
		if (studentDAO.getStudentDetailsById(student.getStudentId()) == null) {
			Student student2 = null;
			return new ResponseEntity<Student>(student2,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Student updated = studentDAO.updateStudent(student);
		return new ResponseEntity<Student>(updated, HttpStatus.OK);
	}

	@RequestMapping(value = "student/controller/deleteStudent/{id}", method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> deleteStudent(@PathVariable("id") int myId) {
		if (studentDAO.getStudentDetailsById(myId) == null) {
			Student student2 = null;
			return new ResponseEntity<Student>(student2,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Student student = studentDAO.removeStudent(myId);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
}