package com.br.api_logistica.mapper;

import com.br.api_logistica.dto.cliente.ClienteResponse;
import com.br.api_logistica.dto.entrega.EntregaRequest;
import com.br.api_logistica.dto.entrega.EntregaResponse;
import com.br.api_logistica.entity.Cliente;
import com.br.api_logistica.entity.Entrega;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EntregaMapper {

    /**
     * Converte os dados de criação para uma entidade Entrega.
     * @param request dados recebidos para criação
     * @return entidade Entrega
     */
    public Entrega toEntity(EntregaRequest request){
        return Entrega.builder()
                .pedidoId(request.pedidoId())
                .motoristaId(request.motoristaId())
                .build();
    }

    /**
     * Converte uma entidade Entrega para o DTO de resposta
     * @param entrega entidade persistida
     * @return representação pública da Entrega
     */
    public EntregaResponse toResponse(Entrega entrega){
        return new EntregaResponse(
                entrega.getId(),
                entrega.getPedidoId(),
                entrega.getMotoristaId(),
                entrega.getStatus()
        );
    }

    /**
     * Converte uma lista de Entidades para uma lista de DTOs de resposta
     * @param entregas lista de Entidades Entrega
     * @return representação publica da Lista de Entrega
     */
    public List<EntregaResponse> toResponseList(List<Entrega> entregas){
        return entregas.stream()
                .map(this::toResponse)
                .toList();
    }
}
