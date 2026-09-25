package com.br.api_logistica.service;

import com.br.api_logistica.dto.historico.HistoricoRequest;
import com.br.api_logistica.dto.historico.HistoricoResponse;
import com.br.api_logistica.dto.motorista.MotoristaResponse;
import com.br.api_logistica.entity.Historico;
import com.br.api_logistica.mapper.HistoricoMapper;
import com.br.api_logistica.repository.HistoricoRepository;
import org.springframework.stereotype.Service;

/**
 * Serviço resposável pelas regras de negócio relacionados aos historicos
 */
@Service
public class HistoricoService {

    private final HistoricoRepository repository;
    private final HistoricoMapper mapper;

    public HistoricoService(HistoricoRepository repository, HistoricoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Busca um historico pelo seu Identificador Único
     * @param id Identificador do historico a ser localizado
     * @return DTO {@link HistoricoResponse} representando o historico encontrado
     * @throws IllegalArgumentException Se nenhum historico for encontrada com o ID informado
     */
    public HistoricoResponse buscarPorId(Long id){
        return repository.buscarPorId(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new
                        IllegalArgumentException("Cliente não encontrado para ID: " + id));
    }

    /**
     * Cadastra um novo historico na lista de dados.
     * @param request Objeto contendo os dados de entrada para criação do historico
     * @return DTO {@link HistoricoResponse} com os dados do historico persistido
     */
    public HistoricoResponse cadastrar(HistoricoRequest request){

        Historico historico = mapper.toEntity(request);
        Historico salvo = repository.inserir(historico);

        return mapper.toResponse(salvo);
    }
}
