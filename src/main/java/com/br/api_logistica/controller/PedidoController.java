package com.br.api_logistica.controller;

import com.br.api_logistica.dto.pedido.PedidoRequest;
import com.br.api_logistica.dto.pedido.PedidoResponse;
import com.br.api_logistica.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/v1/api/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PedidoResponse> cadastrar(@Valid @RequestBody PedidoRequest request){
        PedidoResponse pedido = service.cadastrar(request);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pedido.id())
                .toUri();

        return ResponseEntity.created(uri).body(pedido);
    }

    @PatchMapping("/{id}/cancelar")
    public ResponseEntity<PedidoResponse> atualizarStatus(@PathVariable Long id){
        return ResponseEntity.ok(service.atualizarStatus(id));
    }
}
