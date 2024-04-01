package com.tokiomarine.kanbanservice.domain.tarefa.service;

import java.util.List;
import java.util.stream.Collectors;

import com.tokiomarine.kanbanservice.domain.tarefa.CreateTarefaDTO;
import org.springframework.stereotype.Service;

import com.tokiomarine.kanbanservice.domain.tarefa.GetTarefaDTO;
import com.tokiomarine.kanbanservice.domain.tarefa.Tarefa;
import com.tokiomarine.kanbanservice.repositories.TarefaRepository;

@Service
public class TarefaService {


    private TarefaRepository repository;
    public TarefaService(TarefaRepository tarefaRepositorysitoryo){
        this.repository = tarefaRepositorysitoryo;
    }


    public void create(CreateTarefaDTO createTarefaDTO){
        var tarefa = new Tarefa(createTarefaDTO);
        repository.save(tarefa);
    }

    public GetTarefaDTO getTarefa(Long id){
        var tarefa = repository.findById(id).orElse(null);
        var tarefaResponse = new GetTarefaDTO(tarefa);
        return tarefaResponse;
    }

	
	public List<GetTarefaDTO> buscarTarefasPorFuncionarioId(Long funcionarioId) {
        
        List<Tarefa> tarefas = repository.findByFuncionarioId(funcionarioId);
        
        return tarefas.stream()
                      .map(GetTarefaDTO::new)
                      .collect(Collectors.toList());
    }

}
