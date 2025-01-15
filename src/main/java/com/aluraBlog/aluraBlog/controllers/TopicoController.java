package com.aluraBlog.aluraBlog.controllers;


import com.aluraBlog.aluraBlog.domain.entities.DTOs.TopicoDTO;
import com.aluraBlog.aluraBlog.domain.entities.Topico;
import com.aluraBlog.aluraBlog.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoService topicoService;

    public TopicoController(TopicoService topicoService) {
        this.topicoService = topicoService;
    }

    @PostMapping
    public ResponseEntity<Topico> crearTopico(@Valid @RequestBody TopicoDTO topicoDTO) {
        Topico nuevoTopico = topicoService.crearTopico(topicoDTO);
        return new ResponseEntity<>(nuevoTopico, HttpStatus.CREATED);
    }

    @GetMapping
    public Page<Topico> obtenerTopicos(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return topicoService.obtenerTopicos(pageable);
    }
}
