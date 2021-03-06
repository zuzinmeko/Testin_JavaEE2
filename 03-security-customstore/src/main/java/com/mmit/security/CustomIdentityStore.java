package com.mmit.security;

import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

import com.mmit.sec.entity.Users;
import com.mmit.sec.service.UserService;

@ApplicationScoped
public class CustomIdentityStore implements IdentityStore {
	@Inject
	private UserService service;
	
	@Inject
	private Pbkdf2PasswordHash encoder;
	
	@Override
	public CredentialValidationResult validate(Credential credential) {
		UsernamePasswordCredential nameandpass=(UsernamePasswordCredential) credential;
		
		Users user=service.findByLogId(nameandpass.getCaller());
		
		if(user== null) {
			throw new AppException("Incorrect login id");
		}
		if(!encoder.verify(nameandpass.getPassword().getValue(), user.getPassword())) {
			throw new AppException("Incorrect password");
		}
		return new CredentialValidationResult(user.getEmail(),Set.of(user.getRole().name()));
	}
}
