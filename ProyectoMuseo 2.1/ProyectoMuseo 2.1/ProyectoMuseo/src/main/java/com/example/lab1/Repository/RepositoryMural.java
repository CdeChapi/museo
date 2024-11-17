package com.example.lab1.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lab1.Entidad.Mural;


public interface RepositoryMural extends JpaRepository<Mural, Long>{

	List<Mural> findByRatingGreaterThan(Double rating);
	
}
