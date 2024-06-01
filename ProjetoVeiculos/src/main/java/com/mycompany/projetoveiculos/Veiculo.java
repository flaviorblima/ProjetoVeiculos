/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoveiculos;

/**
 *
 * @author flavi
 */
import java.util.Scanner;

public class Veiculo {
    protected int capacidadeTanque;
    protected int numeroPassageiros;
    protected double preco;

    // Construtor padrão
    public Veiculo() {
        this.capacidadeTanque = 0;
        this.numeroPassageiros = 0;
        this.preco = 0.0;
    }

    // Construtor com parâmetros
    public Veiculo(int capacidadeTanque, int numeroPassageiros, double preco) {
        this.capacidadeTanque = capacidadeTanque;
        this.numeroPassageiros = numeroPassageiros;
        this.preco = preco;
    }

    // Getters e Setters
    public int getCapacidadeTanque() {
        return capacidadeTanque;
    }

    public void setCapacidadeTanque(int capacidadeTanque) {
        this.capacidadeTanque = capacidadeTanque;
    }

    public int getNumeroPassageiros() {
        return numeroPassageiros;
    }

    public void setNumeroPassageiros(int numeroPassageiros) {
        this.numeroPassageiros = numeroPassageiros;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    // Método para reajustar o preço
    public void reajustarPreco(double percentual) {
        this.preco += this.preco * (percentual / 100);
    }

    // Método para imprimir os dados do veículo
    public void imprimir() {
        System.out.println("Capacidade do Tanque: " + capacidadeTanque);
        System.out.println("Número de Passageiros: " + numeroPassageiros);
        System.out.println("Preço: " + preco);
    }

    // Método para entrada de dados
    public void entrada() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Número de Passageiros: ");
            this.numeroPassageiros = scanner.nextInt();
            System.out.print("Preço: ");
            this.preco = scanner.nextDouble();
        } catch (Exception e) {
            System.out.println("Entrada inválida! Por favor, tente novamente.");
            scanner.next(); // Limpa o buffer do scanner
        }
    }
}

