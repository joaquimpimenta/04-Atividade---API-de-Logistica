package com.br.api_logistica.dto.pedido;

import jakarta.validation.constraints.NotNull;

public record PedidoRequest(

        @NotNull(message = "O id o cliente é obrigatório")
        Long clienteID,

        @NotNull(message = "O volume por m³ é obrigatório")
        double volumeM3,

        @NotNull(message = "O peso em quilos é obrigatório")
        double pesoKG
) {}
