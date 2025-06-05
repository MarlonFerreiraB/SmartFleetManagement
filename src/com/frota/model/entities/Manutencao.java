package com.frota.model.entities;

import java.time.LocalDate;
import java.util.UUID;

public class Manutencao {
    private String id = UUID.randomUUID().toString();
    private LocalDate data;
    private String descricao;
    private double valorTotal;
    private Veiculo veiculoAssociado;

    public Manutencao(LocalDate data, String descricao, double valor,Veiculo veiculoAssociado){
        this.data = data;
        this.descricao =descricao;
        this.valorTotal = valor;
        this.veiculoAssociado = veiculoAssociado;
    }

    public String getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valorTotal;
    }

    public Veiculo getVeiculoAssociado() {
        return veiculoAssociado;
    }
}
