package com.greatlearning.menuandbill.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class MenuCard {

	@Id
	@Column
	private int seq_num;
	
	@Column
	private String item_name;
	
	@Column
	private int price;
	
		public MenuCard() {
		super();
		
	}

	public MenuCard(int seq_num, String item_name, int price) {
		super();
		this.seq_num = seq_num;
		this.item_name = item_name;
		this.price = price;
	}

	public int getSeq_num() {
		return seq_num;
	}

	public String getItem_name() {
		return item_name;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "MenuCard [seq_num=" + seq_num + ", item_name=" + item_name + ", price=" + price + "]";
	}
	
	
}
