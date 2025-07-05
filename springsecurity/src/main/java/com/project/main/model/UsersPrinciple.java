package com.project.main.model;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/*
 * verify users from db
 */
public class UsersPrinciple implements UserDetails{

	private Users user;
	
	public UsersPrinciple(Users user) {
		this.user=user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {//ADMIN -> ROLE_ADMIN
		return Collections.singleton(new SimpleGrantedAuthority("ROLE_"+user.getRole()));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword(); //db ku query poogum
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUserName();//db ku query poogum
	}

}
