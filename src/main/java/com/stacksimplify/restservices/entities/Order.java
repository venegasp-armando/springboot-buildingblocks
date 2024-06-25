package com.stacksimplify.restservices.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "ORDERS")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_generator")
	@SequenceGenerator(name = "order_generator", sequenceName = "order_seq", allocationSize = 1)
	@Getter @Setter
	private Long orderid;
	
	@Column(name = "DESCRIPTION", length=50)
	@Getter @Setter
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@Getter @Setter
	private User user;
	
}
