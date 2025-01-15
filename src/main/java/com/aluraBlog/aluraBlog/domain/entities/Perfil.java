package com.aluraBlog.aluraBlog.domain.entities;

import com.aluraBlog.aluraBlog.domain.entities.DTOs.PerfilDTO;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    public Perfil(PerfilDTO perfilDTO) {
        this.id = perfilDTO.id();
        this.nombre = perfilDTO.nombre();
    }
}

