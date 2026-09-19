package com.br.api_logistica.mapper;

import com.br.api_logistica.dto.pedido.PedidoRequest;
import com.br.api_logistica.dto.pedido.PedidoResponse;
import com.br.api_logistica.dto.pedido.PedidoUpdateRequest;
import com.br.api_logistica.entity.Pedido;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {

    /**
     * Converte os dados de criação para uma entidade Pedido.
     * @param request dados recebidos para criação
     * @return entidade Cliente
     */
    public Pedido toEntity(PedidoRequest request){
        return Pedido.builder()
                .clienteID(request.clienteID())
                .volumeM3(request.volumeM3())
                .pesoKG(request.pesoKG())
                .build();
    }

    /**
     * Converte uma entidade Pedido para o DTO de resposta
     * @param pedido entidade persistida
     * @return representação pública da Pedido
     */
    public PedidoResponse toResponse(Pedido pedido){
        return new PedidoResponse(
                pedido.getId(),
                pedido.getClienteID(),
                pedido.getVolumeM3(),
                pedido.getPesoKG(),
                pedido.getStatus());
    }
}
