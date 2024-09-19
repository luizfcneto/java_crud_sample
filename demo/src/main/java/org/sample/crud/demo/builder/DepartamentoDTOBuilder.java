package org.sample.crud.demo.builder;

import java.util.List;

import org.sample.crud.demo.dto.DepartamentoDTO;

public class DepartamentoDTOBuilder {

	public DepartamentoDTO departamentoDTO;
	
	public DepartamentoDTOBuilder() {
		this.departamentoDTO = new DepartamentoDTO();
	}
	
	public DepartamentoDTOBuilder addNome(String nome) {
		this.departamentoDTO.setNome(nome);
		return this;
	}
	
	public DepartamentoDTOBuilder addPessoas(List<String> listaPessoas) {
		this.departamentoDTO.setPessoas(listaPessoas);
		this.departamentoDTO.setQuantidadePessoas(listaPessoas.size());
		return this;
	}
	
	public DepartamentoDTOBuilder addPessoa(String pessoa) {
		this.departamentoDTO.getPessoas().add(pessoa);
		this.departamentoDTO.setQuantidadePessoas(this.departamentoDTO.getPessoas().size());
		return this;
	}
	
	public DepartamentoDTO build() {
		return this.departamentoDTO;
	}
	
}
