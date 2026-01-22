package com.springbootgestionencuestas.springboot_gestion_encuestas.repository;

import com.springbootgestionencuestas.springboot_gestion_encuestas.model.Pregunta;
import com.springbootgestionencuestas.springboot_gestion_encuestas.model.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {
    List<Pregunta> findByEncuestaId(Long encuestaId);

    List<Respuesta> findByPreguntaId(Long preguntaId);
}
