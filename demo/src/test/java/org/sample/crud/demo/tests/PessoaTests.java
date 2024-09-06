package org.sample.crud.demo.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sample.crud.demo.dto.DepartamentoDTO;
import org.sample.crud.demo.dto.PessoaDTO;
import org.sample.crud.demo.dto.TarefaDTO;
import org.sample.crud.demo.entity.Departamento;
import org.sample.crud.demo.entity.Pessoa;
import org.sample.crud.demo.entity.Tarefa;
import org.sample.crud.demo.factory.PessoaDTOFactory;

public class PessoaTests {	
	PessoaDTO pessoaDTO;
	DepartamentoDTO departamentoDTO;
	List<TarefaDTO> tarefasDTO;

	Pessoa pessoa;
	Departamento departamento;
	List<Tarefa> tarefas;
	
	private final String NOME_PESSOA = "Luiz";
	private final String NOME_DEPARTAMENTO = "Departamento 0";
	private final String TITULO_TAREFA_1 = "Titulo da Tarefa 1";
	private final String TITULO_TAREFA_2 = "Titulo da Tarefa 2";
	private final int PRAZO_TAREFA_1 = 2;
	private final int PRAZO_TAREFA_2 = 4;
	
	@BeforeEach
	public void beforeEach() {
		System.out.println("Inicializando beforeEach de teste unitário de Pessoas");
		pessoaDTO = new PessoaDTO();
		departamentoDTO = new DepartamentoDTO();
		tarefasDTO = new ArrayList<TarefaDTO>();
	}
	
	@Test
	@DisplayName("Testando configuracao Teste de Pessoas")
	public void testTests() {
		System.out.println("Iniciando testes de Pessoa");
        assertEquals(11, 11);
	}
	
	@Test
	@DisplayName("Criando pessoa com sucesso")
	public void criandoPessoaComSucesso(){
		this.pessoaDTO.setNome(this.NOME_PESSOA);
		
		this.departamentoDTO = new DepartamentoDTO();
		this.departamentoDTO.setNome(this.NOME_DEPARTAMENTO);
		this.pessoaDTO.setDepartamento(this.departamentoDTO);
		
		TarefaDTO tarefa1 = new TarefaDTO();
		tarefa1.setDepartamento(this.departamentoDTO);
		tarefa1.setTitulo(TITULO_TAREFA_1);
		tarefa1.setPessoaAlocada(this.pessoaDTO.getNome());
		tarefa1.setDuracao(PRAZO_TAREFA_1);
		tarefa1.setFinalizado(true);
				
		this.tarefasDTO.add(tarefa1);
		this.pessoaDTO.setTarefas(this.tarefasDTO);
		
		assertEquals(this.pessoaDTO.getNome(), this.NOME_PESSOA, "Nome de pessoa deve ser igual");
		assertEquals(this.pessoaDTO.getDepartamento().getNome(), this.departamentoDTO.getNome(), "Nome de departamento deve ser igual");
		assertEquals(this.pessoaDTO.getTarefas().getFirst().getTitulo(), this.tarefasDTO.getFirst().getTitulo());		
		
	}
	
	@Test
	@DisplayName("Testando pessoaDTO Factory")
	public void testarPessoaDTOFactory() {	
		PessoaDTOFactory pessoaDTOFactory = PessoaDTOFactory.getInstance();
		this.pessoa = new Pessoa();
		this.departamento = new Departamento();
		this.tarefas = new ArrayList<Tarefa>();
		
		this.pessoa.setNome(this.NOME_PESSOA);
		this.departamento = new Departamento();
		this.departamento.setNome(this.NOME_DEPARTAMENTO);
		this.pessoa.setDepartamento(this.departamento);
		
		Tarefa tarefa1 = new Tarefa();
		tarefa1.setDepartamento(this.departamento);
		tarefa1.setTitulo(TITULO_TAREFA_1);
		tarefa1.setPessoaAlocada(this.pessoa);
		tarefa1.setDuracao(PRAZO_TAREFA_1);
		tarefa1.setFinalizado(true);
		
		Tarefa tarefa2 = new Tarefa();
		tarefa2.setDepartamento(this.departamento);
		tarefa2.setTitulo(TITULO_TAREFA_2);
		tarefa2.setPessoaAlocada(this.pessoa);
		tarefa2.setDuracao(PRAZO_TAREFA_2);
		tarefa2.setFinalizado(true);
		
		this.tarefas.add(tarefa1);
		this.tarefas.add(tarefa2);
		this.pessoa.setTarefas(this.tarefas);
		
		assertEquals(pessoaDTOFactory.createFromEntity(pessoa).getTotalHorasGastas(), tarefa1.getDuracao() + tarefa2.getDuracao());
		assertEquals(pessoaDTOFactory.createFromEntity(pessoa).getMediaHorasGastasPorTarefa(), (PRAZO_TAREFA_1 + PRAZO_TAREFA_2)/2);
	}
	
	
}
