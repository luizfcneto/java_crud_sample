package org.sample.crud.demo.controller;

import java.util.List;

import org.sample.crud.demo.dto.TarefaDTO;
import org.sample.crud.demo.entity.Tarefa;
import org.sample.crud.demo.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

	@Autowired
	TarefaService tarefaService;
	
	@GetMapping("/pendentes")
	public ResponseEntity<List<TarefaDTO>> listaTarefasPendentes(){
		try {
			List<TarefaDTO> tarefaDTO = tarefaService.buscarTarefasPendentes();
			return new ResponseEntity<List<TarefaDTO>>(tarefaDTO, HttpStatusCode.valueOf(201));
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatusCode.valueOf(500));
		}
	}

	@PostMapping
	public ResponseEntity<TarefaDTO> adicionarTarefa(@RequestBody Tarefa tarefa) {

		try {
			TarefaDTO tarefaDTO = tarefaService.criarTarefa(tarefa);
			return new ResponseEntity<TarefaDTO>(tarefaDTO, HttpStatusCode.valueOf(201));
		} catch (Exception ex) {
			return new ResponseEntity<TarefaDTO>(HttpStatusCode.valueOf(500));
		}

	}

	@PutMapping("/alocar/{tarefaId}")
	public ResponseEntity<TarefaDTO> alocarPessoaNaTarefa(
			@PathVariable(name = "tarefaId", required = true) long tarefaId,
			@RequestParam(name = "pessoaId", required = true) long pessoaId) {

		try {
			TarefaDTO tarefaDTO = tarefaService.associarTarefaAPessoa(tarefaId, pessoaId);
			return new ResponseEntity<TarefaDTO>(tarefaDTO, HttpStatusCode.valueOf(200));
		} catch (Exception ex) {
			return new ResponseEntity<TarefaDTO>(HttpStatusCode.valueOf(500));
		}
	}

	@PutMapping("/finalizar/{id}")
	public ResponseEntity<TarefaDTO> finalizarTarefa(@PathVariable(name = "id", required = true) long id){
		
		try {
			TarefaDTO tarefaDTO = tarefaService.finalizarTarefa(id);
			return new ResponseEntity<TarefaDTO>(tarefaDTO, HttpStatusCode.valueOf(200));
		} catch (Exception ex) {
			return new ResponseEntity<TarefaDTO>(HttpStatusCode.valueOf(500));
		}
	}
	
}
