package com.java.platform.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.platform.model.User;

public interface UserRepository extends JpaRepository <User, Integer> 
{
	//already has all the methods to perform CRUD operations for Tickets
	
	public Optional<User> findByFullName(String fullName);
}
