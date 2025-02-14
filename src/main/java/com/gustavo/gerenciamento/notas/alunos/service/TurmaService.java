package com.gustavo.gerenciamento.notas.alunos.service;

import com.gustavo.gerenciamento.notas.alunos.entities.TurmaEntities;
import com.gustavo.gerenciamento.notas.alunos.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TurmaService {

    @Autowired
    TurmaRepository turmaRepository;

    public List<TurmaEntities> listarTurmas(){
        return turmaRepository.findAll();
    }

    public TurmaEntities criarTurma(TurmaEntities turmaEntities){
        return turmaRepository.save(turmaEntities);
    }

    public void DeletarTurma(UUID uuid){
        turmaRepository.deleteById(uuid);
    }

}
