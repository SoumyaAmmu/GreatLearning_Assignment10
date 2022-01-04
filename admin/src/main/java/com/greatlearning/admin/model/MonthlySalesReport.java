package com.greatlearning.admin.model;


public class MonthlySalesReport {
	
	private String month;
	
	private int total_sales;

	public String getMonth() {
		return month;
	}

	public int getTotal_sales() {
		return total_sales;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public void setTotal_sales(int total_sales) {
		this.total_sales = total_sales;
	}

	@Override
	public String toString() {
		return "MonthlySalesReport [month=" + month + ", total_sales=" + total_sales + "]";
	}
	
}
