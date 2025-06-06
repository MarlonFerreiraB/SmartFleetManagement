package com.frota.exceptions;

public class VeiculoNaoEncontradoException extends RuntimeException {
    public VeiculoNaoEncontradoException() {
        super("Não foi possivel encontrar o veiculo");
    }
}
