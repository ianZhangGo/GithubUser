package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.User;
import com.main.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {
	@Autowired
	UserService userService;
	
	/**
	 * Find a User information based his signin name 
	 */
	@GetMapping("/Users/{userId}")
	public User findUser(@PathVariable("userId") String id) {
		id = id.toLowerCase();
		System.out.println("Recevied message:"+id);
		User user = userService.userReposGenerate(id);
		return user;
	}
}
