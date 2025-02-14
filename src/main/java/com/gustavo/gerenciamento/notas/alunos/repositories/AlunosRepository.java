package com.gustavo.gerenciamento.notas.alunos.repositories;

import com.gustavo.gerenciamento.notas.alunos.entities.AlunosEntities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AlunosRepository extends JpaRepository<AlunosEntities, UUID> {

}
