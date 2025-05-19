package com.login.security.entity;

import java.util.HashSet;
import java.util.Set;


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
@Table(name = "users",uniqueConstraints = {
		@UniqueConstraint(columnNames = "username")
})
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Size(max = 50)
	@NotBlank
	private String Username;
	@Size(max = 120)
	@NotBlank
	private String password;
	
	@ManyToMany(fetch = FetchType.LAZY)
	
	@JoinTable(name = "user_roles",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name ="role_id" ))
	private Set<Role> roles = new HashSet<>();

	
	public User( String username,String password) {
		super();
		Username = username;
		this.password = password;
	}

	

	public User(long id, @Size(max = 50) @NotBlank String username, @Size(max = 120) @NotBlank String password,
			Set<Role> roles) {
		super();
		this.id = id;
		Username = username;
		this.password = password;
		this.roles = roles;
	}
	
	



	public User() {
		super();
	}



	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getUsername() {
		return Username;
	}


	public void setUsername(String username) {
		Username = username;
	}
	
	

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	
	
	
	
	

}
