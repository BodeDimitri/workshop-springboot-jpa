package com.bodedimitri.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bodedimitri.course.entities.Product;

//Aqui não e necessario que registrar a dependencia pois JPA ja e registrado como componente de injeção de dependencia
public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
