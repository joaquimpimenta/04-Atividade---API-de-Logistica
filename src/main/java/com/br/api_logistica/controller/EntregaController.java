package com.br.api_logistica.controller;

import com.br.api_logistica.dto.cliente.ClienteResponse;
import com.br.api_logistica.dto.entrega.EntregaRequest;
import com.br.api_logistica.dto.entrega.EntregaResponse;
import com.br.api_logistica.entity.Entrega;
import com.br.api_logistica.service.EntregaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/api/entregas")
public class EntregaController {

    private final EntregaService service;

    public EntregaController(EntregaService service) {
        this.service = service;
    }

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

    @PatchMapping("/{id}/status")
    public ResponseEntity<EntregaResponse> atualizarStatus(@PathVariable Long id){
        return ResponseEntity.ok(service.atualizarStatus(id));
    }

    @GetMapping
    public ResponseEntity<List<EntregaResponse>> listar(){
        return ResponseEntity.ok(service.listar());
    }
}
