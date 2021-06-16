package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{

	@Query(value = "SELECT * FROM Users u where u.username like %:name%", nativeQuery = true)
	List<UserEntity> findAllByName(String name);
	
	UserEntity findByUsername(String username);
}
