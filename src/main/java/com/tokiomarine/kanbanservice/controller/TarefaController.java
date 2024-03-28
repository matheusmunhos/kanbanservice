package com.tokiomarine.kanbanservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tokiomarine.kanbanservice.funcionario.CreateFuncionarioDTO;
import com.tokiomarine.kanbanservice.funcionario.Funcionario;
import com.tokiomarine.kanbanservice.gestor.Gestor;
import com.tokiomarine.kanbanservice.tarefa.CreateTarefaDTO;
import com.tokiomarine.kanbanservice.tarefa.Tarefa;
import com.tokiomarine.kanbanservice.tarefa.TarefaRepository;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

	@Autowired
	TarefaRepository repository;
	
	
	@Transactional
	@PostMapping("/create")
	public void CriarTarefa (@RequestBody CreateTarefaDTO createTarefaDTO) {
		var tarefa = new Tarefa(createTarefaDTO);
		repository.save(tarefa);
	}
	
	@GetMapping("/{id}")
	public Tarefa buscarTarefa(@PathVariable("id") Long id) {
	    return repository.findById(id).orElse(null);
	}
}
