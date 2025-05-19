package com.login.security.controler;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.login.security.entity.ERole;
import com.login.security.entity.Role;
import com.login.security.entity.User;
import com.login.security.jwt.JwtUtils;
import com.login.security.payload.request.LoginRequest;
import com.login.security.payload.request.SignupRequest;
import com.login.security.payload.response.JwtResponse;
import com.login.security.payload.response.MessageResponse;
import com.login.security.repository.RoleRepository;
import com.login.security.repository.UserRepository;
import com.login.security.service.UserDetailsImpl;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthControler {
	
	@Autowired
	AuthenticationManager authenticationManager;
	 
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	JwtUtils jwtUtils;
	
//	@PostMapping("/signin")
//	public ResponseEntity<?> authenticationUser(@Valid @RequestBody LoginRequest loginRequest){
//		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//				loginRequest.getUsername(),loginRequest.getPassword()));
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//		String jwt= jwtUtils.generateToken(authentication);
//		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toList());
//		
//		
//		return ResponseEntity.ok(new JwtResponse(jwt,null,null,userDetails.getUsername(),roles));
//		
//	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginReq){
		Authentication authenication =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginReq.getUsername(),loginReq.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authenication);
		String jwt = jwtUtils.generateToken(authenication);
		UserDetailsImpl userDetailes =(UserDetailsImpl) authenication.getPrincipal();
		List<String>roles = userDetailes.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());
		return ResponseEntity.ok(new JwtResponse(jwt,null, userDetailes.getUsername(), roles));
		
	}
	
	
	@PostMapping("/signup")
	public ResponseEntity<?>registerUser(@Valid @RequestBody SignupRequest signupRequest ){
		int res = userRepository.exisexistsByUserNameData(signupRequest.getUsername());
		if(res != 0) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken !.."));
		}
		
		User user = new User(signupRequest.getUsername(),passwordEncoder.encode(signupRequest.getPassword()));
		Set<String>strRoles = signupRequest.getRole();
		Set<Role> roles= new HashSet<>(); 
		
		if(strRoles==null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(()-> new RuntimeException("Error: Role is not Found"));roles.add(userRole);
		}
		else {
			strRoles.forEach(role->{
				switch (role) {
				case "admin": 
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(()-> new RuntimeException("Error: Role is not Found"));
					roles.add(adminRole);
				break;
				
				case "mod": 
					Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
							.orElseThrow(()-> new RuntimeException("Error: Role is not Found"));
					roles.add(modRole);
				break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(()-> new RuntimeException("Error: Role is not Found"));
			roles.add(userRole);
				}
			});
		}
		user.setRoles(roles);
		userRepository.save(user);
		return ResponseEntity.ok(new MessageResponse("User Registered Successfully"));
		
	}

	
	
	 

}
