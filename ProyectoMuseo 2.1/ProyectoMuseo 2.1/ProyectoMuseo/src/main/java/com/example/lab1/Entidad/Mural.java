package com.example.lab1.Entidad;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "mural")
public class Mural {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long idM;
	    
	    @Column
	    private String titulo;
	    
	    @Column
	    private String anoPublicacion;
	    
	    @Column
	    private String dimensiones;
	    
	    @Column
	    private String materiales;
	    
	    @Column
	    private Double rating;

	    @ManyToOne
	    @JoinColumn(name = "idA")  // Clave foránea para enlazar con Artista
	    private Artista artista;	    
	    
	    public Mural() {}

	    public Mural(Long idM, String titulo, String anoPublicacion, String dimensiones, String materiales, Double rating,
				Artista artista) {
			super();
			this.idM = idM;
			this.titulo = titulo;
			this.anoPublicacion = anoPublicacion;
			this.dimensiones = dimensiones;
			this.materiales = materiales;
			this.artista = artista;
			this.rating= rating;
		}

		// Getters y setters
	    public Long getIdM() {
	        return idM;
	    }

	    public void setIdM(Long idM) {
	        this.idM = idM;
	    }

	    public String getTitulo() {
	        return titulo;
	    }

	    public void setTitulo(String titulo) {
	        this.titulo = titulo;
	    }

	    public String getAnoPublicacion() {
	        return anoPublicacion;
	    }

	    public void setAnoPublicacion(String anoPublicacion) {
	        this.anoPublicacion = anoPublicacion;
	    }

	    public String getDimensiones() {
	        return dimensiones;
	    }

	    public void setDimensiones(String dimensiones) {
	        this.dimensiones = dimensiones;
	    }

	    public String getMateriales() {
	        return materiales;
	    }

	    public void setMateriales(String materiales) {
	        this.materiales = materiales;
	    }
	    public Double getRating() {
	        return rating;
	    }

	    public void setRating(Double rating) {
	        this.rating = rating;
	    }

	    public Artista getArtista() {
	        return artista;
	    }

	    public void setArtista(Artista artista) {
	        this.artista = artista;
	    }
	}