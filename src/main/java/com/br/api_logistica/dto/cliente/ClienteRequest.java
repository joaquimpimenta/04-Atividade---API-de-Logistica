package com.br.api_logistica.dto.cliente;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record ClienteRequest(

        @Schema(
                description = "Nome do cliente",
                example = "Tiago"
        )
        @NotBlank(message = "o nome é obrigatorio")
        String nome,

        @Schema(
                description = "Cpf do cliente",
                example = "123.456.789-00"
        )
        @NotBlank(message = "o cpj ou o cnpj é obrigatorios")
        String cpfCnpj,

        @Schema(
                description = "Endereço do cliente",
                example = "Rua das Flores 123"
        )
        @NotBlank(message = "o endereço é obrigatorio")
        String endereco,

        @Schema(
                description = "Cidade do cliente",
                example = "Jaraguá do Sul"
        )
        @NotBlank(message = "a cidade é obrigatorio")
        String cidade,

        @Schema(
                description = "Estado em que o cliente mora",
                example = "Santa Catarina"
        )
        @NotBlank(message = "o estado é obrigatorio")
        String estado
) {}
