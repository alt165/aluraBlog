package com.aluraBlog.aluraBlog.domain.entities;

import com.aluraBlog.aluraBlog.domain.entities.DTOs.UsuarioDTO;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String nombre;

    @Column(name = "correo_electronico", nullable = false, length = 100)
    private String correoElectronico;

    @Column(nullable = false, length = 100)
    private String contrasena;

    @ManyToMany
    @JoinTable(
            name = "usuarios_perfiles",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_perfil")
    )
    private Set<Perfil> perfiles;

    public Usuario(UsuarioDTO usuarioDTO) {
        this.id = usuarioDTO.id();
        this.nombre = usuarioDTO.nombre();
        this.correoElectronico = usuarioDTO.correoElectronico();
        this.contrasena = usuarioDTO.constrasena();
        if (usuarioDTO.perfiles() != null) {
            this.perfiles = usuarioDTO.perfiles().stream()
                    .map(perfilDTO -> new Perfil(perfilDTO)) // Convertir de PerfilDTO a Perfil
                    .collect(Collectors.toSet());
        }
    }
}

