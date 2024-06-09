package com.example.demo.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
@Table(name = "pregunta")
public class Pregunta {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "contenido")
    private String contenido;

    @Column(name = "valor_correcto")
    private int valorCorrecto;

    @ManyToOne
    @JoinColumn(name = "prueba_id")
    private Prueba prueba;
}
