package org.example;

import com.google.gson.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIService {

    private String apiKey = "ad3f9b60b5d90f25fe4865b0";
    private String urlBase = "https://v6.exchangerate-api.com/v6/";
    private String pairString = "/pair/";

    public void RequisicaoApi(String moedaOrigem, String moedaDestino, double valor) throws IOException, InterruptedException {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlBase + apiKey + pairString + moedaOrigem + "/" + moedaDestino + "/" + valor))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            // System.out.println(response.body());

            if (response.statusCode() == 200) {
                Gson gson = new Gson();
                Conversao conversao = gson.fromJson(response.body(), Conversao.class);
                System.out.println(conversao);
            } else {
                System.err.println("Erro na requisição: Código de resposta HTTP " + response.statusCode());
            }

        } catch (IOException e) {
            System.err.println("Erro de E/S ao enviar a requisição ou ler a resposta: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("A requisição foi interrompida: " + e.getMessage());
            Thread.currentThread().interrupt(); // Reinterrompe a thread
        } catch (JsonSyntaxException e) {
            System.err.println("Erro ao interpretar a resposta JSON: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ocorreu um erro inesperado: " + e.getMessage());
        }

    }

}
