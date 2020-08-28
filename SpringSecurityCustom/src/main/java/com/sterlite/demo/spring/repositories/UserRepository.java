package com.sterlite.demo.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sterlite.demo.spring.entities.User;
/**
 * @author dharmaraj.pawale@sterlite.com
 * @copyright Sterlite Technologies Ltd.
 * @creationdate 19-Aug-2020
 */
public interface UserRepository extends JpaRepository<User, String> {
	
}
