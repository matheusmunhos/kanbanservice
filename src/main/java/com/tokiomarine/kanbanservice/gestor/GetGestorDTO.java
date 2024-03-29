package com.tokiomarine.kanbanservice.gestor;

public record GetGestorDTO(Long id, String nome) {

	public GetGestorDTO(Gestor gestor) {
		this(gestor.getId(), gestor.getNome());
	}

}
