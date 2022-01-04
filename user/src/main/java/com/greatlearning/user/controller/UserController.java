package com.greatlearning.user.controller;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.user.feignclients.UserClient;
import com.greatlearning.user.feignclients.UserClientForLog;
import com.greatlearning.user.model.AuditLog;
import com.greatlearning.user.model.MenuCard;
import com.greatlearning.user.resttemplateclients.UserRestTemplateClient;

@RestController
public class UserController {
	
	@Autowired
	UserRestTemplateClient userRestTemplateClient;
	
	@Autowired
	UserClient userClient;
	
	@Autowired
	UserClientForLog userClientForLog;
	
	@PostMapping("/FeedbackPlease")
	public String FeedbackLog(@RequestBody AuditLog auditLog) {
		return userClientForLog.saveLog(auditLog);
	}
	
	@GetMapping("/getMenu")
	public List<MenuCard> getMenu() {
		return userClient.getMenu();
	}
	
	@PostMapping("/getItemByIds")
	public List<MenuCard> getItemByIds(@RequestBody List<Integer> seq_num){
		return userClient.getItemByIds(seq_num);
	}
	
	@PostMapping("/getFinalBill")
	public int getFinalBillBySelectingItemsbyIds(@RequestBody List<Integer> seq_num) {
		return userClient.getFinalBillBySelectingItemsbyIds(seq_num);
	}
	
	
	@PostMapping("/getFinalBillForMultipleItems")
	public int getFinalBillForSelectedItems(@RequestParam("seq_num") List<Integer> seq_num, 
											@RequestParam("numberforitem") List<Integer> numberforitem) {
		return userClient.getFinalBillForSelectedItems(seq_num, numberforitem);
	}
	
	@PostMapping("/bookYourTable")
	public String getTableBooked(@RequestParam int person, @RequestParam String bookingDate ) throws ParseException{
		return userClient.getTableBooked(person, bookingDate);
	}
}
