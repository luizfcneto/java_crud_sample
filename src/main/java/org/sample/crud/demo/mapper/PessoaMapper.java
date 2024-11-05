package org.sample.crud.demo.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.sample.crud.demo.builder.PessoaDTOBuilder;
import org.sample.crud.demo.dto.PessoaDTO;
import org.sample.crud.demo.entity.Pessoa;

public class PessoaMapper {

	public static PessoaDTO entityToDTO(Pessoa pessoa) {
		PessoaDTOBuilder pessoaDTOBuilder = new PessoaDTOBuilder();
				
		return pessoaDTOBuilder
				.addNome(pessoa.getNome())
				.addDepartamento(DepartamentoMapper.entityToDTO(pessoa.getDepartamento()))
				.addTarefas(pessoa.getTarefas().stream().map(tarefa -> TarefaMapper.entityToDTO(tarefa)).collect(Collectors.toList()))
				.build();
		
	}
	
	public static List<PessoaDTO> entitiesToDTO(List<Pessoa> pessoas){
		return pessoas.stream().map(pessoa -> entityToDTO(pessoa)).collect(Collectors.toList());
	}
	
	
}
