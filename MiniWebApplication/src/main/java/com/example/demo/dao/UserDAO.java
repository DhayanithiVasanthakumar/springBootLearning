package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.UserDetails;

public interface UserDAO extends CrudRepository<UserDetails,Integer>{

}
