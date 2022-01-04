package com.greatlearning.menuandbill.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MonthlySalesReport {
	
	@Id
	@Column
	private String month;
	
	@Column
	private int total_sales;

	public String getMonth() {
		return month;
	}

	public int getTotal_sales() {
		return total_sales;
	}

	public MonthlySalesReport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MonthlySalesReport(String month, int total_sales) {
		super();
		this.month = month;
		this.total_sales = total_sales;
	}

}
