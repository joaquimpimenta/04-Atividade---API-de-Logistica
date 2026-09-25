package com.br.api_logistica.dto.cliente;

import io.swagger.v3.oas.annotations.media.Schema;

public record ClienteResponse(
        @Schema(description = "Identificador unico do cliente", example = "1")
        Long id,
        @Schema(description = "Nome do cliente", example = "Arthur")
        String nome,
        @Schema(description = "Cpf ou cnpj do cliente", example = "123.456.789-00")
        String cpfCnpj,
        @Schema(description = "Endereço do cliente", example = "Rua rau, 123")
        String endereco,
        @Schema(description = "Cidade do cliente", example = "Jaraguá do Sul")
        String cidade,
        @Schema(description = "Estado de moradia do cliente", example = "Santa Catarina")
        String estado
) {}
