package com.tokiomarine.kanbanservice.tarefa;

import com.tokiomarine.kanbanservice.funcionario.Funcionario;

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
