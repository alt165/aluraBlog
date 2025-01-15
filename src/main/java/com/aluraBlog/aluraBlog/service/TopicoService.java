package com.aluraBlog.aluraBlog.service;

import com.aluraBlog.aluraBlog.domain.entities.Curso;
import com.aluraBlog.aluraBlog.domain.entities.DTOs.TopicoDTO;
import com.aluraBlog.aluraBlog.domain.entities.Topico;
import com.aluraBlog.aluraBlog.domain.entities.Usuario;
import com.aluraBlog.aluraBlog.repository.CursoRepository;
import com.aluraBlog.aluraBlog.repository.TopicoRepository;
import com.aluraBlog.aluraBlog.repository.UsuarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    private final TopicoRepository topicoRepository;
    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;

    public TopicoService(TopicoRepository topicoRepository, UsuarioRepository usuarioRepository, CursoRepository cursoRepository) {
        this.topicoRepository = topicoRepository;
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
    }

    public Topico crearTopico(TopicoDTO topicoDTO) {
        // Buscar al autor (usuario) y al curso usando los IDs
        Usuario autor = usuarioRepository.findById(topicoDTO.autor().id())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Curso curso = cursoRepository.findById(topicoDTO.curso().id())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        // Crear la entidad Topico a partir del DTO
        Topico topico = new Topico(topicoDTO);
        topico.setAutor(autor);
        topico.setCurso(curso);

        // Guardar el nuevo topico en la base de datos
        return topicoRepository.save(topico);
    }
    public Page<Topico> obtenerTopicos(Pageable pageable) {
        return topicoRepository.findAll(pageable);  // Devuelve los topicos paginados
    }
    public List<Topico> obtenerTopicosPorCursoYAnio(String nombreCurso, int año) {
        return topicoRepository.findByCursoNombreAndFechaCreacionYear(nombreCurso, año);
    }
}
