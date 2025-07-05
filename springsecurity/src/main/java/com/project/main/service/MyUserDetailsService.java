package com.project.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.main.model.Users;
import com.project.main.model.UsersPrinciple;
import com.project.main.repository.UserDetailsRepo;

/*
 * verify users from db
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserDetailsRepo userDetailsRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user=userDetailsRepo.getByUserName(username);
		if(user==null) {
			throw new UsernameNotFoundException("user not found");
		}
		return new UsersPrinciple(user);
	}

}
