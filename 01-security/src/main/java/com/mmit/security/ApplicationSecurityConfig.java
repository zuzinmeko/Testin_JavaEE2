package com.mmit.security;

import javax.annotation.security.DeclareRoles;
import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;

@ApplicationScoped
@DeclareRoles({"Admin","Staff"})
@BasicAuthenticationMechanismDefinition
@DatabaseIdentityStoreDefinition(
		dataSourceLookup = "java:/jsf_user_ds",
		groupsQuery = "SELECT role FROM Users WHERE loginId=?",
		callerQuery = "SELECT password FROM Users WHERE loginId=?"
		
		)
public class ApplicationSecurityConfig {

}
