package com.bodedimitri.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bodedimitri.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
