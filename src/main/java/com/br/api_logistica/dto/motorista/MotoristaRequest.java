package com.br.api_logistica.dto.motorista;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record MotoristaRequest(

        @NotBlank(message = "O nome é obrigatorio")
        @Size(min = 3, max = 100, message = "O nome deve conter no minimo 3 caracteres e no maximo 100")
        String nome,

        @NotBlank(message = "A cnh é obrigatoria")
        String cnh,

        @NotBlank(message = "O tipo do veículo é obrigatorio")
        String veiculo,

        @NotBlank(message = "O nome da cidade é obrigatorio preencher")
        String cidadeBase
) {}
