package com.br.api_logistica.entity;

import lombok.Builder;


/**
 * Representa um motorista persistido pela aplicação
 * <p>Está entidade contém os dados internos utilizados para camada
 *  * de persistência </p>
 */
@Builder
public class Motorista {

    private Long id;
    private String nome;
    private String cnh;
    private String veiculo;
    private String cidadeBase;

    public Motorista() {}

    public Motorista(Long id, String nome, String cnh, String veiculo, String cidadeBase) {
        this.id = id;
        this.nome = nome;
        this.cnh = cnh;
        this.veiculo = veiculo;
        this.cidadeBase = cidadeBase;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCnh() {
        return cnh;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public String getCidadeBase() {
        return cidadeBase;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public void setCidadeBase(String cidadeBase) {
        this.cidadeBase = cidadeBase;
    }
}
