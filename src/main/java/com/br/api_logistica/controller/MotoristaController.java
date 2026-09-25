package com.br.api_logistica.controller;

import com.br.api_logistica.dto.entrega.EntregaResponse;
import com.br.api_logistica.dto.motorista.MotoristaRequest;
import com.br.api_logistica.dto.motorista.MotoristaResponse;
import com.br.api_logistica.service.MotoristaService;
import io.swagger.v3.oas.annotations.Operation;
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

@Tag(
        name = "Motorista",
        description = "Operações relacionadas ao gerenciamento de motoristas"
)
@RestController
@RequestMapping("/v1/api/motoristas")
public class MotoristaController {

    private final MotoristaService service;

    public MotoristaController(MotoristaService service) {
        this.service = service;
    }

    /**
     * Cadastra um novo motorista
     * @param request DTO com os dados necessários para criação do motorista
     * @return DTO {@link EntregaResponse} com o motorista cadastrada e cabeçalho location
     */

    @Operation(
            summary = "Cadastro de um motorista",
            description = "Cria um novo motorista"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Cotorista criado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados da requisição inválidos",
                    content = @Content(schema = @Schema(implementation = EntregaResponse.class))
            )
    })
    @PostMapping
    public ResponseEntity<MotoristaResponse> cadastrar(@Valid @RequestBody MotoristaRequest request){
        MotoristaResponse motorista = service.cadastrar(request);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(motorista.id())
                .toUri();

        return ResponseEntity.created(uri).body(motorista);
    }

    /**
     * Lista todos os motoristas cadastrados
     * @return Lista de motoristas
     */
    @Operation(
            summary = "Lista de motoristas",
            description = "Retorna todos os motoristas cadastrados"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Motoristas retornados com sucesso"
    )
    @GetMapping
    public ResponseEntity<List<MotoristaResponse>> listarTodos(){
        return ResponseEntity.ok(service.listarTodos());
    }
}
