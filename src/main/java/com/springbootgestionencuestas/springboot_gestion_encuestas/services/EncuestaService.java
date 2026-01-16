package com.springbootgestionencuestas.springboot_gestion_encuestas.services;

import com.springbootgestionencuestas.springboot_gestion_encuestas.model.Encuesta;

import java.util.List;
import java.util.Optional;

public interface EncuestaService {
    Encuesta crearEncuesta(String titulo);

    List<Encuesta> obtenerTodasLAsEncuestas();

    Optional<Encuesta> obtenerDetallesEncuesta(Long encuestaId);

    Encuesta actualizarEncuesta(Long encuestaId, String nuevoTitulo);

    void eliminarEncuesta(Long encuestaId);

}
