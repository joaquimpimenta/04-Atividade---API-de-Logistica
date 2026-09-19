package com.br.api_logistica.mapper;

import com.br.api_logistica.dto.motorista.MotoristaRequest;
import com.br.api_logistica.dto.motorista.MotoristaResponse;
import com.br.api_logistica.entity.Motorista;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MotoristaMapper {

    /**
     * Converte os dados de criação para uma entidade Motorista.
     * @param request dados recebidos para criação
     * @return entidade Motorista
     */
    public Motorista toEntity(MotoristaRequest request){
        return Motorista.builder().
                nome(request.nome()).
                cnh(request.cnh()).
                veiculo(request.veiculo()).
                cidadeBase(request.cidadeBase()).build();
    }

    /**
     * Converte uma entidade Motorista para o DTO de resposta
     * @param motorista entidade persistida
     * @return representação pública da Motorista
     */
    public MotoristaResponse toResponse(Motorista motorista){
        return new MotoristaResponse(
                motorista.getId(),
                motorista.getNome(),
                motorista.getCnh(),
                motorista.getVeiculo(),
                motorista.getCidadeBase()
        );
    }

    /**
     * Converte uma lista de Entidades para uma lista de DTOs de resposta
     * @param motoristas lista de Entidades Motorista
     * @return representação publica da Lista de Motorista
     */
    public List<MotoristaResponse> toResponseList(List<Motorista> motoristas){
        return motoristas.stream()
                .map(this::toResponse)
                .toList();
    }
}
