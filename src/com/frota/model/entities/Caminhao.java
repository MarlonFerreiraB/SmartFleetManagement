package com.frota.model.entities;

import com.frota.enums.TipoCombustivel;
import com.frota.interfaces.Manutenivel;
import com.frota.interfaces.PreditorManutencao;

import javax.annotation.processing.SupportedSourceVersion;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;

public class Caminhao extends  Veiculo implements Manutenivel, PreditorManutencao {
    private double capacidadeTon;
    private int eixos;
    private String consumoKML;
    private double quilometragemUltimaManutencao;
    private LocalDate dataUltimaManutencao;
    private List<Manutencao> histoicoManutencao;

    public Caminhao(String marca, String modelo, int ano, double quilometrageOuHorasUso, TipoCombustivel tipoCombustivel, double capacidadeTon, int eixos, double quilometragemUltimaManutencao, LocalDate dataUltimaManutencao) {
        super(marca, modelo, ano, quilometrageOuHorasUso, tipoCombustivel);
        this.capacidadeTon = capacidadeTon;
        this.eixos = eixos;
        this.quilometragemUltimaManutencao = quilometragemUltimaManutencao;
        this.dataUltimaManutencao = dataUltimaManutencao;
    }

    @Override
    public String calcularConsumoComustivel(int distancia,double totalDeCombustivel){
        this.consumoKML = super.calcularConsumoComustivel(distancia,totalDeCombustivel);
        return super.calcularConsumoComustivel(distancia,totalDeCombustivel);
    }

    //Manutenivel

    @Override
    public boolean precisaManutencao() {
        if(histoicoManutencao.isEmpty()) {
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
        Manutencao novaManutencao = new Manutencao(data,descricao,custo,this);
        System.out.println("sua manutencão foi marcada");
    }

    //Manutenivel

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

    @Override
    public String toString() {
        return super.toString() +
                "capacidadeTon=" + capacidadeTon +
                ", eixos=" + eixos +
                ", consumoKML=" + consumoKML;
    }
}
