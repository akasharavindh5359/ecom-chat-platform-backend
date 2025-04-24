package com.login.security.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity

@Table(name = "users" , uniqueConstraints = {
		@UniqueConstraint(columnNames ="user_name")})
public class UserEntity {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;
	@NotBlank
	@Column(name = "username")
	private String userName;
	@NotBlank
	@Size(max = 50)
	@Column(name = "email_id")
	private String emailId;
	@NotBlank
	@Column(name = "user_password")
	private String password;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name ="role_id" ))
	private Set<RolesEntity> roles = new HashSet<>();


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Set<RolesEntity> getRoles() {
		return roles;
	}


	public void setRoles(Set<RolesEntity> roles) {
		this.roles = roles;
	}
	
		
	
	

}
