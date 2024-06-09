package com.example.demo.entity;

import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;

@Entity
	@Data
	@Table(name = "prueba")
	public class Prueba {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "nombre")
	    private String nombre;

	    @ManyToOne
	    @JoinColumn(name = "director_id")
	    private Usuario director;

	    @OneToMany(mappedBy = "prueba")
	    private Set<Pregunta> preguntas;

	    @ManyToMany(mappedBy = "pruebasInscritas")
	    private Set<Usuario> estudiantesInscritos;

	    @ManyToMany(mappedBy = "pruebasACalificar")
	    private Set<Usuario> jurados;
	}

