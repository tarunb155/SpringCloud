package com.sampleconnection.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.sampleconnection.api.Student;

import StudentRowMapper.StudentRowMapper;

public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate JdbcTemplate = new JdbcTemplate(getDataSource());

	public void insert(Student student) {

		String sql = "INSERT INTO STUDENT VALUES (?,?,?)";
		Object[] arg = { student.getRollNo(), student.getName(), student.getAddress() };
		int rowsInserted = JdbcTemplate.update(sql, arg);
		System.out.println("No of rows inserted is " + rowsInserted);
	}

	public boolean deleteByRollNo(int rollNo) {
		String sql = "DELETE FROM STUDENT WHERE ROLL_NO=?";
		int noOfRowsDeleted = JdbcTemplate.update(sql, rollNo);
		System.out.println("No of records deleted is " + noOfRowsDeleted);
		return noOfRowsDeleted == 1;
	}

	public DataSource getDataSource() {
		String url = "jdbc:hsqldb:hsql://localhost/testdb";
		String username = "SA";
		String password = "";
		String driverClassName = "org.hsqldb.jdbc.JDBCDriver";

		// DataSource dataSource = new DriverManagerDataSource(url, username, password);

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setDriverClassName(driverClassName);
		return dataSource;
	}

	public void insert(ArrayList<Student> students) {

		String sql = "INSERT INTO STUDENT VALUES(?,?,?)";
		ArrayList<Object[]> sqlArgs = new ArrayList<Object[]>();

		for (Student tempStudent : students) {
			Object[] studentData = { tempStudent.getRollNo(), tempStudent.getName(), tempStudent.getAddress() };
			sqlArgs.add(studentData);
		}
		JdbcTemplate.batchUpdate(sql, sqlArgs);
		System.out.println("Batch Update Completed!!!");

	}

	public List<Student> findAllStudents() {
		String sql = "SELECT ROLL_NO as rollNo, STUDENT_NAME as name, STUDENT_ADDRESS as address FROM STUDENT";
	//	List<Student> studentList = JdbcTemplate.query(sql, new StudentRowMapper());
	//Selecting the Student Table data using BeanPropertyMapper instead of customised rowMapper	
		List<Student> studentList = JdbcTemplate.query(sql, new BeanPropertyRowMapper(Student.class));
		return studentList;
	}

	public Student findStudentByRollNo(int rollNo) {
		String sql="SELECT * FROM STUDENT WHERE ROLL_NO=?";
		Student student=JdbcTemplate.queryForObject(sql, new StudentRowMapper(), rollNo);
		return student;
	}
	
	

}
