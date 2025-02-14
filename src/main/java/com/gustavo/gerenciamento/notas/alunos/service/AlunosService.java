package com.gustavo.gerenciamento.notas.alunos.service;


import com.gustavo.gerenciamento.notas.alunos.entities.AlunosEntities;
import com.gustavo.gerenciamento.notas.alunos.repositories.AlunosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AlunosService {


    @Autowired
    AlunosRepository alunosRepository;


    public List<AlunosEntities> listarAluno(){
        return alunosRepository.findAll();
    }

    public AlunosEntities criarAluno(AlunosEntities alunosEntities){
        return alunosRepository.save(alunosEntities);
    }

    public AlunosEntities listarAlunoId(UUID uuid){
        return alunosRepository.findById(uuid).orElseThrow(() -> new RuntimeException("Usuário não existe!"));
    }

    public void deleteAlunoId(UUID uuid){
        alunosRepository.findById(uuid).orElseThrow(() -> new RuntimeException("Usuário não existe!"));

        alunosRepository.deleteById(uuid);
    }


    public AlunosEntities atualizarAlunoId(UUID uuid, AlunosEntities alunosEntities){

        AlunosEntities alunoAtualizado = alunosRepository.findById(uuid).orElseThrow(() -> new RuntimeException("Usuário não existe!"));

        alunoAtualizado.setNome(alunosEntities.getNome());
        alunoAtualizado.setIdade(alunosEntities.getIdade());
        alunoAtualizado.setNota(alunosEntities.getNota());

        return alunosRepository.save(alunoAtualizado);


    }


}
