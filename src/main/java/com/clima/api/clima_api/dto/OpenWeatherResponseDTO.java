package com.clima.api.clima_api.dto;

import java.util.List;

public record OpenWeatherResponseDTO(
        String name,
        MainDTO main,
        List<ClimarDTO> weather
) {
}
