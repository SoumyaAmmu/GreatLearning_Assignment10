package com.greatlearning.user.model;

import java.util.Date;

public class AuditLog {
	
	private Integer id;
	private Date createDate;
	private String discription;

	public Integer getId() {
		return id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public String getDiscription() {
		return discription;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	@Override
	public String toString() {
		return "AuditLog [id=" + id + ", createDate=" + createDate + ", discription=" + discription + "]";
	}


}
