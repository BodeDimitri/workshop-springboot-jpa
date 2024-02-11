package com.bodedimitri.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bodedimitri.course.entities.Product;
import com.bodedimitri.course.services.ProductService;

@RestController // Recurso web que e implementado por um controlador rest
@RequestMapping(value = "/products") //Nome do recurso
public class ProductResource { //Implementa o Product //ProductResource depende do ProductService
	
	@Autowired //Sempre que aparecer isso e injeção implicita de dependencia
	private ProductService service; //ProductService tem de ser registrada como uma injeção de dependencia
	
	@GetMapping // Indicia que e uma requisição get
	public ResponseEntity<List<Product>> findAll() { //A resposta vai ser uma lista de user, por isso o <List<Product>
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list); //.ok para retorna a rresposta com sucesso e .body para retornar no corpo da resposta 
	}
	
	@GetMapping(value = "/{id}") //Vai receber esse parametro aqui em baix
	public ResponseEntity<Product> findById(@PathVariable Long id) { //PathVariable usado para o spring permitir usar
		Product obj = service.findById(id); //Vai procurar por um id em especifico
		return ResponseEntity.ok().body(obj); //Vai retornar para o corpo da pagina o id
	}
	
}
