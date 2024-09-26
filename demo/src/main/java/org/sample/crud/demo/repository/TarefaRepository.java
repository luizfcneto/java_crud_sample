package org.sample.crud.demo.repository;

import java.util.List;

import org.sample.crud.demo.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

	@Query("SELECT t FROM Tarefa t WHERE t.pessoaAlocada IS NULL ORDER BY t.prazo ASC LIMIT 3")
	List<Tarefa> buscaTop3TarefasPendentesSemPessoaAlocada();

	List<Tarefa> findByTitulo(String titulo);

	@Query(value = "SELECT * FROM Tarefa t "
			+ "WHERE "
			+ "t.titulo = :tarefaTitulo "
			+ " AND t.departamento_id = :departamentoId "
			+ " AND t.descricao = :tarefaDescricao"
			+ " AND t.pessoa_alocada_id IS NULL"
			, nativeQuery = true)
	List<Tarefa> buscaTarefaPeloTituloEDescricaoNoDepartamentoSemPessoaAlocada(@Param("tarefaTitulo") String titulo,
			@Param("tarefaDescricao") String descricao, @Param("departamentoId") long departamentoId);
}
