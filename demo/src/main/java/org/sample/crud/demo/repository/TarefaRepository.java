package org.sample.crud.demo.repository;

import java.util.List;

import org.sample.crud.demo.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
	
	@Query("SELECT t FROM Tarefa t WHERE t.pessoaAlocada IS NULL ORDER BY t.prazo ASC LIMIT 3")
	List<Tarefa> buscaTop3TarefasPendentesSemPessoaAlocada();
}
