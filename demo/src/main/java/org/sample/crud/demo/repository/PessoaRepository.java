package org.sample.crud.demo.repository;

import org.sample.crud.demo.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	
}
