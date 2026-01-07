package com.clima.api.clima_api.controller;

import com.clima.api.clima_api.domain.Clima;
import com.clima.api.clima_api.dto.ClimaResponseDTO;
import com.clima.api.clima_api.service.ClimaService;
import jakarta.validation.ValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ClimaResponseDTO> buscarESalvar(@PathVariable String cidade) {

        Clima data = service.buscarESalvar(cidade);
        return ResponseEntity.ok().body(new ClimaResponseDTO(data));

    }

    @GetMapping
    public Page<ClimaResponseDTO> listar(@PageableDefault(sort = {"city"})Pageable paginacao) {
        return service.listar(paginacao);
    }

    @GetMapping("/{cidade}")
    public Page<ClimaResponseDTO> listarPorCidade(@PathVariable String cidade,  @PageableDefault()Pageable paginacao) {
        return service.listarPorCidade(cidade, paginacao);
    }
}
