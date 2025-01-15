package com.aluraBlog.aluraBlog.security;

import com.aluraBlog.aluraBlog.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacionService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public AutenticacionService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public final UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        return usuarioRepository.findByNombre(nombre);
    }
}
