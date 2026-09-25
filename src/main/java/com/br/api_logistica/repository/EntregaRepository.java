package com.br.api_logistica.repository;

import com.br.api_logistica.entity.Entrega;
import com.br.api_logistica.entity.EntregaStatus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Repositório responsável pelo acesso dos dados de entregas
 */
@Repository
public class EntregaRepository {

    private final AtomicLong sequencialId = new AtomicLong(1);
    private final List<Entrega> entregas = new ArrayList<>();

    /**
     * Realiza a inserção da entidade entrega no Lista
     * @param entrega entidade entrega
     * @return retorna a entrega criada
     */
    public Entrega inserir(Entrega entrega){

        if(entrega.getPedidoId() == null && entrega.getMotoristaId() == null){
            throw new RuntimeException("Não foi possivel encontrar nenhum pedido e (ou) nenhum motorista ");
        } else if (entrega.getId() == null){
            entrega.setId(sequencialId.getAndIncrement());
            entregas.add(entrega);
            return entrega;
        }
        return entrega;
    }

    /**
     * Armazena todas as entidades entregas em uma lista
     * @return uma lista de entidades entregas Concluidas.
     */
    public List<Entrega> listar(){
        return entregas.stream().toList();
    }

    /**
     * Atualiza o status da entrega
     * @param id Identificar Único da entidade
     * @return uma entidade entrega com o status atualizado
     */
    public Entrega atualizarStatus(Long id, EntregaStatus status){

        Entrega entrega = entregas.stream()
                .filter(entrega1 -> entrega1.getId().equals(id))
                .findFirst().orElseThrow(() -> new RuntimeException(""));

        entrega.setStatus(status);

        return entrega;
    }

}