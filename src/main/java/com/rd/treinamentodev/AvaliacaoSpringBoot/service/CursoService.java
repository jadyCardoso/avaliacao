package com.rd.treinamentodev.AvaliacaoSpringBoot.service;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.CursoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public ResponseEntity gravar(CursoDTO cursoDTO) {
        CursoEntity cursoEntity = new CursoEntity();
        cursoEntity.setNomeCurso(cursoDTO.getNome());
        cursoEntity.setNrCargaHoraria(cursoDTO.getCargaHoraria());

        CursoEntity cursoEntity1 = cursoRepository.save(cursoEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body("Curso cadastrado com sucesso. ID: " + cursoEntity1.getIdCurso());
    }

}
