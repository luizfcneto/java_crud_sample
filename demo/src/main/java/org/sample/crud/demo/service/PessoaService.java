package org.sample.crud.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.sample.crud.demo.dto.PessoaDTO;
import org.sample.crud.demo.entity.Departamento;
import org.sample.crud.demo.entity.Pessoa;
import org.sample.crud.demo.factory.PessoaDTOFactory;
import org.sample.crud.demo.repository.DepartamentoRepository;
import org.sample.crud.demo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

	@Autowired
	DepartamentoRepository departamentoRepository;

	@Autowired
	PessoaRepository pessoaRepository;

	@Autowired
	PessoaDTOFactory pessoaDTOFactory;

	public PessoaDTO criarPessoa(Pessoa pessoa) {
		List<Departamento> departamentoExistente = departamentoRepository
				.findByNome(pessoa.getDepartamento().getNome());

		Departamento departamento;
		if (departamentoExistente.isEmpty()) {
			departamento = new Departamento();
			departamento.setNome(pessoa.getDepartamento().getNome());
			departamentoRepository.save(departamento);
		} else {
			departamento = departamentoExistente.get(0);
		}

		pessoa.setDepartamento(departamento);
		return pessoaDTOFactory.createFromEntity(pessoaRepository.save(pessoa));
	}

	public List<PessoaDTO> buscarPessoas() {
		List<Pessoa> pessoasEncontradas = pessoaRepository.findAll();
		return pessoasEncontradas.stream().map(pessoa -> pessoaDTOFactory.createFromEntity(pessoa))
				.collect(Collectors.toList());
	}

	public PessoaDTO editarPessoa(long id, Pessoa pessoa) throws Exception {

		Optional<Pessoa> pessoaEncontrada = pessoaRepository.findById(id);

		if (pessoaEncontrada.isPresent()) {
			Pessoa pessoaAtualizada = pessoaEncontrada.get();
			
			List<Departamento> departamentoExistente = departamentoRepository
					.findByNome(pessoa.getDepartamento().getNome());
			
			Departamento departamento;
			if (departamentoExistente.isEmpty()) {
				departamento = new Departamento();
				departamento.setNome(pessoa.getDepartamento().getNome());
				departamentoRepository.save(departamento);
			} else {
				departamento = departamentoExistente.get(0);
			}

			pessoaAtualizada.setNome(pessoa.getNome());
			pessoaAtualizada.setDepartamento(departamento);
			pessoaAtualizada.setTarefas(pessoa.getTarefas());

			pessoaRepository.save(pessoaAtualizada);

			return pessoaDTOFactory.createFromEntity(pessoaAtualizada);
		} else {
			throw new Exception();
		}

	}
	
	public void deletarPessoa(long id) throws Exception {
		pessoaRepository.deleteById(id);		
	}

}
