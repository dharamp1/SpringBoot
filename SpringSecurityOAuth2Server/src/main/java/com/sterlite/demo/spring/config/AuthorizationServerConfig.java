package com.sterlite.demo.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
/**
 * @author dharmaraj.pawale@sterlite.com
 * @copyright Sterlite Technologies Ltd.
 * @creationdate 20-Aug-2020
 */
@Configuration
@EnableAuthorizationServer // OAuth2 Authorization Server
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	
	private final PasswordEncoder encoder;
	
	@Value("${oauth2.client.id}")
	private String clientId;
	
	@Value("${oauth2.client.secret}")
	private String clientSecret;
	
	@Value("${oauth2.client.redirect-uris}")
	private String redirectUris;
	
	
	public AuthorizationServerConfig(PasswordEncoder encoder) {
		// TODO Auto-generated constructor stub
		this.encoder = encoder;
	}
	
	//Configure the security of the Authorization Server, 
	//which means in practical terms the /oauth/token endpoint
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		// TODO Auto-generated method stub
		security
		.tokenKeyAccess("permitAll()")
		.checkTokenAccess("isAuthenticated()");
	}
	
	//Configure the ClientDetailsService, e.g. declaring individual clients and their properties
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		// TODO Auto-generated method stub
		clients
		.inMemory()
		.withClient(clientId)
		.secret(encoder.encode(clientSecret))
		.authorizedGrantTypes("authorization_code")
		.scopes("user_info")
		.autoApprove(true)
		.redirectUris(redirectUris);
	}
	
	/*
	 * @Override public void configure(AuthorizationServerEndpointsConfigurer
	 * endpoints) throws Exception { // TODO Auto-generated method stub endpoints
	 * .authenticationManager(authenticationManager); }
	 */
}
