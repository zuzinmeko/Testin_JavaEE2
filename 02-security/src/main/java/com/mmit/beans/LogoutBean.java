package com.mmit.beans;

import javax.faces.annotation.RequestCookieMap;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestCookieMap
public class LogoutBean {
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/index.xhtml? faces-redirect=true";
	}
}
