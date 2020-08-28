/**
 * 
 */
package com.sterlite.demo.spring.repositories;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sterlite.demo.spring.entities.User;
import com.sterlite.demo.spring.entities.UserAuthority;

/**
 * @author dharm
 *
 */
public interface UserAuthorityRepository extends JpaRepository<UserAuthority, BigInteger> {
	
	
}
