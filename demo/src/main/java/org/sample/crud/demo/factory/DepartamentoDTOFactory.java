package org.sample.crud.demo.factory;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.sample.crud.demo.dto.DepartamentoDTO;
import org.sample.crud.demo.entity.Departamento;
import org.springframework.stereotype.Component;

@Component
public class DepartamentoDTOFactory {

	public DepartamentoDTO createFromEntity(Departamento departamento) {
		DepartamentoDTO dto = new DepartamentoDTO();
		dto.setId(departamento.getId());
		dto.setNome(departamento.getNome());
		dto.setPessoas(departamento.getPessoas() != null
				? departamento.getPessoas().stream().map(pessoa -> pessoa.getNome()).collect(Collectors.toList())
				: Collections.emptyList());

		if (dto.getPessoas() != null) {
			dto.setQuantidadePessoas(dto.getPessoas().size());
		}

		return dto;
	}

	public List<DepartamentoDTO> createFromEntities(List<Departamento> departamentos) {
		return departamentos.stream().map(departamento -> this.createFromEntity(departamento))
				.collect(Collectors.toList());

	}

}
