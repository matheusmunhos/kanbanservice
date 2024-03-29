package com.tokiomarine.kanbanservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tokiomarine.kanbanservice.domain.funcionario.CreateFuncionarioDTO;
import com.tokiomarine.kanbanservice.domain.funcionario.Funcionario;
import com.tokiomarine.kanbanservice.domain.funcionario.GetFuncionarioDTO;
import com.tokiomarine.kanbanservice.repositories.FuncionarioRepository;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	@Autowired
	FuncionarioRepository repository;
	
	@Transactional
	@PostMapping("/create")
	public void Cadastrar (@RequestBody CreateFuncionarioDTO createFuncionarioDTO) {
		var funcionario = new Funcionario(createFuncionarioDTO);
		repository.save(funcionario);
	}
	
	@GetMapping("/{id}")
	public GetFuncionarioDTO buscarFuncionario(@PathVariable Long id) {
	    var funcionario = repository.findById(id).orElse(null);
	    var funcionarioResponse = new GetFuncionarioDTO(funcionario);
	    return funcionarioResponse;
	}
	
	
}
