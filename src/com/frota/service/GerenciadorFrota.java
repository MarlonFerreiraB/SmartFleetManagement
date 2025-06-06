package com.frota.service;

import com.frota.exceptions.ManutencaoInvalidaException;
import com.frota.exceptions.VeiculoJaExistenteException;
import com.frota.exceptions.VeiculoNaoEncontradoException;
import com.frota.interfaces.Manutenivel;
import com.frota.interfaces.PreditorManutencao;
import com.frota.interfaces.RastreadorCusto;
import com.frota.model.entities.Veiculo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorFrota {
    private List<Veiculo> frota = new ArrayList<>();
    private Manutenivel manutenivel;
    private PreditorManutencao preditorManutencao;
    private RastreadorCusto rastreadorCusto;

    public Manutenivel getManutenivel() {
        return manutenivel;
    }

    public boolean addVeiculo(Veiculo veiculo){
        if(!frota.isEmpty()){
         for(Veiculo v: frota){
             if(v.getId().equalsIgnoreCase(veiculo.getId())){
                 throw new VeiculoJaExistenteException();
             }
         }
        }
        frota.add(veiculo);
        System.out.println("Veiculo adicionado");
        return true;
    }

    public boolean removerVeiculo(String id){
        if(frota.isEmpty()){
            System.out.println("Não há nada a ser removido");
            return false;
        }
        for(Veiculo v: frota){
            if(v.getId().equalsIgnoreCase(id)){
                frota.remove(v);
                return true;
            }
        }
        throw new VeiculoNaoEncontradoException();
    }

    public boolean buscarVeicuoId(String id){
        if(frota.isEmpty()){
            System.out.println("Não há nada a ser removido");
            return false;
        }
        for(Veiculo v: frota){
            if(v.getId().equalsIgnoreCase(id)){
                v.toString();
                return true;
            }
        }
        throw new VeiculoNaoEncontradoException();
    }
    public boolean atualizarQuilometragemOuHorasUso(String id, double valor){

        if(frota.isEmpty()){
            System.out.println("Não há veiculos registrados");
            return false;
        }
        for(Veiculo v: frota){
            if(v.getId().equalsIgnoreCase(id)){
                if(valor < v.getQuilometrageOuHorasUso()){
                    throw new ManutencaoInvalidaException();
                }
                v.setQuilometrageOuHorasUso(valor);
                System.out.println("Atualizaod cm sucesso");
                return true;
            }
        }
        throw new VeiculoNaoEncontradoException();
    }
    public boolean registrarCusto(String id,LocalDate data, String descricao, String tipoCusto, double valor){
        if(valor < 40){
            throw new ManutencaoInvalidaException();
        }

        if(frota.isEmpty()){
            System.out.println("não ha nenhum carro na lista de frota");
            return false;
        }
        for(Veiculo v: frota){
            if(v.getId().equalsIgnoreCase(id)){
                v.addCusto(data, descricao, tipoCusto, valor);
                System.out.println("Custo adicionado");
                return true;
            }
        }
        throw new VeiculoNaoEncontradoException();
    }

    public void processarManutencoesPendentes(){
        for(Veiculo v: frota){
            if(v instanceof Manutenivel){
              boolean precisaManutencao = manutenivel.precisaManutencao();

              if(precisaManutencao){
                  System.out.println(manutenivel.obterUltimaManutencao());
              }
            }
        }
    }

    public void gerarRelatorioFinanceiro(String id){
        for(Veiculo v: frota){
            if(v instanceof RastreadorCusto){
                System.out.println("Custo total: " + rastreadorCusto.calcularCustosTotais());
            }
        }
    }

    public void obterPrevisaoManutencao(String id){
        for(Veiculo v: frota){
            if(v instanceof PreditorManutencao){
                System.out.println(preditorManutencao.preverProximaManutencao());
                System.out.println("__________________________");
                System.out.println(preditorManutencao.sugerirAcaoPreventiva());
            }
        }
    }
}
