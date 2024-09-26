package org.sample.crud.demo.controller;

import java.util.List;

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


	// listar pessoas REFATORADO
	@GetMapping
	public ResponseEntity<List<Pessoa>> listarPessoas() {
		
		try {
			List<Pessoa> listaPessoas = pessoaService.buscarPessoas();
			return new ResponseEntity<List<Pessoa>>(listaPessoas, HttpStatusCode.valueOf(200));
			
		}catch(Exception ex) {
			return new ResponseEntity<>(HttpStatusCode.valueOf(500));
		}
	}

	// buscar pessoas por nome e período


//	REFATORADO
	@PostMapping
	public ResponseEntity<Pessoa> adicionarPessoa(@RequestBody Pessoa pessoa) {
		try {
			Pessoa novaPessoa = pessoaService.criarPessoa(pessoa);
			return new ResponseEntity<Pessoa>(novaPessoa, HttpStatusCode.valueOf(201));
			
		}catch(Exception ex) {
			return new ResponseEntity<>(HttpStatusCode.valueOf(500));
		}
	}

//	REFATORADO
	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> atualizarPessoa(@RequestBody Pessoa pessoa, @PathVariable(name = "id", required = true) long id){

		try {
			Pessoa pessoaAtualizada = pessoaService.editarPessoa(id, pessoa);
			return new ResponseEntity<Pessoa>(pessoaAtualizada, HttpStatusCode.valueOf(200));
		}catch(Exception ex) {
			return new ResponseEntity<>(HttpStatusCode.valueOf(500));
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
