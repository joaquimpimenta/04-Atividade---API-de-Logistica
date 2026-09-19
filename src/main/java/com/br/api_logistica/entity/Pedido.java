package com.br.api_logistica.entity;

import lombok.Builder;


/**
 * Representa um pedido persistido pela aplicação
 * <p>Está entidade contém os dados internos utilizados para camada
 *  * de persistência </p>
 */
@Builder
public class Pedido {

    private Long id;
    private Long clienteID;
    private double volumeM3;
    private double pesoKG;
    private PedidoStatus status;

    public Pedido(Long id, Long clienteID, double volumeM3, double pesoKG, PedidoStatus status) {
        this.id = id;
        this.clienteID = clienteID;
        this.volumeM3 = volumeM3;
        this.pesoKG = pesoKG;
        this.status = status;
    }

    public Pedido(){}

    public Long getId() {
        return id;
    }

    public Long getClienteID() {
        return clienteID;
    }

    public double getVolumeM3() {
        return volumeM3;
    }

    public double getPesoKG() {
        return pesoKG;
    }

    public PedidoStatus getStatus(){
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setClienteID(Long clienteID) {
        this.clienteID = clienteID;
    }

    public void setVolumeM3(double volumeM3) {
        this.volumeM3 = volumeM3;
    }

    public void setPesoKG(double pesoKG) {
        this.pesoKG = pesoKG;
    }

    public void setStatus(PedidoStatus status){
        this.status = status;
    }
}
