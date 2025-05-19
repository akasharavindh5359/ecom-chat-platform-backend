package com.login.security.controler;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
@RequestMapping("/api/moderator")
public class ModeratorControler {
	
	@GetMapping("/api")
	public String adminAccess() {
		return "moderator content.";
	}

}
