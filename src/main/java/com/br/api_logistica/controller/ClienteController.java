package com.br.api_logistica.controller;

import com.br.api_logistica.dto.cliente.ClienteRequest;
import com.br.api_logistica.dto.cliente.ClienteResponse;
import com.br.api_logistica.dto.entrega.EntregaResponse;
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

    /**
     * Busca uma cliente pelo seu Identificador
     * @param id Identificador da cliente
     * @return DTO {@link ClienteResponse} com os dados da cliente encontrado
     */

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

    /**
     * Cadastra um novo cliente
     * @param request DTO com os dados necessários para criação do cliente
     * @return DTO {@link EntregaResponse} com o cliente cadastrada e cabeçalho location
     */

    @Operation(
            summary = "Cadastro de um cliente",
            description = "Cria um novo cliente"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Cliente criado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados da requisição inválidos",
                    content = @Content(schema = @Schema(implementation = EntregaResponse.class))
            )
    })
    @PostMapping
    public ResponseEntity<ClienteResponse> cadastrar(@Valid @RequestBody ClienteRequest request){
        ClienteResponse cliente = service.cadastrar(request);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(cliente.id())
                .toUri();

        return ResponseEntity.created(uri).body(cliente);
    }

    /**
     * Busca um cliente pelo seu CPF ou CNPJ
     * @param documento identificador do CPF ou CPNJ do cliente
     * @return DTO {@link ClienteResponse} com os dados do cliente encontrado
     */

    @Operation(
            summary = "Busca cliente por CPF ou CNPJ",
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
    @GetMapping("/encontrarCliente")
    public ResponseEntity<ClienteResponse> buscarPorCpfCnpj(@RequestParam (required = false) String documento){
        return ResponseEntity.ok(service.buscarPorCpfCnpj(documento));
    }

    /**
     * Remove um cliente
     * @param id Identificador do cliente a ser removido
     * @return Resposta sem conteúdo (HTTP 204 No Content)
     */
    @Operation(
            summary = "Remove um cliente",
            description = "Realiza a exclusão de um cliente"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Cliente removido com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Cliente não encontrado",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        service.remover(id);

        return ResponseEntity.noContent().build();
    }
}
