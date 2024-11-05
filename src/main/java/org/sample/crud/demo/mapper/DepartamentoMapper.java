package org.sample.crud.demo.mapper;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.sample.crud.demo.builder.DepartamentoDTOBuilder;
import org.sample.crud.demo.dto.DepartamentoDTO;
import org.sample.crud.demo.entity.Departamento;

public class DepartamentoMapper {

	public static DepartamentoDTO entityToDTO(Departamento departamento) {
		DepartamentoDTOBuilder departamentoDTOBuilder = new DepartamentoDTOBuilder();
		return departamentoDTOBuilder
				.addNome(departamento.getNome())
				.addPessoas(departamento.getPessoas() != null
						? departamento.getPessoas().stream().map(pessoa -> pessoa.getNome()).collect(Collectors.toList())
								: Collections.emptyList())
				.build();
	}
	
	public static List<DepartamentoDTO> entitiesToDTO(List<Departamento> departamentos){
		return departamentos.stream().map(departamento -> entityToDTO(departamento))
		.collect(Collectors.toList());
	}
	
}
