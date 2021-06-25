package com.mmit.sec.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

import com.mmit.sec.entity.Users;

@Stateless
public class UserService {
	@PersistenceContext
	private EntityManager em;
	@Inject
	private Pbkdf2PasswordHash encoder;
	public void save(Users user) {
		user.setPassword(encoder.generate(user.getPassword().toCharArray()));
		em.persist(user);
	}
	public Users findByLogId(String email) {
		TypedQuery<Users> query=em.createNamedQuery("Users.findLoginId", Users.class);
		query.setParameter("email", email);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			// TODO: handle exception
		}
		return null;
	}
	
}
