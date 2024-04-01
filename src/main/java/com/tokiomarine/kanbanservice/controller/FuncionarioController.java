package com.tokiomarine.kanbanservice.controller;

import com.tokiomarine.kanbanservice.domain.funcionario.service.FuncionarioService;
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

	private FuncionarioService service;

	public FuncionarioController(FuncionarioService funcionarioService){
		this.service = funcionarioService;
	}
	
	@Transactional
	@PostMapping("/create")
	public void Cadastrar (@RequestBody CreateFuncionarioDTO createFuncionarioDTO) {
		service.criar(createFuncionarioDTO);
	}
	
	@GetMapping("/{id}")
	public GetFuncionarioDTO buscarFuncionario(@PathVariable Long id) {
	    return service.buscar(id);
    }

}
