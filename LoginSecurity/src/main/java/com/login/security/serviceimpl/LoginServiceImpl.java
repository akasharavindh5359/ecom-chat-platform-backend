package com.login.security.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.login.security.dto.MessageReponse;
import com.login.security.dto.SiginRequestDto;
import com.login.security.repository.UserRepository;
import com.login.security.service.LoginService;


@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	UserRepository userRepo;

	@Override
	public ResponseEntity<MessageReponse> Sigin(SiginRequestDto siginDto) {
		if(userRepo.ExistsByUsername(siginDto.getUserName())) {
			return ResponseEntity.badRequest().body(new MessageReponse("Error: Username is already taken !.."));
		}
		return null;
	}

}
