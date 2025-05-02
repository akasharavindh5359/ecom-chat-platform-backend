package com.login.security;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.login.security.serviceimpl.UserDetailesImpl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


@Component	
public class JwtUtil {
	 
//	@Value("${codewithakdev.app.jwtSecret}")
//	private String jwtSecret;
//	@Value("${codewithakdev.app.jwtExpirationMs}")
//	private long jwtExpirationMs;
//	
//	 public String generateToken(UserDetails userDetails) {
//			UserDetailesImpl userPrincipal = (UserDetailesImpl) userDetails.getAuthorities();
//			return Jwts.builder().setSubject((userPrincipal.getUsername())).setIssuedAt(new Date())
//					.setExpiration(new Date((new Date().getTime() + jwtExpirationMs)))
//					.signWith(SignatureAlgorithm.HS256, key()).compact();
//
//		}
//	 
//	 public Key key() {
//			return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
//
//		}
//	 
//	



}
