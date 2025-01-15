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

import java.util.List;
import java.util.Optional;

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
    @GetMapping
    public List<Topico> obtenerTopicosPorCursoYAnio(
            @RequestParam String nombreCurso,
            @RequestParam int año) {
        return topicoService.obtenerTopicosPorCursoYAnio(nombreCurso, año);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Topico> obtenerTopicoPorId(@PathVariable Long id) {
        Optional<Topico> topico = topicoService.obtenerTopicoPorId(id);
        if (topico.isPresent()) {
            return ResponseEntity.ok(topico.get());  // Devuelve el topico en formato JSON
        } else {
            return ResponseEntity.notFound().build();  // Devuelve un error 404 si no se encuentra el topico
        }
    }

    // Endpoint para actualizar un topico por ID
    @PutMapping("/{id}")
    public ResponseEntity<Topico> actualizarTopico(@PathVariable Long id, @RequestBody Topico topicoActualizado) {
        // Llamar al servicio para actualizar el topico
        Topico topico = topicoService.actualizarTopico(id, topicoActualizado);

        if (topico != null) {
            // Si el topico se actualizó correctamente, devolverlo con código 200 OK
            return ResponseEntity.ok(topico);
        } else {
            // Si no se encuentra el topico con ese ID, devolver error 404
            return ResponseEntity.notFound().build();
        }
    }
}
