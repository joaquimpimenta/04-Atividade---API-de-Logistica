package com.br.api_logistica.dto.cliente;

import jakarta.validation.constraints.NotBlank;

public record ClienteRequest(

        @NotBlank(message = "o nome é obrigatorio")
        String nome,

        @NotBlank(message = "o cpj ou o cnpj é obrigatorios")
        String cpfCnpj,

        @NotBlank(message = "o endereço é obrigatorio")
        String endereco,

        @NotBlank(message = "a cidade é obrigatorio")
        String cidade,

        @NotBlank(message = "o estado é obrigatorio")
        String estado
) {}
