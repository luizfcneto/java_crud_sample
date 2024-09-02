package org.sample.crud.demo.repository;

import org.sample.crud.demo.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
	
}
