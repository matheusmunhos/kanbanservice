package com.tokiomarine.kanbanservice.domain.gestor;

public record GetGestorDTO(Long id, String nome, String login) {

	public GetGestorDTO(Gestor gestor) {
		this(gestor.getId(), gestor.getNome(), gestor.getLogin());
	}

}
