package com.gustavo.gerenciamento.notas.alunos.controller;

import com.gustavo.gerenciamento.notas.alunos.entities.AlunosEntities;
import com.gustavo.gerenciamento.notas.alunos.service.AlunosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    AlunosService alunosService;

    @GetMapping
    public ResponseEntity<List<AlunosEntities>> listarAluno(){
        return ResponseEntity.ok(alunosService.listarAluno());
    }

    @PostMapping
    public ResponseEntity<AlunosEntities> adicionarAluno(@RequestBody  AlunosEntities alunosEntities) {

        AlunosEntities novoAluno = alunosService.criarAluno(alunosEntities);

        return ResponseEntity.ok(novoAluno);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<AlunosEntities> listarAlunoId(@PathVariable UUID uuid){
        return ResponseEntity.ok(alunosService.listarAlunoId(uuid));
    }

    @PutMapping("/{uuid}")
    public void atualizarAlunoId(@PathVariable UUID uuid, @RequestBody AlunosEntities alunosEntities){
        alunosService.atualizarAlunoId(uuid, alunosEntities);

    }

    @DeleteMapping("/{uuid}")
    public void DeletarAlunoId(@PathVariable UUID uuid){
        alunosService.deleteAlunoId(uuid);
    }

}
