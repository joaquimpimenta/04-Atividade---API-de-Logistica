package com.br.api_logistica.controller;

import com.br.api_logistica.dto.cliente.ClienteRequest;
import com.br.api_logistica.dto.cliente.ClienteResponse;
import com.br.api_logistica.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/api/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> listar(){
        return ResponseEntity.ok(service.listar());
    }

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
