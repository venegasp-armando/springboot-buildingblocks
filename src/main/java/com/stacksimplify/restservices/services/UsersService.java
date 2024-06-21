package com.stacksimplify.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stacksimplify.restservices.entities.Users;
import com.stacksimplify.restservices.repositories.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;
	
	public List<Users> getAllUsers(){
		return usersRepository.findAll();
	}
	
	public Users createUsers(Users users) {
		return usersRepository.save(users);
	}
	
	public Optional<Users> getUsersById(Long id) {
		Optional<Users> users = usersRepository.findById(id);
		return users;
	}
	
	public Users updateUsersById(Long id, Users users) {
		users.setId(id);
		return usersRepository.save(users);
	} 
	
	public void deleteUsersById(Long id) {
		if (usersRepository.existsById(id)) {
			usersRepository.deleteById(id);
		}
	} 
	
	public Users getUsersByUserName(String userName) {
		return usersRepository.findByUserName(userName);
	}
}
