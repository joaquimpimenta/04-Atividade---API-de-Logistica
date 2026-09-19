package com.br.api_logistica.controller;

import com.br.api_logistica.dto.historico.HistoricoRequest;
import com.br.api_logistica.dto.historico.HistoricoResponse;
import com.br.api_logistica.service.HistoricoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/v1/api/entregas")
public class HistoricoController {

    private final HistoricoService service;

    public HistoricoController(HistoricoService service) {
        this.service = service;
    }

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