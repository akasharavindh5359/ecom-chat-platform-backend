package com.login.security.serviceimpl;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.login.security.entity.UserEntity;




public class UserDetailesImpl implements UserDetails {
	
	private static final long serialVersionUID = 8695044517973700964L;
	private long id;
	private String username;
	private String password;
	
	
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}


	private Collection<? extends GrantedAuthority> authorities;
	
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}
	
	

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
	
	@Override
	public boolean isAccountNonExpired() {	
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {	
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {	
		return true;
	}
	
	@Override
	public boolean isEnabled() {	
		return true;
	}
	
	
	@Override
	public boolean equals(Object o) {
		if(this==o) {
			return true;
		}
		if(o==null || getClass() !=o.getClass()) {
			return false;
		}
		UserDetailesImpl user = (UserDetailesImpl)o;
		return Objects.equals(id, user.id);
	}



	public UserDetailesImpl(long id, String username, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}
	
	
	public static UserDetailesImpl build(UserEntity user) {
		List<GrantedAuthority> authorities = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());
		return new UserDetailesImpl(user.getId(),user.getEmailId(),user.getPassword(),authorities);
	}



	

//	______________Getters and Setters_________________
	
	}
