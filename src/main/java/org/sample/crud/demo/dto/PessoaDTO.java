package org.sample.crud.demo.dto;

import java.util.List;

public class PessoaDTO {
	private String nome;
	private DepartamentoDTO departamento;
	private List<TarefaDTO> tarefas;
	private int totalHorasGastas;
	private double mediaHorasGastasPorTarefa;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public DepartamentoDTO getDepartamento() {
		return departamento;
	}

	public void setDepartamento(DepartamentoDTO departamento) {
		this.departamento = departamento;
	}

	public List<TarefaDTO> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<TarefaDTO> tarefas) {
		this.tarefas = tarefas;
	}

	public int getTotalHorasGastas() {
		return totalHorasGastas;
	}

	public void setTotalHorasGastas(int totalHorasGastas) {
		this.totalHorasGastas = totalHorasGastas;
	}

	public double getMediaHorasGastasPorTarefa() {
		return mediaHorasGastasPorTarefa;
	}

	public void setMediaHorasGastasPorTarefa(double mediaHorasGastasPorTarefa) {
		this.mediaHorasGastasPorTarefa = mediaHorasGastasPorTarefa;
	}

}
