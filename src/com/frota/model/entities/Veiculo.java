package com.frota.model.entities;

import com.frota.enums.StatusVeiculos;
import com.frota.enums.TipoCombustivel;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public  class Veiculo {
    protected String id = UUID.randomUUID().toString();
    protected String marca, modelo;
    protected int ano;
    protected double quilometrageOuHorasUso;
    protected TipoCombustivel tipoCombustivel;
    protected StatusVeiculos statusVeiculos;
    private List<CustoOperacional> operacionalList = new ArrayList<>();

    public Veiculo(){}

    public Veiculo( String marca, String modelo,int ano, double quilometrageOuHorasUso, TipoCombustivel tipoCombustivel){
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.quilometrageOuHorasUso = quilometrageOuHorasUso;
        this.tipoCombustivel = tipoCombustivel;
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

    public List<CustoOperacional> getOperacionalList() {
        return operacionalList;
    }

    public void setQuilometrageOuHorasUso(double quilometrageOuHorasUso) {
        this.quilometrageOuHorasUso = quilometrageOuHorasUso;
    }

    public String calcularConsumoComustivel(int distancia, double totalDeCombustivel){
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String df = decimalFormat.format(tipoCombustivel.calculaGastoCombustivel(distancia, totalDeCombustivel));
        return df;
    }

    public void atualizarStatus(StatusVeiculos novoStatus){
        System.out.println("Veiculo " + novoStatus.toString());
    }

    public void addCusto(LocalDate data, String descricao, String tipoCusto, double valor){
        CustoOperacional custoOperacional = new CustoOperacional(data, descricao, tipoCusto, valor,this);
        operacionalList.add(custoOperacional);
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
