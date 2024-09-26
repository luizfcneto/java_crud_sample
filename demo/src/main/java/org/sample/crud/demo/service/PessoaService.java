package org.sample.crud.demo.service;

import java.util.List;
import java.util.Optional;

import org.sample.crud.demo.entity.Departamento;
import org.sample.crud.demo.entity.Pessoa;
import org.sample.crud.demo.entity.Tarefa;
import org.sample.crud.demo.factory.PessoaDTOFactory;
import org.sample.crud.demo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

	@Autowired
	DepartamentoService departamentoService;

	@Autowired
	PessoaRepository pessoaRepository;

	@Autowired
	PessoaDTOFactory pessoaDTOFactory;
	
	@Autowired
	TarefaService tarefaService;
	
	public List<Pessoa> buscarPessoas(){
		return pessoaRepository.findAll();
	}
	

//	TODO: Melhorar tratamento de erros
	public Pessoa criarPessoa(Pessoa pessoa) throws Exception {
		Departamento departamento = departamentoService.confirmarDepartamento(pessoa.getDepartamento());
		pessoa.setDepartamento(departamento);
		
		
		if(pessoa.getTarefas() != null) {
			List<Tarefa> tarefasConfirmadas = tarefaService.confirmarTarefas(pessoa.getTarefas(), pessoa.getDepartamento());			
			pessoa.setTarefas(tarefasConfirmadas);
		}
		
		pessoa = pessoaRepository.save(pessoa);
		tarefaService.associarTarefasAPessoa(pessoa);
		
		return pessoa;
		
	}

//	Melhorar Tratamento de erro
	public Pessoa editarPessoa(long id, Pessoa pessoa) throws Exception {
		Optional<Pessoa> pessoaEncontrada = pessoaRepository.findById(id);

		if (pessoaEncontrada.isPresent()) {
			Pessoa pessoaAtualizada = pessoaEncontrada.get();
			Departamento departamento = departamentoService.confirmarDepartamento(pessoa.getDepartamento());

			pessoaAtualizada.setNome(pessoa.getNome());
			pessoaAtualizada.setDepartamento(departamento);

			pessoaRepository.save(pessoaAtualizada);
			
			return pessoaAtualizada;
		} else {
			throw new Exception();
		}

	}
	
	public void deletarPessoa(long id) throws Exception {
		pessoaRepository.deleteById(id);		
	}
	
	public Pessoa confirmarPessoa(Pessoa pessoa) {
		Optional<Pessoa> pessoaExiste = pessoaRepository.findById(pessoa.getId());
		
		if(pessoaExiste.isPresent()) {
			return pessoaExiste.get();
		}
		
		return pessoaRepository.save(pessoa);
	}
	
	public Optional<Pessoa> buscarPessoaPorId(long pessoaId) {
		return pessoaRepository.findById(pessoaId);
	}

}
