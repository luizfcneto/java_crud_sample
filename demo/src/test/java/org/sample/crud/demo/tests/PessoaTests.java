package org.sample.crud.demo.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PessoaTests {
	
	@BeforeEach
	public void beforeEach() {
		System.out.println("Inicializando beforeEach de teste unitário de Pessoas");
	}
	
	@Test
	@DisplayName("Testando configuracao Teste de Pessoas")
	public void testTests() {
		System.out.println("Iniciando testes de Pessoa");
        assertEquals(11, 11);
	}
}
