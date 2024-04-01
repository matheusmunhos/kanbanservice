package com.tokiomarine.kanbanservice.domain.gestor.service;

import com.tokiomarine.kanbanservice.domain.funcionario.GetFuncionarioDTO;
import com.tokiomarine.kanbanservice.domain.gestor.CreateGestorDTO;
import com.tokiomarine.kanbanservice.domain.gestor.Gestor;
import com.tokiomarine.kanbanservice.domain.gestor.GetGestorDTO;
import com.tokiomarine.kanbanservice.domain.gestor.exception.GestorNotFoundException;
import com.tokiomarine.kanbanservice.domain.tarefa.CreateTarefaDTO;
import com.tokiomarine.kanbanservice.repositories.FuncionarioRepository;
import com.tokiomarine.kanbanservice.repositories.GestorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GestorService {

    private GestorRepository repository;
    private FuncionarioRepository funcionarioRepository;

    public GestorService(GestorRepository gestorRepository, FuncionarioRepository funcionarioRepository){

        this.repository = gestorRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    public void cadastrar(CreateGestorDTO createGestorDTO){
        var gestor = new Gestor(createGestorDTO);
        repository.save(gestor);
    }

    public GetGestorDTO buscar(Long id){
        var gestor = repository.findById(id).orElseThrow(GestorNotFoundException::new);
        var gestorResponse = new GetGestorDTO(gestor);
        return gestorResponse;
    }

    public List<GetFuncionarioDTO> buscarFuncionarios(Long id){
        var gestor = repository.findById(id).orElseThrow(GestorNotFoundException::new);
        var funcionarios = funcionarioRepository.findByGestor(gestor);
        return funcionarios.stream()
                .map(GetFuncionarioDTO::new)
                .collect(Collectors.toList());
    }

}
