package com.example.lab1.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lab1.Entidad.Artista;

public interface RepositoryArtista extends  JpaRepository<Artista, Long>{

	List<Artista> findByNombreContainingIgnoreCase(String nombre);
}
