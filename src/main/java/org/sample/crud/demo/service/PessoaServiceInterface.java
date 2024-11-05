package org.sample.crud.demo.service;

import java.util.Optional;

import org.sample.crud.demo.entity.Pessoa;

public interface PessoaServiceInterface {
	Optional<Pessoa> buscarPessoaPorId(long pessoaId);
	Pessoa salvar(Pessoa pessoa);	
}
