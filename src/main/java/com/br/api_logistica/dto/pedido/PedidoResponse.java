package com.br.api_logistica.dto.pedido;

import com.br.api_logistica.entity.PedidoStatus;

public record PedidoResponse (

        Long id,
        Long clienteID,
        double volumeM3,
        double pesoKG,
        PedidoStatus status
){}
