package com.tokiomarine.kanbanservice.tarefa;

import com.tokiomarine.kanbanservice.funcionario.Funcionario;

public record GetTarefaDTO(Long id, String titulo, String descricao, Funcionario funcionario) {

	public GetTarefaDTO(Tarefa tarefa) {
		this(tarefa.getId(), tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getFuncionario());
	}
}
