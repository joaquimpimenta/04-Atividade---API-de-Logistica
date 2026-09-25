package com.br.api_logistica.controller;

import com.br.api_logistica.dto.entrega.EntregaResponse;
import com.br.api_logistica.dto.pedido.PedidoRequest;
import com.br.api_logistica.dto.pedido.PedidoResponse;
import com.br.api_logistica.service.PedidoService;
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

@Tag(
        name = "Pedidos",
        description = "Operações relacionadas ao gerenciamento de pedidos"
)
@RestController
@RequestMapping("/v1/api/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    /**
     * Cadastra um novo pedido
     * @param request DTO com os dados necessários para criação do pedido
     * @return DTO {@link PedidoResponse} com o pedido cadastrada e cabeçalho location
     */

    @Operation(
            summary = "Cadastro de um pedido",
            description = "Cria um novo pedido"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Pedido criado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados da requisição inválidos",
                    content = @Content(schema = @Schema(implementation = EntregaResponse.class))
            )
    })
    @PostMapping
    public ResponseEntity<PedidoResponse> cadastrar(@Valid @RequestBody PedidoRequest request){
        PedidoResponse pedido = service.cadastrar(request);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pedido.id())
                .toUri();

        return ResponseEntity.created(uri).body(pedido);
    }

    /**
     * Atualiza o status de um pedido existente
     * @param id Identificador do pedido a ser atualizada
     * @return DTO {@link PedidoResponse} atualizado
     */
    @Operation(
            summary = "Atualiza status de um pedido pelo Id",
            description = "Atualiza status"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Pedido atualizado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "204",
                    description = "Dados da requisição inválidos",
                    content = @Content(schema = @Schema(implementation = EntregaResponse.class))
            )
    })
    @PatchMapping("/{id}/cancelar")
    public ResponseEntity<PedidoResponse> atualizarStatus(@PathVariable Long id){
        return ResponseEntity.ok(service.atualizarStatus(id));
    }
}