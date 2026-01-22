package com.springbootgestionencuestas.springboot_gestion_encuestas.services.impl;

import com.springbootgestionencuestas.springboot_gestion_encuestas.model.Pregunta;
import com.springbootgestionencuestas.springboot_gestion_encuestas.model.Respuesta;
import com.springbootgestionencuestas.springboot_gestion_encuestas.repository.PreguntaRepository;
import com.springbootgestionencuestas.springboot_gestion_encuestas.repository.RespuestaRepository;
import com.springbootgestionencuestas.springboot_gestion_encuestas.services.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RespuestaServiceImpl implements RespuestaService {
    @Autowired
    private PreguntaRepository preguntaRepository;
    private RespuestaRepository respuestaRepository;

    @Override
    public Respuesta agregarRespuestaAPregunta(Long preguntaId, String contenido) {

        Optional<Pregunta> preguntaOptional = preguntaRepository.findById(preguntaId);
        return preguntaOptional.map(pregunta -> {
            Respuesta respuesta = new Respuesta(null,contenido,pregunta);
            pregunta.getRespuestas().add(respuesta);

            preguntaRepository.save(pregunta);
            return respuesta;
        }).orElse(null);

    }

    @Override
    public List<Respuesta> obtenerRespuestasPorPregunta(Long preguntaId) {
        return preguntaRepository.findByPreguntaId(preguntaId);
    }

    @Override
    public Optional<Respuesta> obtenerDetalleRespuesta(Long preguntaId) {
        return respuestaRepository.findById(preguntaId);
    }

    @Override
    public Respuesta actualizarRespuesta(Long respuestaId, String nuevoContenido) {
        return respuestaRepository.findById(respuestaId)
                .map(respuesta -> {
                    respuesta.setContendo(nuevoContenido);
                    return  respuestaRepository.save(respuesta);
                }).orElse(null);
    }

    @Override
    public void eliminarRespuesta(Long respuestaId) {
         respuestaRepository.findById(respuestaId).ifPresent(respuesta -> {
             Pregunta pregunta = respuesta.getPregunta();
             pregunta.getRespuestas().remove(respuesta);
         });
    }
}
