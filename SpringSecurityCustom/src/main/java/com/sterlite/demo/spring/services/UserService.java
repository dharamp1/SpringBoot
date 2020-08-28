package com.sterlite.demo.spring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sterlite.demo.spring.entities.User;
import com.sterlite.demo.spring.repositories.UserRepository;
/**
 * @author dharmaraj.pawale@sterlite.com
 * @copyright Sterlite Technologies Ltd.
 * @creationdate 19-Aug-2020
 */
@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> dbUserOp = userRepo.findById(username);
		return dbUserOp.orElseThrow(()->new UsernameNotFoundException("User " + username + " not found"));
	}

}
