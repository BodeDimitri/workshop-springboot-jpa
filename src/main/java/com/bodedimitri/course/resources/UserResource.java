package com.bodedimitri.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bodedimitri.course.entities.User;

@RestController // Recurso web que e implementado por um controlador rest
@RequestMapping(value = "/users") //Nome do recurso
public class UserResource { //Implementa o User 
	
	@GetMapping // Indicia que respode ao get do HTTP
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "Nome", "email@mail.com", "111", "a23"); //L no final do long
		return ResponseEntity.ok().body(u); //.ok para retorna a rresposta com sucesso e .body para retornar no corpo da resposta 
	}
}
