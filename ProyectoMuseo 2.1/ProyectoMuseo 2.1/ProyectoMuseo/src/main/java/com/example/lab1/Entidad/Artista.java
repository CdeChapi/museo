package com.example.lab1.Entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;



@Entity
@Table(name= "artista")
public class Artista {
	
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ida;  // Campo de clave primaria para el Artista
    
    @Column
    private String nombre;
    
    @Column(name = "apellido_completo")
    private String apellido;
    
    @Column
    private String pais;
    
    
    public Artista() {
    }

    public Artista(Long ida, String nombre, String apellido, String pais) {
		super();
		this.ida = ida;
		this.nombre = nombre;
		this.apellido = apellido;
		this.pais = pais;
	}

	// Getters y setters
    public Long getIda() {
        return ida;
    }

    public void setIda(Long ida) {
        this.ida = ida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

   
}