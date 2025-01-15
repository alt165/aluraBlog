package com.aluraBlog.aluraBlog.repository;

import com.aluraBlog.aluraBlog.domain.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
