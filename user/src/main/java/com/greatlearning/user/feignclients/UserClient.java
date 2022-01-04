package com.greatlearning.user.feignclients;

import java.text.ParseException;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.user.model.MenuCard;

@FeignClient(url = "http://localhost:8086", name = "User-Client")
public interface UserClient {
	
	@GetMapping("/getMenu")
	public List<MenuCard> getMenu();
	
	@PostMapping("/getItemByIds")
	public List<MenuCard> getItemByIds(@RequestBody List<Integer> seq_num);
	
	@PostMapping("/getFinalBill")
	public int getFinalBillBySelectingItemsbyIds(@RequestBody List<Integer> seq_num);
	
	@PostMapping("/getFinalBillForMultipleItems")
	public int getFinalBillForSelectedItems(@RequestParam("seq_num") List<Integer> seq_num,
			@RequestParam("numberforitem") List<Integer> numberforitem);
	
	@PostMapping("/bookYourTable")
	public String getTableBooked(@RequestParam int person,@RequestParam String bookingDate ) throws ParseException;
}
