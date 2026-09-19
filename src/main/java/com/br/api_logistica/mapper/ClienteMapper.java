package com.br.api_logistica.mapper;

import com.br.api_logistica.dto.cliente.ClienteRequest;
import com.br.api_logistica.dto.cliente.ClienteResponse;
import com.br.api_logistica.dto.cliente.ClienteUpdateRequest;
import com.br.api_logistica.entity.Cliente;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteMapper {

    /**
     * Converte os dados de criação para uma entidade Cliente.
     * @param request dados recebidos para criação
     * @return entidade Cliente
     */
    public Cliente toEntity(ClienteRequest request){
        return Cliente.builder()
                .nome(request.nome())
                .cpfCnpj(request.cpfCnpj())
                .endereco(request.endereco())
                .cidade(request.cidade())
                .estado(request.estado())
                .build();
    }

    /**
     * Converte uma entidade Cliente para o DTO de resposta
     * @param cliente entidade persistida
     * @return representação pública da tarefa
     */
    public ClienteResponse toResponse(Cliente cliente){
        return new ClienteResponse(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpfCnpj(),
                cliente.getEndereco(),
                cliente.getCidade(),
                cliente.getEstado());
    }

    /**
     * Converte uma lista de Entidades para uma lista de DTOs de resposta
     * @param clientes lista de Entidades Cliente
     * @return representação publica da Lista de Cliente
     */
    public List<ClienteResponse> toResponseList(List<Cliente> clientes){
        return clientes.stream()
                .map(this::toResponse)
                .toList();
    }
}
