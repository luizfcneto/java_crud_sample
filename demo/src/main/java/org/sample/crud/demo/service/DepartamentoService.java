package org.sample.crud.demo.service;

import java.util.List;
import java.util.Optional;

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
	
	public List<Departamento> listarTodosDepartamentos(){
		List<Departamento> departamentos = departamentoRepository.findAll();
		return departamentos;
	}
	
	public Optional<Departamento> verificaDepartamentoExistente(Departamento departamento) {
		return departamentoRepository.findById(departamento.getId());
	}
	
	public Departamento confirmarDepartamento(Departamento departamento) {
		Optional<Departamento> departamentoExiste = verificaDepartamentoExistente(departamento);

		if (departamentoExiste.isPresent()) {
			return departamentoExiste.get();
		}
		
		return departamentoRepository.save(departamento);
	}
	
}
