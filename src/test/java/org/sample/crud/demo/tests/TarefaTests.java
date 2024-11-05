package org.sample.crud.demo.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
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
import org.sample.crud.demo.factory.TarefaDTOFactory;

public class TarefaTests {

	private Tarefa tarefa;
	private Departamento departamento;
	private Pessoa pessoa;
	
	private TarefaDTO tarefaDTO;
	private DepartamentoDTO departamentoDTO;
	private PessoaDTO pessoaDTO;
	
	private List<Tarefa> tarefas;
	private List<TarefaDTO> tarefasDTO;
	
	private final String TITULO_TAREFA_1 = "Titulo Tarefa 1";
	private final String DESCRICAO_TAREFA_1 = "Descricao da tarefa 1";
	private final int DURACAO_TAREFA_1 = 2;
	private final LocalDateTime PRAZO_TAREFA1 = LocalDateTime.now(); 
	private final boolean FINALIZADO = true;
//	private final boolean NAO_FINALIZADO = false;
	
	private final String NOME_PESSOA = "Nome de uma Pessoa";
	
	private final String NOME_DEPARTAMENTO = "Departamento 0";	
	
	@BeforeEach
	public void beforeEach() {
		this.tarefa = new Tarefa();
		this.tarefaDTO = new TarefaDTO();
		this.departamento = new Departamento();
		this.departamentoDTO = new DepartamentoDTO();
		this.pessoa = new Pessoa();
		this.pessoaDTO = new PessoaDTO();
		this.tarefas = new ArrayList<Tarefa>();
		this.tarefasDTO = new ArrayList<TarefaDTO>();
	}
	
	@Test
	@DisplayName("Testando criacao de TarefaDTO")
	public void testeCriarTarefaComSucesso() {
		this.tarefaDTO.setTitulo(TITULO_TAREFA_1);
		this.tarefaDTO.setDescricao(DESCRICAO_TAREFA_1);
		this.tarefaDTO.setDuracao(DURACAO_TAREFA_1);
		this.tarefaDTO.setPrazo(PRAZO_TAREFA1);
		
		this.departamentoDTO.setNome(NOME_DEPARTAMENTO); 
		this.tarefaDTO.setDepartamento(this.departamentoDTO);
		this.tarefaDTO.setFinalizado(FINALIZADO);
		
		this.tarefasDTO.add(tarefaDTO);
	
		this.pessoaDTO.setDepartamento(this.departamentoDTO);
		this.pessoaDTO.setNome(NOME_PESSOA);
		this.pessoaDTO.setTarefas(this.tarefasDTO);
		
		this.tarefaDTO.setPessoaAlocada(this.pessoaDTO.getNome());
		
		assertEquals(this.tarefaDTO.getTitulo(), TITULO_TAREFA_1);
		assertEquals(this.tarefaDTO.getDescricao(), DESCRICAO_TAREFA_1);
		assertEquals(this.tarefaDTO.getDuracao(), DURACAO_TAREFA_1);
		assertEquals(this.tarefaDTO.getDepartamento().getNome(), NOME_DEPARTAMENTO, "Nome de Departamento deve ser o mesmo");
		assertEquals(this.tarefaDTO.getPrazo(), PRAZO_TAREFA1);
		assertEquals(this.tarefaDTO.isFinalizado(), FINALIZADO);
		assertEquals(this.tarefaDTO.getPessoaAlocada(), NOME_PESSOA, "Nome da pessoa alocada deve ser igual nome da pessoa");
	}
	
	@Test
	@DisplayName("Testando criacao de TarefaDTOFactory")
	public void testCriacaoTarefaDTOFactoryMap() {
		TarefaDTOFactory tarefaDTOFactory = TarefaDTOFactory.getInstance();
		this.tarefa.setTitulo(TITULO_TAREFA_1);
		this.tarefa.setDescricao(DESCRICAO_TAREFA_1);
		this.tarefa.setDuracao(DURACAO_TAREFA_1);
		this.tarefa.setPrazo(PRAZO_TAREFA1);
		
		this.departamento.setNome(NOME_DEPARTAMENTO); 
		this.tarefa.setDepartamento(this.departamento);
		this.tarefa.setFinalizado(FINALIZADO);
		
		this.tarefas.add(tarefa);
	
		this.pessoa.setDepartamento(this.departamento);
		this.pessoa.setNome(NOME_PESSOA);
		this.pessoa.setTarefas(this.tarefas);
		
		this.tarefa.setPessoaAlocada(this.pessoa);
		
		this.tarefasDTO = tarefaDTOFactory.createFromEntities(this.tarefas);
		assertEquals(this.tarefasDTO.get(0).getTitulo(), TITULO_TAREFA_1);
		assertEquals(this.tarefasDTO.get(0).getDescricao(), DESCRICAO_TAREFA_1);
		assertEquals(this.tarefasDTO.get(0).getDuracao(), DURACAO_TAREFA_1);
		assertEquals(this.tarefasDTO.get(0).getDepartamento().getNome(), NOME_DEPARTAMENTO, "Nome de Departamento deve ser o mesmo");
		assertEquals(this.tarefasDTO.get(0).getPrazo(), PRAZO_TAREFA1);
		assertEquals(this.tarefasDTO.get(0).isFinalizado(), FINALIZADO);
		assertEquals(this.tarefasDTO.get(0).getPessoaAlocada(), NOME_PESSOA, "Nome da pessoa alocada deve ser igual nome da pessoa");
	}
	
	
	
}
