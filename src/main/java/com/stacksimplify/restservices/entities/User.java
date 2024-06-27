package com.stacksimplify.restservices.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor()
@NoArgsConstructor()
@ToString()
@Entity
@Table(name="_USER")
//@JsonIgnoreProperties({"firstname", "lastname"}) - Static filterin @JsonIgnore
//@JsonFilter(value = "userFilter") - Used for MappinJacksonValue filtering section
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "_user_generator")
	@SequenceGenerator(name = "_user_generator", sequenceName = "_user_seq", allocationSize = 1)
	@JsonView(Views.External.class)
	@Getter @Setter
	private Long id;
	
	@Getter @Setter
	@NotEmpty(message = "Username is Mandatory field. Please provide username")
	@Column(name = "USER_NAME", length=50, nullable=false, unique=true)
	@JsonView(Views.External.class)
	private String username;
	
	@Getter @Setter
	@Size(min=2, message="FirstName should have atleast 2 characters")
	@Column(name = "FIRST_NAME", length=50)
	@JsonView(Views.External.class)
	private String firstname;
	
	@Getter @Setter
	@Column(name = "LAST_NAME", length=50)
	@JsonView(Views.External.class)
	private String lastname;
	
	@Getter @Setter
	@Column(name = "EMAIL", length=50)
	@JsonView(Views.External.class)
	private String email;
	
	@Getter @Setter
	@Column(name = "ROLE", length=50)
	@JsonView(Views.Internal.class)
	private String role;
	
	@Getter @Setter
	//@JsonIgnore - Static filterin @JsonIgnore
	@Column(name = "SSN", length=50, nullable=true, unique=true)
	@JsonView(Views.Internal.class)
	private String ssn;

	@Getter @Setter
	@Column(name = "ADDRESS", length=50)
	@JsonView(Views.Internal.class)
	private String address;
	
	@Getter @Setter
	@OneToMany(mappedBy = "user")
	@JsonView(Views.Internal.class)
	private List<Order> orders;
	

}
