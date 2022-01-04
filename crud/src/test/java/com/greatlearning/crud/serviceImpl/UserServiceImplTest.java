package com.greatlearning.crud.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.greatlearning.crud.entity.User;
import com.greatlearning.crud.repository.UserRepository;

@SpringBootTest
public class UserServiceImplTest {

	List<User> users = new ArrayList<User>();
	
	@Mock
	UserRepository userRepository;
	
	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	@BeforeEach
	public void userSetup() {
		users.add(new User(12345l, "Pswd@123", "Ram Mishra", 9108679861l, "n4you@gmail.com", 1));
		users.add(new User(12346l, "Pswd@321", "Raj B", 9234569861l, "b4you@gmail.com", 1));
	}
	
	@Test
	public void shouldUserGetCreated() {
		User userCreated = new User(123l, "Pswd@1", "Ram M", 9154679861l, "n4u@gmail.com", 1);
		Mockito.when(userRepository.save(userCreated)).thenReturn(userCreated);
		userServiceImpl.userRegistration(userCreated);
		assertEquals(123l,userCreated.getUserid());
		users.add(userCreated);
		assertEquals(3, users.size());
	}
	
	@Test
	@DisplayName("Testing User Creation for existing user : Test should through Runtime Exception with valid message")
	public void shouldThrowErrorForUserCreationWithExistingUserId() {
		User existingUser = new User(12346l, "Pswd@321", "Raj B", 9234569861l, "b4you@gmail.com", 1);
		Optional<User> optionaluser = Optional.ofNullable(existingUser);
		Mockito.when(userRepository.findById(existingUser.getUserid())).thenReturn(optionaluser);
		RuntimeException ex = assertThrows(RuntimeException.class, () -> userServiceImpl.userRegistration(existingUser));
	    assertTrue(ex.getMessage().contains("User is already available"));
	}
	
	@Test
	public void shouldGetAllUsers() {
		userServiceImpl.getAllUsers();
		Mockito.verify(userRepository).findAll();
	}
	
	@Test
	@DisplayName("Testing get user by Id: User should get retrieved")
	public void shouldGetUserById() {
		User existingUser = new User(12346l, "Pswd@321", "Raj B", 9234569861l, "b4you@gmail.com", 1);
		userServiceImpl.getUserByUserId(existingUser.getUserid());
		Mockito.verify(userRepository).findById(existingUser.getUserid());
	}
	
	@Test
	public void shouldDeleteAllUsers() {
		userServiceImpl.deleteAllUsers();
		Mockito.verify(userRepository).deleteAll();
	}
	
	@Test
	@DisplayName("Testing user Deletion for Existing User : User should get deleted")
	public void shouldDeleteUserByIdForExistingUser() {
		User existingUser = new User(12346l, "Pswd@321", "Raj B", 9234569861l, "b4you@gmail.com", 1);
		Optional<User> optionaluser = Optional.ofNullable(existingUser);
		Mockito.when(userRepository.findById(existingUser.getUserid())).thenReturn(optionaluser);
		userServiceImpl.deleteUserByUserId(existingUser.getUserid());
		Mockito.verify(userRepository).deleteById(existingUser.getUserid());
	} 
	
	@Test
	@DisplayName("Testing user Deletion for non Existing User : Test should throw Runtime Exception with valid message")
	public void shouldDeleteUserByIdForNonExistingUser() {
		User newUser = new User(12346l, "Pswd@321", "Raj B", 9234569861l, "b4you@gmail.com", 1);
		Optional<User> optionaluser = Optional.empty();
		Mockito.when(userRepository.findById(newUser.getUserid())).thenReturn(optionaluser);
		RuntimeException ex = assertThrows(RuntimeException.class, () -> userServiceImpl.deleteUserByUserId(newUser.getUserid()));
	    assertTrue(ex.getMessage().contains("User does not exist"));
	} 
	
