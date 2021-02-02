package com.rd.treinamentodev.AvaliacaoSpringBoot.controller;

import com.rd.treinamentodev.AvaliacaoSpringBoot.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TurmaController {

    @Autowired
    private TurmaService service;

    @GetMapping("/turmas")
    public ResponseEntity listar() {
        return ResponseEntity.ok().body(service.listar());
    }
}
