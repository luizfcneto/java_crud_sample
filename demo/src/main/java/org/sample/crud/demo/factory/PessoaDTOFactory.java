package org.sample.crud.demo.factory;

import java.util.stream.Collectors;

import org.sample.crud.demo.dto.PessoaDTO;
import org.sample.crud.demo.entity.Pessoa;
import org.springframework.stereotype.Component;

@Component
public class PessoaDTOFactory {

	public static PessoaDTOFactory pessoaDTOFactory;

	public PessoaDTOFactory() {
	}

	public static PessoaDTOFactory getInstance() {
		if (pessoaDTOFactory == null) {
			pessoaDTOFactory = new PessoaDTOFactory();
		}
		return pessoaDTOFactory;
	}

	private DepartamentoDTOFactory departamentoDTOFactory = DepartamentoDTOFactory.getInstance();

	private TarefaDTOFactory tarefaDTOFactory = TarefaDTOFactory.getInstance();

	public PessoaDTO createFromEntity(Pessoa pessoa) {
		PessoaDTO dto = new PessoaDTO();
		dto.setNome(pessoa.getNome());
		dto.setDepartamento(departamentoDTOFactory.createFromEntity(pessoa.getDepartamento()));
		dto.setTarefas(pessoa.getTarefas().stream().map(tarefa -> tarefaDTOFactory.createFromEntity(tarefa))
				.collect(Collectors.toList()));

		if (dto.getTarefas().size() > 0) {
			int totalHorasGastas = dto.getTarefas().stream().mapToInt(tarefa -> tarefa.getDuracao()).sum();
			dto.setTotalHorasGastas(totalHorasGastas);

			dto.setMediaHorasGastasPorTarefa(totalHorasGastas / dto.getTarefas().size());
		}

		return dto;
	}

}
