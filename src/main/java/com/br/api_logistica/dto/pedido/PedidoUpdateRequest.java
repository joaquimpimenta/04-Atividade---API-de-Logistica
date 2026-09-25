package com.br.api_logistica.dto.pedido;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record PedidoUpdateRequest (

        @Schema(example = "1")
        @NotNull(message = "O id o cliente é obrigatório")
        Long clienteID,

        @Schema(example = "100 m3")
        @NotNull(message = "O volume por m³ é obrigatório")
        double volumeM3,

        @Schema(example = "100kg")
        @NotNull(message = "O peso em quilos é obrigatório")
        double pesoKG
){}
