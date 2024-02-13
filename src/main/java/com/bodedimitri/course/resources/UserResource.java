package com.bodedimitri.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bodedimitri.course.entities.User;
import com.bodedimitri.course.services.UserService;

@RestController // Recurso web que e implementado por um controlador rest
@RequestMapping(value = "/users") //Nome do recurso
public class UserResource { //Implementa o User //UserResource depende do UserService
	
	@Autowired 
	private UserService service; //UserService tem de ser registrada como uma injeção de dependencia
	
	//endpoint
	
	@GetMapping // Indicia que e uma requisição get
	public ResponseEntity<List<User>> findAll() { //A resposta vai ser uma lista de user, por isso o <List<User>
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list); //.ok para retorna a rresposta com sucesso e .body para retornar no corpo da resposta 
	}
	
	@GetMapping(value = "/{id}") 
	public ResponseEntity<User> findById(@PathVariable Long id) { 
		User obj = service.findById(id); //Vai procurar por um id em especifico
		return ResponseEntity.ok().body(obj); //Vai retornar para o corpo da pagina o id
	}
	
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) { //
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); //tudo isso para gerar uma URI
		return ResponseEntity.created(uri).body(obj); //201
	}
	
	@DeleteMapping(value = "/{id}") //Usado para deleção
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build(); //204
	}
	
	@PutMapping(value = "/{id}") //Notation usada para Update, usa put
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}
