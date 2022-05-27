package com.accenture.lkm.bussiness.bean;

public class Student {
	private String studentName;
	private Integer studentId;
	private Integer age;
	private String department;

	public Student() {
		super();
	}

	public Student(String studentName, Integer studentId, Integer age, String department) {
		super();
		this.studentName = studentName;
		this.studentId = studentId;
		this.age = age;
		this.department = department;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", studentId=" + studentId + ", age=" + age + ", department="
				+ department + "]";
	}
	
}
