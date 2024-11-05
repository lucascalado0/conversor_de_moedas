package org.example;
import java.util.Scanner;

public class CasaDeCambio {
    Scanner scanner = new Scanner(System.in);
    public void mostrarMenuBemVindo () {
        String menu = """
                Ola, bem vindo a casa de câmbio do tio patinhas!
                Para dar continuidade ao seu atendimento, informe o seu nome:""";

        System.out.println(menu);
        String nome = scanner.nextLine();

        String mensagemBemVindo = "\nBem vindo a casa de câmbio do tio patinhas " + nome + "!";
        System.out.println(mensagemBemVindo);

    }

    public void mostrarMenuMoedas(){
        String menuMoedas = """
                \nA seguir, escolha as moedas que você deseja fazer conversão:
                - USD: Dólar Americano
                - BRL: Real
                - ARS: Peso Argentino
                - EUR: Euro
                - GBP: Libra Esterlina
                - JPY: Iene Japonês
                - KRW: Won Coreano
                """;
        System.out.println(menuMoedas);
    }




}
