package com.aluraBlog.aluraBlog.domain.entities.DTOs;

import jakarta.validation.constraints.NotNull;

public record PerfilDTO(@NotNull Long id, @NotNull String nombre) {
}
