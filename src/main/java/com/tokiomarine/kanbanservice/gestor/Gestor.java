package com.tokiomarine.kanbanservice.gestor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "gestores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Gestor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String login;
    private String senha;

    public Gestor(CreateGestorDTO dto) {
        this.nome = dto.nome();
        this.email = dto.email();
        this.login = dto.login();
        this.senha = dto.senha();
    }
}
