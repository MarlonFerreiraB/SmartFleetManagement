package com.frota.interfaces;

import java.time.LocalDate;

public interface Manutenivel {
    boolean precisaManutencao();
    String obterUltimaManutencao();
    void registrarManutencao(String descricao, double custo, LocalDate data);

}
