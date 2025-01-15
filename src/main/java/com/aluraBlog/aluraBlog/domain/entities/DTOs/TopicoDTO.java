package com.aluraBlog.aluraBlog.domain.entities.DTOs;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDateTime;

public record TopicoDTO(
        @NotNull
        Long id,
        @NotNull
        String titulo,
        @NotNull
        String mensaje,
        @NotNull
        @Past
        LocalDateTime fechaCreacion,
        @NotNull
        String status,
        @NotNull
        UsuarioDTO autor,
        @NotNull
        CursoDTO curso) {
}
