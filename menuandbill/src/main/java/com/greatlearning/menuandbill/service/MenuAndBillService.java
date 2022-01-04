package com.greatlearning.menuandbill.service;

import java.util.List;

import com.greatlearning.menuandbill.entity.MenuCard;
import com.greatlearning.menuandbill.entity.MonthlySalesReport;

public interface MenuAndBillService {
	
	List<MenuCard> getMenu();
	
	List<MenuCard> getItemByIds(List<Integer> seq_num);
	
	List<MonthlySalesReport> getMonthlySalesReport();
	
	
}
