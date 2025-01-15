package com.aluraBlog.aluraBlog.repository;

import com.aluraBlog.aluraBlog.domain.entities.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
