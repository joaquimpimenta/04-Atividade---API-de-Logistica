package com.br.api_logistica.dto.entrega;

import io.swagger.v3.oas.annotations.media.Schema;

public record EntregaRequest(
        @Schema(
                description = "Associa uma entrega a um pedido",
                example = "1"
        )
        Long pedidoId,

        @Schema(
                description = "Associação de um motorista com uma entrega",
                example = "1"
        )
        Long motoristaId
) {}