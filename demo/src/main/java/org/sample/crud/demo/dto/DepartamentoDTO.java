package org.sample.crud.demo.dto;

import java.util.List;

public class DepartamentoDTO {
	private long id;
	private String nome;
	private List<String> pessoas;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<String> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<String> pessoas) {
		this.pessoas = pessoas;
	}	
	
}
