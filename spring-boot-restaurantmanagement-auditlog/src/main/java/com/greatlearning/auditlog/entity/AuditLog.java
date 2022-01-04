package com.greatlearning.auditlog.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AuditLog {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(columnDefinition = "date default sysdate")
	private Date createDate;
	
	@Column
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

	public AuditLog(Integer id, Date createDate, String discription) {
		super();
		this.id = id;
		this.createDate = createDate;
		this.discription = discription;
	}

	public AuditLog() {
		super();
	}
	
	
	
}
