package com.br.api_logistica.dto.motorista;

public record MotoristaResponse(
        Long id,
        String nome,
        String cnh,
        String veiculo,
        String cidadeBase
) {}
