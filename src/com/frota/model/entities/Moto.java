package com.frota.model.entities;

import com.frota.enums.TipoCombustivel;

import java.text.DecimalFormat;

public class Moto extends Veiculo{
    private int cilindrada;
    private String consumoKML;
    public Moto(String marca, String modelo, int ano, double quilometrageOuHorasUso, TipoCombustivel tipoCombustivel, int cilindrada){
        super(marca, modelo, ano, quilometrageOuHorasUso,tipoCombustivel);
        this.cilindrada = cilindrada;
        //colocar um erro o tanque de uma moto cabe entre 12 a 20
    }

    public String getConsumoKML() {
        return consumoKML;
    }

    public int getCilindrada() {
        return cilindrada;
    }
    @Override
    public String calcularConsumoComustivel(int distancia,double totalDeCombustivel){
        this.consumoKML = super.calcularConsumoComustivel(distancia,totalDeCombustivel);
        return super.calcularConsumoComustivel(distancia,totalDeCombustivel);
    }

    @Override
    public String toString() {
        return super.toString() +
                "cilindrada=" + cilindrada +
                ", consumoKML=" + consumoKML;
    }
}
