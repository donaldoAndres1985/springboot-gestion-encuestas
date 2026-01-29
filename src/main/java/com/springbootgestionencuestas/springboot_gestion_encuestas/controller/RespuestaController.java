package com.springbootgestionencuestas.springboot_gestion_encuestas.controller;

import com.springbootgestionencuestas.springboot_gestion_encuestas.services.PreguntaService;
import com.springbootgestionencuestas.springboot_gestion_encuestas.services.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/encuestas")
public class RespuestaController {

    @Autowired
    private RespuestaService respuestaService;

}
