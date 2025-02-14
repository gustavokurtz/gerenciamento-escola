package com.gustavo.gerenciamento.notas.alunos.service;


import com.gustavo.gerenciamento.notas.alunos.entities.AlunosEntities;
import com.gustavo.gerenciamento.notas.alunos.entities.TurmaEntities;
import com.gustavo.gerenciamento.notas.alunos.repositories.AlunosRepository;
import com.gustavo.gerenciamento.notas.alunos.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AlunosService {

    private final AlunosRepository alunosRepository;
    private final TurmaRepository turmaRepository;

    @Autowired
    public AlunosService(AlunosRepository alunosRepository, TurmaRepository turmaRepository) {
        this.alunosRepository = alunosRepository;
        this.turmaRepository = turmaRepository;
    }

    public List<AlunosEntities> listarAluno() {
        return alunosRepository.findAll();
    }

    public AlunosEntities criarAluno(AlunosEntities alunosEntities) {
        if (alunosEntities.getTurma() == null || alunosEntities.getTurma().getTurmaId() == null) {
            throw new RuntimeException("ID da turma é obrigatório");
        }

        // Buscar a Turma no banco antes de associar ao aluno
        TurmaEntities turma = turmaRepository.findById(alunosEntities.getTurma().getTurmaId())
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));

        alunosEntities.setTurma(turma); // Associando a turma ao aluno
        return alunosRepository.save(alunosEntities);
    }

    public AlunosEntities listarAlunoId(UUID uuid) {
        return alunosRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Usuário não existe!"));
    }

    public void deleteAlunoId(UUID uuid) {
        alunosRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Usuário não existe!"));

        alunosRepository.deleteById(uuid);
    }

    public AlunosEntities atualizarAlunoId(UUID uuid, AlunosEntities alunosEntities) {
        AlunosEntities alunoAtualizado = alunosRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Usuário não existe!"));

        alunoAtualizado.setNome(alunosEntities.getNome());
        alunoAtualizado.setIdade(alunosEntities.getIdade());
        alunoAtualizado.setNota(alunosEntities.getNota());

        return alunosRepository.save(alunoAtualizado);
    }
}

