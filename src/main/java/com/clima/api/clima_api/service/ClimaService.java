package com.clima.api.clima_api.service;

import com.clima.api.clima_api.client.ClimaClient;
import com.clima.api.clima_api.domain.Clima;
import com.clima.api.clima_api.dto.ClimaResponseDTO;
import com.clima.api.clima_api.dto.OpenWeatherResponseDTO;
import com.clima.api.clima_api.repository.ClimaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClimaService {

    private final ClimaClient client;
    private final ClimaRepository repository;

    public ClimaService(ClimaClient client, ClimaRepository repository) {
        this.client = client;
        this.repository = repository;
    }

    public Clima buscarESalvar(String city) {
        OpenWeatherResponseDTO response = client.obterClima(city);

        Clima data = new Clima();
        data.setCity(response.name());
        data.setTemperature(response.main().temp());
        data.setFeelsLike(response.main().feels_like());
        data.setHumidity(response.main().humidity());
        data.setDescription(response.weather().get(0).description());

        return repository.save(data);
    }

    public List<ClimaResponseDTO> listar() {
        return repository.findAll()
                .stream()
                .map(ClimaResponseDTO::new)
                .toList();
    }

    public List<ClimaResponseDTO> listarPorCidade(String city) {
        return repository.findByCityIgnoreCase(city).stream().map(ClimaResponseDTO::new).toList();
    }
}
