package com.br.api_logistica.dto.entrega;

import com.br.api_logistica.entity.EntregaStatus;
import com.br.api_logistica.entity.Motorista;
import com.br.api_logistica.entity.Pedido;

public record EntregaResponse(
        Long id,
        Long pedidoId,
        Long motoristaId,
        EntregaStatus status
) {}