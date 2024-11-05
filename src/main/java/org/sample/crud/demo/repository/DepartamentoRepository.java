package org.sample.crud.demo.repository;

import java.util.List;

import org.sample.crud.demo.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{

	List<Departamento> findByNome(String nome);
}
