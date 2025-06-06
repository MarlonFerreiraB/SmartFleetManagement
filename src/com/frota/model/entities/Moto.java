package com.frota.model.entities;

import com.frota.enums.TipoCombustivel;
import com.frota.interfaces.Manutenivel;
import com.frota.interfaces.PreditorManutencao;
import com.frota.interfaces.RastreadorCusto;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Moto extends Veiculo implements Manutenivel, PreditorManutencao, RastreadorCusto {
    private int cilindrada;
    private String consumoKML;
    private double quilometragemUltimaManutencao;
    private LocalDate dataUltimaManutencao;
    private List<Manutencao> histoicoManutencao = new ArrayList<>();

    public Moto(String marca, String modelo, int ano, double quilometrageOuHorasUso, TipoCombustivel tipoCombustivel, int cilindrada,double quilometragemUltimaManutencaom, LocalDate dataUltimaManutencao){
        super(marca, modelo, ano, quilometrageOuHorasUso,tipoCombustivel);
        this.cilindrada = cilindrada;
        this.quilometragemUltimaManutencao = quilometragemUltimaManutencao;
        this.dataUltimaManutencao = dataUltimaManutencao;
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

    //Manutenivel

    @Override
    public boolean precisaManutencao() {
        if(histoicoManutencao.isEmpty()){
            System.out.println("Precisa de manutencao");
            return true;
        }
        LocalDate hj = LocalDate.now();
        LocalDate seismesesAtras = dataUltimaManutencao.minusMonths(6);

        boolean manutencao = seismesesAtras.isAfter(hj);
        if(!manutencao){
            System.out.println("Precisa de manutencao");
            return true;
        }

        System.out.println("Nao precisa de manutencao");
        return false;
    }

    @Override
    public void registrarManutencao(String descricao, double custo, LocalDate data) {
        Manutencao novaManutencao = new Manutencao(data, descricao,custo,this);
        histoicoManutencao.add(novaManutencao);
        System.out.println("Manuetencao registrada");

        this.quilometragemUltimaManutencao = this.quilometrageOuHorasUso;
        this.dataUltimaManutencao = data;
    }

    @Override
    public String obterUltimaManutencao() {
        if(histoicoManutencao.isEmpty()){
            return "nao houve nenhuma manutencao";
        }
        return "Data: " + dataUltimaManutencao;
    }

    //

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
        return super.toString() +
                "cilindrada=" + cilindrada +
                ", consumoKML=" + consumoKML;
    }
}
