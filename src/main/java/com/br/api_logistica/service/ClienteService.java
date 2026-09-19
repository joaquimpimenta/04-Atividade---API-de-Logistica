package com.br.api_logistica.service;

import com.br.api_logistica.dto.cliente.ClienteRequest;
import com.br.api_logistica.dto.cliente.ClienteResponse;
import com.br.api_logistica.entity.Cliente;
import com.br.api_logistica.mapper.ClienteMapper;
import com.br.api_logistica.repository.ClienteRepository;
import com.br.api_logistica.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repository;
    private final PedidoRepository pedidoRepository;
    private final ClienteMapper mapper;

    public ClienteService(ClienteRepository repository, PedidoRepository pedidoRepository, ClienteMapper mapper) {
        this.repository = repository;
        this.pedidoRepository = pedidoRepository;
        this.mapper = mapper;
    }

    public List<ClienteResponse> listar(){

        List<Cliente> clientes = repository.listar();

        return mapper.toResponseList(clientes);
    }

    public ClienteResponse buscarPorId(Long id){
        return repository.buscarPorId(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new
                        IllegalArgumentException("Cliente não encontrado para ID: " + id));
    }

    public ClienteResponse cadastrar(ClienteRequest request){

        Cliente cliente = mapper.toEntity(request);
        Cliente salvo = repository.inserir(cliente);

        return mapper.toResponse(salvo);
    }

    public ClienteResponse buscarPorCpfCnpj(String cpfCnpj){
        return repository.buscarPorCpfCnpj(cpfCnpj)
                .map(mapper::toResponse)
                .orElseThrow(() -> new
                        IllegalArgumentException("Cliente não encontrado para o CPF(CNPJ): " + cpfCnpj));
    }

    public void remover(Long id){
        Cliente cliente = repository.buscarPorId(id)
                        .orElseThrow(()-> new
                IllegalArgumentException("Cliente não encontrado para ID: " + id));

        pedidoRepository.percorrerLista(cliente);

        repository.remover(id);
    }
}
