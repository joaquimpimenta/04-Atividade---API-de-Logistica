package com.br.api_logistica.controller;

import com.br.api_logistica.dto.entrega.EntregaPorMotorista;
import com.br.api_logistica.service.RelatorioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(
        name = "Relatorios",
        description = "Operações relacionadas ao gerenciamento de relatorios"
)
@RestController
@RequestMapping("v1/api/relatorios/entregas-por-motorista")
public class RelatorioController {

    private final RelatorioService relatorioService;

    public RelatorioController(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    /**
     * Faz a contagem de entregas por motorista
     * @return DTO {@link EntregaPorMotorista} com a contagem
     */
    @Operation(
            summary = "Atualiza status de um pedido pelo Id",
            description = "Atualiza status"
    )
    @GetMapping
    public ResponseEntity<List<EntregaPorMotorista>> entregasPorMotorista(){
        return ResponseEntity.ok(relatorioService.entregaPorMotoristas());
    }
}
