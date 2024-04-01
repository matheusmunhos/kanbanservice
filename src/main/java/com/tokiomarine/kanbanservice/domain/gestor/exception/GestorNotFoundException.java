package com.tokiomarine.kanbanservice.domain.gestor.exception;

public class GestorNotFoundException extends RuntimeException {

    public GestorNotFoundException(){
        super("Gestor não encontrado.");
    }

    public GestorNotFoundException(String message){
        super(message);
    }
}
