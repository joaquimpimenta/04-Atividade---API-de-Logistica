package com.br.api_logistica.controller;

import com.br.api_logistica.dto.motorista.MotoristaRequest;
import com.br.api_logistica.dto.motorista.MotoristaResponse;
import com.br.api_logistica.service.MotoristaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/api/motoristas")
public class MotoristaController {

    private final MotoristaService service;

    public MotoristaController(MotoristaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<MotoristaResponse> cadastrar(@Valid @RequestBody MotoristaRequest request){
        MotoristaResponse motorista = service.cadastrar(request);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(motorista.id())
                .toUri();

        return ResponseEntity.created(uri).body(motorista);
    }

    @GetMapping
    public ResponseEntity<List<MotoristaResponse>> listarTodos(){
        return ResponseEntity.ok(service.listarTodos());
    }
}
