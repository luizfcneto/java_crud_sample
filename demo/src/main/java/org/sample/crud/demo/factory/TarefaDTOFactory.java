package org.sample.crud.demo.factory;

import java.util.List;
import java.util.stream.Collectors;

import org.sample.crud.demo.dto.TarefaDTO;
import org.sample.crud.demo.entity.Tarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TarefaDTOFactory {

	@Autowired
	private DepartamentoDTOFactory departamentoDTOFactory;

	public TarefaDTO createFromEntity(Tarefa tarefa) {
		TarefaDTO dto = new TarefaDTO();
		dto.setId(tarefa.getId());
		dto.setTitulo(tarefa.getTitulo());
		dto.setDescricao(tarefa.getDescricao());
		dto.setPrazo(tarefa.getPrazo());
		dto.setDepartamento(departamentoDTOFactory.createFromEntity(tarefa.getDepartamento()));
		dto.setDuracao(tarefa.getDuracao());
		dto.setPessoaAlocada(tarefa.getPessoaAlocada() != null ? tarefa.getPessoaAlocada().getNome() : null);
		dto.setFinalizado(tarefa.isFinalizado());
		return dto;
	}

	public List<TarefaDTO> createFromEntities(List<Tarefa> tarefas) {
		return tarefas.stream().map(tarefa -> this.createFromEntity(tarefa)).collect(Collectors.toList());
	}
}
