package org.sample.crud.demo.model;

import java.time.LocalDateTime;

public class Tarefa {
    private long id;
    private String titulo;
    private String descricao;
    private LocalDateTime prazo;
    private Departamento departamento;
    private int duracao;
    private Pessoa pessoaAlocada;
    private boolean finalizado;
}
