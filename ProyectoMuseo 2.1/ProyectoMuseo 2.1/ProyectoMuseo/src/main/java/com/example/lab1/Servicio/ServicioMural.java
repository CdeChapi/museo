package com.example.lab1.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.lab1.Entidad.Mural;
import com.example.lab1.Repository.RepositoryMural;


@Service
public class ServicioMural {
	
	@Autowired
    private RepositoryMural repositoryMural;

    // Obtener todos los murales
    public List<Mural> obtenerTodosLosMurales() {
        return repositoryMural.findAll();
    }

    // Obtener un mural por su ID
    public Optional<Mural> obtenerMuralPorId(Long id) {
        return repositoryMural.findById(id);
    }

    // Guardar un nuevo mural
    public Mural guardarMural(Mural mural) {
        return repositoryMural.save(mural);
    }

    // Eliminar un mural por su ID
    public void eliminarMural(Long id) {
        repositoryMural.deleteById(id);
    }

    public List<Mural> obtenerMuralesPorRatingMayorA(Double rating) {
        return repositoryMural.findByRatingGreaterThan(rating);
    }
	
}
