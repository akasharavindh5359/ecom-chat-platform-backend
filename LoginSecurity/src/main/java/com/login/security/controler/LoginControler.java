package com.login.security.controler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.login.security.dto.MessageReponse;
import com.login.security.dto.SiginRequestDto;
import com.login.security.service.LoginService;

@RestController
//@ResponseBody
@RequestMapping("/login")
public class LoginControler{
	
	
	@Autowired
	private LoginService loginService;
	
	private Logger logger = LoggerFactory.getLogger(LoginControler.class);
	
	@PostMapping("/sigin")
	public ResponseEntity<MessageReponse> Sigin(@RequestBody SiginRequestDto siginDto) {
		logger.info("Login-------- Sigin ---> Started ");
		ResponseEntity<MessageReponse> ResponceMessage = loginService.Sigin(siginDto);
	
		logger.info("Login-------- Sigin ---> Ented ");
		return ResponceMessage;
	}
	
}
