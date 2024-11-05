package org.example;
import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        APIService apiService = new APIService();
        CasaDeCambio casaDeCambio = new CasaDeCambio();
        Conversao cambio1 = new Conversao();
        Scanner scanner = new Scanner(System.in);

        int opcao = -1;

        casaDeCambio.mostrarMenuBemVindo();

        while (opcao != 0) {
            try {
                casaDeCambio.mostrarMenuMoedas();

                cambio1.solicitarMoedaOrigem();
                String moedaOrigem = scanner.nextLine().toUpperCase();

                cambio1.solicitarMoedaDestino();
                String moedaDestino = scanner.nextLine().toUpperCase();

                System.out.println("Informe o valor a ser convertido: ");
                double valor = scanner.nextDouble();
                cambio1.setValor(valor);

                apiService.RequisicaoApi(moedaOrigem, moedaDestino, valor);

                System.out.println("Deseja realizar outra conversão? (Digite -1 para encerrar ou qualquer outro número para continuar): ");
                opcao = scanner.nextInt();


            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Erro de entrada/saída: " + e.getMessage());
            } catch (InterruptedException e) {
                System.out.println("A operação foi interrompida: " + e.getMessage());
            }
        }
        System.out.println("Programa encerrado. Obrigado por utilizar a casa de câmbio do tio Patinhas.");

    }
}