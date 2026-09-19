package com.br.api_logistica.repository;

import com.br.api_logistica.entity.Motorista;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MotoristaRepository {

    private final AtomicLong sequencialId = new AtomicLong(1);
    private final List<Motorista> motoristas = new ArrayList<>();

    public List<Motorista> listar(){
        return new ArrayList<>(motoristas);
    }

    public Motorista inserir(Motorista motorista){
        if (motorista.getId() == null){
            motorista.setId(sequencialId.getAndIncrement());
            motoristas.add(motorista);
            return motorista;
        }
        return motorista;
    }
}
