package com.springbootgestionencuestas.springboot_gestion_encuestas.services.impl;

import com.springbootgestionencuestas.springboot_gestion_encuestas.model.Encuesta;
import com.springbootgestionencuestas.springboot_gestion_encuestas.repository.EncuentaRepository;
import com.springbootgestionencuestas.springboot_gestion_encuestas.services.EncuestaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EncuestaServiceImpl implements EncuestaService {

    @Autowired
    private EncuentaRepository encuentaRepository;

    @Override
    public Encuesta crearEncuesta(String titulo) {
        Encuesta encuesta = new Encuesta();
        encuesta.setTitulo(titulo);
        return encuentaRepository.save(encuesta);
    }

    @Override
    public List<Encuesta> obtenerTodasLAsEncuestas() {
        return encuentaRepository.findAll();
    }

    @Override
    public Optional<Encuesta> obtenerDetallesEncuesta(Long encuestaId) {
        return encuentaRepository.findById(encuestaId);
    }


    @Override
    public Encuesta actualizarEncuesta(Long encuestaId, String nuevoTitulo) {
        return encuentaRepository.findById(encuestaId)
                .map(encuesta -> {
                    encuesta.setTitulo(nuevoTitulo);
                    return encuentaRepository.save(encuesta);
                })
                //TODO: probar con el front cuando retorne  Optional<Encuesta> para forzar que. Fuerza al consumidor a manejar el caso vacío
                .orElseThrow(() ->
                        new EntityNotFoundException("Encuesta no encontrada con id " + encuestaId)
                );
    }

    @Override
    public void eliminarEncuesta(Long encuestaId) {
        encuentaRepository.deleteById(encuestaId);
    }
}
