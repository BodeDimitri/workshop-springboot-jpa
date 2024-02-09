package com.bodedimitri.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bodedimitri.course.entities.User;
import com.bodedimitri.course.repositories.UserRepository;

@Service //Indica que isso vai ser usado como injeção de dependencia, tambem pode ser usado o @Component ou @Repository
public class UserService {
	

	@Autowired //Spring fazer a injeção de dependencia
	private UserRepository repository;
	
	public List<User> findAll() { //Operação na camada de serviço que repassa a chamada para o repository.findall
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();//Retorna o que foi guardado no optional
	}
	
}
