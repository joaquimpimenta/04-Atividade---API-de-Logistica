package com.br.api_logistica.dto.historico;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record HistoricoRequest(
        @Schema(
                description = "Descrição do historico",
                example = "Historico para entrega"
        )
        @NotBlank(message = "Descrição é obrigatoria")
        @Size(min = 10, max = 250, message = "Descrição deve ter uma tamanho minimo de 10 caracteres e no maximo 250.")
        String descricao
)
{}
