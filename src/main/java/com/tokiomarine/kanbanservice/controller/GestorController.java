package com.tokiomarine.kanbanservice.controller;

import com.tokiomarine.kanbanservice.domain.funcionario.GetFuncionarioDTO;
import com.tokiomarine.kanbanservice.domain.gestor.service.GestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tokiomarine.kanbanservice.domain.gestor.CreateGestorDTO;
import com.tokiomarine.kanbanservice.domain.gestor.Gestor;
import com.tokiomarine.kanbanservice.domain.gestor.GetGestorDTO;
import com.tokiomarine.kanbanservice.repositories.GestorRepository;

import java.util.List;

@RestController
@RequestMapping("/gestor")
public class GestorController {

	private GestorService service;
	public GestorController(GestorService gestorService){
		this.service = gestorService;
	}

	@Transactional
	@PostMapping("/create")
	public void Cadastrar (@RequestBody CreateGestorDTO createGestorDTO){
		service.cadastrar(createGestorDTO);
	};
	
	@GetMapping("/{id}")
	public GetGestorDTO buscarGestor(@PathVariable Long id) {

		return service.buscar(id);
	}

	@GetMapping("/funcionario/{id}")
	public List<GetFuncionarioDTO> getFuncionarioPorGestor(@PathVariable Long id){
	return	service.buscarFuncionarios(id);
	}
}
