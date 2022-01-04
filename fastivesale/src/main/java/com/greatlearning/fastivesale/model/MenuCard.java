package com.greatlearning.fastivesale.model;

public class MenuCard {
	private int seq_num;
	
	private String item_name;
	
	private int price;

	public int getSeq_num() {
		return seq_num;
	}

	public String getItem_name() {
		return item_name;
	}

	public int getPrice() {
		return price;
	}

	public void setSeq_num(int seq_num) {
		this.seq_num = seq_num;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "MenuCard [seq_num=" + seq_num + ", item_name=" + item_name + ", price=" + price + "]";
	}
	
	
}
