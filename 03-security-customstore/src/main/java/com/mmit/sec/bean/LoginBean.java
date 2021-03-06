package com.mmit.sec.bean;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotEmpty;

import com.mmit.security.AppException;

@Named
@RequestScoped
public class LoginBean {
	
	@NotEmpty(message = "Require login Id")
	private String loginId;
	
	@NotEmpty(message = "Require password")
	private String password;
	
	@Inject
	private ExternalContext exContent;
	@Inject
	private SecurityContext securityContext;
	
		public String login() {
			try {
				HttpServletRequest req=(HttpServletRequest) exContent.getRequest();
				HttpServletResponse response=(HttpServletResponse) exContent.getResponse();
				UsernamePasswordCredential credential=new UsernamePasswordCredential(loginId, password);
				AuthenticationStatus status=securityContext.authenticate(req, response, AuthenticationParameters.withParams().credential(credential));
				
				if(status== AuthenticationStatus.SUCCESS)
					return "/index";
			} catch (AppException e) {
				FacesContext cxt=FacesContext.getCurrentInstance();
				cxt.addMessage(null, new FacesMessage(e.getMessage()));
			}
			return null;
		}
		public String getLoginId() {
			return loginId;
		}
		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
}
