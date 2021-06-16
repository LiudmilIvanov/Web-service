package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dtos.UserServiceModel;
import com.example.demo.services.UserService;

@RestController
@RequestMapping("/")
public class UserController {

	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}


	@CrossOrigin
	@GetMapping("/users/{name}")
	public List<UserServiceModel> viewUsers(@PathVariable String name) {
		return userService.findAllByName(name);
	}
	
	@CrossOrigin
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Long> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
}
