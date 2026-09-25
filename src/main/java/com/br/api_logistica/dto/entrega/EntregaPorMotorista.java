package com.br.api_logistica.dto.entrega;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record EntregaPorMotorista(
        @Positive(message = "Id deve ser maior que zero")
        Long motoristaId,
        @NotBlank(message = "O nome é obrigatorio")
        String motoristaNome,
        @Positive(message = "O total de entregas deve ser maior que zero")
        long totalEntregas
) {}
