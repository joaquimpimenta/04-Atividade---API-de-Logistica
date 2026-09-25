package com.br.api_logistica.controller;

import com.br.api_logistica.dto.entrega.EntregaResponse;
import com.br.api_logistica.dto.historico.HistoricoRequest;
import com.br.api_logistica.dto.historico.HistoricoResponse;
import com.br.api_logistica.service.HistoricoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Tag(
        name = "Historico de Entregas",
        description = "Operações relacionadas ao gerenciamento de historicos"
)
@RestController
@RequestMapping("/v1/api/entregas")
public class HistoricoController {

    private final HistoricoService service;

    public HistoricoController(HistoricoService service) {
        this.service = service;
    }

    /**
     * Faz um registro de evento no historico
     * @param request DTO com os dados necessários para criação do historico
     * @return DTO {@link HistoricoResponse} com o historico cadastrada e cabeçalho location
     */

    @Operation(
            summary = "Cadastro de um historico",
            description = "Cria um novo historico"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Historico criado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados da requisição inválidos",
                    content = @Content(schema = @Schema(implementation = EntregaResponse.class))
            )
    })
    @PostMapping("/{id}/historico")
    public ResponseEntity<HistoricoResponse> registraEvento(@PathVariable Long id, @RequestBody HistoricoRequest request){
        HistoricoResponse historico = service.cadastrar(request);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(historico.id())
                .toUri();

        return ResponseEntity.created(uri).body(historico);
    }
}