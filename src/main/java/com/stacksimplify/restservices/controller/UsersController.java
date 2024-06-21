package com.stacksimplify.restservices.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stacksimplify.restservices.entities.Users;
import com.stacksimplify.restservices.services.UsersService;

@RestController
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	@GetMapping("/users")
	public List<Users> getAllUsers(){
		return usersService.getAllUsers();
	}
	
	@PostMapping("/users")
	public Users createUsers(@RequestBody Users users) {
		return usersService.createUsers(users);
	}
	
	@GetMapping("/users/{id}")
	public Optional<Users> getUsersById(@PathVariable("id") Long id) {
		return usersService.getUsersById(id);
	}
	
	@PutMapping("/users/{id}")
	public Users updateUsersById(@PathVariable("id") Long id, @RequestBody Users users) {
		return usersService.updateUsersById(id, users);
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUsersById(@PathVariable("id") Long id) {
		usersService.deleteUsersById(id);
	}
	
	@GetMapping("/users/un/{username}")
	public Users getUsersById(@PathVariable("username") String userName) {
		return usersService.getUsersByUserName(userName);
	}
}
