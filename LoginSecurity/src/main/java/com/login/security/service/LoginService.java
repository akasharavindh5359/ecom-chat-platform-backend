package com.login.security.service;

import org.springframework.http.ResponseEntity;

import com.login.security.dto.JwtResponse;
import com.login.security.dto.MessageReponse;
import com.login.security.dto.SigninRequest;
import com.login.security.dto.SignupRequest;


public interface LoginService {

	ResponseEntity<MessageReponse> Sigin(SignupRequest siginDto);

	JwtResponse authenticateUser(SigninRequest signinRequest) throws Exception;

}
