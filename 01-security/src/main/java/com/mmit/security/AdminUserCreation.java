package com.mmit.security;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.mmit.model.entity.Users;
import com.mmit.model.entity.Users.Role;
import com.mmit.model.service.UserService;

@ApplicationScoped
@Singleton
@Startup
public class AdminUserCreation {
	
	@Inject
	private UserService service;
	@PostConstruct
	private void init() {
		Users admin=new Users();
		admin.setUserName("YWK");
		admin.setLoginId("ywk@gmail.com");
		admin.setPassword("12345678");
		admin.setRole(Role.Admin);
		service.create(admin);
		
		Users staff=new Users();
		staff.setUserName("tms");
		staff.setLoginId("tms@gmail.com");
		staff.setPassword("12345678");
		staff.setRole(Role.Staff);
		service.create(staff);
	}
}
