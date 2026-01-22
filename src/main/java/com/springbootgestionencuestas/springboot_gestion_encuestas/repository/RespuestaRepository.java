package com.springbootgestionencuestas.springboot_gestion_encuestas.repository;

import com.springbootgestionencuestas.springboot_gestion_encuestas.model.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {
    List<Respuesta> findByPregunta(Integer preguntaId);
}
