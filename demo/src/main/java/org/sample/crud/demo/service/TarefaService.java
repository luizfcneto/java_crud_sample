package org.sample.crud.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.sample.crud.demo.entity.Departamento;
import org.sample.crud.demo.entity.Pessoa;
import org.sample.crud.demo.entity.Tarefa;
import org.sample.crud.demo.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarefaService {

	@Autowired
	TarefaRepository tarefaRepository;

	@Autowired
	PessoaService pessoaService;

	@Autowired
	DepartamentoService departamentoService;

	public List<Tarefa> buscarTarefasPendentes() {
		return tarefaRepository.buscaTop3TarefasPendentesSemPessoaAlocada();
	}

	public Tarefa criarTarefa(Tarefa tarefa) {
		Optional<Tarefa> tarefaExistente = tarefaRepository.findById(tarefa.getId());
		if (tarefaExistente.isPresent()) {
			return tarefaExistente.get();
		}

		Departamento departamento = departamentoService.confirmarDepartamento(tarefa.getDepartamento());
		tarefa.setDepartamento(departamento);

//		if (tarefa.getPessoaAlocada() != null) {
//			Pessoa pessoaAlocada = pessoaService.confirmarPessoa(tarefa.getPessoaAlocada());
//			tarefa.setPessoaAlocada(pessoaAlocada);
//		}

		return tarefaRepository.save(tarefa);
	}

//	public List<Tarefa> buscarTarefas(List<TarefaDTO> tarefasDTO) {
//		List<Tarefa> tarefasEntity = new ArrayList<Tarefa>();
//
//		tarefasDTO.forEach(tarefa -> {
//			List<Tarefa> tarefaExiste = tarefaRepository.findByTitulo(tarefa.getTitulo());
//
//			if (!tarefaExiste.isEmpty()) {
//				tarefasEntity.add(tarefaExiste.getFirst());
//			} else {
//				tarefasEntity.add(criarTarefa(tarefa));
//			}
//
//		});
//
//		return null;
//	}
	
	public List<Tarefa> confirmarTarefas(List<Tarefa> tarefas, Departamento departamento) {
		List<Tarefa> tarefasConfirmadas = new ArrayList<Tarefa>();
		
		tarefas.forEach(tarefa -> {
			if(tarefa.getDepartamento().getNome().equals(departamento.getNome())) {
				tarefa.setDepartamento(departamento);
				Tarefa novaTarefa = criarTarefa(tarefa);
				tarefasConfirmadas.add(novaTarefa);
			}
		});
		
		return tarefasConfirmadas;
	}
	
	public void associarTarefasAPessoa(Pessoa pessoa) throws Exception {
		pessoa.getTarefas().forEach(tarefa -> {
			try {
				associarTarefaAPessoa(tarefa.getId(), pessoa.getId());
			}catch(Exception ex) {
				System.out.println("Erro ao tentar associar tarefa " + tarefa.getId()  + " à pessoa" + pessoa.getId());
			}
		});
	}


//	TODO: Melhorar tratamento de erro
	public Tarefa associarTarefaAPessoa(long tarefaId, long pessoaId) throws Exception {

		Optional<Tarefa> tarefa = tarefaRepository.findById(tarefaId);
		Optional<Pessoa> pessoa = pessoaService.buscarPessoaPorId(pessoaId);

		if (tarefa.isEmpty() || pessoa.isEmpty()) {
			throw new Error();
		}

		boolean departamentoDeTarefaEPessoaIguais = tarefa.get().getDepartamento()
				.equals(pessoa.get().getDepartamento());
		if (departamentoDeTarefaEPessoaIguais) {
			tarefa.get().setPessoaAlocada(pessoa.get());

			return tarefaRepository.save(tarefa.get());

		} else {
			throw new Error();
		}
	}

//	Melhorar tratamento de Erro
	public Tarefa finalizarTarefa(long id) throws Exception {
		Optional<Tarefa> tarefa = tarefaRepository.findById(id);

		if (tarefa.isEmpty() || tarefa.get().getPessoaAlocada() == null) {
			throw new Error();
		}

		tarefa.get().setFinalizado(true);
		return tarefaRepository.save(tarefa.get());
	}
	

}
