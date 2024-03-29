package com.tokiomarine.kanbanservice.domain.tarefa;


import com.tokiomarine.kanbanservice.domain.funcionario.Funcionario;
import com.tokiomarine.kanbanservice.domain.funcionario.GetFuncionarioDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "tarefas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tarefa {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusTarefa status;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    public Tarefa(CreateTarefaDTO dto) {
    	this.titulo = dto.titulo();
    	this.descricao = dto.descricao();
    	this.status = dto.status();
    	this.funcionario = dto.funcionario();
    }
    
    
   
}
