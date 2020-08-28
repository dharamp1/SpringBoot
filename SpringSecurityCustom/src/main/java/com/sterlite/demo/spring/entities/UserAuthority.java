package com.sterlite.demo.spring.entities;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MYUSERAUTHORITIES")
public class UserAuthority {
	
	@Id
	private BigInteger authority_id;
	private String authority;
	
	@ManyToOne
	@JoinColumn(name = "username")
	private User user;
	
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserAuthority() {
		// TODO Auto-generated constructor stub
	}

	public UserAuthority(BigInteger authority_id, String authority) {
		super();
		this.authority_id = authority_id;
		this.authority = authority;
	}
	
	public UserAuthority(String authority) {
		super();
		this.authority = authority;
	}

	public BigInteger getAuthority_id() {
		return authority_id;
	}

	public void setAuthority_id(BigInteger authority_id) {
		this.authority_id = authority_id;
	}

	
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	@Override
	public String toString() {
		return "UserAuthority [authority_id=" + authority_id + ", authority=" + authority + "]";
	}
	
	
}
