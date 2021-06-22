package com.mmit.model.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;
import javax.print.DocFlavor.STRING;
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
	@NotEmpty(message = "Require email!")
	@Column(unique = true)
	private String email;
	private String password;
	private String userName;
	@CreationTimestamp
	private LocalDate create_at;
	@UpdateTimestamp
	private LocalDate update_at;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	public enum Role{
		Admin,Customer
	}
	

	public Users() {
		super();
	}
   
}
