package com.br.api_logistica.dto.motorista;

import io.swagger.v3.oas.annotations.media.Schema;

public record MotoristaResponse(
        @Schema(description = "Identificador unico do motorista", example = "1")
        Long id,
        @Schema(description = "Nome do motorista", example = "1")
        String nome,
        @Schema(description = "Cnh do motorista", example = "1")
        String cnh,
        @Schema(description = "Veiculo do motorista", example = "1")
        String veiculo,
        @Schema(description = "Cidade base do motorista", example = "1")
        String cidadeBase
) {}
