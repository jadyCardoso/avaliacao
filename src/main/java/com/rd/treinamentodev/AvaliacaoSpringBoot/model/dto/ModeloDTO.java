package com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ModeloDTO {

    private Long idModulo;

    private String nome;

    private Long idInstrutor;
}
