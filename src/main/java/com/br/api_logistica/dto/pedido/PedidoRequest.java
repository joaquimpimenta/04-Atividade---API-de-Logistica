package com.br.api_logistica.dto.pedido;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PedidoRequest(

        @Schema(
                description = "Id do cliente para o cliente estar associado aquele pedido que realizou",
                example = "2"
        )
        @NotNull(message = "O id o cliente é obrigatório")
        Long clienteID,

        @Schema(
                description = "Volume m3 do pedido",
                example = "45m3"
        )
        @NotNull(message = "O volume por m³ é obrigatório")
        double volumeM3,

        @Schema(
                description = "Peso do pedido",
                example = "1200Kg"
        )
        @Positive(message = "O peso deve ser maior que zero")
        @NotNull(message = "O peso em quilos é obrigatório")
        double pesoKG
) {}
