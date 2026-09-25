package com.br.api_logistica.dto.pedido;

import com.br.api_logistica.entity.PedidoStatus;
import io.swagger.v3.oas.annotations.media.Schema;

public record PedidoResponse (
        @Schema(description = "Identificador unico do pedido", example = "1")
        Long id,
        @Schema(description = "Identificador unico do cliente", example = "1")
        Long clienteID,
        @Schema(description = "Volume cubico do pedido", example = "123 m3")
        double volumeM3,
        @Schema(description = "Peso do peso", example = "100kg")
        double pesoKG,
        @Schema(description = "Status do pedidos", example = "PENDENTE")
        PedidoStatus status
){}
