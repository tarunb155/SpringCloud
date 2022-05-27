package StudentRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sampleconnection.api.Student;

public class StudentRowMapper implements RowMapper<Student> {

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student newStudent = new Student();
		newStudent.setRollNo(rs.getInt("ROLL_NO"));
		newStudent.setName(rs.getString("STUDENT_NAME"));
		newStudent.setAddress(rs.getString("STUDENT_ADDRESS"));
		return newStudent;
	}

}
