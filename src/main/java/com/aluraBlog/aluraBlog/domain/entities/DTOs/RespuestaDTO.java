package com.aluraBlog.aluraBlog.domain.entities.DTOs;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDateTime;

public record RespuestaDTO(
        @NotNull
        Long id,
        @NotNull
        String mensaje,
        @NotNull
        TopicoDTO topico,
        @NotNull
        @Past
        LocalDateTime fechaCreacion,
        @NotNull
        UsuarioDTO autor,
        @NotNull
        String solucion) {
}
