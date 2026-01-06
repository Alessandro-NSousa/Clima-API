package com.clima.api.clima_api.controller;

import com.clima.api.clima_api.domain.Clima;
import com.clima.api.clima_api.dto.ClimaResponseDTO;
import com.clima.api.clima_api.service.ClimaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clima")
public class ClimaController {

    private final ClimaService service;

    public ClimaController(ClimaService service) {
        this.service = service;
    }

    @PostMapping("/{cidade}")
    public ClimaResponseDTO buscarESalvar(@PathVariable String cidade) {

        Clima data = service.buscarESalvar(cidade);

        return new ClimaResponseDTO(data);
    }

    @GetMapping
    public List<ClimaResponseDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{cidade}")
    public List<ClimaResponseDTO> listarPorCidade(@PathVariable String cidade) {
        return service.listarPorCidade(cidade);
    }
}
