package com.br.api_logistica.service;

import com.br.api_logistica.dto.entrega.EntregaRequest;
import com.br.api_logistica.dto.entrega.EntregaRequestStatus;
import com.br.api_logistica.dto.entrega.EntregaResponse;
import com.br.api_logistica.dto.motorista.MotoristaResponse;
import com.br.api_logistica.dto.pedido.PedidoResponse;
import com.br.api_logistica.entity.Entrega;
import com.br.api_logistica.entity.EntregaStatus;
import com.br.api_logistica.mapper.EntregaMapper;
import com.br.api_logistica.repository.EntregaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Serviço resposável pelas regras de negócio relacionados aos entregas
 */
@Service
public class EntregaService {

    private final EntregaRepository repository;
    private final EntregaMapper mapper;

    public EntregaService(EntregaRepository repository, EntregaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Cadastra uma nova entrega na lista de dados.
     * @param request Objeto contendo os dados de entrada para criação da entrega
     * @return DTO {@link EntregaResponse} com os dados da entrega persistido
     */
    public EntregaResponse cadastrar(EntregaRequest request){
        Entrega entrega = mapper.toEntity(request);
        entrega.setStatus(EntregaStatus.EM_ROTA);
        Entrega salva = repository.inserir(entrega);
        return mapper.toResponse(salva);
    }

    /**
     * Atualiza os status de uma entrega existente
     *
     * @param id Identificador da entrega a ser atualizada
     * @return DTO {@link EntregaResponse} com os dados da entrega atualzada
     * @throws IllegalArgumentException Se nenhuma entrega for encontrada com o ID informado
     */
    public EntregaResponse atualizarStatus(Long id, EntregaRequestStatus status){

        Entrega entrega = repository.atualizarStatus(id, status.status());

        return mapper.toResponse(entrega);
    }

    /**
     * Lista todas as entregas
     * @return DTO {@link EntregaResponse com todas as entregas encontradas
     */
    public List<EntregaResponse> listar(){

        List<Entrega> entregas = repository.listar();

        return mapper.toResponseList(entregas);
    }



}
