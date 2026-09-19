package com.br.api_logistica.repository;

import com.br.api_logistica.entity.Cliente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ClienteRepository {

    private final AtomicLong sequencialId = new AtomicLong(1);
    private final List<Cliente> clientes = new ArrayList<>();

    public List<Cliente> listar(){
        return clientes.stream().toList();
    }

    public Optional<Cliente> buscarPorId(Long id){
        return clientes.stream().
                filter(cliente -> cliente.getId().equals(id))
                .findFirst();
    }

    public Cliente inserir(Cliente cliente){
        if(cliente.getId() == null){
            cliente.setId(sequencialId.getAndIncrement());
            clientes.add(cliente);
            return cliente;
        }
        return cliente;
    }

    public Optional<Cliente> buscarPorCpfCnpj(String cpfCnpj){
        return clientes.stream().
                filter(cliente -> cliente.getCpfCnpj().equals(cpfCnpj))
                .findFirst();
    }

    public void remover(Long id){
        /*clientes.removeIf(cliente -> cliente.getId().equals(id));*/

        clientes.removeIf(cliente -> cliente.getId().equals(id) );
    }

}
