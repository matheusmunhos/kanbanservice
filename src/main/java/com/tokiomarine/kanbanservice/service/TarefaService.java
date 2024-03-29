package com.tokiomarine.kanbanservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokiomarine.kanbanservice.domain.tarefa.GetTarefaDTO;
import com.tokiomarine.kanbanservice.domain.tarefa.Tarefa;
import com.tokiomarine.kanbanservice.repositories.TarefaRepository;

@Service
public class TarefaService {
	
	@Autowired
	TarefaRepository repository;
	
	
	public List<GetTarefaDTO> buscarTarefasPorFuncionarioId(Long funcionarioId) {
        // Chame o repositório para buscar as tarefas por ID do funcionário
        List<Tarefa> tarefas = repository.findByFuncionarioId(funcionarioId);
        // Mapeie as tarefas para DTOs e retorne
        return tarefas.stream()
                      .map(GetTarefaDTO::new)
                      .collect(Collectors.toList());
    }

}
