package com.frota.model.entities;

import com.frota.enums.TipoCombustivel;

import java.text.DecimalFormat;

public class Carro extends Veiculo{
    private String consumoKML;
    private int numeroPortas;


    public Carro(String marca, String modelo,int ano, double quilometrageOuHorasUso, TipoCombustivel tipoCombustivel, int numeroPortas){
        super(marca, modelo, ano, quilometrageOuHorasUso, tipoCombustivel);
        this.tipoCombustivel = tipoCombustivel;
        //colocar um erro o tanque de uma moto cabe entre 40 a 115
        this.numeroPortas = numeroPortas;
    }

    public TipoCombustivel getTipoCombustivel() {
        return tipoCombustivel;
    }

    public String getconsumoKML() {
        return consumoKML;
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }

    @Override
    public String calcularConsumoComustivel(int distancia,double totalDeCombustivel){
        this.consumoKML = super.calcularConsumoComustivel(distancia,totalDeCombustivel);
        return super.calcularConsumoComustivel(distancia,totalDeCombustivel);
    }

    @Override
    public String toString() {
        return super.toString() +  '\'' +
                "tipoCombustivel=" + tipoCombustivel + '\'' +
                ", consumoKML=" + consumoKML + '\'' +
                ", numeroPortas=" + numeroPortas;
    }
}
