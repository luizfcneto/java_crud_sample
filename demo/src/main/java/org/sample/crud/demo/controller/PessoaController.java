package org.sample.crud.demo.controller;

import java.util.List;

import org.sample.crud.demo.dto.PessoaDTO;
import org.sample.crud.demo.entity.Pessoa;
import org.sample.crud.demo.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	PessoaService pessoaService;


	// listar pessoas
	@GetMapping
	public ResponseEntity<List<PessoaDTO>> listarPessoas() {
		
		try {
			List<PessoaDTO> listaPessoas = pessoaService.buscarPessoas();
			return new ResponseEntity<List<PessoaDTO>>(listaPessoas, HttpStatusCode.valueOf(200));
			
		}catch(Exception ex) {
			return new ResponseEntity<>(HttpStatusCode.valueOf(500));
		}
	}

	// buscar pessoas por nome e período

	
	@PostMapping
	public ResponseEntity<PessoaDTO> adicionarPessoa(@RequestBody Pessoa pessoa) {
		try {
			PessoaDTO pessoaDTO = pessoaService.criarPessoa(pessoa);
			return new ResponseEntity<PessoaDTO>(pessoaDTO, HttpStatusCode.valueOf(201));
			
		}catch(Exception ex) {
			return new ResponseEntity<PessoaDTO>(HttpStatusCode.valueOf(500));
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<PessoaDTO> atualizarPessoa(@RequestBody Pessoa pessoa, @PathVariable(name = "id", required = true) long id){

		try {
			PessoaDTO pessoaAtualizada = pessoaService.editarPessoa(id, pessoa);
			return new ResponseEntity<PessoaDTO>(pessoaAtualizada, HttpStatusCode.valueOf(200));
		}catch(Exception ex) {
			return new ResponseEntity<PessoaDTO>(HttpStatusCode.valueOf(500));
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> removerPessoa(@PathVariable(name = "id", required = true) long id){
		
		try {
			pessoaService.deletarPessoa(id);
			return new ResponseEntity<>(HttpStatusCode.valueOf(204));
		}catch(Exception ex) {
			return new ResponseEntity<>(HttpStatusCode.valueOf(500));
		}
		
	}
	
}
