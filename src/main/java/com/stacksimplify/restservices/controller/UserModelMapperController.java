package com.stacksimplify.restservices.controller;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stacksimplify.restservices.dtos.UserMmDto;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.services.UserService;

import jakarta.validation.constraints.Min;

@RestController
@RequestMapping("/modelmapper/user")
public class UserModelMapperController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/{id}")
	public UserMmDto getUserById(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException  {
		Optional<User> user = Optional.of(userService.getUserById(id).orElseThrow(() -> new UserNotFoundException("User not found")));
		
		UserMmDto userDto = modelMapper.map(user, UserMmDto.class);
		return userDto;
	}
}
