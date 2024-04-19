package br.com.alura.api;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorDeMoedas {

    private String chaveApi = "COLOQUE SUA CHAVE API AQUI!";

    // Método para realizar a conversão de moedas
    public ConversaoResultado conversao(String primeiraMoeda, String segundaMoeda, double valorMoeda) {
        try {
            // Codificar os valores de moeda para evitar espaços em branco
            String primeiraMoedaCodificada = URLEncoder.encode(primeiraMoeda, "UTF-8");
            String segundaMoedaCodificada = URLEncoder.encode(segundaMoeda, "UTF-8");

            // Construir a URL com os valores codificados
            String urlApi = "https://v6.exchangerate-api.com/v6/" + chaveApi + "/pair/" +
                    primeiraMoedaCodificada + "/" + segundaMoedaCodificada + "/" + valorMoeda;

            // Criar a requisição HTTP
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlApi))
                    .GET()
                    .build();

            // Enviar a requisição e obter a resposta
            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar o código de status da resposta
            if (response.statusCode() != 200) {
                throw new RuntimeException("Erro de acesso: " + response.statusCode());
            }

            // Converter a resposta JSON em um objeto ConversaoResultado
            Gson gson = new Gson();
            ConversaoResultado resultadoConversao = gson.fromJson(response.body(), ConversaoResultado.class);

            // Imprimir os resultados
            imprimirResultados(resultadoConversao, valorMoeda);

            return resultadoConversao;

        } catch (IOException | InterruptedException e) {
            // Lidar com exceções durante a requisição
            throw new RuntimeException("Sua solicitação não pôde ser realizada, devido a um erro/exceção.", e);
        }
    }

    // Método para imprimir os resultados da conversão
    private void imprimirResultados(ConversaoResultado resultadoConversao, double valorMoeda) {
        System.out.println("----------------------------------------------");
        System.out.printf("MOEDA DE ORIGEM: %s\n", resultadoConversao.getprimeiraMoeda());
        System.out.printf("MOEDA DESTINO: %s\n", resultadoConversao.getsegundaMoeda());
        System.out.printf("QUANTIA: %.2f\n", valorMoeda);
        System.out.printf("TAXA DE CÂMBIO: %.3f\n", resultadoConversao.getTaxaConversao());
        System.out.printf("QUANTIA CONVERTIDA: %.2f\n", resultadoConversao.getConversion_result());
        System.out.println("----------------------------------------------");
    }
}
