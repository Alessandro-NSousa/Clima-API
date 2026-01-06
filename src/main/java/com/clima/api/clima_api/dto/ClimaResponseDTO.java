package com.clima.api.clima_api.dto;

import com.clima.api.clima_api.domain.Clima;

import java.time.LocalDateTime;

public record ClimaResponseDTO(
        String cidade,
        Double temperatura,
        Double sensacaoTermica,
        Integer umidade,
        String descricao,
        LocalDateTime criado
) {
    public ClimaResponseDTO(Clima data){
        this(data.getCity(), data.getTemperature(), data.getFeelsLike(), data.getHumidity(), data.getDescription(), data.getCreatedAt());
    }
}
