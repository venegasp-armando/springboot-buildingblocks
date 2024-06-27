package com.stacksimplify.restservices.dtos;

import java.util.List;

import com.stacksimplify.restservices.entities.Order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class UserDtoV2 {

	@Getter @Setter private Long id;
	@Getter @Setter private String username;
	@Getter @Setter private String firstname;
	@Getter @Setter private String lastname;
	@Getter @Setter private String email;
	@Getter @Setter private String role;
	@Getter @Setter private String ssn;
	@Getter @Setter private String address;
	@Getter @Setter private List<Order> orders;
}
