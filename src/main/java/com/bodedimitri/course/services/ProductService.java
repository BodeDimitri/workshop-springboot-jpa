package com.bodedimitri.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bodedimitri.course.entities.Product;
import com.bodedimitri.course.repositories.ProductRepository;

@Service //Indica que isso vai ser usado como injeção de dependencia, tambem pode ser usado o @Component ou @Repository
public class ProductService {
	

	@Autowired //Spring fazer a injeção de dependencia
	private ProductRepository repository;
	
	public List<Product> findAll() { //Operação na camada de serviço que repassa a chamada para o repository.findall
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();//Retorna o que foi guardado no optional
	}
	
}
