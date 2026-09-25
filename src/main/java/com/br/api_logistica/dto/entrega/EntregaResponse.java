package com.br.api_logistica.dto.entrega;

import com.br.api_logistica.entity.EntregaStatus;
import com.br.api_logistica.entity.Motorista;
import com.br.api_logistica.entity.Pedido;
import io.swagger.v3.oas.annotations.media.Schema;

public record EntregaResponse(
        @Schema(description = "Identificador unico do cliente", example = "1")
        Long id,
        @Schema(description = "Identificador unico do pedido", example = "1")
        Long pedidoId,
        @Schema(description = "Identificador unico do motorista", example = "1")
        Long motoristaId,
        @Schema(description = "Status da entrega", example = "EM_ROTA")
        EntregaStatus status
) {}