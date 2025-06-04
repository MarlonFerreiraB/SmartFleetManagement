package com.frota.interfaces;

import java.time.LocalDate;

public interface PreditorManutencao {
    LocalDate preverProximaManutencao();
    String sugerirAcaoPreventiva();
}
