package com.br.api_logistica.service;

import com.br.api_logistica.dto.historico.HistoricoRequest;
import com.br.api_logistica.dto.historico.HistoricoResponse;
import com.br.api_logistica.entity.Historico;
import com.br.api_logistica.mapper.HistoricoMapper;
import com.br.api_logistica.repository.HistoricoRepository;
import org.springframework.stereotype.Service;

@Service
public class HistoricoService {

    private final HistoricoRepository repository;
    private final HistoricoMapper mapper;

    public HistoricoService(HistoricoRepository repository, HistoricoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public HistoricoResponse buscarPorId(Long id){
        return repository.buscarPorId(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new
                        IllegalArgumentException("Cliente não encontrado para ID: " + id));
    }

    public HistoricoResponse cadastrar(HistoricoRequest request){

        Historico historico = mapper.toEntity(request);
        Historico salvo = repository.inserir(historico);

        return mapper.toResponse(salvo);
    }
}
