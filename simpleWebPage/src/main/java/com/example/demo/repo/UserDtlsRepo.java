package com.example.demo.repo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDtlsRepo {

	@Qualifier("postgres")
	private JdbcTemplate jdbcTemplate;

	public UserDtlsRepo(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int testEmpCount() {
		return this.jdbcTemplate.queryForObject("select count(1) from employee.user_dtls", Integer.class);
	}

}
