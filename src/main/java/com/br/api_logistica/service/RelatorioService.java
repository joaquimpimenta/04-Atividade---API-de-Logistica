package com.br.api_logistica.service;

import com.br.api_logistica.dto.entrega.EntregaPorMotorista;
import com.br.api_logistica.entity.Entrega;
import com.br.api_logistica.repository.EntregaRepository;
import com.br.api_logistica.repository.MotoristaRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Serviço resposável pelas regras de negócio relacionados aos relatórios
 */
@Service
public class RelatorioService {

    private final EntregaRepository entregaRepository;
    private final MotoristaRepository motoristaRepository;

    public RelatorioService(EntregaRepository entregaRepository, MotoristaRepository motoristaRepository) {
        this.entregaRepository = entregaRepository;
        this.motoristaRepository = motoristaRepository;
    }

    /**
     * Retorna a contagem de entregas por motorista
     * @return O número de entregas por motorista
     */
    public List<EntregaPorMotorista> entregaPorMotoristas(){

        Map<Long, Long> totalPorMotoristaId = entregaRepository.listar().stream().collect(Collectors.groupingBy(Entrega::getMotoristaId, Collectors.counting()));

        return motoristaRepository.listar().stream()
                .map(motorista -> new EntregaPorMotorista(
                        motorista.getId(),
                        motorista.getNome(),
                        totalPorMotoristaId.getOrDefault(motorista.getId(), 0L)
                ))
                .sorted(Comparator.comparingLong(EntregaPorMotorista::totalEntregas).reversed())
                .toList();
    }
}
