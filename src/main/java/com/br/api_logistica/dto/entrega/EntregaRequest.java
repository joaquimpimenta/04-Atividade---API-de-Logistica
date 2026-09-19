package com.br.api_logistica.dto.entrega;

public record EntregaRequest(
        Long pedidoId,
        Long motoristaId
) {}