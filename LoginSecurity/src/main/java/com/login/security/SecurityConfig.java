package com.login.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
		 http
         .csrf().disable()
         .authorizeHttpRequests()
		.requestMatchers("/api/auth/**").permitAll()
		.requestMatchers("/api/admin/**").hasAuthority("ADMIN")
		 .requestMatchers("/api/moderator/**").hasAuthority("MODERATOR")
         .requestMatchers("/api/user/**").hasAnyAuthority("USER", "ADMIN", "MODERATOR")
         .anyRequest().authenticated()
     .and()
     .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		return http.build();
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	    @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
	        return authenticationConfiguration.getAuthenticationManager();
	    }
	    
	    
	    @Bean
	    public JavaMailSender mailSender() {
	        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	        mailSender.setHost("smtp.gmail.com");
	        mailSender.setPort(587);
	        mailSender.setUsername("akasharavindh.cs@gmail.com");
	        mailSender.setPassword("efrr otvd ejkq yndg");

	        mailSender.getJavaMailProperties().put("mail.smtp.auth", "true");
	        mailSender.getJavaMailProperties().put("mail.smtp.starttls.enable", "true");

	        return mailSender;
	    }

}
