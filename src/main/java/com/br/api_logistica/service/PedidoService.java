package com.br.api_logistica.service;

import com.br.api_logistica.dto.pedido.PedidoRequest;
import com.br.api_logistica.dto.pedido.PedidoResponse;
import com.br.api_logistica.dto.pedido.PedidoUpdateRequest;
import com.br.api_logistica.entity.Entrega;
import com.br.api_logistica.entity.Motorista;
import com.br.api_logistica.entity.Pedido;
import com.br.api_logistica.entity.PedidoStatus;
import com.br.api_logistica.mapper.PedidoMapper;
import com.br.api_logistica.repository.EntregaRepository;
import com.br.api_logistica.repository.MotoristaRepository;
import com.br.api_logistica.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Serviço resposável pelas regras de negócio relacionados aos pedidos
 */
@Service
public class PedidoService {

    private final PedidoRepository repository;
    private final MotoristaRepository motoristaRepository;
    private final EntregaRepository entregaRepository;
    private final PedidoMapper mapper;

    public PedidoService(PedidoRepository repository, MotoristaRepository motoristaRepository, EntregaRepository entregaRepository, PedidoMapper mapper) {
        this.repository = repository;
        this.motoristaRepository = motoristaRepository;
        this.entregaRepository = entregaRepository;
        this.mapper = mapper;
    }

    /**
     * Cadastra umo novo pedido na lista de dados.
     * @param request Objeto contendo os dados de entrada para criação do pedido
     * @return DTO {@link PedidoResponse} com os dados do pedido persistido
     */
    public PedidoResponse cadastrar(PedidoRequest request){

        Pedido pedido = mapper.toEntity(request);
        pedido.setStatus(PedidoStatus.PENDENTE);
        Pedido salvo = repository.inserir(pedido);
        return mapper.toResponse(salvo);
    }

    /**
     * Atualiza os status de um pedido existente
     *
     * @param id Identificador do pedido a ser atualizada=
     * @return DTO {@link PedidoResponse} com os dados do pedido atualzados
     * @throws IllegalArgumentException Se nenhuma pedido for encontrada com o ID informado
     */
    public PedidoResponse atualizarStatus(Long id){
        Pedido pedido = repository.buscarPorId(id).orElseThrow(() -> new RuntimeException("Teste"));

        pedido.setStatus(PedidoStatus.CANCELADO);
        Pedido atualizado = repository.inserir(pedido);
        return mapper.toResponse(atualizado);
    }
}
