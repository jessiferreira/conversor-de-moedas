package br.com.alura.principal;

import br.com.alura.api.ConversaoResultado;
import br.com.alura.api.ConversorDeMoedas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Inicialização do scanner para entrada do usuário
        Scanner scanner = new Scanner(System.in);
        int entrada; // Variável para armazenar a escolha do usuário (continuar ou sair)

        String primeiraMoeda; // Variável para armazenar a moeda de origem
        String segundaMoeda; // Variável para armazenar a moeda de destino
        double valor; // Variável para armazenar o valor a ser convertido

        ConversorDeMoedas conversorDeMoedas = new ConversorDeMoedas(); // Objeto para realizar as conversões
        List<ConversaoResultado> conversoesRealizadas = new ArrayList<>(); // Lista para armazenar os resultados das conversões

        // Loop para realizar as conversões até que o usuário decida sair
        do {
            // Solicitar entrada ao usuário
            System.out.print("""
                       
                    ----------------------------------------------         
                            LISTA DE MOEDAS PARA CONVERSÃO
                    ----------------------------------------------
                    BRL (Real Brasileiro)
                    USD (Dólar Americano)
                    EUR (Euro)
                    GBP (Libra Esterlina)
                    JPY (Iene Japonês)
                    CHF (Franco Suíço)
                    CNY (Yuan Chinês)
                    ----------------------------------------------
                    DIGITE A MOEDA DE ORIGEM ESCOLHIDA:                   
                    """);
            primeiraMoeda = scanner.nextLine().toUpperCase();

            System.out.print("""
                       
                    ----------------------------------------------         
                            LISTA DE MOEDAS PARA CONVERSÃO
                    ----------------------------------------------
                    BRL (Real Brasileiro)
                    USD (Dólar Americano)
                    EUR (Euro)
                    GBP (Libra Esterlina)
                    JPY (Iene Japonês)
                    CHF (Franco Suíço)
                    CNY (Yuan Chinês)
                    ----------------------------------------------
                    DIGITE A MOEDA DESTINO ESCOLHIDA: 
                    """);
            segundaMoeda = scanner.nextLine().toUpperCase();

            System.out.print("""
                                        
                    ----------------------------------------------
                    DIGITE A QUANTIA:                      
                    """);
            valor = scanner.nextDouble();

            scanner.nextLine(); // Limpar o buffer do scanner

            // Realizar a conversão e armazenar o resultado
            ConversaoResultado conversao = conversorDeMoedas.conversao(primeiraMoeda, segundaMoeda, valor);
            conversoesRealizadas.add(conversao);

            // Perguntar ao usuário se deseja fazer outra conversão
            System.out.print("GOSTARIA DE REALIZAR UMA NOVA CONVERSÃO?\nDIGITE 1 - SIM OU 0 - NÃO: ");
            entrada = scanner.nextInt();

            scanner.nextLine(); // Limpar o buffer do scanner

        } while (entrada != 0);

        scanner.close(); // Fechar o scanner após a conclusão

        System.out.println("""
                ----------------------------------------------
                APLICAÇÃO ENCERRADA COM SUCESSO. ATÉ A PRÓXIMA!
                """);
    }
}
