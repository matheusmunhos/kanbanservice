package com.tokiomarine.kanbanservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tokiomarine.kanbanservice.domain.tarefa.CreateTarefaDTO;
import com.tokiomarine.kanbanservice.domain.tarefa.GetTarefaDTO;
import com.tokiomarine.kanbanservice.domain.tarefa.Tarefa;
import com.tokiomarine.kanbanservice.repositories.TarefaRepository;
import com.tokiomarine.kanbanservice.service.TarefaService;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

	@Autowired
	TarefaRepository repository;
	
	@Autowired
	TarefaService tarefaService;
	
	
	@Transactional
	@PostMapping("/create")
	public void CriarTarefa (@RequestBody CreateTarefaDTO createTarefaDTO) {
		var tarefa = new Tarefa(createTarefaDTO);

		repository.save(tarefa);
	}
	
	
	@GetMapping("/{id}")
	public GetTarefaDTO buscarTarefa(@PathVariable Long id) {
	    var tarefa = repository.findById(id).orElse(null);
	    var tarefaResponse = new GetTarefaDTO(tarefa);
	    return tarefaResponse;
	}
	
	@GetMapping("/funcionario/{funcionarioId}")
    public List<GetTarefaDTO> getTarefasDoFuncionario(@PathVariable Long funcionarioId) {
        return tarefaService.buscarTarefasPorFuncionarioId(funcionarioId);
    }
}
