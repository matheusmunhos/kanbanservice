package com.tokiomarine.kanbanservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tokiomarine.kanbanservice.gestor.Gestor;
import com.tokiomarine.kanbanservice.gestor.CreateGestorDTO;
import com.tokiomarine.kanbanservice.gestor.GestorRepository;

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
	public Gestor buscarGestor(@PathVariable("id") Long id) {
	    return repository.findById(id).orElse(null);
	}







}
