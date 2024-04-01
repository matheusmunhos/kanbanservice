package com.tokiomarine.kanbanservice.domain.funcionario.exception;

public class FuncionarioNotFoundException extends RuntimeException{

    public FuncionarioNotFoundException(){
        super("Funcionario não encontrado");
    }

    public FuncionarioNotFoundException(String message){
        super(message);
    }
}
