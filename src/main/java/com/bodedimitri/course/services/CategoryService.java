package com.bodedimitri.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bodedimitri.course.entities.Category;
import com.bodedimitri.course.repositories.CategoryRepository;

@Service 
public class CategoryService {
	

	@Autowired //Spring fazer a injeção de dependencia
	private CategoryRepository repository;
	
	public List<Category> findAll() { //Operação na camada de serviço que repassa a chamada para o repository.findall
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();//Retorna o que foi guardado no optional
	}
	
}
