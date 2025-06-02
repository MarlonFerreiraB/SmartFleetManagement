package com.frota.model.entities;

import com.frota.enums.TipoCombustivel;

import java.text.DecimalFormat;

public class Caminhao extends  Veiculo {
    private double capacidadeTon;
    private int eixos;
    private String consumoKML;

    public Caminhao(String marca, String modelo, int ano, double quilometrageOuHorasUso, TipoCombustivel tipoCombustivel, double capacidadeTon, int eixos) {
        super(marca, modelo, ano, quilometrageOuHorasUso, tipoCombustivel);
        this.capacidadeTon = capacidadeTon;
        this.eixos = eixos;
    }

    @Override
    public String calcularConsumoComustivel(int distancia,double totalDeCombustivel){
        this.consumoKML = super.calcularConsumoComustivel(distancia,totalDeCombustivel);
        return super.calcularConsumoComustivel(distancia,totalDeCombustivel);
    }

    @Override
    public String toString() {
        return super.toString() +
                "capacidadeTon=" + capacidadeTon +
                ", eixos=" + eixos +
                ", consumoKML=" + consumoKML;
    }
}
