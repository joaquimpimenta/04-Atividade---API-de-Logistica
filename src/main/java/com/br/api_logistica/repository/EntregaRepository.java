package com.br.api_logistica.repository;

import com.br.api_logistica.entity.Entrega;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class EntregaRepository {

    private final AtomicLong sequencialId = new AtomicLong(1);
    private final List<Entrega> entregas = new ArrayList<>();

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

    public Optional<Entrega> buscarPorId(Long id){
        return entregas.stream().
                filter(entrega -> entrega.getId().equals(id))
                .findFirst();
    }

    public List<Entrega> listar(){
        return entregas.stream().toList();
    }

}