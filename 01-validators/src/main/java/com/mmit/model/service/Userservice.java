package com.mmit.model.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.mmit.model.entity.Users;

@Stateless
public class Userservice {
	@PersistenceContext
	private EntityManager em;

	public Users findByLogInID(String loginId) {
		TypedQuery<Users>query=em.createNamedQuery("Users.findById", Users.class);
		query.setParameter("login", loginId);
		try {
			return query.getSingleResult();
		}catch(NoResultException e) {
			
		}
		return null;
	}

}
