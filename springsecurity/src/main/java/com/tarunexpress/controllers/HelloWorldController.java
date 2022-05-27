package com.tarunexpress.controllers;

import java.security.Principal;
import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tarunexpress.dto.ChangePasswordDTO;

@Controller
public class HelloWorldController {
	@Autowired
	private JdbcUserDetailsManager userDetailsManager;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/")
	public String helloWorld(Principal principal, Authentication auth, Model model) {
		// here principal means the logged in user so in above helloWorld method we can
		// pass Principal also as parameter
		try {
			String username = principal.getName();
			System.out.println("Logged in user is " + username);
			// String username= auth.getPrincipal().toString();
			Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
			System.out.println(authorities);
			model.addAttribute("username", username);
			model.addAttribute("roles", authorities);
		} catch (NullPointerException ne) {
			System.out.println("Principal value is null");
		}
		return "home-page";
	}

//	@ResponseBody
//	@GetMapping("/hello")
//	public String Hello()
//	{
//		return "Hello from Tarun Express";
//	}
//	@ResponseBody
//	@GetMapping("/bye")
//	public String Bye()
//	{
//		return "bye bye guys";
//	}

	@GetMapping("/deleteUser")
	public String deleteUser(@RequestParam("username") String username) {
		userDetailsManager.deleteUser(username);
		System.out.println("Deleted User" + username);
		return "redirect:/myCustomLogin";
	}

	@GetMapping("/changePassword")
	public String changePassword(Model model) {
		model.addAttribute("password-chng", new ChangePasswordDTO());
		return "change-password";
	}

	@PostMapping("/save-password")
	public String savePassword(Principal principal, ChangePasswordDTO changePasswordDTO) {
		// check whether old pass is correct or not
		// check the new pass and confirm if it matches
		// write logic to save the new pass to db
		UserDetails user = userDetailsManager.loadUserByUsername(principal.getName());
		boolean matches = passwordEncoder.matches(changePasswordDTO.getOldPassword(), user.getPassword());
		if (!changePasswordDTO.getNewPassword().equals(changePasswordDTO.getConfirmPassword())) {
			return "redirect:/changePassword?notMatched";
		}
		if (matches) {
			String encodedPassword = passwordEncoder.encode(changePasswordDTO.getConfirmPassword());
			userDetailsManager.changePassword(changePasswordDTO.getOldPassword(), encodedPassword);
			System.out.println(changePasswordDTO);
			return "redirect:/home";
		}
		return "redirect:/changePassword?invalidPassword";
	}

	@GetMapping("/trainer")
	public String showTrainerDashboard() {
		return "trainer-dashboard";
	}

	@GetMapping("/coder")
	public String showCoderDashboard() {
		return "coder-dashboard";
	}

	@GetMapping("/accessDenied")
	public String error() {
		return "access-denied";
	}

}
