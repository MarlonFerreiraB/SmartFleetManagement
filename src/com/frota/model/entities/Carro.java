package com.frota.model.entities;

import com.frota.enums.TipoCombustivel;

import java.text.DecimalFormat;

public class Carro extends Veiculo{
    private int consumoKML;
    private int numeroPortas;


    public Carro(String marca, String modelo,int ano, double quilometrageOuHorasUso, TipoCombustivel tipoCombustivel, int consumoKML, int numeroPortas){
        super(marca, modelo, ano, quilometrageOuHorasUso, tipoCombustivel);
        this.tipoCombustivel = tipoCombustivel;
        //colocar um erro o tanque de uma moto cabe entre 40 a 115
        this.consumoKML = consumoKML;
        this.numeroPortas = numeroPortas;
    }

    public TipoCombustivel getTipoCombustivel() {
        return tipoCombustivel;
    }

    public int getconsumoKML() {
        return consumoKML;
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }

    @Override
        public String calcularConsumoComustivel(double distancia){
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String df = decimalFormat.format(distancia / this.consumoKML);
        return df;
    }

    @Override
    public String toString() {
        return super.toString() +  '\'' +
                "tipoCombustivel=" + tipoCombustivel + '\'' +
                ", consumoKML=" + consumoKML + '\'' +
                ", numeroPortas=" + numeroPortas;
    }
}
