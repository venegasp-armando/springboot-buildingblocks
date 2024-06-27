package com.stacksimplify.restservices.controller;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stacksimplify.restservices.dtos.UserDtoV1;
import com.stacksimplify.restservices.dtos.UserDtoV2;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.services.UserService;

import jakarta.validation.constraints.Min;

@RestController
@RequestMapping("/versioning/uri/user")
public class UserUriVersioningController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping({"/v1.0/{id}", "/v1.1/{id}"})
	public UserDtoV1 getUserById1(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException  {
		Optional<User> user = Optional.of(userService.getUserById(id)
				.orElseThrow(() -> new UserNotFoundException("User not found")));
		
		UserDtoV1 userDto = modelMapper.map(user.get(), UserDtoV1.class);
		return userDto;
	}
	
	@GetMapping({"/v2.0/{id}"})
	public UserDtoV2 getUserById2(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException  {
		Optional<User> user = Optional.of(userService.getUserById(id)
				.orElseThrow(() -> new UserNotFoundException("User not found")));
		
		UserDtoV2 userDto = modelMapper.map(user.get(), UserDtoV2.class);
		return userDto;
	}
}
