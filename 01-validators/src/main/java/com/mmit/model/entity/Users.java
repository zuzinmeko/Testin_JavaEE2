package com.mmit.model.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.EnumType.STRING;

/**
 * Entity implementation class for Entity: Users
 *
 */
@Entity
@NamedQuery(name="Users.findById",query="SELECT u FROM Users u WHERE u.loginId=:login")
public class Users implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String userName;
	@Column(unique = true)
	@NotEmpty(message="* Required login id,please fill")
	private String loginId;
	private String password;
	
	@Enumerated(STRING)
	private Role role;
	
	@CreationTimestamp
	private LocalDate register_at;
	@UpdateTimestamp
	private LocalDate update_at;
	
	public enum Role{
		Staff,Member
	}
	public Users() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public LocalDate getRegister_at() {
		return register_at;
	}
	public void setRegister_at(LocalDate register_at) {
		this.register_at = register_at;
	}
	public LocalDate getUpdate_at() {
		return update_at;
	}
	public void setUpdate_at(LocalDate update_at) {
		this.update_at = update_at;
	}
   
	
}
