package com.br.api_logistica.controller;

import com.br.api_logistica.dto.cliente.ClienteRequest;
import com.br.api_logistica.dto.cliente.ClienteResponse;
import com.br.api_logistica.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Controller REST responsavel pelos endpoints relacionados ao recusso cliente
 */
@Tag(
        name = "Clientes",
        description = "Operações relacionadas ao gerenciamento de clientes"
)
@RestController
@RequestMapping("/v1/api/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    /**
     * Lista todos os clientes cadastrados
     * @return Lista de clientes
     */
    @Operation(
            summary = "Lista de clientes",
            description = "Retorna todos os clientes cadastrados"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Clientes retornados com sucesso"
    )
    @GetMapping
    public ResponseEntity<List<ClienteResponse>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @Operation(
            summary = "Busca cliente por ID",
            description = "Retorna os detalhes de um cliente específico com base no seu identificador único"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Cliente encontrado com sucesso"
            ),
            @ApiResponse (
                    responseCode = "404",
                    description = "Cliente não encontrado",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> buscarPorId(
            @PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> cadastrar(@Valid @RequestBody ClienteRequest request){
        ClienteResponse cliente = service.cadastrar(request);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(cliente.id())
                .toUri();

        return ResponseEntity.created(uri).body(cliente);
    }

    @GetMapping("/encontrarCliente")
    public ResponseEntity<ClienteResponse> buscarPorCpfCnpj(@RequestParam (required = false) String documento){
        return ResponseEntity.ok(service.buscarPorCpfCnpj(documento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        service.remover(id);

        return ResponseEntity.noContent().build();
    }
}
