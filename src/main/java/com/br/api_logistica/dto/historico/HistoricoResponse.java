package com.br.api_logistica.dto.historico;

import io.swagger.v3.oas.annotations.media.Schema;

public record HistoricoResponse(
        @Schema(description = "Identificador unico do historico herado", example = "1")
        Long id,
        @Schema(description = "Descrição do historico realizado", example = "Historico atualizaod")
        String descricao
) {}
