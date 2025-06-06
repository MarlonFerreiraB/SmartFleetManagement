package com.frota.model.entities;

import com.frota.enums.StatusVeiculos;
import com.frota.enums.TipoCombustivel;
import com.frota.interfaces.Manutenivel;
import com.frota.interfaces.PreditorManutencao;
import com.frota.interfaces.RastreadorCusto;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Carro extends Veiculo implements Manutenivel, PreditorManutencao, RastreadorCusto {
    private String consumoKML;
    private int numeroPortas;
    private double quilometragemUltimaManutencao;
    private LocalDate dataUltimaManutencao;
    private List<Manutencao> histoicoManutencao = new ArrayList<>();

    public Carro(String marca, String modelo,int ano, double quilometrageOuHorasUso, TipoCombustivel tipoCombustivel, int numeroPortas,double quilometragemUltimaManutencao){
        super(marca, modelo, ano, quilometrageOuHorasUso, tipoCombustivel);
        this.tipoCombustivel = tipoCombustivel;
        this.numeroPortas = numeroPortas;
        this.quilometragemUltimaManutencao = quilometragemUltimaManutencao;
        this.dataUltimaManutencao = null;
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


    //Interface Manutenivel
    @Override
    public boolean precisaManutencao() {
        boolean vazia = histoicoManutencao.isEmpty();
        if(vazia) {
            System.out.println("Precisa de manutencao");
            return true;
        }
        LocalDate hj = LocalDate.now();
        LocalDate seismesesatras = dataUltimaManutencao.minusMonths(6);
        boolean manutencao = seismesesatras.isAfter(hj);
        if(!manutencao){
            System.out.println("Precisa de manutencao, faz mais de 6 meses");
            return true;
        }
        System.out.println("manutencao em dia");
        return false;
    }

    @Override
    public String obterUltimaManutencao() {
        if(histoicoManutencao.isEmpty()){
            return "Não houve nenhuma manutencao";
        }
        return "Data: " + dataUltimaManutencao;
    }

    @Override
    public void registrarManutencao(String descricao, double custo, LocalDate data) {
        Manutencao novaManu = new Manutencao(data, descricao,custo,this);
        histoicoManutencao.add(novaManu);
        System.out.println("Manuetencao registrada");

        this.quilometragemUltimaManutencao = this.quilometrageOuHorasUso;
        this.dataUltimaManutencao = data;

        statusVeiculos = StatusVeiculos.DISPONIVEL;
    }
    //Interface Manutenivel


    //PreditorManutencao

    @Override
    public LocalDate preverProximaManutencao() {
        LocalDate proximaManutencao = dataUltimaManutencao.plusMonths(6);
        return proximaManutencao;
    }

    @Override
    public String sugerirAcaoPreventiva() {

        return "Troca de oleo regulamento, calibrar os pneus e se atentas no estado deles, sempre limpar o filtro do ar, e verificar o nivel de agua";
    }

    //PreditorManutencao



    //RastreadorCusto

    @Override
    public double calcularCustosTotais() {
        double total = 0;
        for(CustoOperacional c: getOperacionalList()){
            total += c.getValor();
        }
            return total;
    }

    //RastreadorCusto

    @Override
    public String toString() {
        return super.toString() +  '\'' +
                "tipoCombustivel=" + tipoCombustivel + '\'' +
                ", consumoKML=" + consumoKML + '\'' +
                ", numeroPortas=" + numeroPortas;
    }
}
