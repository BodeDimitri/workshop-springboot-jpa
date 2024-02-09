package com.bodedimitri.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bodedimitri.course.entities.Order;
import com.bodedimitri.course.services.OrderService;

@RestController // Recurso web que e implementado por um controlador rest
@RequestMapping(value = "/orders") //Nome do recurso
public class OrderResource { //Implementa o Order //OrderResource depende do OrderService
	
	@Autowired //Sempre que aparecer isso e injeção implicita de dependencia
	private OrderService service; //OrderService tem de ser registrada como uma injeção de dependencia
	
	@GetMapping // Indicia que e uma requisição get
	public ResponseEntity<List<Order>> findAll() { 
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list); 
	}
	
	@GetMapping(value = "/{id}") 
	public ResponseEntity<Order> findById(@PathVariable Long id) { 
		Order obj = service.findById(id); 
		return ResponseEntity.ok().body(obj); 
	}
	
}
