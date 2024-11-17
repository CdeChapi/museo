package com.example.lab1.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lab1.Entidad.Artista;
import com.example.lab1.Repository.RepositoryArtista;

@Service
public class ServicioArtista {
	
	@Autowired
    private RepositoryArtista repositoryArtista;

    public List<Artista> obtenerTodosLosArtistas() {
        return repositoryArtista.findAll();
    }

    public Optional<Artista> obtenerArtistaPorId(Long id) {
        return repositoryArtista.findById(id);
    }

    public Artista guardarArtista(Artista artista) {
        return repositoryArtista.save(artista);
    }

    public void eliminarArtista(Long id) {
        repositoryArtista.deleteById(id);
    }
    
    public List<Artista> buscarPorNombre(String nombre) {
        return repositoryArtista.findByNombreContainingIgnoreCase(nombre);
    }


}
