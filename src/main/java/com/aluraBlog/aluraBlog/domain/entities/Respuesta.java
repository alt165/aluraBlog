package com.aluraBlog.aluraBlog.domain.entities;

import com.aluraBlog.aluraBlog.domain.entities.DTOs.RespuestaDTO;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String mensaje;

    @ManyToOne
    @JoinColumn(name = "id_topico", nullable = false)
    private Topico topico;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "id_autor", nullable = false)
    private Usuario autor;

    @Column(columnDefinition = "TEXT")
    private String solucion;

    public Respuesta(RespuestaDTO respuestaDTO) {
        this.id = respuestaDTO.id();
        this.mensaje = respuestaDTO.mensaje();
        this.fechaCreacion = respuestaDTO.fechaCreacion();
        this.solucion = respuestaDTO.solucion();
        this.topico = new Topico(respuestaDTO.topico()); // Convertir TopicoDTO a Topico
        this.autor = new Usuario(respuestaDTO.autor()); // Convertir UsuarioDTO a Usuario
    }
}

