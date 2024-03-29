package com.tokiomarine.kanbanservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.tokiomarine.kanbanservice.domain.gestor.Gestor;

@Component
public interface GestorRepository extends JpaRepository<Gestor, Long> {
}
