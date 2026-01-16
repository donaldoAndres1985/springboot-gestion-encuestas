package com.springbootgestionencuestas.springboot_gestion_encuestas.services;

import com.springbootgestionencuestas.springboot_gestion_encuestas.model.Respuesta;

import java.util.List;
import java.util.Optional;

public interface RespuestaService {

    Respuesta agregarRespuestaAPregunta(Long preguntaId, String contenido);

    List<Respuesta> obtenerRespuestasPorPregunta(Long preguntaId);

    Optional<Respuesta> obtenerDetalleRespuesta(Long preguntaId);

    Respuesta actualizarRespuesta(Long respuestaId, String nuevoContenido);

    void eliminarRespuesta(Long respuestaId);

}
