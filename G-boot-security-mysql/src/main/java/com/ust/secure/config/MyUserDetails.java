package com.ust.secure.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ust.secure.model.MyUser;

public class MyUserDetails implements UserDetails{
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private List<GrantedAuthority> authorities;

	public MyUserDetails(MyUser user) {
		username=user.getUsername();
		password=user.getUsername();
		authorities = Arrays.stream(user.getRole().split(","))
							.map(SimpleGrantedAuthority::new)
							.collect(Collectors.toList());
		//String role = "ADMIN,USER,OPS,HR";
		//CONVERTING A COMMA SEPARATED STRING INTO AN ARRAYLIST
				
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
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
}
