package com.frota.model.entities;

import com.frota.enums.StatusVeiculos;

import java.util.UUID;

public  class Veiculo {
    protected String id = UUID.randomUUID().toString();
    protected String marca, modelo;
    protected int ano;
    protected double quilometrageOuHorasUso;

    public Veiculo(){}

    public Veiculo( String marca, String modelo,int ano, double quilometrageOuHorasUso){
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.quilometrageOuHorasUso = quilometrageOuHorasUso;
    }

    public String getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public double getQuilometrageOuHorasUso() {
        return quilometrageOuHorasUso;
    }

    public double calcularConsumoComustivel(double distancia){
        return distancia;
    }

    public void atualizarStatus(StatusVeiculos novoStatus){
        System.out.println("Veiculo " + novoStatus.toString());
    }

    @Override
    public String toString() {
        return "Veiculo =" +
                "id='" + id + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                ", quilometrageOuHorasUso=" + quilometrageOuHorasUso;
    }
}
