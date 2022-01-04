package com.greatlearning.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.crud.entity.Authorities;
import com.greatlearning.crud.entity.User;
import com.greatlearning.crud.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/userRegistration")
	public String userRegistration(@RequestBody User user) {
		return userService.userRegistration(user);
	}
	
	@PostMapping("/addAuthorities")
	public String addAuthorities(@RequestBody Authorities authorities) {
		return userService.addAuthorities(authorities);
	}
	
	@PutMapping("/updateUserAuthority")
	public String updateAuthority(String authority,Long id) {
		return userService.updateAuthority(authority, id);
	}
	
	@PutMapping("/updateUserMobileNumber")
	public String updateUserMobileNumber(Long mobilenumber,Long id) {
		return userService.updateUserMobileNumber(mobilenumber, id);
	}
	
	@PutMapping("/updateUserEmailId")
	public String updateUserEmailId(String emailid,Long id) {
		return userService.updateUserEmailId(emailid, id);
	}
	
	@PutMapping("/updateUserPassword")
	public String updateUserPassword(String password,Long id) {
		return userService.updateUserPassword(password, id);
	}
	
	@DeleteMapping("/deleteAllUsers")
	public String deleteAllUsers() {
		return userService.deleteAllUsers();
	}
	
	@DeleteMapping("/deleteUserByUserId")
	public String deleteUserById(Long userid) {
		return userService.deleteUserByUserId(userid);
	}
	
	@DeleteMapping("/deleteAuthoritiesById")
	public String deleteAuthoritiesById(Long id) {
		return userService.deleteAuthoritiesById(id);
	}
	
	@DeleteMapping("/deleteAllAuthorities")
	public String deleteAllAuthorities() {
		return userService.deleteAuthorities();
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/getUserByUserId")
	public Optional<User> getUserByUserId(Long userid) {
		return userService.getUserByUserId(userid);
	}
	
	@GetMapping("/getAllAuthorities")
	public List<Authorities> getAllAuthorities() {
		return userService.getAllAuthorities();
	}
}

