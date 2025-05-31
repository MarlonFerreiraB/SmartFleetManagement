package com.frota.model.entities;

import com.frota.enums.TipoCombustivel;

import java.text.DecimalFormat;

public class Caminhao extends  Veiculo {
    private double capacidadeTon;
    private int eixos;
    private int consumoKML;

    public Caminhao(String marca, String modelo, int ano, double quilometrageOuHorasUso, TipoCombustivel tipoCombustivel, double capacidadeTon, int eixos, int consumoKML) {
        super(marca, modelo, ano, quilometrageOuHorasUso, tipoCombustivel);
        this.capacidadeTon = capacidadeTon;
        this.eixos = eixos;
        this.consumoKML = consumoKML;
    }

    @Override
    public String calcularConsumoComustivel(double distancia){
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String df = decimalFormat.format(distancia / this.consumoKML);
        return df;
    }

    @Override
    public String toString() {
        return super.toString() +
                "capacidadeTon=" + capacidadeTon +
                ", eixos=" + eixos +
                ", consumoKML=" + consumoKML;
    }
}
