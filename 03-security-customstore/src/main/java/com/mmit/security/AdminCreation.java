package com.mmit.security;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.mmit.sec.entity.Users;
import com.mmit.sec.entity.Users.Role;
import com.mmit.sec.service.UserService;

@ApplicationScoped
@Singleton
@Startup
public class AdminCreation {
	@Inject
	private UserService service;
	@PostConstruct
	private void init() {
		Users admin=new Users();
		admin.setEmail("ywk@gmail.com");
		admin.setPassword("12345678");
		admin.setRole(Role.Admin);
		admin.setUserName("ywk");
		service.save(admin);
	}
}
