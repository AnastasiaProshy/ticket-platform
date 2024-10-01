package com.java.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.platform.model.Role;

public interface RoleRepository extends JpaRepository <Role, Integer> 
{
	//already has all the methods to perform CRUD operations for Tickets
}
