package com.br.api_logistica.service;

import com.br.api_logistica.dto.motorista.MotoristaRequest;
import com.br.api_logistica.dto.motorista.MotoristaResponse;
import com.br.api_logistica.entity.Motorista;
import com.br.api_logistica.mapper.MotoristaMapper;
import com.br.api_logistica.repository.MotoristaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoristaService {

    private final MotoristaRepository repository;
    private final MotoristaMapper mapper;

    public MotoristaService(MotoristaRepository repository, MotoristaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<MotoristaResponse> listarTodos(){
        return mapper.toResponseList(repository.listar());
    }

    public MotoristaResponse cadastrar(MotoristaRequest request){
        Motorista motorista = mapper.toEntity(request);
        Motorista salvo = repository.inserir(motorista);
        return mapper.toResponse(salvo);
    }
}
