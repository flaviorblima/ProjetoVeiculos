/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoveiculos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author flavi
 */
public class Navio extends Veiculo {
    private String nome;
    private int numeroTripulantes;
    private String dataLancamento;

    // Construtor padrão
    public Navio() {
        super();
        this.nome = "";
        this.numeroTripulantes = 0;
        this.dataLancamento = "";
    }

    // Construtor com parâmetros
    public Navio(String nome, int capacidadeTanque, int numeroPassageiros, int numeroTripulantes, double preco, String dataLancamento) {
        super(capacidadeTanque, numeroPassageiros, preco);
        this.nome = nome;
        this.numeroTripulantes = numeroTripulantes;
        this.dataLancamento = dataLancamento;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroTripulantes() {
        return numeroTripulantes;
    }

    public void setNumeroTripulantes(int numeroTripulantes) {
        this.numeroTripulantes = numeroTripulantes;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    // Método para imprimir os dados do navio
    @Override
    public void imprimir() {
        System.out.println("Nome: " + nome);
        super.imprimir();
        System.out.println("Número de Tripulantes: " + numeroTripulantes);
        System.out.println("Data de Lançamento: " + dataLancamento);
    }

    // Método para entrada de dados
    @Override
    public void entrada() {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        try {
            System.out.print("Nome: ");
            this.nome = scanner.next();
            super.entrada();
            System.out.print("Número de Tripulantes: ");
            this.numeroTripulantes = scanner.nextInt();

            boolean dataValida = false;
            while (!dataValida) {
                System.out.print("Data de Lançamento (dd/mm/aaaa): ");
                String dataInput = scanner.next();
                try {
                    Date data = dateFormat.parse(dataInput);
                    this.dataLancamento = dateFormat.format(data);
                    dataValida = true;
                } catch (ParseException e) {
                    System.out.println("Data inválida! Por favor, insira no formato dd/mm/aaaa.");
                }
            }
        } catch (Exception e) {
            System.out.println("Entrada inválida! Por favor, tente novamente.");
            scanner.next();
        }
    }

    // Método para calcular a razão de passageiros por tripulante
    public double passageirosPorTripulantes() {
        if (numeroTripulantes == 0) {
            return 0;
        }
        return (double) numeroPassageiros / numeroTripulantes;
    }
}

