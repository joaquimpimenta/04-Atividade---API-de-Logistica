package com.br.api_logistica.entity;

import lombok.Builder;


/**
 * Representa um entrega persistido pela aplicação
 * <p>Está entidade contém os dados internos utilizados para camada
 *  * de persistência </p>
 */
@Builder
public class Entrega {

    private Long id;
    private Long pedidoId;
    private Long motoristaId;
    private EntregaStatus status;

    public Entrega(Long id, Long pedidoId, Long motoristaId, EntregaStatus status) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.motoristaId = motoristaId;
        this.status = status;
    }

    public Entrega() {}

    public Long getId() {
        return id;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public Long getMotoristaId() {
        return motoristaId;
    }

    public EntregaStatus getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public void setMotoristaId(Long motoristaId) {
        this.motoristaId = motoristaId;
    }

    public void setStatus(EntregaStatus status) {
        this.status = status;
    }
}