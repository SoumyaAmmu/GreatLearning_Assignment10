package com.greatlearning.crud.service;

import java.util.List;
import java.util.Optional;

import com.greatlearning.crud.entity.Authorities;
import com.greatlearning.crud.entity.User;

public interface UserService {
	String userRegistration(User user);
	
	String deleteAllUsers();
	
	String deleteUserByUserId(Long userid);
	
	List<User> getAllUsers();
	
	Optional<User> getUserByUserId(Long userid);
	
	String updateUserMobileNumber(Long mobilenumber,Long id);
	
	String updateUserEmailId(String emailid,Long id);
	
	String updateUserPassword(String password,Long id);
	
	String addAuthorities(Authorities Authorities);
	
	String updateAuthority(String authority,Long id);
	
	List<Authorities> getAllAuthorities();
	
	String deleteAuthorities();
	
	String deleteAuthoritiesById(Long id);

}
