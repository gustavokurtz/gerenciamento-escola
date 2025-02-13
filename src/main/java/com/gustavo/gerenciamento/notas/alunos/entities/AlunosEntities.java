package com.gustavo.gerenciamento.notas.alunos.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
@ToString
@Table(name = "Alunos")
public class AlunosEntities {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID alunoId;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private int idade;

    @Column(nullable = false)
    private String notaTotal;

    public AlunosEntities(String nome, int idade, String notaTotal) {
        this.alunoId = UUID.randomUUID(); // Garante que o UUID seja gerado antes de salvar
        this.nome = nome;
        this.idade = idade;
        this.notaTotal = notaTotal;
    }

}
