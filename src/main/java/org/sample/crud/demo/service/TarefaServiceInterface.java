package org.sample.crud.demo.service;

import java.util.List;

import org.sample.crud.demo.entity.Departamento;
import org.sample.crud.demo.entity.Pessoa;
import org.sample.crud.demo.entity.Tarefa;

public interface TarefaServiceInterface {
	Tarefa associarTarefaAPessoa(long tarefaId, long pessoaId) throws Exception;
	List<Tarefa> confirmarTarefas(List<Tarefa> tarefas, Departamento departamento);
	Tarefa salvar(Tarefa tarefa);
	void associarTarefasAPessoa(Pessoa pessoa) throws Exception;
}
