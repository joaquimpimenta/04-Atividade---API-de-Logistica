package com.br.api_logistica.controller;
import com.br.api_logistica.dto.entrega.EntregaRequest;
import com.br.api_logistica.dto.entrega.EntregaRequestStatus;
import com.br.api_logistica.dto.entrega.EntregaResponse;
import com.br.api_logistica.service.EntregaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Controller REST responsavel pelos endpoints relacionados ao recusso entrega
 */
@Tag(
        name = "Entregas",
        description = "Operações relacionadas ao gerenciamento de entregas"
)
@RestController
@RequestMapping("/v1/api/entregas")
public class EntregaController {

    private final EntregaService service;

    public EntregaController(EntregaService service) {
        this.service = service;
    }

    /**
     * Lista todos os entregas cadastrados
     * @return Lista de entregas
     */
    @Operation(
            summary = "Lista de entregas",
            description = "Retorna todos os entregas cadastrados"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Entregas retornados com sucesso"
    )
    @GetMapping
    public ResponseEntity<List<EntregaResponse>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    /**
     * Cadastra uma nova entrega
     * @param request DTO com os dados necessários para criação da entrega
     * @return DTO {@link EntregaResponse} com a entrega cadastrada e cabeçalho location
     */

    @Operation(
            summary = "Cadastro de uma entrega",
            description = "Cria uma nova entrega"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Entrega criada com sucesso"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados da requisição inválidos",
                    content = @Content(schema = @Schema(implementation = EntregaResponse.class))
            )
    })
    @PostMapping
    public ResponseEntity<EntregaResponse> cadastrar(@Valid @RequestBody EntregaRequest request){
        EntregaResponse entrega = service.cadastrar(request);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entrega.id())
                .toUri();

        return ResponseEntity.created(uri).body(entrega);

    }

    /**
     * Atualiza o status de uma entrega existente
     * @param id Identificador da entrega a ser atualizada
     * @return DTO {@link EntregaResponse} atualizado
     */
    @Operation(
            summary = "Atualiza status de uma entrega pelo Id",
            description = "Atualiza status"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Entrega atualizada com sucesso"
            ),
            @ApiResponse(
                    responseCode = "204",
                    description = "Dados da requisição inválidos",
                    content = @Content(schema = @Schema(implementation = EntregaResponse.class))
            )
    })
    @PatchMapping("/{id}/status")
    public ResponseEntity<EntregaResponse> atualizarStatus(
            @Parameter(description = "Identificador único da entrega", example = "1")
            @PathVariable Long id, @RequestBody EntregaRequestStatus requestStatus){
        return ResponseEntity.ok(service.atualizarStatus(id, requestStatus));
    }
}
