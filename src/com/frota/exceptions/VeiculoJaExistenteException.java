package com.frota.exceptions;

public class VeiculoJaExistenteException extends RuntimeException {
    public VeiculoJaExistenteException() {
        super("Esse veiculo ja existe");
    }
}
