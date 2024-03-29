package com.tokiomarine.kanbanservice.domain.tarefa;

import com.tokiomarine.kanbanservice.domain.funcionario.Funcionario;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record CreateTarefaDTO(
		
		String titulo,
		String descricao,
		@Enumerated(EnumType.STRING)
		StatusTarefa status,
		Funcionario funcionario
		
		) {

}
