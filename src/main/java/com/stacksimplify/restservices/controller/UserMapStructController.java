package com.stacksimplify.restservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stacksimplify.restservices.dtos.UserMsDto;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.mappers.UserMapper;
import com.stacksimplify.restservices.repositories.UserRepository;

import jakarta.validation.constraints.Min;

@RestController
@RequestMapping("/mapstruct/user")
public class UserMapStructController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	@GetMapping
	public List<UserMsDto> getAllUserDtos(){
		return userMapper.usersToUserMsDtos(userRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public UserMsDto getUserById(@PathVariable("id") Long id) throws UserNotFoundException {
		User user= userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User not found"));
		return userMapper.userToUserMsDto(user);
	}
}
