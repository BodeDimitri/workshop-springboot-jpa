package com.bodedimitri.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bodedimitri.course.entities.User;
import com.bodedimitri.course.services.UserService;

@RestController // Recurso web que e implementado por um controlador rest
@RequestMapping(value = "/users") //Nome do recurso
public class UserResource { //Implementa o User //UserResource depende do UserService
	
	@Autowired //Sempre que aparecer isso e injeção implicita de dependencia
	private UserService service; //UserService tem de ser registrada como uma injeção de dependencia
	
	@GetMapping // Indicia que e uma requisição get
	public ResponseEntity<List<User>> findAll() { //A resposta vai ser uma lista de user, por isso o <List<User>
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list); //.ok para retorna a rresposta com sucesso e .body para retornar no corpo da resposta 
	}
	
	@GetMapping(value = "/{id}") //Vai receber esse parametro aqui em baix
	public ResponseEntity<User> findById(@PathVariable Long id) { //PathVariable usado para o spring permitir usar
		User obj = service.findById(id); //Vai procurar por um id em especifico
		return ResponseEntity.ok().body(obj); //Vai retornar para o corpo da pagina o id
	}
	
}
