package com.br.api_logistica.mapper;

import com.br.api_logistica.dto.historico.HistoricoRequest;
import com.br.api_logistica.dto.historico.HistoricoResponse;
import com.br.api_logistica.entity.Historico;
import org.springframework.stereotype.Component;

@Component
public class HistoricoMapper {

    /**
     * Converte os dados de criação para uma entidade Historico.
     * @param request dados recebidos para criação
     * @return entidade Historico
     */
    public Historico toEntity(HistoricoRequest request){
        return Historico.builder()
                .descricao(request.descricao())
                .build();
    }

    /**
     * Converte uma entidade Entrega para o DTO de resposta
     * @param historico entidade persistida
     * @return representação pública da Historico
     */
    public HistoricoResponse toResponse(Historico historico){
        return new HistoricoResponse(
                historico.getId(),
                historico.getDescricao()
        );
    }
}
