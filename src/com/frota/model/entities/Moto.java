package com.frota.model.entities;

import java.text.DecimalFormat;

public class Moto extends Veiculo{
    private int cilindrada;
    private int consumoKML;
    public Moto(String marca, String modelo,int ano, double quilometrageOuHorasUso, int cilindrada, int consumoKML){
        super(marca, modelo, ano, quilometrageOuHorasUso);
        this.cilindrada = cilindrada;
        //colocar um erro o tanque de uma moto cabe entre 12 a 20
        this.consumoKML = consumoKML;
    }

    public int getQuantidadeLitros() {
        return consumoKML;
    }

    public int getCilindrada() {
        return cilindrada;
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
                "cilindrada=" + cilindrada +
                ", consumoKML=" + consumoKML;
    }
}
