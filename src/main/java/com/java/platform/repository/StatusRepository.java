package com.java.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.platform.model.UserStatus;

public interface StatusRepository extends JpaRepository <UserStatus, Integer> 
{
	//already has all the methods to perform CRUD operations for Tickets
}
