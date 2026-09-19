package com.br.api_logistica.service;

import com.br.api_logistica.dto.pedido.PedidoRequest;
import com.br.api_logistica.dto.pedido.PedidoResponse;
import com.br.api_logistica.dto.pedido.PedidoUpdateRequest;
import com.br.api_logistica.entity.Pedido;
import com.br.api_logistica.entity.PedidoStatus;
import com.br.api_logistica.mapper.PedidoMapper;
import com.br.api_logistica.repository.PedidoRepository;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private final PedidoRepository repository;
    private final PedidoMapper mapper;

    public PedidoService(PedidoRepository repository, PedidoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public PedidoResponse cadastrar(PedidoRequest request){

        Pedido pedido = mapper.toEntity(request);
        pedido.setStatus(PedidoStatus.PENDENTE);
        Pedido salvo = repository.inserir(pedido);
        return mapper.toResponse(salvo);
    }

    public PedidoResponse atualizarStatus(Long id){
        Pedido pedido = repository.buscarPorId(id).orElseThrow(() -> new RuntimeException("Teste"));

        pedido.setStatus(PedidoStatus.CANCELADO);
        Pedido atualizado = repository.inserir(pedido);
        return mapper.toResponse(atualizado);
    }
}
