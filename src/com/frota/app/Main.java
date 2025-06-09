package com.frota.app;

import com.frota.enums.TipoCombustivel;
import com.frota.model.entities.Caminhao;
import com.frota.model.entities.Carro;
import com.frota.model.entities.Moto;
import com.frota.service.GerenciadorFrota;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorFrota gerenciador = new GerenciadorFrota();

        while (true) {
            System.out.println("\n=== Sistema de Gestão de Frota ===");
            System.out.println("1. Adicionar novo veículo");
            System.out.println("2. Registrar custo operacional");
            System.out.println("3. Atualizar quilometragem");
            System.out.println("4. Verificar manutenções pendentes");
            System.out.println("5. Gerar relatório financeiro");
            System.out.println("6. Ver previsão de manutenção");
            System.out.println("7. Calcular consumo de combustível");
            System.out.println("8. Sair");
            System.out.println("9. Listar todos os veículos");
            System.out.println("10. Remover veículo");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (opcao) {
                    case 1:
                        System.out.println("\nTipo de veículo:");
                        System.out.println("1. Carro");
                        System.out.println("2. Moto");
                        System.out.println("3. Caminhão");
                        System.out.print("Escolha: ");
                        int tipoVeiculo = scanner.nextInt();
                        scanner.nextLine(); 

                        System.out.print("Marca: ");
                        String marca = scanner.nextLine();
                        System.out.print("Modelo: ");
                        String modelo = scanner.nextLine();
                        System.out.print("Ano: ");
                        int ano = scanner.nextInt();
                        System.out.print("Quilometragem atual: ");
                        double quilometragem = scanner.nextDouble();
                        scanner.nextLine(); 

                        System.out.println("Tipo de combustível:");
                        System.out.println("1. GASOLINA");
                        System.out.println("2. ETANOL");
                        System.out.println("3. DIESEL");
                        System.out.println("4. GNV");
                        System.out.print("Escolha: ");
                        int tipoCombustivel = scanner.nextInt();
                        scanner.nextLine(); 

                        TipoCombustivel combustivel = switch (tipoCombustivel) {
                            case 1 -> TipoCombustivel.GASOLINA;
                            case 2 -> TipoCombustivel.ETANOL;
                            case 3 -> TipoCombustivel.DIESEL;
                            case 4 -> TipoCombustivel.GNV;
                            default -> TipoCombustivel.GASOLINA;
                        };

                        switch (tipoVeiculo) {
                            case 1: 
                                System.out.print("Número de portas: ");
                                int numeroPortas = scanner.nextInt();
                                Carro carro = new Carro(marca, modelo, ano, quilometragem, combustivel, numeroPortas, quilometragem);
                                gerenciador.addVeiculo(carro);
                                System.out.println("Carro adicionado com sucesso!");
                                break;

                            case 2: 
                                System.out.print("Cilindrada: ");
                                int cilindrada = scanner.nextInt();
                                Moto moto = new Moto(marca, modelo, ano, quilometragem, combustivel, cilindrada, quilometragem, LocalDate.now());
                                gerenciador.addVeiculo(moto);
                                System.out.println("Moto adicionada com sucesso!");
                                break;

                            case 3: 
                                System.out.print("Capacidade em toneladas: ");
                                double capacidade = scanner.nextDouble();
                                System.out.print("Número de eixos: ");
                                int eixos = scanner.nextInt();
                                Caminhao caminhao = new Caminhao(marca, modelo, ano, quilometragem, combustivel, capacidade, eixos, quilometragem, LocalDate.now());
                                gerenciador.addVeiculo(caminhao);
                                System.out.println("Caminhão adicionado com sucesso!");
                                break;

                            default:
                                System.out.println("Tipo de veículo inválido!");
                        }
                        break;

                    case 2:
                        System.out.print("ID do veículo: ");
                        String idCusto = scanner.nextLine();
                        System.out.print("Descrição do custo: ");
                        String descricao = scanner.nextLine();
                        System.out.print("Tipo do custo: ");
                        String tipoCusto = scanner.nextLine();
                        System.out.print("Valor: ");
                        double valor = scanner.nextDouble();
                        
                        if (valor < 0) {
                            throw new IllegalArgumentException("Valor não pode ser negativo");
                        }
                        
                        gerenciador.registrarCusto(idCusto, LocalDate.now(), descricao, tipoCusto, valor);
                        System.out.println("Custo registrado com sucesso!");
                        break;

                    case 3:
                        System.out.print("ID do veículo: ");
                        String idQuilometragem = scanner.nextLine();
                        System.out.print("Nova quilometragem: ");
                        double novaQuilometragem = scanner.nextDouble();
                        
                        gerenciador.atualizarQuilometragemOuHorasUso(idQuilometragem, novaQuilometragem);
                        System.out.println("Quilometragem atualizada com sucesso!");
                        break;

                    case 4:
                        gerenciador.processarManutencoesPendentes();
                        break;

                    case 5:
                        System.out.print("ID do veículo: ");
                        String idRelatorio = scanner.nextLine();
                        gerenciador.gerarRelatorioFinanceiro(idRelatorio);
                        break;

                    case 6:
                        System.out.print("ID do veículo: ");
                        String idPrevisao = scanner.nextLine();
                        gerenciador.obterPrevisaoManutencao(idPrevisao);
                        break;

                    case 7:
                        System.out.print("ID do veículo: ");
                        String idConsumo = scanner.nextLine();
                        System.out.print("Distância percorrida (km): ");
                        int distancia = scanner.nextInt();
                        System.out.print("Total de combustível (litros): ");
                        double combustivelTotal = scanner.nextDouble();
                        
                        
                        System.out.println("Consumo calculado: " + distancia / combustivelTotal + " km/l");
                        break;

                    case 8:
                        System.out.println("Saindo do sistema...");
                        scanner.close();
                        return;

                    case 9:
                        gerenciador.listarVeiculos();
                        break;

                    case 10:
                        System.out.print("ID do veículo: ");
                        String idRemover = scanner.nextLine();
                        gerenciador.removerVeiculo(idRemover);
                        System.out.println("Veículo removido com sucesso!");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Erro de validação: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        }
    }
}