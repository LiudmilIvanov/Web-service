package com.example.demo.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public List<UserServiceModel> viewUsers(@PathVariable String name, HttpServletResponse response) {
		 response.setContentType("application/json");
		return userService.findAllByName(name);
	}
	
	
	@CrossOrigin
	@RequestMapping(value = "/users", method = RequestMethod.POST, 
	consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} )
	public @ResponseBody ResponseEntity<UserServiceModel> createUser(@Valid @RequestBody UserServiceModel userServiceModel) {
		 userService.save(userServiceModel);

		 return new ResponseEntity<>(HttpStatus.CREATED);
	};
	
	@CrossOrigin
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Long> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
}
