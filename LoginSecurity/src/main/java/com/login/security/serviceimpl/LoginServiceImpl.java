package com.login.security.serviceimpl;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.login.security.JwtUtil;
import com.login.security.dto.JwtResponse;
import com.login.security.dto.MessageReponse;
import com.login.security.dto.SigninRequest;
import com.login.security.dto.SignupRequest;
import com.login.security.entity.ERole;
import com.login.security.entity.RolesEntity;
import com.login.security.entity.UserEntity;
import com.login.security.repository.RoleRepository;
import com.login.security.repository.UserRepository;
import com.login.security.service.LoginService;


@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired 
	JavaMailSender mailSender;
	
	@Autowired
	JwtUtil jwtUtils;
	
	@Value("${spring.mail.username}")
	public String  fromemailId;
	
	
	@Override
	public ResponseEntity<MessageReponse> Sigin(SignupRequest siginDto) {
		Long count = userRepo.existsByUsername(siginDto.getEmailId());
		try {
			sentOTP(siginDto);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (count == 1) {
			return ResponseEntity.badRequest().body(new MessageReponse("Error: Username is already taken !.."));
		} else {
			Set<String> strRole = siginDto.getRole();
			Set<RolesEntity> roles = new HashSet<>();
			if (strRole == null) {
				RolesEntity userroles = roleRepository.findByName(ERole.ROLE_USER)
						.orElseThrow(() -> new RuntimeException("Error: Role is not Found..!"));
				roles.add(userroles);
			} else {
				strRole.forEach(role -> {
					switch (role) {
					case "admin": {

						RolesEntity adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
								.orElseThrow(() -> new RuntimeException("Error: Role is not Found..!"));
						roles.add(adminRole);
						break;
					}
					case "mod": {
						RolesEntity modRole = roleRepository.findByName(ERole.ROLE_MADERATOR)
								.orElseThrow(() -> new RuntimeException("Error: Role is not Found..!"));
						roles.add(modRole);
						break;
					}
					default:
						RolesEntity userroles = roleRepository.findByName(ERole.ROLE_USER)
								.orElseThrow(() -> new RuntimeException("Error: Role is not Found..!"));
						roles.add(userroles);
					}
				});

			}
			UserEntity userEntity = new UserEntity();
			userEntity.setUserName(siginDto.getUserName());
			userEntity.setEmailId(siginDto.getEmailId());
			userEntity.setPassword(passwordEncoder.encode(siginDto.getPassword()));
			userEntity.setRoles(roles); 
			userRepo.save(userEntity);

		}
		return ResponseEntity.badRequest().body(new MessageReponse("Succes: User registered successfully!"));
	}

	private void sentOTP(SignupRequest siginDto) throws UnsupportedEncodingException {
		
		  SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		  String subject = "Your OTP Code for Secure Access - Ecom Chat Platform !";
		  String content = "Dear User,\r\n"
		  		+ "\r\n"
		  		+ "To complete your verification process on **Ecom Chat Platform**, please use the following One-Time Password (OTP):\r\n"
		  		+ "\r\n"
		  		+ "🔒 **Your OTP: {6388}**\r\n"
		  		+ "\r\n"
		  		+ "This OTP is valid for the next 10 minutes.  \r\n"
		  		+ "Please do not share this OTP with anyone for security reasons.\r\n"
		  		+ "\r\n"
		  		+ "If you did not request this OTP, please ignore this email.\r\n"
		  		+ "\r\n"
		  		+ "Thank you for trusting **Ecom Chat Platform**.\r\n"
		  		+ "\r\n"
		  		+ "Best Regards,  \r\n"
		  		+ "**Team Ecom Chat Platform**  \r\n"
		  		+ "*Developed by CodeWithAKDev*";
	        simpleMailMessage.setFrom("akasharavindh.cs@gmail.com");
	        simpleMailMessage.setTo(siginDto.getEmailId());
	        simpleMailMessage.setText(content);
	        simpleMailMessage.setSubject(subject);
	        
	        mailSender.send(simpleMailMessage);
		
		

//			helper.setFrom(fromemailId);
//			helper.setTo(siginDto.getEmailId());
			
			
//			helper.setSubject(subject);/
//			helper.setText(content, true);
//			mailSender.send(message);
	
		
		
	}

	@Override
	public JwtResponse authenticateUser(SigninRequest signinRequest) throws Exception {
//		UserEntity user = userRepo.findByEmail(signinRequest.getEmail()).get();
		Authentication authenication =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getUsername(),signinRequest.getPassword()));
		
		System.out.println("authenticationManager = " + authenticationManager);
		 Authentication authentication = authenticationManager.authenticate(
		            new UsernamePasswordAuthenticationToken(
		                signinRequest.getUsername(),
		                signinRequest.getPassword()
		            )
		        );

//		        SecurityContextHolder.getContext().setAuthentication(authentication);
//		        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//		        UserEntity user = userRepo.findByEmail(userDetails.getUsername()).get();
//
//		        String token = jwtUtils.generateToken(userDetails);
//		        String token ="hasdf8a87faydf";

//		        return new JwtResponse(token, user.getEmailId(), "role");
		 return null;
//	/	 UserEntity user = userRepo.findByEmail(userDetails.getUsername()).get();
//		 UserEntity user = userRepo.findByEmail(userDetails.getUsername()).get();
	
	}

}
