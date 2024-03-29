package com.tokiomarine.kanbanservice.domain.funcionario;

public record GetFuncionarioDTO(Long id, String nome, String login) {

	public GetFuncionarioDTO(Funcionario funcionario) {
		this(funcionario.getId(), funcionario.getNome(), funcionario.getLogin());
	}
}
