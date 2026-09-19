package com.br.api_logistica.repository;

import com.br.api_logistica.entity.Historico;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class HistoricoRepository {

    private final AtomicLong sequencialId = new AtomicLong(1);
    private final List<Historico> historicos = new ArrayList<>();

    public Historico inserir(Historico historico){
        if(historico.getId() == null){
            historico.setId(sequencialId.getAndIncrement());
            historicos.add(historico);
            return historico;
        }
        return historico;
    }

    public Optional<Historico> buscarPorId(Long id){
        return historicos.stream().
                filter(historico -> historico.getId().equals(id))
                .findFirst();
    }
}
