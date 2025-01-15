package com.aluraBlog.aluraBlog.domain.entities.DTOs;

import jakarta.validation.constraints.NotNull;

public record CursoDTO(
        @NotNull
        Long id,
        @NotNull
        String nombre,
        @NotNull
        String categoria) {
}
