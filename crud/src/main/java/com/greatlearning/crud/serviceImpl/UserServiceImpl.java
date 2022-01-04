package com.greatlearning.crud.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.crud.entity.Authorities;
import com.greatlearning.crud.entity.User;
import com.greatlearning.crud.repository.AuthoritiesRepository;
import com.greatlearning.crud.repository.UserRepository;
import com.greatlearning.crud.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AuthoritiesRepository authoritiesRepository;
	
	@Override
	public String userRegistration(User user) {
		Optional<User> optionaluser= userRepository.findById(user.getUserid());
		if(optionaluser.isPresent()) {
			throw new RuntimeException("User is already available for userid " + user.getUserid());
			//return "User is already availabe for userid " + user.getUserid();
		}else {
			userRepository.saveAndFlush(user);
			return " Congratulations !!! User has been created ";
		}
	}

	@Override
	public String addAuthorities(Authorities authorities) {
		Optional<User> optionaluser= userRepository.findById(authorities.getUser().getUserid());
		if(optionaluser.isPresent()) {
		authoritiesRepository.saveAndFlush(authorities);
		return "Authority has been created for user " + authorities.getUser().getUserid();
		}else {
			return "User does not exist for user id " + authorities.getUser().getUserid();
		}
			
	}

	@Override
	public String updateAuthority(String authority,Long id) {
		Optional<Authorities> optionalauthorities= authoritiesRepository.findById(id);
		if(optionalauthorities.isPresent()) {
			Authorities authorities = optionalauthorities.get();
			authorities.setAuthority(authority);
			authoritiesRepository.saveAndFlush(authorities);
			
			return "Role got updated for id : " + id;
		}else {
			return "No role is available for id " + id;
		}
		
	}

	@Override
	public List<Authorities> getAllAuthorities() {
		return authoritiesRepository.findAll();
	}

	@Override
	public String deleteAllUsers() {
		userRepository.deleteAll();
		return "All users got deleted";
	}

	

	@Override
	public List<User> getAllUsers() {
		System.out.println("Please delete the record from authorities , before deleting this user");
		return userRepository.findAll();
	}

	@Override
	public String deleteUserByUserId(Long userid) {
		Optional<User> optionaluser= userRepository.findById(userid);
		if(optionaluser.isPresent()) {
			System.out.println("Please delete the record from authorities for this user, before deleting this user");
			userRepository.deleteById(userid);
			return "User deleted for Id : " + userid;
		}else {
			throw new RuntimeException("User does not exist for userid " + userid);
			//return "User not exist for Id : " + userid;
		}
	}

	@Override
	public String deleteAuthoritiesById(Long id) {
		Optional<Authorities> optionalauthorities= authoritiesRepository.findById(id);
		if(optionalauthorities.isPresent()) {
			authoritiesRepository.deleteById(id);
			return "Authorities deleted for Id : " + id;
		}else {
			return "Authorities not exist for Id : " + id;
		}
	}

	@Override
	public String deleteAuthorities() {
		authoritiesRepository.deleteAll();
		return "All Authorities has been deleted";
	}

	@Override
	public Optional<User> getUserByUserId(Long userid) {
		return userRepository.findById(userid);
	}

	@Override
	public String updateUserMobileNumber(Long mobilenumber, Long id) {
		Optional<User> optionaluser= userRepository.findById(id);
		if(optionaluser.isPresent()) {
			User user = optionaluser.get();
			user.setMobilenumber(mobilenumber);
			userRepository.saveAndFlush(user);
			
			return "Mobile number got updated for user id : " + id;
		}else {
			throw new RuntimeException("User is not available for userid " + id);
			//return "No user is available for user id " + id;
		}
			
	}

	@Override
	public String updateUserEmailId(String emailid, Long id) {
		Optional<User> optionaluser= userRepository.findById(id);
		if(optionaluser.isPresent()) {
			User user = optionaluser.get();
			user.setEmailid(emailid);
			userRepository.saveAndFlush(user);
			
			return "Email Id got updated for user id : " + id;
		}else {
			throw new RuntimeException("User is not available for userid " + id);
			//return "No user is available for user id " + id;
		}
			
	}
	
	@Override
	public String updateUserPassword(String password, Long id) {
		Optional<User> optionaluser= userRepository.findById(id);
		if(optionaluser.isPresent()) {
			User user = optionaluser.get();
			user.setPassword(password);
			userRepository.saveAndFlush(user);
			
			return "Password got updated for user id : " + id;
		}else {
			throw new RuntimeException("User is not available for userid " + id);
			//return "No user is available for user id " + id;
		}
			
	}

}
