package org.sample.crud.demo.controller;

import java.util.List;

import org.sample.crud.demo.dto.DepartamentoDTO;
import org.sample.crud.demo.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

	@Autowired
	DepartamentoService departamentoService;
	
	@GetMapping
	public ResponseEntity<List<DepartamentoDTO>> listarDepartamentos(){
		try {
			List<DepartamentoDTO> departamentos = departamentoService.listarTodosDepartamentos();
			return new ResponseEntity<List<DepartamentoDTO>>(departamentos, HttpStatusCode.valueOf(200));
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatusCode.valueOf(500));
		}
	}
}
