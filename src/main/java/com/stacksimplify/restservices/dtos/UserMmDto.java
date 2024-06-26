package com.stacksimplify.restservices.dtos;

import java.util.List;

import com.stacksimplify.restservices.entities.Order;

import lombok.Getter;
import lombok.Setter;

public class UserMmDto {
	
	@Getter @Setter
	private Long userid;
	
	@Getter @Setter
	private String username;
	
	@Getter @Setter
	private String firstname;
	
	@Getter @Setter
	private List<Order> orders;

}
