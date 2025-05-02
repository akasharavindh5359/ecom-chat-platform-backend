package com.login.security.controler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.login.security.dto.JwtResponse;
import com.login.security.dto.MessageReponse;
import com.login.security.dto.SigninRequest;
import com.login.security.dto.SignupRequest;
import com.login.security.service.LoginService;

@RestController
//@ResponseBody
@RequestMapping("/api/auth")
public class LoginControler{
	
	
	@Autowired
	private LoginService loginService;
	
	private Logger logger = LoggerFactory.getLogger(LoginControler.class);
	
	@PostMapping("/signup")
	public ResponseEntity<MessageReponse> Sigin(@RequestBody SignupRequest siginDto) {
		logger.info("Login-------- Sigin ---> Started ");
		ResponseEntity<MessageReponse> ResponceMessage = loginService.Sigin(siginDto);
		
	
		logger.info("Login-------- Sigin ---> Ented ");
		return ResponceMessage;
	}
	
	@PostMapping("/signin")
	public ResponseEntity<JwtResponse> sigup(@RequestBody SigninRequest signinRequest) throws Exception{
		JwtResponse jwtResponce = loginService.authenticateUser(signinRequest); 
		return null;
		
	}
	
}
