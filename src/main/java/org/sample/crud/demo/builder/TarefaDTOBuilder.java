package org.sample.crud.demo.builder;

import java.time.LocalDateTime;

import org.sample.crud.demo.dto.DepartamentoDTO;
import org.sample.crud.demo.dto.TarefaDTO;

public class TarefaDTOBuilder {

	public TarefaDTO tarefaDTO;
	
	public TarefaDTOBuilder() {
		this.tarefaDTO = new TarefaDTO();
	}
	
	public TarefaDTOBuilder addTitulo(String titulo) {
		this.tarefaDTO.setTitulo(titulo);
		return this;
	}
	
	public TarefaDTOBuilder addDescricao(String descricao) {
		this.tarefaDTO.setDescricao(descricao);
		return this;
	}
	
	public TarefaDTOBuilder addPrazo(LocalDateTime prazo) {
		this.tarefaDTO.setPrazo(prazo);
		return this;
	}
	
	public TarefaDTOBuilder addDepartamento(DepartamentoDTO departamento) {
		this.tarefaDTO.setDepartamento(departamento);
		return this;
	}
	
	public TarefaDTOBuilder addDuracao(int duracao) {
		this.tarefaDTO.setDuracao(duracao);
		return this;
	}
	
	public TarefaDTOBuilder addPessoaAlocada(String pessoa) {
		this.tarefaDTO.setPessoaAlocada(pessoa);
		return this;
	}
	
	public TarefaDTOBuilder addFinalizada(boolean finalizada) {
		this.tarefaDTO.setFinalizado(finalizada);
		return this;
	}
	
	public TarefaDTO build() {
		return this.tarefaDTO;
	}
	
}