	@Test
	@DisplayName("Testing mobile number modification for Existing User : Mobile  Number should get updated")
	public void shouldModifyMobileNumberForExistingUser() {
		User existingUser = new User(12346l, "Pswd@321", "Raj B", 9234569861l, "b4you@gmail.com", 1);
		Optional<User> optionaluser = Optional.ofNullable(existingUser);
		Mockito.when(userRepository.findById(existingUser.getUserid())).thenReturn(optionaluser);
		userServiceImpl.updateUserMobileNumber(9999998888l, existingUser.getUserid());
		assertEquals(9999998888l,existingUser.getMobilenumber());
	} 
	
	@Test
	@DisplayName("Testing mobile number modification for non Existing User : Test should throw Runtime Exception with valid message")
	public void shouldModifyMobileNumberForNonExistingUser() {
		User newUser = new User(12346l, "Pswd@321", "Raj B", 9234569861l, "b4you@gmail.com", 1);
		Optional<User> optionaluser = Optional.empty();
		Mockito.when(userRepository.findById(newUser.getUserid())).thenReturn(optionaluser);
		RuntimeException ex = assertThrows(RuntimeException.class, () -> userServiceImpl.updateUserMobileNumber(9999998888l, newUser.getUserid()));
	    assertTrue(ex.getMessage().contains("User is not available"));
	} 
	
	@Test
	@DisplayName("Testing Email Id modification for Existing User : Email Id should get updated")
	public void shouldModifyEmailIdForExistingUser() {
		User existingUser = new User(12346l, "Pswd@321", "Raj B", 9234569861l, "b4you@gmail.com", 1);
		Optional<User> optionaluser = Optional.ofNullable(existingUser);
		Mockito.when(userRepository.findById(existingUser.getUserid())).thenReturn(optionaluser);
		userServiceImpl.updateUserEmailId("ram@gmail.com", existingUser.getUserid());
		assertEquals("ram@gmail.com",existingUser.getEmailid());
	} 
	
	@Test
	@DisplayName("Testing Email Id modification for non Existing User : Test should throw Runtime Exception with valid message")
	public void shouldModifyEmailIdForNonExistingUser() {
		User newUser = new User(12346l, "Pswd@321", "Raj B", 9234569861l, "b4you@gmail.com", 1);
		Optional<User> optionaluser = Optional.empty();
		Mockito.when(userRepository.findById(newUser.getUserid())).thenReturn(optionaluser);
		RuntimeException ex = assertThrows(RuntimeException.class, () -> userServiceImpl.updateUserEmailId("ram@gmail.com", newUser.getUserid()));
	    assertTrue(ex.getMessage().contains("User is not available"));
	} 
	
	@Test
	@DisplayName("Testing Password modification for Existing User : Password should get updated")
	public void shouldModifyPasswordForExistingUser() {
		User existingUser = new User(12346l, "Pswd@321", "Raj B", 9234569861l, "b4you@gmail.com", 1);
		Optional<User> optionaluser = Optional.ofNullable(existingUser);
		Mockito.when(userRepository.findById(existingUser.getUserid())).thenReturn(optionaluser);
		userServiceImpl.updateUserPassword("pswd@ZP12", existingUser.getUserid());
		assertEquals("pswd@ZP12",existingUser.getPassword());
	} 
	
	@Test
	@DisplayName("Testing Password modification for non Existing User : Test should throw Runtime Exception with valid message")
	public void shouldModifyPasswordForNonExistingUser() {
		User newUser = new User(12346l, "Pswd@321", "Raj B", 9234569861l, "b4you@gmail.com", 1);
		Optional<User> optionaluser = Optional.empty();
		Mockito.when(userRepository.findById(newUser.getUserid())).thenReturn(optionaluser);
		RuntimeException ex = assertThrows(RuntimeException.class, () -> userServiceImpl.updateUserPassword("pswd@ZP12", newUser.getUserid()));
	    assertTrue(ex.getMessage().contains("User is not available"));
	} 
}

