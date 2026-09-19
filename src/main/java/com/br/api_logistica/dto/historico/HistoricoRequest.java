package com.br.api_logistica.dto.historico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record HistoricoRequest(

        @NotBlank(message = "Descrição é obrigatoria")
        @Size(min = 10, max = 250, message = "Descrição deve ter uma tamanho minimo de 10 caracteres e no maximo 250.")
        String descricao
)
{}
