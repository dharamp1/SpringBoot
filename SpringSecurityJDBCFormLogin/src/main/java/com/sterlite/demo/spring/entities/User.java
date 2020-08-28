package com.sterlite.demo.spring.entities;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * @author dharmaraj.pawale@sterlite.com
 * @copyright Sterlite Technologies Ltd.
 * @creationdate 18-Aug-2020
 */
@Entity
@Table(name = "MYUSERS")
public class User {
	@Id
	private String username;
	
	private String password;
	
	private String enabled;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String username, String password, String enabled) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", enabled=" + enabled + "]";
	}
	
	

}
