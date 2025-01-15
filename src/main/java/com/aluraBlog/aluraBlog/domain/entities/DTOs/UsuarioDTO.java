package com.aluraBlog.aluraBlog.domain.entities.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record UsuarioDTO(
        @NotNull
        Long id,
        @NotNull
        String nombre,
        @NotNull
        @Email
        String correoElectronico,
        @NotNull
        Set<PerfilDTO> perfiles,
        String constrasena) {
}

