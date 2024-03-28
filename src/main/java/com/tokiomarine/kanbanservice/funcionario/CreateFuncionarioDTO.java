package com.tokiomarine.kanbanservice.funcionario;

import com.tokiomarine.kanbanservice.gestor.Gestor;

public record CreateFuncionarioDTO(String nome, String email, String login, String senha, Gestor gestor) {

}
