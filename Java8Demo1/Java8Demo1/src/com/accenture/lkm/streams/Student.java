package com.accenture.lkm.streams;

import java.util.List;

public class Student {
	private Integer studentId;
	private String studentName;
	private List<String> subject;
	public Student(Integer studentId, String studentName, List<String> subject) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.subject = subject;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public List<String> getSubject() {
		return subject;
	}
	public void setSubject(List<String> subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", subject=" + subject + "]";
	}
	
}
