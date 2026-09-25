package com.br.api_logistica.dto.exception;

import io.swagger.v3.oas.annotations.media.Schema;

public record ErroResponse(
        @Schema(description = "Código do erro", example = "404")
        int codigoErro,

        @Schema(description = "Tipo do erro", example = "Erro de conexão")
        String tipoDoErro,

        @Schema(description = "Mensagem do erro", example = "O recurso não foi encontrado")
        String mensagemDoErro,
        String uri
) {}
