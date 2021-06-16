package com.example.demo.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dtos.UserServiceModel;
import com.example.demo.model.entities.UserEntity;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	private final UserRepository userRepository;
	private final ModelMapper modelMapper;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<UserServiceModel> findAllByName(String name) {
		return userRepository.findAllByName(name).stream().map(user -> {
		UserServiceModel userServiceModel =	modelMapper.map(user, UserServiceModel.class);
			
			return userServiceModel;
		}).collect(Collectors.toList());
	}

	@Override
	public void deleteUser(Long id) {
		//UserEntity user = userRepository.findByUsername(name);
		
		userRepository.deleteById(id);
	}

	@Override
	public void save(UserServiceModel userServiceModel) {
		userRepository.save(modelMapper.map(userServiceModel, UserEntity.class));
	}
	
	
	
}
