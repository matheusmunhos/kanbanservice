package com.tokiomarine.kanbanservice.repositories;

import com.tokiomarine.kanbanservice.domain.gestor.Gestor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tokiomarine.kanbanservice.domain.funcionario.Funcionario;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    List<Funcionario> findByGestor(Gestor gestor);
}
