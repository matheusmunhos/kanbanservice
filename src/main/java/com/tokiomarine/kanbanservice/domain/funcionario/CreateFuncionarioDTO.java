package com.tokiomarine.kanbanservice.domain.funcionario;

import com.tokiomarine.kanbanservice.domain.gestor.Gestor;

public record CreateFuncionarioDTO(String nome, String email, String login, String senha, Gestor gestor) {

}
