package org.sample.crud.demo.factory;

import java.util.Collections;
import java.util.stream.Collectors;

import org.sample.crud.demo.dto.DepartamentoDTO;
import org.sample.crud.demo.entity.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
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
		return dto;
	}

}
