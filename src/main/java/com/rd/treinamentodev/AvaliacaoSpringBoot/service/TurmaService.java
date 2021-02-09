package com.rd.treinamentodev.AvaliacaoSpringBoot.service;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.AlunoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.CursoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.InstrutorDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.TurmaDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.AlunoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.InstrutorEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.TurmaEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.CursoRepository;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private CursoRepository cursoRepository;

    SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

    public List<TurmaDTO> listar() {
        List<TurmaEntity> listEntity = turmaRepository.findAll();
        List<TurmaDTO> listDTO = new ArrayList<>();

        //TODO implementar a conversão da lista de objetos de TurmaEntity para TurmaDTO e retornar a listDTO preenchida
        for (TurmaEntity turmaEntity : listEntity) {
            //Atribuição CursoEntity ao Objeto do tipo CursoDTO
            CursoEntity cursoEntity = turmaEntity.getCurso();
            CursoDTO cursoDTO = new CursoDTO();
            cursoDTO.setNome(cursoEntity.getNomeCurso());
            cursoDTO.setCargaHoraria(cursoEntity.getNrCargaHoraria());

            TurmaDTO turmaDTO = new TurmaDTO();
            turmaDTO.setCurso(cursoDTO);
            turmaDTO.setDtInicio(SDF.format(turmaEntity.getDtInicio()));
            turmaDTO.setDtFim(SDF.format(turmaEntity.getDtFinal()));

            List<InstrutorDTO> instrutorDTOS = new ArrayList<>();
            for (InstrutorEntity instrutorEntity : turmaEntity.getInstrutores()) {
                InstrutorDTO instrutorDTO = new InstrutorDTO();
                instrutorDTO.setNome(instrutorEntity.getNomeInstrutor());
                instrutorDTO.setValorHora(instrutorEntity.getValorHora());

                instrutorDTOS.add(instrutorDTO);
            }
            turmaDTO.setInstrutores(instrutorDTOS);

            List<AlunoDTO> alunoDTOS = new ArrayList<>();
            for (AlunoEntity alunoEntity : turmaEntity.getAlunos()) {
                AlunoDTO alunoDTO = new AlunoDTO();
                alunoDTO.setNome(alunoEntity.getNomeAluno());
                alunoDTO.setCpf(alunoEntity.getCpf());

                alunoDTOS.add(alunoDTO);
            }
            turmaDTO.setAlunos(alunoDTOS);

            listDTO.add(turmaDTO);
        }

        return listDTO;
    }
}