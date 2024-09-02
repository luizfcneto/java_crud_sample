package org.sample.crud.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Pessoa {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
    private String nome;
    
    @ManyToOne
    private Departamento departamento;
    
    @OneToMany(mappedBy = "pessoaAlocada")
    private List<Tarefa> tarefas;
    
    public void setId(long id) {
		this.id = id;
	}
    
    public void setNome(String nome) {
		this.nome = nome;
	}
    
    public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
    
    public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}
    
    public long getId() {
    	return id;
    }
    
    public Departamento getDepartamento() {
		return departamento;
	}
    
    public String getNome() {
		return nome;
	}
    
    public List<Tarefa> getTarefas() {
		return tarefas;
	}
}
