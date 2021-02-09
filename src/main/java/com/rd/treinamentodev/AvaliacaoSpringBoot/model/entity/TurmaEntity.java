package com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "TB_TURMA")
@Data
public class TurmaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TURMA")
    private Long idTurma;

    @ManyToOne
    @JoinColumn(name = "ID_CURSO")
    private CursoEntity curso;

    @Column(name = "DT_INICIO")
    private Date dtInicio;

    @Column(name = "DT_FINAL")
    private Date dtFinal;

    @ManyToMany
    @JoinTable(
            name = "TB_TURMA_INSTRUTOR",
            joinColumns = @JoinColumn(name = "ID_TURMA"),
            inverseJoinColumns = @JoinColumn(name = "ID_INSTRUTOR")
    )
    private List<InstrutorEntity> instrutores;

    @ManyToMany
    @JoinTable(
            name = "TB_TURMA_ALUNO",
            joinColumns = @JoinColumn(name = "ID_TURMA"),
            inverseJoinColumns = @JoinColumn(name = "ID_ALUNO")
    )
    private List<AlunoEntity> alunos;

}
