package com.tokiomarine.kanbanservice.controller;

import java.util.List;

import com.tokiomarine.kanbanservice.domain.funcionario.GetFuncionarioDTO;
import com.tokiomarine.kanbanservice.domain.tarefa.UpdateTarefaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.tokiomarine.kanbanservice.domain.tarefa.CreateTarefaDTO;
import com.tokiomarine.kanbanservice.domain.tarefa.GetTarefaDTO;
import com.tokiomarine.kanbanservice.domain.tarefa.Tarefa;
import com.tokiomarine.kanbanservice.repositories.TarefaRepository;
import com.tokiomarine.kanbanservice.domain.tarefa.service.TarefaService;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

	private TarefaService service;

	public TarefaController(TarefaService tarefaService ){
	this.service = tarefaService;
	}

	@Transactional
	@PostMapping("/create")
	public void CriarTarefa (@RequestBody CreateTarefaDTO createTarefaDTO) {
		service.create(createTarefaDTO);
	}

	@GetMapping("/{id}")
	public GetTarefaDTO buscarTarefa(@PathVariable Long id) {
		return service.getTarefa(id);
	}
	
	@GetMapping("/funcionario/{funcionarioId}")
    public List<GetTarefaDTO> getTarefasDoFuncionario(@PathVariable Long funcionarioId) {
        return service.buscarTarefasPorFuncionarioId(funcionarioId);
    }

	@PutMapping("/{id}")
	public void atualizar (@PathVariable Long id, @RequestBody UpdateTarefaDTO updateTarefaDTO){
	service.atualizar(id, updateTarefaDTO);
	}


}
