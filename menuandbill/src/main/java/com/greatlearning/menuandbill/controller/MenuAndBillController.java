package com.greatlearning.menuandbill.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.menuandbill.entity.MenuCard;
import com.greatlearning.menuandbill.entity.MonthlySalesReport;
import com.greatlearning.menuandbill.serviceImpl.MenuAndBillServiceImpl;

@RestController
public class MenuAndBillController {
	
	@Autowired
	MenuAndBillServiceImpl menuAndBillServiceImpl;
	
	@GetMapping("/getMenu")
	public List<MenuCard> getMenu() {
		return menuAndBillServiceImpl.getMenu();
	}
	
	@PostMapping("/getItemByIds")
	public List<MenuCard> getItemByIds(@RequestBody List<Integer> seq_num){
		return menuAndBillServiceImpl.getItemByIds(seq_num);
	}
	
	@PostMapping("/getFinalBill")
	public int getFinalBillBySelectingItemsbyIds(@RequestBody List<Integer> seq_num) {
		List<MenuCard> menucard = menuAndBillServiceImpl.getItemByIds(seq_num);
		return menuAndBillServiceImpl.getBill(menucard);
		
	}
	
	@PostMapping("/getFinalBillForMultipleItems")
	public int getFinalBillBySelectingMultipleItems(@RequestParam List<Integer> seq_num,@RequestParam List<Integer> numberforitems ) {
		List<MenuCard> menucard = menuAndBillServiceImpl.getItemByIds(seq_num);
		return menuAndBillServiceImpl.getBillForMultipleItem(menucard,numberforitems);
		
	}
	
	@PostMapping("/bookYourTable")
	public String getTableBooked(@RequestParam int person,String bookingDate ) throws ParseException {
		return menuAndBillServiceImpl.tableBooking(person, bookingDate);
		
	}
	
	@GetMapping("/getMonthlySalesReport")
	public List<MonthlySalesReport> getMonthlySalesReport() {
		return menuAndBillServiceImpl.getMonthlySalesReport();
	}

}
