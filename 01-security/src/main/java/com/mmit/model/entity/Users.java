package com.mmit.model.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Entity implementation class for Entity: Users
 *
 */
@Entity

public class Users implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@NotEmpty(message="Require login id")
	@Column(unique = true)
	private String loginId;
	private String userName;
	@NotEmpty(message="Require password")
	private String password;
	@Enumerated(EnumType.STRING)
	private Role role;
	@CreationTimestamp
	private LocalDate create_at;
	@UpdateTimestamp
	private LocalDate update_at;
	
	
	public enum Role{
		Admin,Staff
	}
	public Users() {
		super();
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public LocalDate getCreate_at() {
		return create_at;
	}
	public void setCreate_at(LocalDate create_at) {
		this.create_at = create_at;
	}
	public LocalDate getUpdate_at() {
		return update_at;
	}
	public void setUpdate_at(LocalDate update_at) {
		this.update_at = update_at;
	}
   
}
