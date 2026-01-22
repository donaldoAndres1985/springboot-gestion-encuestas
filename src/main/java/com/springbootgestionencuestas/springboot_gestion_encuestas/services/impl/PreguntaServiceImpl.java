package com.springbootgestionencuestas.springboot_gestion_encuestas.services.impl;

import com.springbootgestionencuestas.springboot_gestion_encuestas.model.Encuesta;
import com.springbootgestionencuestas.springboot_gestion_encuestas.model.Pregunta;
import com.springbootgestionencuestas.springboot_gestion_encuestas.repository.EncuentaRepository;
import com.springbootgestionencuestas.springboot_gestion_encuestas.repository.PreguntaRepository;
import com.springbootgestionencuestas.springboot_gestion_encuestas.services.PreguntaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PreguntaServiceImpl implements PreguntaService {

    @Autowired
    private EncuentaRepository encuentaRepository;
    private PreguntaRepository preguntaRepository;

    @Override
    public Pregunta agregarPreguntaAEncuesta(Long encuestaId, String contenido) {
        Optional<Encuesta> oEncuesta = encuentaRepository.findById(encuestaId);

        return oEncuesta.map(encuesta -> {
            Pregunta pregunta = new Pregunta(null, contenido, encuesta, new ArrayList<>() );
            encuesta.getPreguntas().add(pregunta);
            encuentaRepository.save(encuesta);
            return pregunta;
        }) .orElseThrow(() ->
                new EntityNotFoundException("Encuesta no encontrada con id " + encuestaId)
        );
    }

    @Override
    public List<Pregunta> obtenerPreguntasPorEncuesta(Long encuestaId) {
        return preguntaRepository.findByEncuestaId(encuestaId);
    }

    @Override
    public Optional<Pregunta> obtenerDetallesPregunta(Long preguntaId) {
        return preguntaRepository.findById(preguntaId);
    }

    @Override
    public Pregunta actualizarPregunta(Long preguntaId, String nuevoContenido, Long encuestaId) {
        return preguntaRepository.findById(preguntaId)
                .map(pregunta -> {
                    pregunta.setContendo(nuevoContenido);
                    Optional<Encuesta> oEncuesta = encuentaRepository.findById(encuestaId);
                    oEncuesta.ifPresent(pregunta::setEncuesta);
                    return preguntaRepository.save(pregunta);
                })
                .orElseThrow(() ->
                        new EntityNotFoundException("Encuesta no encontrada con id " + encuestaId)
                );
    }

    @Override
    public void eliminarPregunta(Long preguntaId) {

        preguntaRepository.findById(preguntaId).ifPresent(pregunta -> {
                    Encuesta encuesta = pregunta.getEncuesta();
                    encuesta.getPreguntas().remove(pregunta);

                    preguntaRepository.deleteById(preguntaId);
                    encuentaRepository.save(encuesta);
                });
    }
}
