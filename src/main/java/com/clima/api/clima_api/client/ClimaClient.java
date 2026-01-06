package com.clima.api.clima_api.client;

import com.clima.api.clima_api.dto.ClimaResponseDTO;
import com.clima.api.clima_api.dto.OpenWeatherResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class ClimaClient {

    @Value("${openweather.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public OpenWeatherResponseDTO obterClima(String city) {
        String url = "https://api.openweathermap.org/data/2.5/weather?q={city}&appid={key}&units=metric&lang=pt_br";

        return restTemplate.getForObject(
                url,
                OpenWeatherResponseDTO.class,
                city,
                apiKey
        );
    }
}
