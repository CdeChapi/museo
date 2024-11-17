package com.example.lab1.Controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lab1.Entidad.Mural;
import com.example.lab1.Servicio.ServicioMural;


@RestController
@RequestMapping("/api/murales")

public class ControladorMural {
	
	@Autowired
    private ServicioMural servicioMural;

    // Obtener todos los murales
    @GetMapping
    public List<Mural> obtenerTodosLosMurales() {
        return servicioMural.obtenerTodosLosMurales();
    }

    // Obtener un mural por ID
    @GetMapping("/{id}")
    public ResponseEntity<Mural> obtenerMuralPorId(@PathVariable Long id) {
        Optional<Mural> mural = servicioMural.obtenerMuralPorId(id);
        return mural.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo mural
    @PostMapping
    public Mural crearMural(@RequestBody Mural mural) {
        return servicioMural.guardarMural(mural);
    }

    // Actualizar un mural
    @PutMapping("/{id}")
    public ResponseEntity<Mural> actualizarMural(@PathVariable Long id, @RequestBody Mural muralActualizado) {
        Optional<Mural> muralExistente = servicioMural.obtenerMuralPorId(id);
        if (muralExistente.isPresent()) {
            Mural mural = muralExistente.get();
            mural.setTitulo(muralActualizado.getTitulo());
            mural.setAnoPublicacion(muralActualizado.getAnoPublicacion());
            mural.setDimensiones(muralActualizado.getDimensiones());
            mural.setMateriales(muralActualizado.getMateriales());
            mural.setArtista(muralActualizado.getArtista());
            return ResponseEntity.ok(servicioMural.guardarMural(mural));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un mural
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMural(@PathVariable Long id) {
        Optional<Mural> muralExistente = servicioMural.obtenerMuralPorId(id);
        if (muralExistente.isPresent()) {
            servicioMural.eliminarMural(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
 // Obtener murales con rating mayor a X valor
    @GetMapping("/rating/{rt}")
    public ResponseEntity<List<Mural>> obtenerMuralesPorRating(@PathVariable("rt") Double rating) {
        List<Mural> murales = servicioMural.obtenerMuralesPorRatingMayorA(rating);
        if (murales.isEmpty()) {
            return ResponseEntity.noContent().build(); // Devuelve 204 si no hay resultados
        }
        return ResponseEntity.ok(murales);
    }
	

}
