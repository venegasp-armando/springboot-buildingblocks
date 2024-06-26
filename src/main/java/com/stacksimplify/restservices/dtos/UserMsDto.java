package com.stacksimplify.restservices.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class UserMsDto {

	@Getter @Setter
	private Long userid;
	
	@Getter @Setter
	private String username;
	
	@Getter @Setter
	private String emailaddress;

	@Getter @Setter
	private String rolename;
	
}
