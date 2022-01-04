package com.greatlearning.offlineuser.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.greatlearning.offlineuser.model.MenuCard;

@FeignClient(url = "http://localhost:8086", name = "OfflineUser-Client")
public interface OfflineUserClient {
	
	@GetMapping("/getMenu")
	public List<MenuCard> getMenu();
	
		
}
