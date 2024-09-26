package org.sample.crud.demo.controller;

import java.util.List;

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
	
//	REFATORADO
	@GetMapping("/pendentes")
	public ResponseEntity<List<Tarefa>> listaTarefasPendentes(){
		try {
			List<Tarefa> tarefasPendentes = tarefaService.buscarTarefasPendentes();
			return new ResponseEntity<List<Tarefa>>(tarefasPendentes, HttpStatusCode.valueOf(201));
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatusCode.valueOf(500));
		}
	}

//	REFATORADO
	@PostMapping
	public ResponseEntity<Tarefa> adicionarTarefa(@RequestBody Tarefa tarefa) {

		try {
			Tarefa novaTarefa = tarefaService.criarTarefa(tarefa);
			return new ResponseEntity<Tarefa>(novaTarefa, HttpStatusCode.valueOf(201));
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatusCode.valueOf(500));
		}
	}

//	REFATORADO
	@PutMapping("/alocar/{tarefaId}")
	public ResponseEntity<Tarefa> alocarPessoaNaTarefa(
			@PathVariable(name = "tarefaId", required = true) long tarefaId,
			@RequestParam(name = "pessoaId", required = true) long pessoaId) {

		try {
			Tarefa tarefa = tarefaService.associarTarefaAPessoa(tarefaId, pessoaId);
			return new ResponseEntity<Tarefa>(tarefa, HttpStatusCode.valueOf(200));
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatusCode.valueOf(500));
		}
	}

	
//	REFATORADO
	@PutMapping("/finalizar/{id}")
	public ResponseEntity<Tarefa> finalizarTarefa(@PathVariable(name = "id", required = true) long id){
		
		try {
			Tarefa tarefa = tarefaService.finalizarTarefa(id);
			return new ResponseEntity<Tarefa>(tarefa, HttpStatusCode.valueOf(200));
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatusCode.valueOf(500));
		}
	}
	
}
