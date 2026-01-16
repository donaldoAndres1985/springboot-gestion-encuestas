package com.springbootgestionencuestas.springboot_gestion_encuestas.services;

import com.springbootgestionencuestas.springboot_gestion_encuestas.model.Pregunta;

import java.util.List;
import java.util.Optional;

public interface PreguntaService {

    Pregunta agregarPreguntaAEncuesta(Long encuestaId, String contenido);

    List<Pregunta> obtenerPreguntasPorEncuesta(Long encuestaId);

    Optional<Pregunta> obtenerDetallesPregunta(Long preguntaId);

    Pregunta actualizarPregunta(Long preguntaId,String nuevoContenido, Long encuestaId);

    void eliminarPregunta(Long preguntaId);
}
