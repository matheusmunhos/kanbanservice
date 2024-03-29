package com.tokiomarine.kanbanservice.domain.tarefa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tokiomarine.kanbanservice.domain.funcionario.Funcionario;


public record GetTarefaDTO(
		Long id,
		String titulo,
		String descricao,
		StatusTarefa statusTarefa,
		@JsonIgnoreProperties({"gestor", "email", "senha"})
		Funcionario funcionario
		) {

	public GetTarefaDTO(Tarefa tarefa) {
		this(tarefa.getId(),
				tarefa.getTitulo(),
				tarefa.getDescricao(),
				tarefa.getStatus(),
				tarefa.getFuncionario());
				
			
	}
}
