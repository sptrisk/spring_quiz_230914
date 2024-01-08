package com.quiz.lesson07.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.lesson07.entity.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer>{
	// Spring data JPA
	
	// save(Entity 객체)
	// Optional<Entity 객체> findById(id)
}
