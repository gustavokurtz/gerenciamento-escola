package com.gustavo.gerenciamento.notas.alunos.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
@ToString
@Table(name = "Turmas")
public class TurmaEntities {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID TurmaId;

    private String nome;

    @JsonIgnore // 🔴 Impede que os alunos sejam serializados diretamente
    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AlunosEntities> alunos;


}

