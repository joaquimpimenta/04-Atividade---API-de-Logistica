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

    /**
     * Realiza a inserção da entidade pedido no Lista
     * @param pedido entidade pedido
     * @return retorna a pedido criada
     */
    public Pedido inserir(Pedido pedido){
        if(pedido.getId() == null){
            pedido.setId(sequencialId.getAndIncrement());
            pedidos.add(pedido);
            return pedido;
        }
        return pedido;
    }

    /**
     * Realiza a busca de acordo com o Identificador Único para encontrar a entidade desejada
     * @param id Identificar Único da entidade
     * @return uma entidade pedido de acordo com o Identificador Único selecionado
     */
    public Optional<Pedido> buscarPorId(Long id){
        return pedidos.stream().
                filter(pedido -> pedido.getId().equals(id))
                .findFirst();
    }

    /**
     * Percorre a lista para verificar se não há nenhum cliente relacionado ao pedido
     * @param cliente entidade cliente
     * @return retorna uma lista de pedidos
     */
    public List<Pedido> percorrerLista(Cliente cliente){
        for(Pedido pedido : pedidos){
            if(pedido.getClienteID().equals(cliente.getId())){
                throw new RuntimeException("Este cliente tem um pedido relacionado com ele!");
            }
        }
        return pedidos;
    }
}
