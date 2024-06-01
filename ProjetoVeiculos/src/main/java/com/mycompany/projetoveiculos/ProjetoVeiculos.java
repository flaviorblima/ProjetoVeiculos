/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projetoveiculos;

/**
 *
 * @author flavi
 */
public class ProjetoVeiculos {

        public static void main(String[] args) {
        // Vetor para armazenar os veículos
        Veiculo[] veiculos = new Veiculo[20];

        // Preenche o vetor com 10 aviões e 10 navios
        for (int i = 0; i < 10; i++) {
            veiculos[i] = new Aviao();
            veiculos[i + 10] = new Navio();
        }

        // Entrada de dados para cada veículo
        for (int i = 0; i < veiculos.length; i++) {
            System.out.println("Entrada de dados para " + (i < 10 ? "Avião" : "Navio") + " " + (i % 10 + 1) + ":");
            veiculos[i].entrada();
        }

        // Imprime os dados de cada veículo
        for (Veiculo veiculo : veiculos) {
            veiculo.imprimir();
            System.out.println("--------------------");
        }
    }
}


