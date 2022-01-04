package com.greatlearning.admin.feignclients;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.admin.entity.User;
import com.greatlearning.admin.entity.Authorities;

@FeignClient(url = "http://localhost:8085", name = "Admin-Client-For-CRUD")
public interface AdminClientForCrud {
	
	@PostMapping("/userRegistration")
	public String userRegistration(@RequestBody User user);
	
	@PostMapping("/addAuthorities")
	public String addAuthorities(@RequestBody Authorities authorities);

	@PutMapping("/updateUserAuthority")
	public String updateAuthority(@RequestParam String authority,
								  @RequestParam Long id);
		
	@PutMapping("/updateUserMobileNumber")
	public String updateUserMobileNumber(@RequestParam Long mobilenumber,
										 @RequestParam Long id);
	
	
	@PutMapping("/updateUserEmailId")
	public String updateUserEmailId(@RequestParam String emailid, @RequestParam Long id);
	
	@PutMapping("/updateUserPassword")
	public String updateUserPassword(@RequestParam String password,@RequestParam Long id);
	
	@DeleteMapping("/deleteAllUsers")
	public String deleteAllUsers() ;
	
	@DeleteMapping("/deleteUserByUserId")
	public String deleteUserById(@RequestParam Long userid);
	
	@DeleteMapping("/deleteAuthoritiesById")
	public String deleteAuthoritiesById(@RequestParam Long id);
	
	@DeleteMapping("/deleteAllAuthorities")
	public String deleteAllAuthorities() ;
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers();
	
	@GetMapping("/getUserByUserId")
	public Optional<User> getUserByUserId(@RequestParam Long userid);
	
	@GetMapping("/getAllAuthorities")
	public List<Authorities> getAllAuthorities();
}
