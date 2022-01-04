package com.greatlearning.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class User {
	
		@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userid;
	
	@Column
	private String password;
	
	@Column
	private String fullname;
	
	@Column
	private Long mobilenumber;
	
	@Column
	private String emailid;
	
	@Column(columnDefinition = "integer default 1")
	private int enabled;
	
	public User() {
		super();
	}

	public User(Long userid, String password, String fullname, Long mobilenumber, String emailid, int enabled) {
		super();
		this.userid = userid;
		this.password = password;
		this.fullname = fullname;
		this.mobilenumber = mobilenumber;
		this.emailid = emailid;
		this.enabled = enabled;
	}

	public Long getUserid() {
		return userid;
	}

	public String getPassword() {
		return password;
	}

	public String getFullname() {
		return fullname;
	}

	public Long getMobilenumber() {
		return mobilenumber;
	}

	public String getEmailid() {
		return emailid;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public void setMobilenumber(Long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailid == null) ? 0 : emailid.hashCode());
		result = prime * result + enabled;
		result = prime * result + ((fullname == null) ? 0 : fullname.hashCode());
		result = prime * result + ((mobilenumber == null) ? 0 : mobilenumber.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (emailid == null) {
			if (other.emailid != null)
				return false;
		} else if (!emailid.equals(other.emailid))
			return false;
		if (enabled != other.enabled)
			return false;
		if (fullname == null) {
			if (other.fullname != null)
				return false;
		} else if (!fullname.equals(other.fullname))
			return false;
		if (mobilenumber == null) {
			if (other.mobilenumber != null)
				return false;
		} else if (!mobilenumber.equals(other.mobilenumber))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}

	

}

