package com.gustavo.gerenciamento.notas.alunos.dto;

import com.gustavo.gerenciamento.notas.alunos.entities.AlunosEntities;
import com.gustavo.gerenciamento.notas.alunos.entities.TurmaEntities;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class TurmaDTO {
    private UUID turmaId;
    private String nome;
    private List<String> alunosNomes;

    public TurmaDTO(TurmaEntities turma) {
        this.turmaId = turma.getTurmaId();
        this.nome = turma.getNome();
        this.alunosNomes = turma.getAlunos().stream()
                .map(AlunosEntities::getNome) // Obtém apenas os nomes dos alunos
                .collect(Collectors.toList());
    }

    // Getters
    public UUID getTurmaId() { return turmaId; }
    public String getNome() { return nome; }
    public List<String> getAlunosNomes() { return alunosNomes; }
}
