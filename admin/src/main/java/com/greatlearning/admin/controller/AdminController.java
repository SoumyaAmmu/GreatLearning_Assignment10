package com.greatlearning.admin.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.admin.entity.Authorities;
import com.greatlearning.admin.entity.User;
import com.greatlearning.admin.feignclients.AdminClientForCrud;
import com.greatlearning.admin.feignclients.AdminClientForSales;
import com.greatlearning.admin.model.MonthlySalesReport;

@RestController
public class AdminController {
	
	@Autowired
	AdminClientForSales adminClientForSales;
	
	@Autowired
	AdminClientForCrud adminClientForCrud;
	
	@GetMapping("/getMonthlySalesReport")
	public List<MonthlySalesReport> getMonthlySalesReport(){
		return adminClientForSales.getMonthlySalesReport();
	}
	
	@PostMapping("/userRegistration")
	public String userRegistration(@RequestBody User user) {
		return adminClientForCrud.userRegistration(user);
	}
	
	@PostMapping("/addAuthorities")
	public String addAuthorities(@RequestBody Authorities authorities) {
		return adminClientForCrud.addAuthorities(authorities);
	}
	
	@PutMapping("/updateUserAuthority")
	public String updateAuthority(String authority,Long id) {
		return adminClientForCrud.updateAuthority(authority, id);
	}
	
	@PutMapping("/updateUserMobileNumber")
	public String updateUserMobileNumber(Long mobilenumber,Long id) {
		return adminClientForCrud.updateUserMobileNumber(mobilenumber, id);
	}
	
	@PutMapping("/updateUserEmailId")
	public String updateUserEmailId(String emailid,Long id) {
		return adminClientForCrud.updateUserEmailId(emailid, id);
	}
	
	@PutMapping("/updateUserPassword")
	public String updateUserPassword(String password,Long id) {
		return adminClientForCrud.updateUserPassword(password, id);
	}
	
	@DeleteMapping("/deleteAllUsers")
	public String deleteAllUsers() {
		return adminClientForCrud.deleteAllUsers();
	}
	
	@DeleteMapping("/deleteUserByUserId")
	public String deleteUserById(Long userid) {
		return adminClientForCrud.deleteUserById(userid);
	}
	
	@DeleteMapping("/deleteAuthoritiesById")
	public String deleteAuthoritiesById(Long id) {
		return adminClientForCrud.deleteAuthoritiesById(id);
	}
	
	@DeleteMapping("/deleteAllAuthorities")
	public String deleteAllAuthorities() {
		return adminClientForCrud.deleteAllAuthorities();
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers(){
		return adminClientForCrud.getAllUsers();
	}
	
	@GetMapping("/getUserByUserId")
	public Optional<User> getUserByUserId(Long userid){
		return adminClientForCrud.getUserByUserId(userid);
	}
	
	@GetMapping("/getAllAuthorities")
	public List<Authorities> getAllAuthorities(){
		return adminClientForCrud.getAllAuthorities();
	}
	
}
