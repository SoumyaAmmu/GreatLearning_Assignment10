package com.greatlearning.menuandbill.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Authorities {
 
	@Id
	@Column
	private Long id;
	
	@Column
	private String authority ;
	
	@OneToOne
	private User user;

	public Long getId() {
		return id;
	}

	public String getAuthority() {
		return authority;
	}

	public User getUser() {
		return user;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public void setUser(User user) {
		this.user = user;
	}

//	public Authorities(String authority, User user) {
//		super();
//		this.authority = authority;
//		this.user = user;
//	}

	

	
}
