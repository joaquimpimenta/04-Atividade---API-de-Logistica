package com.br.api_logistica.repository;

import com.br.api_logistica.entity.Cliente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Repositório responsável pelo acesso dos dados de clientes
 */
@Repository
public class ClienteRepository {

    private final AtomicLong sequencialId = new AtomicLong(1);
    private final List<Cliente> clientes = new ArrayList<>();

    /**
     * Armazena todas as entidades clientes em uma lista
     * @return uma lista de entidades clientes Concluidas.
     */
    public List<Cliente> listar(){
        return clientes.stream().toList();
    }

    /**
     * Realiza a busca de acordo com o Identificador Único para encontrar a entidade desejada
     * @param id Identificar Único da entidade
     * @return uma entidade cliente de acordo com o Identificador Único selecionado
     */
    public Optional<Cliente> buscarPorId(Long id){
        return clientes.stream().
                filter(cliente -> cliente.getId().equals(id))
                .findFirst();
    }

    /**
     * Realiza a inserção da entidade cliente no Lista
     * @param cliente entidade cliente
     * @return retorna o cliente criado
     */
    public Cliente inserir(Cliente cliente){
        if(cliente.getId() == null){
            cliente.setId(sequencialId.getAndIncrement());
            clientes.add(cliente);
            return cliente;
        }
        return cliente;
    }

    /**
     * Realiza a busca de acordo com o CPF ou CNPJ do cliente
     * @param cpfCnpj Identificador do CPF ou CNPJ do cliente
     * @return uma entidiade cliente de acordo com o CPF ou CPNJ
     */
    public Optional<Cliente> buscarPorCpfCnpj(String cpfCnpj){
        return clientes.stream().
                filter(cliente -> cliente.getCpfCnpj().equals(cpfCnpj))
                .findFirst();
    }

    /**
     * Realiza a exclusão da entidade cliente na Lista de acordo com o Identificador único
     * @param id Identificar Único da entidade cliente
     */
    public void remover(Long id){

        clientes.removeIf(cliente -> cliente.getId().equals(id) );
    }

}
