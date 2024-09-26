package org.sample.crud.demo.repository;

import java.util.Optional;

import org.sample.crud.demo.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	Optional<Pessoa> findByNome(String pessoaAlocada);
	
}
