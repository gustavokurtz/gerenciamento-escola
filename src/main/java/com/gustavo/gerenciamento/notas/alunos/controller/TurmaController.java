package com.gustavo.gerenciamento.notas.alunos.controller;

import com.gustavo.gerenciamento.notas.alunos.dto.TurmaDTO;
import com.gustavo.gerenciamento.notas.alunos.entities.TurmaEntities;
import com.gustavo.gerenciamento.notas.alunos.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired
    TurmaService turmaService;

    @GetMapping
    public List<TurmaDTO> listarTurmas() {
        return turmaService.listarTurmas().stream()
                .map(TurmaDTO::new) // Converte cada TurmaEntities para um DTO
                .collect(Collectors.toList());
    }

    @PostMapping
    public TurmaEntities criarTurma(@RequestBody TurmaEntities turmaEntities){
        return turmaService.criarTurma(turmaEntities);
    }

}
