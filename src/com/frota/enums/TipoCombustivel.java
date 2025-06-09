package com.frota.enums;

import com.frota.interfaces.ImplementCalcCombustivel;

public enum TipoCombustivel implements ImplementCalcCombustivel {
    GASOLINA{
        @Override
        public double calculaGastoCombustivel( int distanciaPecorrida, double totalLitros) {
            return distanciaPecorrida/ totalLitros;
        }
    },
    DIESEL{
        @Override
        public double calculaGastoCombustivel(int distanciaPecorrida, double totalLitros) {
            double calculo = distanciaPecorrida / totalLitros * 0.2;

            return  (distanciaPecorrida / totalLitros) + calculo ;
        }


    },
    ETANOL{
        @Override
        public double calculaGastoCombustivel(int distanciaPecorrida, double totalLitros) {
            double calculo = ( distanciaPecorrida / totalLitros) * 0.13;

            return (distanciaPecorrida/ totalLitros) - calculo ;
        }
    },
    GNV{
        @Override
        public double calculaGastoCombustivel( int distanciaPecorrida, double totalLitros) {
            double calculo = (distanciaPecorrida / totalLitros) * 0.25;

            return (distanciaPecorrida / totalLitros) - calculo;
        }
    },
    ELETRICO{
        @Override
        public double calculaGastoCombustivel(int distanciaPecorrida, double totalLitros) {
            return distanciaPecorrida / totalLitros;
        }
    }



    //implementar uma nova interface estrategia de combustivel, ela vai ter um metodo de calcular consumo e cada enum ira ter o metodo retornando o valor(verificar se tem como)
}
