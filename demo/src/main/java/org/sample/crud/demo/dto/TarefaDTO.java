package org.sample.crud.demo.dto;

import java.time.LocalDateTime;

public class TarefaDTO {
	private long id;
	private String titulo;
    private String descricao;
    private LocalDateTime prazo;
    private DepartamentoDTO departamento;
    private int duracao;
    private String pessoaAlocada;
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
	
	public DepartamentoDTO getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(DepartamentoDTO departamento) {
		this.departamento = departamento;
	}
	
	public int getDuracao() {
		return duracao;
	}
	
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	public String getPessoaAlocada() {
		return pessoaAlocada;
	}
	
	public void setPessoaAlocada(String pessoaAlocada) {
		this.pessoaAlocada = pessoaAlocada;
	}
	
	public boolean isFinalizado() {
		return finalizado;
	}
	
	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
    
}
