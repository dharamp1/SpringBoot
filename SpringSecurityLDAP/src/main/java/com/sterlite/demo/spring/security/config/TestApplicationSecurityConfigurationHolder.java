package com.sterlite.demo.spring.security.config;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
import org.springframework.security.ldap.userdetails.UserDetailsContextMapper;


//@Configuration
//@Profile("DEV_STANDALONE_H2_TEST_LDAP")
public class TestApplicationSecurityConfigurationHolder {
private static final Logger LOG = LoggerFactory.getLogger(TestApplicationSecurityConfigurationHolder.class);
/*
@EnableGlobalAuthentication
@Profile("DEV_STANDALONE_H2_TEST_LDAP")
public static class AuthConfigure {

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        LOG.info("#################");
        LOG.info("TEST");
        LOG.info("configuring ldap authenticaton");
        LOG.info("#################");

        auth
                .ldapAuthentication()
                .userDetailsContextMapper(ldapUserContextMapper())
                .contextSource(contextSource())
                .userDnPatterns("cn={0},ou=people")
                .groupSearchBase("ou=groups")
                .passwordCompare()
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .passwordAttribute("userPassword");
    }

    @Bean
    public DefaultSpringSecurityContextSource contextSource() {
        LOG.info("configuring embedded LDAP context source");
        DefaultSpringSecurityContextSource contextSource = new DefaultSpringSecurityContextSource(
                Arrays.asList("ldap://localhost:8389/"), "dc=springframework,dc=org");
        contextSource.afterPropertiesSet();
        return contextSource;
    }

    @Bean
    public LdapTemplate ldapTemplate(){
        return new LdapTemplate(contextSource());
    }

    @Bean
    public UserDetailsContextMapper ldapUserContextMapper() {
        return new AccountLdapContextMapper();
    }
}*/
}