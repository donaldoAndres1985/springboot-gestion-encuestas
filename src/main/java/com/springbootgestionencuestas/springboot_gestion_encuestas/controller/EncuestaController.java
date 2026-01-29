package com.springbootgestionencuestas.springboot_gestion_encuestas.controller;


import com.springbootgestionencuestas.springboot_gestion_encuestas.model.Encuesta;
import com.springbootgestionencuestas.springboot_gestion_encuestas.services.EncuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/encuestas")
public class EncuestaController {

    @Autowired
    private EncuestaService encuestaService;

    @PostMapping
    public ResponseEntity<Encuesta> crearEncuesta(@RequestBody String titulo) throws URISyntaxException {
        Encuesta encuesta = encuestaService.crearEncuesta(titulo);
        return ResponseEntity.created(new URI("/api/encuestas/"+encuesta.getId())).body(encuesta);
    }

    @GetMapping
    public List<Encuesta> obtenerTodasLasEncuestas() {
        return encuestaService.obtenerTodasLasEncuestas();
    }

    @GetMapping("/{encuestaId}")
    public ResponseEntity<Encuesta> obtenerDetallesEncuesta(@PathVariable Long encuestaId) {
        Optional<Encuesta> OptionalEncuesta  = encuestaService.obtenerDetallesEncuesta(encuestaId);
        return OptionalEncuesta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{encuestaId}")
    public ResponseEntity<Encuesta> actualizarEncuesta(@PathVariable Long encuestaId, @PathVariable String nuevoTitulo){
        Encuesta encuestaActualizada =  encuestaService.actualizarEncuesta(encuestaId, nuevoTitulo);
        return encuestaActualizada != null ? ResponseEntity.ok().body(encuestaActualizada)  : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{encuestaId}")
    public void eliminarEncuesta(@PathVariable Long encuestaId) {
        encuestaService.eliminarEncuesta(encuestaId);
    }

}
