/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoveiculos;

/**
 *
 * @author flavi
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Aviao extends Veiculo {
    private String prefixo;
    private String dataRevisao; // Armazenada como String no formato dd/MM/yyyy

    // Construtor padrão
    public Aviao() {
        super();
        this.prefixo = "";
        this.dataRevisao = "";
    }

    // Construtor com parâmetros
    public Aviao(String prefixo, int capacidadeTanque, int numeroPassageiros, double preco, String dataRevisao) {
        super(capacidadeTanque, numeroPassageiros, preco);
        this.prefixo = prefixo;
        this.dataRevisao = dataRevisao;
    }

    // Getters e Setters
    public String getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(String prefixo) {
        this.prefixo = prefixo;
    }

    public String getDataRevisao() {
        return dataRevisao;
    }

    public void setDataRevisao(String dataRevisao) {
        this.dataRevisao = dataRevisao;
    }

    // Método para imprimir os dados do avião
    @Override
    public void imprimir() {
        System.out.println("Prefixo: " + prefixo);
        super.imprimir();
        System.out.println("Data de Revisão: " + dataRevisao);
    }

    // Método para entrada de dados
    @Override
    public void entrada() {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        try {
            System.out.print("Prefixo: ");
            this.prefixo = scanner.next();

            // Loop até que a entrada para capacidade do tanque seja válida
            boolean capacidadeValida = false;
            while (!capacidadeValida) {
                System.out.print("Capacidade do Tanque: ");
                if (scanner.hasNextInt()) {
                    this.capacidadeTanque = scanner.nextInt();
                    capacidadeValida = true; // Sai do loop se a entrada for um número
                } else {
                    System.out.println("Entrada inválida! Por favor, insira um valor numérico.");
                    scanner.nextLine(); // Limpa o buffer do scanner
                }
            }

            super.entrada();

            // Validação da data
            boolean dataValida = false;
            while (!dataValida) {
                System.out.print("Data de Revisão (dd/mm/aaaa): ");
                String dataInput = scanner.next();
                try {
                    Date data = dateFormat.parse(dataInput);
                    this.dataRevisao = dateFormat.format(data); // Formata a data como dd/MM/yyyy
                    dataValida = true;
                } catch (ParseException e) {
                    System.out.println("Data inválida! Por favor, insira no formato dd/mm/aaaa.");
                }
            }
        } catch (Exception e) {
            System.out.println("Entrada inválida! Por favor, tente novamente.");
            scanner.next(); // Limpa o buffer do scanner
        } finally {
            scanner.nextLine(); // Limpa o buffer do scanner antes de finalizar
        }
    }
}
