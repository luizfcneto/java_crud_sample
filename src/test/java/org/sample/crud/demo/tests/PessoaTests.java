package org.sample.crud.demo.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sample.crud.demo.builder.DepartamentoDTOBuilder;
import org.sample.crud.demo.builder.PessoaDTOBuilder;
import org.sample.crud.demo.builder.TarefaDTOBuilder;
import org.sample.crud.demo.dto.DepartamentoDTO;
import org.sample.crud.demo.dto.PessoaDTO;
import org.sample.crud.demo.dto.TarefaDTO;

public class PessoaTests {	
	PessoaDTO pessoaDTO;
	DepartamentoDTO departamentoDTO;
	List<TarefaDTO> tarefasDTO;
	
	private final String NOME_PESSOA = "Luiz";
	private final String NOME_DEPARTAMENTO = "Departamento 0";
	private final String TITULO_TAREFA_1 = "Titulo da Tarefa 1";
	private final String TITULO_TAREFA_2 = "Titulo da Tarefa 2";
	private final int DURACAO_TAREFA_1 = 2;
	private final int DURACAO_TAREFA_2 = 4;
	
	@BeforeEach
	public void beforeEach() {
		pessoaDTO = new PessoaDTO();
		departamentoDTO = new DepartamentoDTO();
		tarefasDTO = new ArrayList<TarefaDTO>();
	}
	
	@Test
	@DisplayName("Criando pessoa com sucesso com getters e setters")
	public void criandoPessoaComSucesso(){
		this.pessoaDTO.setNome(this.NOME_PESSOA);
		
		this.departamentoDTO = new DepartamentoDTO();
		this.departamentoDTO.setNome(this.NOME_DEPARTAMENTO);
		this.pessoaDTO.setDepartamento(this.departamentoDTO);
		
		TarefaDTO tarefa1 = new TarefaDTO();
		tarefa1.setDepartamento(this.departamentoDTO);
		tarefa1.setTitulo(TITULO_TAREFA_1);
		tarefa1.setPessoaAlocada(this.pessoaDTO.getNome());
		tarefa1.setDuracao(DURACAO_TAREFA_1);
		tarefa1.setFinalizado(true);
				
		this.tarefasDTO.add(tarefa1);
		this.pessoaDTO.setTarefas(this.tarefasDTO);
		
		assertEquals(this.pessoaDTO.getNome(), this.NOME_PESSOA, "Nome de pessoa deve ser igual");
		assertEquals(this.pessoaDTO.getDepartamento().getNome(), this.departamentoDTO.getNome(), "Nome de departamento deve ser igual");
		assertEquals(this.pessoaDTO.getTarefas().get(0).getTitulo(), this.tarefasDTO.get(0).getTitulo());		
		
	}
	
	
	@Test
	@DisplayName("Testando criação pessoaDTO pelo Builder")
	public void testarPessoaDTOBuilder() {
		departamentoDTO = new DepartamentoDTOBuilder().addNome(NOME_DEPARTAMENTO).build();
		
		TarefaDTO tarefaDTO1 = new TarefaDTOBuilder()
				.addDepartamento(departamentoDTO)
				.addTitulo(TITULO_TAREFA_1)
				.addDescricao("Descricao Tarefa 1")
				.addDuracao(DURACAO_TAREFA_1)
				.addPrazo(LocalDateTime.now())
				.build();
				
		tarefasDTO.add(tarefaDTO1);
		
		TarefaDTO tarefaDTO2 = new TarefaDTOBuilder()
				.addDepartamento(departamentoDTO)
				.addTitulo(TITULO_TAREFA_2)
				.addDescricao("Descricao Tarefa 2")
				.addDuracao(DURACAO_TAREFA_2)
				.addPrazo(LocalDateTime.of(2024, 10, 20, 22, 30))
				.build();
		tarefasDTO.add(tarefaDTO2);

		pessoaDTO = new PessoaDTOBuilder()
				.addNome(NOME_PESSOA)
				.addDepartamento(departamentoDTO)
				.addTarefas(tarefasDTO)
				.build();
		
		assertEquals(this.pessoaDTO.getNome(), this.NOME_PESSOA, "Nome de pessoa deve ser igual");
		assertEquals(this.pessoaDTO.getDepartamento().getNome(), this.departamentoDTO.getNome(), "Nome de departamento deve ser igual");
		assertEquals(this.pessoaDTO.getTarefas().get(0).getTitulo(), this.tarefasDTO.get(0).getTitulo());
		
	}	
	
}
