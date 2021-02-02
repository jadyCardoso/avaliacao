package com.rd.treinamentodev.AvaliacaoSpringBoot.service;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.CursoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public void inserir(CursoDTO dto) {
        CursoEntity entity = parseToEntity(dto, null);
        if (entity.getNomeCurso() != null)
            cursoRepository.save(entity);
    }

    public CursoEntity parseToEntity(CursoDTO dto, CursoEntity entity) {
        if (entity == null)
            entity = new CursoEntity();

        if (dto == null)
            return entity;

        entity.setNomeCurso(dto.getNome());
        entity.setNrCargaHoraria(dto.getCargaHoraria());
        return entity;
    }

}
