package com.clima.api.clima_api.dto;

public record MainDTO(
        Double temp,
        Double feels_like,
        Integer humidity
) {
}
