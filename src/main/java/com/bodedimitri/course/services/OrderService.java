package com.bodedimitri.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bodedimitri.course.entities.Order;
import com.bodedimitri.course.repositories.OrderRepository;

@Service //Indica que isso vai ser usado como injeção de dependencia, tambem pode ser usado o @Component ou @Repository
public class OrderService {
	

	@Autowired 
	private OrderRepository repository;
	
	public List<Order> findAll() { 
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}
