package org.sample.crud.demo.dto;

import java.util.List;

public class DepartamentoDTO {
	private String nome;
	private List<String> pessoas;
	private int quantidadePessoas;
		
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

	public int getQuantidadePessoas() {
		return quantidadePessoas;
	}

	public void setQuantidadePessoas(int quantidadePessoas) {
		this.quantidadePessoas = quantidadePessoas;
	}	
		
}
