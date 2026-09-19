package com.br.api_logistica.dto.cliente;

public record ClienteResponse(
        Long id,
        String nome,
        String cpfCnpj,
        String endereco,
        String cidade,
        String estado
) {}
