package com.sterlite.demo.spring;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sterlite.demo.spring.respository.LDAPRepository;
/**
 * @author dharmaraj.pawale@sterlite.com
 * @copyright Sterlite Technologies Ltd.
 * @creationdate 20-Aug-2020
 */
@SpringBootApplication
public class SpringSecurityLdapApplication {
	
	private static Logger log = LoggerFactory.getLogger(SpringSecurityLdapApplication.class);

    @Autowired
    private LDAPRepository ldapRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityLdapApplication.class, args);
	}
	
	 @PostConstruct
	    public void setup(){
	        log.info("Spring LDAP and Spring Boot Configuration Example");

	        List<String> names = ldapRepository.getAllPersonNames();
	        log.info("names: " + names);

	        System.exit(-1);
	    }

}
