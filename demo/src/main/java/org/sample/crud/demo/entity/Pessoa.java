package org.sample.crud.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
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
    
    @OneToMany(mappedBy = "pessoaAlocada", cascade = CascadeType.ALL, orphanRemoval = true)
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
