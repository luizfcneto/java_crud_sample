package org.sample.crud.demo.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.sample.crud.demo.builder.TarefaDTOBuilder;
import org.sample.crud.demo.dto.TarefaDTO;
import org.sample.crud.demo.entity.Tarefa;

public class TarefaMapper {

	public static TarefaDTO entityToDTO(Tarefa tarefa) {
		TarefaDTOBuilder tarefaDTOBuilder = new TarefaDTOBuilder();
		
		return tarefaDTOBuilder
				.addTitulo(tarefa.getTitulo())
				.addDescricao(tarefa.getDescricao())
				.addDuracao(tarefa.getDuracao())
				.addDepartamento(DepartamentoMapper.entityToDTO(tarefa.getDepartamento()))
				.addPessoaAlocada(tarefa.getPessoaAlocada() != null ? tarefa.getPessoaAlocada().getNome() : null)
				.addPrazo(tarefa.getPrazo())
				.addFinalizada(tarefa.isFinalizado())
				.build();
	}
	
	public static List<TarefaDTO> entitiesToDTO(List<Tarefa> tarefas){
		return tarefas.stream().map(tarefa -> entityToDTO(tarefa)).collect(Collectors.toList());
	}
	
}
