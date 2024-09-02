package org.sample.crud.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Tarefa {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    
    private String titulo;
    
    private String descricao;
	
    private LocalDateTime prazo;
    
    @ManyToOne
	private Departamento departamento;
    
    private int duracao;
    
    @ManyToOne
    private Pessoa pessoaAlocada;
    
    private boolean finalizado;
    
    public long getId() {
    	return id;
    }
    
    public void setId(long id) {
    	this.id = id;
    }
    
    public String getTitulo() {
    	return titulo;
    }
    
    public void setTitulo(String titulo) {
    	this.titulo = titulo;
    }
    
    public String getDescricao() {
    	return descricao;
    }
    
    public void setDescricao(String descricao) {
    	this.descricao = descricao;
    }
    
    public LocalDateTime getPrazo() {
    	return prazo;
    }
    
    public void setPrazo(LocalDateTime prazo) {
    	this.prazo = prazo;
    }
    
    public Departamento getDepartamento() {
    	return departamento;
    }
    
    public void setDepartamento(Departamento departamento) {
    	this.departamento = departamento;
    }
    
    public int getDuracao() {
    	return duracao;
    }
    
    public void setDuracao(int duracao) {
    	this.duracao = duracao;
    }
    
    public Pessoa getPessoaAlocada() {
    	return pessoaAlocada;
    }
    
    public void setPessoaAlocada(Pessoa pessoaAlocada) {
    	this.pessoaAlocada = pessoaAlocada;
    }
    
    public boolean isFinalizado() {
    	return finalizado;
    }
    
    public void setFinalizado(boolean finalizado) {
    	this.finalizado = finalizado;
    }
}
