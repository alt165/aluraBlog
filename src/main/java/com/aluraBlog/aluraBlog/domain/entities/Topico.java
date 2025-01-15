package com.aluraBlog.aluraBlog.domain.entities;

import com.aluraBlog.aluraBlog.domain.entities.DTOs.TopicoDTO;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String mensaje;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(length = 50)
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_autor", nullable = false)
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

    public Topico(TopicoDTO topicoDTO) {
        this.id = topicoDTO.id();
        this.titulo = topicoDTO.titulo();
        this.mensaje = topicoDTO.mensaje();
        this.fechaCreacion = topicoDTO.fechaCreacion();
        this.status = topicoDTO.status();
        this.autor = new Usuario(topicoDTO.autor()); // Convertir UsuarioDTO a Usuario
        this.curso = new Curso(topicoDTO.curso()); // Convertir CursoDTO a Curso
    }
}

