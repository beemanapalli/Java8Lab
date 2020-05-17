package com.basicwebapp.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.basicwebapp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String userame);
	

}
