package com.br.api_logistica.dto.motorista;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record MotoristaRequest(

        @Schema(
                description = "Nome do motorista",
                example = "Paulo"
        )
        @NotBlank(message = "O nome é obrigatorio")
        @Size(min = 3, max = 100, message = "O nome deve conter no minimo 3 caracteres e no maximo 100")
        String nome,

        @Schema(
                description = "Cnh do motorista",
                example = "12345678"
        )
        @NotBlank(message = "A cnh é obrigatoria")
        String cnh,

        @Schema(
                description = "Veículo do motorista",
                example = "Caminhão"
        )
        @NotBlank(message = "O tipo do veículo é obrigatorio")
        String veiculo,

        @Schema(
                description = "Cidade base do motorista",
                example = "São Paulo"
        )
        @NotBlank(message = "O nome da cidade é obrigatorio preencher")
        String cidadeBase
) {}
