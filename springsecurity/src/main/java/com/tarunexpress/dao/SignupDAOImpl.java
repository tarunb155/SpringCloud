package com.tarunexpress.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.tarunexpress.dto.SignupDTO;

@Repository
public class SignupDAOImpl implements SignupDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	public void saveUser(final SignupDTO signupDTO) {
		// TODO Auto-generated method stub

		String sql="insert into users values(?,?,?)";
		String sql2="insert into authorities values(?,?)";
	//	jdbcTemplate.update(sql,signupDTO.getUsername(),signupDTO.getPassword(),1);
	//	jdbcTemplate.update(sql2,signupDTO.getUsername(),"USER");
		
//	Above Line#19 and 20 can be written in below way by using diff constructor for jdbcTemplate
	
	jdbcTemplate.update(sql, new PreparedStatementSetter() {
		public void setValues(PreparedStatement ps) throws SQLException {
			ps.setString(1, signupDTO.getUsername());
			ps.setString(2, signupDTO.getPassword());
			ps.setInt(3, 1);
		}
	});
	
	jdbcTemplate.update(sql2, new PreparedStatementSetter() {
		public void setValues(PreparedStatement ps) throws SQLException {
			ps.setString(1, signupDTO.getUsername());
			ps.setString(2, "coder");
		}
	});
		
		
	}

}
