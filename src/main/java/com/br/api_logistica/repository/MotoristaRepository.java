package com.br.api_logistica.repository;

import com.br.api_logistica.entity.Motorista;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Repositório responsável pelo acesso dos dados de motoristas
 */
@Repository
public class MotoristaRepository {

    private final AtomicLong sequencialId = new AtomicLong(1);
    private final List<Motorista> motoristas = new ArrayList<>();

    /**
     * Armazena todas as entidades motoristas em uma lista
     * @return uma lista de entidades motoristas Concluidas.
     */
    public List<Motorista> listar(){
        return new ArrayList<>(motoristas);
    }

    /**
     * Realiza a inserção da entidade motorista no Lista
     * @param motorista entidade motorista
     * @return retorna a motorista criada
     */
    public Motorista inserir(Motorista motorista){
        if (motorista.getId() == null){
            motorista.setId(sequencialId.getAndIncrement());
            motoristas.add(motorista);
            return motorista;
        }
        return motorista;
    }

    /**
     * Realiza a busca de acordo com o Identificador Único para encontrar a entidade desejada
     * @param id Identificar Único da entidade
     * @return uma entidade motorista de acordo com o Identificador Único selecionado
     */
    public Optional<Motorista> buscarPorId(Long id){
        return motoristas.stream().
                filter(motorista -> motorista.getId().equals(id))
                .findFirst();
    }
}
