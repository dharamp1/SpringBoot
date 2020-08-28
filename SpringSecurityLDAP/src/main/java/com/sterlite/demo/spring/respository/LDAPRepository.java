package com.sterlite.demo.spring.respository;

import java.util.List;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Repository;
import static org.springframework.ldap.query.LdapQueryBuilder.query;

/**
 * @author dharmaraj.pawale@sterlite.com
 * @copyright Sterlite Technologies Ltd.
 * @creationdate 20-Aug-2020
 */
@Repository
public class LDAPRepository {
	
	@Autowired
    private LdapTemplate ldapTemplate;

    /**
     * Retrieves all the persons in the ldap server
     * @return list of person names
     */
    public List<String> getAllPersonNames() {
        return ldapTemplate.search(
                query().where("objectclass").is("person"),
                new AttributesMapper<String>() {
                    public String mapFromAttributes(Attributes attrs)
                            throws NamingException {
                        return (String) attrs.get("cn").get();
                    }
                });
    }
}
