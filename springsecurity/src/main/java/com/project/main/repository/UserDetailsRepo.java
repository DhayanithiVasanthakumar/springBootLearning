package com.project.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.main.model.Users;

@Repository
public interface UserDetailsRepo extends JpaRepository<Users, Integer> {

	/*
	 * verify users from db
	 */
	Users getByUserName(String username);
}
