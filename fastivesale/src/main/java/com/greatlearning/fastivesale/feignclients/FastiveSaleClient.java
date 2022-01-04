package com.greatlearning.fastivesale.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.greatlearning.fastivesale.model.MenuCard;

@FeignClient(url = "http://localhost:8086", name = "FastiveSale-Client")
public interface FastiveSaleClient {
	
	@PostMapping("/getFinalBill")
	public int getFinalBillBySelectingItemsbyIds(@RequestBody List<Integer> seq_num);
	
}
