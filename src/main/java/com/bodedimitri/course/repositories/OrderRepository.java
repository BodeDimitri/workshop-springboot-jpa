package com.bodedimitri.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bodedimitri.course.entities.Order;


public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
