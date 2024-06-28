package com.stacksimplify.restservices.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stacksimplify.restservices.entities.Order;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.repositories.OrderRepository;
import com.stacksimplify.restservices.repositories.UserRepository;

import io.swagger.annotations.Api;

@Api(tags = "User Management RESTful Services", value = "UserController")
@RestController
@RequestMapping(value = "/user")
public class OrderController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping("/{id}/orders")
	public List<Order> getAllOrder(@PathVariable Long id) throws UserNotFoundException{
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("User not in repository");
		}
		return user.get().getOrders();
	}
	
	@PostMapping("/{id}/orders")
	public Order createOrder(@PathVariable Long id, @RequestBody Order order) throws UserNotFoundException {
		Optional<User> user = userRepository.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException("User not found");
		}
		order.setUser(user.get());
		return orderRepository.save(order);
	}
	
	@GetMapping("/{id}/orders/{orderid}")
	public Order getOrderById(@PathVariable("id") Long id, @PathVariable("id") Long orderid) throws UserNotFoundException {
		Optional<Order> order = orderRepository.findById(orderid);
		if (order.isEmpty()) {
			throw new UserNotFoundException("Order not found");
		}
		return order.get();
		
	}
}
