package com.br.api_logistica.service;

import com.br.api_logistica.dto.cliente.ClienteRequest;
import com.br.api_logistica.dto.cliente.ClienteResponse;
import com.br.api_logistica.dto.motorista.MotoristaResponse;
import com.br.api_logistica.entity.Cliente;
import com.br.api_logistica.mapper.ClienteMapper;
import com.br.api_logistica.repository.ClienteRepository;
import com.br.api_logistica.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Serviço resposável pelas regras de negócio relacionados aos clientes
 */
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

    /**
     * Lista todos os clientes
     * @return DTO {@link ClienteResponse} com todos os clientes encontrados
     */
    public List<ClienteResponse> listar(){

        List<Cliente> clientes = repository.listar();

        return mapper.toResponseList(clientes);
    }

    /**
     * Busca um cliente pelo seu Identificador Único
     * @param id Identificador do cliente a ser localizado
     * @return DTO {@link ClienteResponse} representando o cliente encontrado
     * @throws IllegalArgumentException Se nenhum cliente for encontrada com o ID informado
     */
    public ClienteResponse buscarPorId(Long id){
        return repository.buscarPorId(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new
                        IllegalArgumentException("Cliente não encontrado para ID: " + id));
    }

    /**
     * Cadastra um novo cliente na lista de dados.
     * @param request Objeto contendo os dados de entrada para criação do cliente
     * @return DTO {@link ClienteResponse} com os dados do cliente persistido
     */
    public ClienteResponse cadastrar(ClienteRequest request){

        Cliente cliente = mapper.toEntity(request);
        Cliente salvo = repository.inserir(cliente);

        return mapper.toResponse(salvo);
    }

    /**
     * Busca um cliente pelo seu CPF ou CNPj
     * @param cpfCnpj Identificador do seu CPF ou CNPJ
     * @return DTP {@link ClienteResponse} com o cliente com o mesmo identificador encontrado
     */
    public ClienteResponse buscarPorCpfCnpj(String cpfCnpj){
        return repository.buscarPorCpfCnpj(cpfCnpj)
                .map(mapper::toResponse)
                .orElseThrow(() -> new
                        IllegalArgumentException("Cliente não encontrado para o CPF(CNPJ): " + cpfCnpj));
    }

    /**
     * Remove a Entidade cliente de acordo com o Identificador Único
     * @param id Identificador Único da Entidade cliente
     * @throws IllegalArgumentException Se nenhuma cliente for encontrada com o ID informado
     */
    public void remover(Long id){
        Cliente cliente = repository.buscarPorId(id)
                        .orElseThrow(()-> new
                IllegalArgumentException("Cliente não encontrado para ID: " + id));

        pedidoRepository.percorrerLista(cliente);

        repository.remover(id);
    }
}
