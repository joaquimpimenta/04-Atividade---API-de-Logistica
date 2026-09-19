package com.br.api_logistica.repository;

import com.br.api_logistica.entity.Cliente;
import com.br.api_logistica.entity.Pedido;
import com.br.api_logistica.entity.PedidoStatus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PedidoRepository {

    private final AtomicLong sequencialId = new AtomicLong(1);
    private final List<Pedido> pedidos = new ArrayList<>();

    public Pedido inserir(Pedido pedido){
        if(pedido.getId() == null){
            pedido.setId(sequencialId.getAndIncrement());
            pedidos.add(pedido);
            return pedido;
        }
        return pedido;
    }

    public Optional<Pedido> buscarPorId(Long id){
        return pedidos.stream().
                filter(pedido -> pedido.getId().equals(id))
                .findFirst();
    }

    public List<Pedido> percorrerLista(Cliente cliente){
        for(Pedido pedido : pedidos){
            if(pedido.getClienteID().equals(cliente.getId())){
                throw new RuntimeException("Este cliente tem um pedido relacionado com ele!");
            }
        }
        return pedidos;
    }
}
