package com.stacksimplify.restservices.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = "Model to create a new user")
//@JsonIgnoreProperties({"firstname", "lastname"}) - Static filterin @JsonIgnore
//@JsonFilter(value = "userFilter") - Used for MappinJacksonValue filtering section
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "_user_generator")
	@SequenceGenerator(name = "_user_generator", sequenceName = "_user_seq", allocationSize = 1)
	@ApiModelProperty(notes = "Auto generated unique Id", required = true, position=1)
	@JsonView(Views.External.class)
	private Long id;
	
	@Size(min=2, max=50)
	@NotEmpty(message = "Username is Mandatory field. Please provide username")
	@Column(name = "USER_NAME", length=50, nullable=false, unique=true)
	@ApiModelProperty(notes = "username should be in format: flname ", example="armvene", required = false, position=2)
	@JsonView(Views.External.class)
	private String username;
	
	@Getter @Setter
	@Size(min=2, max=50, message="FirstName should have atleast 2 characters")
	@Column(name = "FIRST_NAME", length=50)
	@JsonView(Views.External.class)
	private String firstname;
	
	@Getter @Setter
	@Column(name = "LAST_NAME", length=50)
	@JsonView(Views.External.class)
	private String lastname;
	
	@Column(name = "EMAIL", length=50)
	@JsonView(Views.External.class)
	private String email;
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
}
