package com.aluraBlog.aluraBlog.repository;

import com.aluraBlog.aluraBlog.domain.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
