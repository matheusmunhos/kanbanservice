package com.tokiomarine.kanbanservice.controller;

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

@RestController
@RequestMapping("/gestor")
public class GestorController {

	@Autowired
	GestorRepository repository;

	@Transactional
	@PostMapping("/create")
	public void Cadastrar (@RequestBody CreateGestorDTO createGestorDTO){
		var gestor = new Gestor(createGestorDTO);
		repository.save(gestor);
	};
	
	@GetMapping("/{id}")
	public GetGestorDTO buscarGestor(@PathVariable Long id) {
	    var gestor = repository.findById(id).orElse(null);
	    var gestorResponse = new GetGestorDTO(gestor);
	    return gestorResponse;
	    
	}







}
