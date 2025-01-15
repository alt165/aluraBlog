package com.aluraBlog.aluraBlog.repository;

import com.aluraBlog.aluraBlog.domain.entities.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    List<Topico> findByCursoNombreAndFechaCreacionYear(String nombreCurso, int año);
}
