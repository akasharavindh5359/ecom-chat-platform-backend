package com.login.security.controler;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/test")
public class TestControler {
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Public Access";
	}
	
//	@GetMapping("/user")
//	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
//	public String userAccess() {
//		return "User content.";
//	}
//	
//	@GetMapping("/moderator")
//	@PreAuthorize("hasRole('MODERATOR') or hasRole('USER')")
//	public String modAccess() {
//		return "mod content.";
//	}
//	
//	@GetMapping("/admin")
//	@PreAuthorize("hasRole('ADMIN')")
//	public String adminAccess() {
//		return "admin content.";
//	}
	
//	@GetMapping("/user")
//	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
//	public String userAccess() {
//		return "User content.";
//	}
//	
//	@GetMapping("/moderator")
//	@PreAuthorize("hasRole('MODERATOR') or hasRole('USER')")
//	public String modAccess() {
//		return "mod content.";
//	}
//	
//	@GetMapping("/admin")
//	@PreAuthorize("hasRole('ADMIN')")
//	public String adminAccess() {
//		return "admin content.";
//	}
//	

}
