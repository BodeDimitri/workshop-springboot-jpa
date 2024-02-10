package com.bodedimitri.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bodedimitri.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
