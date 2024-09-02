package org.sample.crud.demo.factory;

import java.util.stream.Collectors;

import org.sample.crud.demo.dto.PessoaDTO;
import org.sample.crud.demo.entity.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PessoaDTOFactory {

	@Autowired
	private DepartamentoDTOFactory departamentoDTOFactory;

	@Autowired
	private TarefaDTOFactory tarefaDTOFactory;

	public PessoaDTO createFromEntity(Pessoa pessoa) {
		PessoaDTO dto = new PessoaDTO();
		dto.setId(pessoa.getId());
		dto.setNome(pessoa.getNome());
		dto.setDepartamento(departamentoDTOFactory.createFromEntity(pessoa.getDepartamento()));
		dto.setTarefas(pessoa.getTarefas().stream().map(tarefa -> tarefaDTOFactory.createFromEntity(tarefa))
				.collect(Collectors.toList()));
		return dto;
	}

}
