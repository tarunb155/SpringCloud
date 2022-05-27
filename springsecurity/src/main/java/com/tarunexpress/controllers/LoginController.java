package com.tarunexpress.controllers;

import javax.sql.DataSource;
import org.springframework.security.core.userdetails.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tarunexpress.dao.SignupDAO;
import com.tarunexpress.dto.SignupDTO;

@Controller
public class LoginController {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	JdbcUserDetailsManager jdbcUserDetailsManager;
	@Autowired
	DataSource dataSource;
	
	@Autowired
	SignupDAO signupDAO;
	@GetMapping("/myCustomLogin")
	public String customLogin()
	{
		return "login";
	}
	
	@GetMapping("/signup")
	public String signup(@ModelAttribute("signupdto") SignupDTO signupDTO)
	{
		return "signup";
	}
	
	@PostMapping("/process-signup")
	public String processSignup(SignupDTO signupDTO)
	{
		//Before encoding
		System.out.println(signupDTO);
		String encodedPassword=passwordEncoder.encode(signupDTO.getPassword());
		signupDTO.setPassword(encodedPassword);
		//After encoding
		System.out.println(signupDTO);
		
//		JdbcUserDetailsManager jdbcUserDetailsManager;
//		jdbcUserDetailsManager.setDataSource(dataSource);
		
		UserDetails user= User.withUsername(signupDTO.getUsername()).password(signupDTO.getPassword()).roles("Coder").build();
		jdbcUserDetailsManager.createUser(user);
		//save the dto and do the db call
		//signupDAO.saveUser(signupDTO);
		
		//redirecting to custom login page
		return "redirect:/myCustomLogin";
	}
}
