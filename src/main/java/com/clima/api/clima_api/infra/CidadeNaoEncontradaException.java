package com.clima.api.clima_api.infra;

public class CidadeNaoEncontradaException extends RuntimeException {

    public CidadeNaoEncontradaException(String cidade) {
        super("Cidade não encontrada: " + cidade);
    }
}
