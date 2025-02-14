package com.gustavo.gerenciamento.notas.alunos.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String aprovado_ou_reprovado;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private int nota;

    @ManyToOne
    @JoinColumn(name = "turma_id", nullable = false)
    private TurmaEntities turma;



    @JsonIgnore
    public String getStatus() {
        if (this.nota == 0) {
            return "Em Processo"; // Aluno ainda não recebeu nota
        }

        if (this.nota >= 60) {
            return "Aprovado";
        }

        if (this.nota >= 40) {
            return "Recuperação";
        }

        return "Reprovado";
    }

    public void setNota(int nota) {
        this.nota = Math.min(nota, 100);
        this.aprovado_ou_reprovado = getStatus(); // Atualiza automaticamente o status
    }

    @PrePersist
    @PreUpdate
    private void atualizarStatus() {
        this.aprovado_ou_reprovado = getStatus();
    }


    public AlunosEntities(String nome, int idade, int nota) {
        this.alunoId = UUID.randomUUID();
        this.nome = nome;
        this.idade = idade;
        this.nota = nota;
        this.aprovado_ou_reprovado = getStatus();
    }

}
