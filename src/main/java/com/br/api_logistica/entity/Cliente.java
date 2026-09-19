package com.br.api_logistica.entity;

import lombok.Builder;

/**
 * Representa um cliente persistido pela aplicação
 * <p>Está entidade contém os dados internos utilizados para camada
 *  * de persistência </p>
 */

@Builder
public class Cliente {

    private Long id;
    private String nome;
    private String cpfCnpj;
    private String endereco;
    private String cidade;
    private String estado;

    public Cliente() {}

    public Cliente(Long id, String nome, String cpfCnpj, String endereco, String cidade, String estado) {
        this.id = id;
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
    }


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
