package com.greatlearning.user.resttemplateclients;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.greatlearning.user.model.MenuCard;


@Service
public class UserRestTemplateClient {
	
	@Autowired
	RestTemplate restTemplate;
	
	ObjectMapper mapper = new ObjectMapper();
	
	@Async
	public CompletableFuture<List<MenuCard>> getMenu() {
		String bseURL = "http://localhost:8086/getMenu";
		List<MenuCard> menucard = (List<MenuCard>)restTemplate.getForObject(bseURL, MenuCard.class);
		return CompletableFuture.completedFuture(menucard);
		
//		ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity(bseURL, Object[].class);
//		Object[] objects = responseEntity.getBody();
//		return  Arrays.stream(objects)
//				  .map(object -> mapper.convertValue(object, MenuCard.class))
//				  .map(MenuCard::getItem_name)
//				  .collect(Collectors.toList());
		
	}
}
