package com.example.demo.services;

import java.util.List;

import com.example.demo.model.dtos.UserServiceModel;

public interface UserService {

	List<UserServiceModel> findAllByName(String name);
	
	public void deleteUser(Long id);
}
