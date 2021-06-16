package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.entities.UserEntity;
import com.example.demo.repositories.UserRepository;

@Component
public class DBInit implements CommandLineRunner{

	private final UserRepository userRepository;
	
	
	@Autowired
	public DBInit(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		/*UserEntity userOne = new UserEntity();
		userOne.setUsername("Georgi Petrov");
		userOne.setEmail("gpetrov@abv.bg");
		
		UserEntity userTwo = new UserEntity();
		userTwo.setUsername("Ivan Ivanov");
		userTwo.setEmail("ivanov@abv.bg");
		
		userRepository.saveAll(List.of(userOne, userTwo));*/
	}

}
