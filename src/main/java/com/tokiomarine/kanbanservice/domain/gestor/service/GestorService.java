package com.tokiomarine.kanbanservice.domain.gestor.service;

import com.tokiomarine.kanbanservice.domain.gestor.CreateGestorDTO;
import com.tokiomarine.kanbanservice.domain.gestor.Gestor;
import com.tokiomarine.kanbanservice.domain.gestor.GetGestorDTO;
import com.tokiomarine.kanbanservice.domain.tarefa.CreateTarefaDTO;
import com.tokiomarine.kanbanservice.repositories.GestorRepository;
import org.springframework.stereotype.Service;

@Service
public class GestorService {

    private GestorRepository repository;

    public GestorService(GestorRepository gestorRepository){
        this.repository = gestorRepository;
    }

    public void cadastrar(CreateGestorDTO createGestorDTO){
        var gestor = new Gestor(createGestorDTO);
        repository.save(gestor);
    }

    public GetGestorDTO buscar(Long id){
        var gestor = repository.findById(id).orElse(null);
        var gestorResponse = new GetGestorDTO(gestor);
        return gestorResponse;
    }
}
