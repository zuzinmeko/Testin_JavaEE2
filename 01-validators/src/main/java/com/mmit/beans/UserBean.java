package com.mmit.beans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.mmit.model.entity.Users;
import com.mmit.model.service.Userservice;



@RequestScoped
@Named
public class UserBean {
	@Inject
	private Userservice service;
	
	private Users user;
	
	@PostConstruct
	private void init() {
		user=new Users();
	}
	
	public  void checkLogIn() {
		FacesContext context=FacesContext.getCurrentInstance();
		Users tmp_obj=  service.findByLogInID(user.getLoginId());
		boolean flag=true;
		if(tmp_obj!=null) {
			if(!tmp_obj.getPassword().equals(user.getPassword())) {
				//incorrect password
				context.addMessage("loginForm:loginId", new FacesMessage("* incorrect password"));
				flag=false;
			}
			else {
				//correct password
				user=tmp_obj;
				flag=true;
			}
		}else {
			//new user
			context.addMessage("loginForm:loginId", new FacesMessage("* user doesnot exist!"));
			flag=false;
		}
		if(!flag) {
			context.isValidationFailed();//declared validition fail to faces context
		}
		
		
		
	}
	
	public String login() {
		FacesContext context=FacesContext.getCurrentInstance();
		
		if(context.isValidationFailed()) {
			return null;
			}
		else {
			return "/views/home.xhtml?faces-redirect=true";
		}
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	
}
