package com.tokiomarine.kanbanservice.domain.tarefa.service;

import java.util.List;
import java.util.stream.Collectors;

import com.tokiomarine.kanbanservice.domain.tarefa.CreateTarefaDTO;
import com.tokiomarine.kanbanservice.domain.tarefa.UpdateTarefaDTO;
import com.tokiomarine.kanbanservice.domain.tarefa.exception.TarefaNotFoundException;
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

    public void atualizar (Long id, UpdateTarefaDTO updateTarefaDTO){
        Tarefa tarefa = repository.findById(id).orElseThrow(TarefaNotFoundException::new);
        if(!updateTarefaDTO.titulo().isEmpty()) tarefa.setTitulo(updateTarefaDTO.titulo());
        if(!updateTarefaDTO.descricao().isEmpty()) tarefa.setDescricao(updateTarefaDTO.descricao());
        if(updateTarefaDTO.status() != null){
            tarefa.setStatus(updateTarefaDTO.status());
        }
        if(updateTarefaDTO.funcionario() != null){
            tarefa.setFuncionario(updateTarefaDTO.funcionario());
        }
        repository.save(tarefa);
    }

}
