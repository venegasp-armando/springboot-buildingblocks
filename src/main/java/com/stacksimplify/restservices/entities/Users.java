package com.stacksimplify.restservices.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor()
@NoArgsConstructor()
@ToString()
@Entity
@Table(name="USERS")
public class Users {
	
	@Id
	@GeneratedValue
	@Getter @Setter
	private Long id;
	
	@Getter @Setter
	@Column(name = "USER_NAME", length=50, nullable=false, unique=true)
	private String username;
	
	@Getter @Setter
	@Column(name = "FIRST_NAME", length=50)
	private String firstname;
	
	@Getter @Setter
	@Column(name = "LAST_NAME", length=50)
	private String lastname;
	
	@Getter @Setter
	@Column(name = "EMAIL", length=50)
	private String email;
	
	@Getter @Setter
	@Column(name = "ROLE", length=50)
	private String role;
	
	@Getter @Setter
	@Column(name = "SSN", length=50, nullable=false, unique=true)
	private String ssn;

	
	
	

}
