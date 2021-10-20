package com.example.userService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userService.VO.ResponseTemplateVO;
import com.example.userService.entity.User;
import com.example.userService.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public User saveUser(@RequestBody  User user) {
		log.info("Inside saveUser method in UserController ");
		return userService.saveUser(user);
	}
	@GetMapping("/{id}")
	public ResponseTemplateVO getUserWithDepartment( @PathVariable("id") int userId) {
		log.info("Inside getUserWithDepartment method in UserController ");

		return userService.getUserWithDepartment(userId);
	}
}
