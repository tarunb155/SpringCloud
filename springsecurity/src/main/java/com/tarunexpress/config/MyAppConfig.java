package com.tarunexpress.config;

import javax.sql.DataSource;

import org.hsqldb.jdbc.JDBCDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com")
public class MyAppConfig {
@Bean	
InternalResourceViewResolver viewResolver(){
	InternalResourceViewResolver viewResolver= new InternalResourceViewResolver();
	viewResolver.setPrefix("/WEB-INF/view/");
	viewResolver.setSuffix(".jsp");
	return viewResolver;
}
//@Bean
//PasswordEncoder getPasswordEncoder() {
//	return new BCryptPasswordEncoder();
//}

@Bean
public JdbcTemplate jdbcTemplate()
{
	JdbcTemplate jdbcTemplate= new JdbcTemplate(dataSource());
	return jdbcTemplate;
	
}

@Bean
public DataSource dataSource()
{
	DriverManagerDataSource driverManagerDataSource= new DriverManagerDataSource();
	driverManagerDataSource.setUrl("jdbc:hsqldb:hsql://localhost/testdb");
	driverManagerDataSource.setUsername("SA");
	driverManagerDataSource.setPassword("");
	driverManagerDataSource.setDriverClassName("org.hsqldb.jdbc.JDBCDriver");
	return driverManagerDataSource;
}
@Bean
public PasswordEncoder passwordEncoder()
{
//	return new BCryptPasswordEncoder();
	return NoOpPasswordEncoder.getInstance();
}

@Bean
public JdbcUserDetailsManager jdbcUserDetailsManager()
{
	//return new JdbcUserDetailsManager(dataSource());
	JdbcUserDetailsManager userDetailsManager= new JdbcUserDetailsManager(dataSource());
	userDetailsManager.setUsersByUsernameQuery("select username,password,enabled from customers where username = ?");
	userDetailsManager.setAuthoritiesByUsernameQuery("select username,roles from customers where username = ?");
	userDetailsManager.setChangePasswordSql("update customers set password = ? where username = ?");
	userDetailsManager.setDeleteUserSql("delete from customers where username =?");
	return userDetailsManager;
	
}

}
