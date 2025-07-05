package com.project.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import com.project.main.model.Users;
import com.project.main.repository.UserDetailsRepo;

@Service
public class UserService {

	//security configuration class la yum change panaum
	BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder(12);
	
	@Autowired
	UserDetailsRepo repo;
	

	
	public void addUser(Users user) {
		// using bcrypt
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		repo.save(user);
	}

	// for verify  
	@Autowired
	AuthenticationManager authManager;
	
	//JwtService class ku obj create panarom
	@Autowired
	private JwtService jwtService;
	
	public String verify(Users user) {
        Authentication auth=
				   authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
	
		if(auth.isAuthenticated()){
			//user name pass um authorize aachi na ->generate token
			return jwtService.generateToken(user.getUserName());
		}
		return "fail";
		
	}

}
