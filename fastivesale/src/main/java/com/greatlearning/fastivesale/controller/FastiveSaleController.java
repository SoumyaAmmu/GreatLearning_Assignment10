package com.greatlearning.fastivesale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.fastivesale.feignclients.FastiveSaleClient;

@RestController
public class FastiveSaleController {
	
	@Autowired
	FastiveSaleClient fastiveSaleClient;
	
	@PostMapping("/getFinalBill")
	public double getFinalBillBySelectingItemsbyIds(@RequestBody List<Integer> seq_num, String offer_code) {
		if(offer_code.equalsIgnoreCase("FESTIVE50")){
			return (fastiveSaleClient.getFinalBillBySelectingItemsbyIds(seq_num))/2;
		}else{
			return fastiveSaleClient.getFinalBillBySelectingItemsbyIds(seq_num);
		}
	}
	
}
