package com.frota.model.entities;

import java.time.LocalDate;
import java.util.UUID;

public class CustoOperacional {
    private String id = UUID.randomUUID().toString();
    private LocalDate data;
    private String descricao, tipoCusto;
    private double valor;
    private Veiculo veiculoAssociado;

    public CustoOperacional(LocalDate data, String descricao, String tipoCusto, double valor,Veiculo veiculoAssociado){
        this.data = data;
        this.descricao =descricao;
        this.tipoCusto = tipoCusto;
        this.valor = valor;
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

    public String getTipoCusto() {
        return tipoCusto;
    }

    public double getValor() {
        return valor;
    }

    public Veiculo getVeiculoAssociado() {
        return veiculoAssociado;
    }
}
