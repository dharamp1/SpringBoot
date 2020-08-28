package com.sterlite.demo.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sterlite.demo.spring.entities.User;
import com.sterlite.demo.spring.entities.UserAuthority;
import com.sterlite.demo.spring.repositories.UserAuthorityRepository;
import com.sterlite.demo.spring.repositories.UserRepository;

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
