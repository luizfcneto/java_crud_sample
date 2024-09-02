package org.sample.crud.demo.service;

import java.util.List;

import org.sample.crud.demo.dto.DepartamentoDTO;
import org.sample.crud.demo.entity.Departamento;
import org.sample.crud.demo.factory.DepartamentoDTOFactory;
import org.sample.crud.demo.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartamentoService {

	@Autowired
	DepartamentoRepository departamentoRepository;
	
	@Autowired
	DepartamentoDTOFactory departamentoDTOFactory;
	
	public List<DepartamentoDTO> listarTodosDepartamentos(){
		List<Departamento> departamentos = departamentoRepository.findAll();
		return departamentoDTOFactory.createFromEntities(departamentos);
	}
	
}
