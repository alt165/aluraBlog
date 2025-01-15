package com.aluraBlog.aluraBlog.repository;

import com.aluraBlog.aluraBlog.domain.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByNombre(String nombre);
}
