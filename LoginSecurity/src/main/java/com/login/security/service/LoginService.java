package com.login.security.service;

import org.springframework.http.ResponseEntity;

import com.login.security.dto.MessageReponse;
import com.login.security.dto.SiginRequestDto;


public interface LoginService {

	ResponseEntity<MessageReponse> Sigin(SiginRequestDto siginDto);

}
