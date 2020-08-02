package com.sterlite.demo.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sterlite.demo.spring.entities.User;

public interface UserRepository extends JpaRepository<User, String> {
	
}
