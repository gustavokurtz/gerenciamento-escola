package com.gustavo.gerenciamento.notas.alunos.repositories;

import com.gustavo.gerenciamento.notas.alunos.entities.TurmaEntities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TurmaRepository extends JpaRepository<TurmaEntities, UUID> {
}
