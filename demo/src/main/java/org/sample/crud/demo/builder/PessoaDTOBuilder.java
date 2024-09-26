package org.sample.crud.demo.builder;

import java.util.List;

import org.sample.crud.demo.dto.DepartamentoDTO;
import org.sample.crud.demo.dto.PessoaDTO;
import org.sample.crud.demo.dto.TarefaDTO;

public class PessoaDTOBuilder {

	public PessoaDTO pessoa;
	
	public PessoaDTOBuilder() {
		this.pessoa = new PessoaDTO();
	}
	
	
	public PessoaDTOBuilder addNome(String nome) {
		this.pessoa.setNome(nome);
		return this;
	}
	
	public PessoaDTOBuilder addDepartamento(DepartamentoDTO departamento) {
		this.pessoa.setDepartamento(departamento);
		return this;
	}
	
	public PessoaDTOBuilder addTarefas(List<TarefaDTO> listaTarefas) {
		this.pessoa.setTarefas(listaTarefas);
		
		if (this.pessoa.getTarefas().size() > 0) {
			int totalHorasGastas = this.pessoa.getTarefas().stream().mapToInt(tarefa -> tarefa.getDuracao()).sum();
			this.pessoa.setTotalHorasGastas(totalHorasGastas);

			this.pessoa.setMediaHorasGastasPorTarefa(totalHorasGastas / this.pessoa.getTarefas().size());
		}
		
		return this;
	}
	
	public PessoaDTO build() {
		return this.pessoa;
	}
	
}
