package com.springbootgestionencuestas.springboot_gestion_encuestas.controller;

import com.springbootgestionencuestas.springboot_gestion_encuestas.model.Encuesta;
import com.springbootgestionencuestas.springboot_gestion_encuestas.model.Pregunta;
import com.springbootgestionencuestas.springboot_gestion_encuestas.services.EncuestaService;
import com.springbootgestionencuestas.springboot_gestion_encuestas.services.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/encuestas")
public class PreguntaController {

    @Autowired
    private PreguntaService preguntaService;

    @PostMapping
    public ResponseEntity<Pregunta> agregarPreguntaAEncuesta(@RequestBody Long encuestaId, @RequestBody  String contenido) throws URISyntaxException {
        Pregunta pregunta = preguntaService.agregarPreguntaAEncuesta(encuestaId, contenido);

        return ResponseEntity.created(new URI("/api/encuestas/"+pregunta.getId())).body(pregunta);
    }



}
