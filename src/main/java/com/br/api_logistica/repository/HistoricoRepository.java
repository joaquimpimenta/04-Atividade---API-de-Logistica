package com.br.api_logistica.repository;

import com.br.api_logistica.entity.Historico;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Repositório responsável pelo acesso dos dados de historicos
 */
@Repository
public class HistoricoRepository {

    private final AtomicLong sequencialId = new AtomicLong(1);
    private final List<Historico> historicos = new ArrayList<>();

    /**
     * Realiza a inserção da entidade historico no Lista
     * @param historico entidade historico
     * @return retorna o historico criado
     */
    public Historico inserir(Historico historico){
        if(historico.getId() == null){
            historico.setId(sequencialId.getAndIncrement());
            historicos.add(historico);
            return historico;
        }
        return historico;
    }

    /**
     * Realiza a busca de acordo com o Identificador Único para encontrar a entidade desejada
     * @param id Identificar Único da entidade
     * @return uma entidade historico de acordo com o Identificador Único selecionado
     */
    public Optional<Historico> buscarPorId(Long id){
        return historicos.stream().
                filter(historico -> historico.getId().equals(id))
                .findFirst();
    }
}
