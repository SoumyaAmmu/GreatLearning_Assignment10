package com.greatlearning.offlineuser.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.offlineuser.feignclients.OfflineUserClient;
import com.greatlearning.offlineuser.model.MenuCard;

@RestController
public class OfflineUserController {
	
	@Autowired
	OfflineUserClient offlineUserClient;
	
	@GetMapping("/getMenu")
	public List<MenuCard> getMenu() {
		return offlineUserClient.getMenu();
	}
	
	@PostMapping("/postPaymentMethod")
	public String postPaymentMethod(String paymentmethod) {
		if(paymentmethod.equalsIgnoreCase("CARD")) {
			return "Payment done by Card";
		}else if(paymentmethod.equalsIgnoreCase("CASH")) {
			return "Payment done by Cash" ;
		}else {
			return "Invalid Payment Method" ;
		}
	}
}
