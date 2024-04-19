package br.com.alura.api;

// Classe para armazenar os resultados de uma conversão
public class ConversaoResultado {

    // Atributos privados para armazenar informações sobre as moedas e a taxa de conversão
    private String base_code, target_code; // Código da moeda base e da moeda alvo
    private double conversion_rate, conversion_result; // Taxa de conversão e resultado da conversão

    // Método para retornar o código da primeira moeda
    public String getprimeiraMoeda() {
        return base_code;
    }

    // Método para retornar o código da segunda moeda
    public String getsegundaMoeda() {
        return target_code;
    }

    // Método para retornar a taxa de conversão
    public double getTaxaConversao() {
        return conversion_rate;
    }

    // Método para retornar o resultado da conversão
    public double getConversion_result() {
        return conversion_result;
    }

}