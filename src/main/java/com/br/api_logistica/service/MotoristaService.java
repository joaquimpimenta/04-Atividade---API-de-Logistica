package com.br.api_logistica.service;

import com.br.api_logistica.dto.motorista.MotoristaRequest;
import com.br.api_logistica.dto.motorista.MotoristaResponse;
import com.br.api_logistica.entity.Motorista;
import com.br.api_logistica.mapper.MotoristaMapper;
import com.br.api_logistica.repository.MotoristaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Serviço resposável pelas regras de negócio relacionados aos motoristas
 */
@Service
public class MotoristaService {

    private final MotoristaRepository repository;
    private final MotoristaMapper mapper;

    public MotoristaService(MotoristaRepository repository, MotoristaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Retorna todos motoristas cadastradas
     * @return Lista de DTOs {@link MotoristaResponse}
     * representando as motoristas encontradas. Lista vazia caso nenhum motorista seja encontrada
     */
    public List<MotoristaResponse> listarTodos(){
        return mapper.toResponseList(repository.listar());
    }

    /**
     * Cadastra um novo motorista na lista de dados.
     * @param request Objeto contendo os dados de entrada para criação do motorista
     * @return DTO {@link MotoristaResponse} com os dados do motorista persistido
     */
    public MotoristaResponse cadastrar(MotoristaRequest request){
        Motorista motorista = mapper.toEntity(request);
        Motorista salvo = repository.inserir(motorista);
        return mapper.toResponse(salvo);
    }

    /**
     * Busca um motorista pelo seu Identificador Único
     * @param id Identificador do motorista a ser localizado
     * @return DTO {@link MotoristaResponse} representando o motorista encontrado
     * @throws IllegalArgumentException Se nenhum motorista for encontrada com o ID informado
     */
    public MotoristaResponse buscarPorId(Long id){
        return repository.buscarPorId(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new
                        IllegalArgumentException("Motorista não encontrado para ID: " + id));
    }
}
