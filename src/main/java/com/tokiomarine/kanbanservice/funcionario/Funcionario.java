package com.tokiomarine.kanbanservice.funcionario;


import com.tokiomarine.kanbanservice.gestor.Gestor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String login;
    private String senha;

    @ManyToOne
    @JoinColumn(name = "gestor_id")
    private Gestor gestor;

    public Funcionario(CreateFuncionarioDTO dto) {
    	this.nome = dto.nome();
    	this.email = dto.email();
    	this.login = dto.login();
    	this.senha = dto.senha();
    	this.gestor = dto.gestor();
    }
  
}
