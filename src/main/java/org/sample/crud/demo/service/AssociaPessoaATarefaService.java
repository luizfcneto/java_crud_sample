package org.sample.crud.demo.service;

import java.util.List;
import java.util.Optional;

import org.sample.crud.demo.entity.Departamento;
import org.sample.crud.demo.entity.Pessoa;
import org.sample.crud.demo.entity.Tarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AssociaPessoaATarefaService {

	@Autowired
	PessoaServiceInterface pessoaService;
	
	@Autowired
	TarefaServiceInterface tarefaService;
	
	
	public Optional<Pessoa> buscaPessoaPorId(long pessoaId){	
		return pessoaService.buscarPessoaPorId(pessoaId);
	}
	
	
	public List<Tarefa> confirmarTarefas(List<Tarefa> tarefas, Departamento departamento){
		return tarefaService.confirmarTarefas(tarefas, departamento);
	}
	
	public void associarTarefasAPessoa(Pessoa pessoa) throws Exception {
		tarefaService.associarTarefasAPessoa(pessoa);
	}
	
}
