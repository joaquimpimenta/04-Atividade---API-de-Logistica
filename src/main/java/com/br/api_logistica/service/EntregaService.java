package com.br.api_logistica.service;

import com.br.api_logistica.dto.entrega.EntregaRequest;
import com.br.api_logistica.dto.entrega.EntregaResponse;
import com.br.api_logistica.entity.Entrega;
import com.br.api_logistica.entity.EntregaStatus;
import com.br.api_logistica.mapper.EntregaMapper;
import com.br.api_logistica.repository.EntregaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregaService {

    private final EntregaRepository repository;
    private final EntregaMapper mapper;

    public EntregaService(EntregaRepository repository, EntregaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public EntregaResponse cadastrar(EntregaRequest request){
        Entrega entrega = mapper.toEntity(request);
        entrega.setStatus(EntregaStatus.EM_ROTA);
        Entrega salva = repository.inserir(entrega);
        return mapper.toResponse(salva);
    }

    public EntregaResponse atualizarStatus(Long id){
        Entrega entrega = repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException(""));


        if (entrega.getStatus().equals(EntregaStatus.EM_ROTA)){
            entrega.setStatus(EntregaStatus.ATRASADA);
            Entrega salva = repository.inserir(entrega);
            return mapper.toResponse(salva);
        }

        return null;
    }

    public List<EntregaResponse> listar(){

        List<Entrega> entregas = repository.listar();

        return mapper.toResponseList(entregas);
    }



}
