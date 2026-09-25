package com.br.api_logistica.dto.entrega;

import com.br.api_logistica.entity.EntregaStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record EntregaRequestStatus (
        @Schema(
                description = "Status da entrega",
                example = "ATRASADA"
        )
        @NotBlank(message = "O status da entrega é obrigatório!")
        EntregaStatus status
){}
