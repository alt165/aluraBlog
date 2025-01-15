package com.aluraBlog.aluraBlog.domain.entities;

import com.aluraBlog.aluraBlog.domain.entities.DTOs.CursoDTO;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String nombre;

    @Column(length = 50)
    private String categoria;
    public Curso(CursoDTO cursoDTO) {
        this.id = cursoDTO.id();
        this.nombre = cursoDTO.nombre();
        this.categoria = cursoDTO.categoria();
    }
}

