package com.aluraBlog.aluraBlog.controllers;

import com.aluraBlog.aluraBlog.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    @Autowired
    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        // Aquí deberías verificar las credenciales del usuario (por ejemplo, con una base de datos)
        // Si las credenciales son correctas, generamos un JWT
        if ("usuario_valido".equals(username) && "contraseña_valida".equals(password)) {
            return jwtUtil.generateToken(username);
        } else {
            throw new RuntimeException("Credenciales incorrectas");
        }
    }
}
