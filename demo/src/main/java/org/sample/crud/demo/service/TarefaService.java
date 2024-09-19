package org.sample.crud.demo.service;

import java.util.List;
import java.util.Optional;

import org.sample.crud.demo.dto.TarefaDTO;
import org.sample.crud.demo.entity.Departamento;
import org.sample.crud.demo.entity.Pessoa;
import org.sample.crud.demo.entity.Tarefa;
import org.sample.crud.demo.factory.TarefaDTOFactory;
import org.sample.crud.demo.mapper.TarefaMapper;
import org.sample.crud.demo.repository.DepartamentoRepository;
import org.sample.crud.demo.repository.PessoaRepository;
import org.sample.crud.demo.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarefaService {

	@Autowired
	TarefaRepository tarefaRepository;

	@Autowired
	PessoaRepository pessoaRepository;

	@Autowired
	DepartamentoRepository departamentoRepository;

	@Autowired
	TarefaDTOFactory tarefaDTOFactory;

	public List<TarefaDTO> buscarTarefasPendentes() {
		List<Tarefa> tarefas = tarefaRepository.buscaTop3TarefasPendentesSemPessoaAlocada();
//		return tarefaDTOFactory.createFromEntities(tarefas);
		return TarefaMapper.entitiesToDTO(tarefas);
	}

	public TarefaDTO criarTarefa(Tarefa tarefa) {
		List<Departamento> departamentoExistente = departamentoRepository
				.findByNome(tarefa.getDepartamento().getNome());
		Departamento departamento;

		if (departamentoExistente.isEmpty()) {
			departamento = new Departamento();
			departamento.setNome(tarefa.getDepartamento().getNome());
			departamentoRepository.save(departamento);
		} else {
			departamento = departamentoExistente.get(0);
		}

		tarefa.setDepartamento(departamento);
		
//		return tarefaDTOFactory.createFromEntity(tarefaRepository.save(tarefa));
		return TarefaMapper.entityToDTO(tarefaRepository.save(tarefa));
	}

	public TarefaDTO associarTarefaAPessoa(long tarefaId, long pessoaId) throws Exception {

		Optional<Tarefa> tarefa = tarefaRepository.findById(tarefaId);
		Optional<Pessoa> pessoa = pessoaRepository.findById(pessoaId);

		if (tarefa.isEmpty() || pessoa.isEmpty()) {
			throw new Error();
		}

		if (tarefa.get().getDepartamento().equals(pessoa.get().getDepartamento())) {
			tarefa.get().setPessoaAlocada(pessoa.get());

//			return tarefaDTOFactory.createFromEntity(tarefaRepository.save(tarefa.get()));
			return TarefaMapper.entityToDTO(tarefaRepository.save(tarefa.get()));

		} else {
			throw new Error();
		}
	}

	public TarefaDTO finalizarTarefa(long id) throws Exception {
		Optional<Tarefa> tarefa = tarefaRepository.findById(id);

		if (tarefa.isEmpty() || tarefa.get().getPessoaAlocada() == null) {
			throw new Error();
		}

		tarefa.get().setFinalizado(true);

//		return tarefaDTOFactory.createFromEntity(tarefaRepository.save(tarefa.get()));
		return TarefaMapper.entityToDTO(tarefaRepository.save(tarefa.get()));
	}

}
