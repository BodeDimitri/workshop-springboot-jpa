package com.bodedimitri.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bodedimitri.course.entities.User;
import com.bodedimitri.course.repositories.UserRepository;
import com.bodedimitri.course.services.exceptions.ResourceNotFoundException;

@Service //Indica que isso vai ser usado como injeção de dependencia, tambem pode ser usado o @Component ou @Repository
public class UserService {
	

	@Autowired //Spring fazer a injeção de dependencia
	private UserRepository repository;
	
	public List<User> findAll() { //Operação na camada de serviço que repassa a chamada para o repository.findall
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id)); //Caso não consiga vai ocorrer erro  //Retorna o que foi guardado no optional
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id); 
		updateDate(entity, obj);
		return repository.save(entity);
	}

	private void updateDate(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
	
}
