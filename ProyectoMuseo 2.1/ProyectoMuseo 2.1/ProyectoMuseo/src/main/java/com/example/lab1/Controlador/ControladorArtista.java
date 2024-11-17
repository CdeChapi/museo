package com.example.lab1.Controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lab1.Entidad.Artista;
import com.example.lab1.Servicio.ServicioArtista;

@RestController
@RequestMapping("/api/artistas")
public class ControladorArtista {
	
	@Autowired
    private ServicioArtista servicioArtista;

    // Obtener todos los artistas
    @GetMapping
    public List<Artista> obtenerTodosLosArtistas() {
        return servicioArtista.obtenerTodosLosArtistas();
    }

    // Obtener un artista por ID
    @GetMapping("/{id}")
    public ResponseEntity<Artista> obtenerArtistaPorId(@PathVariable Long id) {
        Optional<Artista> artista = servicioArtista.obtenerArtistaPorId(id);
        return artista.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo artista
    @PostMapping
    public ResponseEntity<Artista> crearArtista(@RequestBody Artista artista) {
        Artista nuevoArtista = servicioArtista.guardarArtista(artista);
        return new ResponseEntity<>(nuevoArtista, HttpStatus.CREATED);
    }

    // Actualizar un artista existente
    @PutMapping("/{id}")
    public ResponseEntity<Artista> actualizarArtista(@PathVariable Long id, @RequestBody Artista artistaActualizado) {
        Optional<Artista> artistaExistente = servicioArtista.obtenerArtistaPorId(id);
        
        if (artistaExistente.isPresent()) {
            Artista artista = artistaExistente.get();
            artista.setNombre(artistaActualizado.getNombre());
            artista.setApellido(artistaActualizado.getApellido());
            artista.setPais(artistaActualizado.getPais());
            servicioArtista.guardarArtista(artista);
            return ResponseEntity.ok(artista);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un artista por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarArtista(@PathVariable Long id) {
        if (servicioArtista.obtenerArtistaPorId(id).isPresent()) {
            servicioArtista.eliminarArtista(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/buscar/{nombre}")
    public ResponseEntity<List<Artista>> buscarArtistasPorNombre(@PathVariable String nombre) {
        List<Artista> artistas = servicioArtista.buscarPorNombre(nombre);
        if (artistas.isEmpty()) {
            return ResponseEntity.noContent().build(); // Devuelve 204 si no se encontraron artistas
        }
        return ResponseEntity.ok(artistas);
    }
}