package com.stacksimplify.restservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stacksimplify.restservices.entities.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
	
	Users findByUserName(String userName);

}
