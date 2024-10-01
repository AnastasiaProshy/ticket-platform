package com.java.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.platform.model.Status;

public interface StatusRepository extends JpaRepository <Status, Integer> 
{
	//already has all the methods to perform CRUD operations for Tickets
}
