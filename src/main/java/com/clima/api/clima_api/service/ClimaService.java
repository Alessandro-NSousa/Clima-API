package com.clima.api.clima_api.service;

import com.clima.api.clima_api.client.ClimaClient;
import com.clima.api.clima_api.domain.Clima;
import com.clima.api.clima_api.dto.ClimaResponseDTO;
import com.clima.api.clima_api.dto.OpenWeatherResponseDTO;
import com.clima.api.clima_api.infra.CidadeNaoEncontradaException;
import com.clima.api.clima_api.repository.ClimaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class ClimaService {

    private final ClimaClient client;
    private final ClimaRepository repository;

    public ClimaService(ClimaClient client, ClimaRepository repository) {
        this.client = client;
        this.repository = repository;
    }

    public Clima buscarESalvar(String cidade) {

        try {
            OpenWeatherResponseDTO response = client.obterClima(cidade);

            Clima data = new Clima();
            data.setCity(response.name());
            data.setTemperature(response.main().temp());
            data.setFeelsLike(response.main().feels_like());
            data.setHumidity(response.main().humidity());
            data.setDescription(response.weather().get(0).description());

            return repository.save(data);

        } catch (HttpClientErrorException.NotFound e) {
            throw new CidadeNaoEncontradaException(cidade);
        }

    }

    public Page<ClimaResponseDTO> listar(Pageable paginacao) {
        return repository.findAll(paginacao).map(ClimaResponseDTO::new);
    }

    public Page<ClimaResponseDTO> listarPorCidade(String city, Pageable paginacao) {
        return repository.findByCityIgnoreCase(city, paginacao).map(ClimaResponseDTO::new);
    }
}
