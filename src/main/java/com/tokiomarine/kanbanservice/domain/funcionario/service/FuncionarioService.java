package com.tokiomarine.kanbanservice.domain.funcionario.service;

import com.tokiomarine.kanbanservice.domain.funcionario.CreateFuncionarioDTO;
import com.tokiomarine.kanbanservice.domain.funcionario.Funcionario;
import com.tokiomarine.kanbanservice.domain.funcionario.GetFuncionarioDTO;
import com.tokiomarine.kanbanservice.repositories.FuncionarioRepository;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    private FuncionarioRepository repository;

    public FuncionarioService (FuncionarioRepository funcionarioRepository){
        this.repository = funcionarioRepository;
    }

    public void criar (CreateFuncionarioDTO createFuncionarioDTO){
        var funcionario = new Funcionario(createFuncionarioDTO);
        repository.save(funcionario);
    }

    public GetFuncionarioDTO buscar(Long id){
       var funcionario = repository.findById(id).orElse(null);
       var funcionarioResponse = new GetFuncionarioDTO(funcionario);
       return  funcionarioResponse;
    }
}
