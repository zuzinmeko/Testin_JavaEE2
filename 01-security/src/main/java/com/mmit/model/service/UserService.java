package com.mmit.model.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

import com.mmit.model.entity.Users;

@Stateless
public class UserService {
	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private Pbkdf2PasswordHash encoder;
	
	public void create(Users user) {
		user.setPassword(encoder.generate(user.getPassword().toCharArray()));
		em.persist(user);
		
	}

}
