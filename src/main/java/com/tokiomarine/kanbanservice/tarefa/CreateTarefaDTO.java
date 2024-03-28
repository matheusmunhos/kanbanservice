package com.tokiomarine.kanbanservice.tarefa;

import com.tokiomarine.kanbanservice.funcionario.Funcionario;

public record CreateTarefaDTO(
		
		String titulo,
		String descricao,
		StatusTarefa status,
		Funcionario funcionario
		
		) {

}
