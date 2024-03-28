package com.tokiomarine.kanbanservice.gestor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface GestorRepository extends JpaRepository<Gestor, Long> {
}
