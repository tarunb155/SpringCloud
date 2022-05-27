package com.tarunexpress.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
//this class is going to help us to create Security Filter Chain
	@Autowired
	DataSource dataSource;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	//below code is for jdbc authentication ie load the user from db
		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username, password, enabled from customers where username=?").
		authoritiesByUsernameQuery("select username,roles from customers where username=?").
		passwordEncoder(passwordEncoder);
		
	//below code is for inmemory authentication	
	/*	auth
		.inMemoryAuthentication()
		.withUser("tarun")
		.password("{bcrypt}$2a$10$kygEFPGwDXPmo6xC6jiBA.kHB/mGuJUEgYF/uE7Pa.0diguboep2G")
		.roles("admin");
		*/
	//	auth.inMemoryAuthentication().withUser("koushik").password("{bcrypt}$2a$10$kygEFPGwDXPmo6xC6jiBA.kHB/mGuJUEgYF/uE7Pa.0diguboep2G").roles("user");
	}
@Override
	protected void configure(HttpSecurity http) throws Exception {
//	http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
	http.
	authorizeRequests().
	antMatchers("/coder").hasAuthority("coder").
	antMatchers("/trainer").hasAuthority("trainer").
	antMatchers("/").authenticated()
//	antMatchers("/helloWorld").permitAll().
	.and().
	formLogin().loginPage("/myCustomLogin").permitAll()
	.and().
	httpBasic().and().logout().permitAll().and().exceptionHandling().accessDeniedPage("/accessDenied")
	;
	}
}