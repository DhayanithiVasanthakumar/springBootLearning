package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserDetails;

//public interface UserDAO extends CrudRepository<UserDetails,Integer>{
//
//}

@Repository
public class UserDAO {

	@Autowired 
	private JdbcTemplate jdbcTemplate;

	public void saveUser(UserDetails userDtls) {
		this.jdbcTemplate.update("insert into user_dtls values (?,?)",
				userDtls.getId(), userDtls.getName());
	}

}
