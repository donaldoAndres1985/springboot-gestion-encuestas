package com.springbootgestionencuestas.springboot_gestion_encuestas.repository;

import com.springbootgestionencuestas.springboot_gestion_encuestas.model.Encuesta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EncuentaRepository extends JpaRepository<Encuesta, Long> {
}
