package com.tokiomarine.kanbanservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tokiomarine.kanbanservice.domain.tarefa.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

	List<Tarefa> findByFuncionarioId(Long funcionarioId);
}
