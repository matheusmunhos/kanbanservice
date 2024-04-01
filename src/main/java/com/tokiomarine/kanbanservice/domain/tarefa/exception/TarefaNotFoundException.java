package com.tokiomarine.kanbanservice.domain.tarefa.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;


public class TarefaNotFoundException extends RuntimeException {

    public TarefaNotFoundException() {
        super("Tarefa não encontrada");
    }

    public TarefaNotFoundException(String message) {
        super(message);
    }
}
