package org.example;

import com.google.gson.annotations.SerializedName;
import java.text.DecimalFormat;

public class Conversao implements Comparable <Conversao>{
    @SerializedName("base_code")
    private String moedaOrigem;
    @SerializedName("target_code")
    private String moedaDestino;
    @SerializedName("time_last_update_utc")
    private String ultimaAtualizacao;
    @SerializedName("time_next_update_utc")
    private String proximaAtualizacao;
    @SerializedName("conversion_rate")
    private double taxaDeConversao;
    @SerializedName("conversion_result")
    private double valor;


    public String getMoedaOrigem() {
        return moedaOrigem;
    }

    public String getMoedaDestino() {
        return moedaDestino;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void solicitarMoedaOrigem(){
        System.out.println("Informe a moeda de origem: ");

    }
    public void solicitarMoedaDestino(){
        System.out.println("Informe a moeda de destino: ");
    }

    @Override
    public int compareTo(Conversao conversao) {
        return this.getMoedaOrigem().compareTo(conversao.getMoedaDestino());
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");

        return "\nConversão - " +
                "\nMoeda de Origem: " + moedaOrigem +
                "\nMoeda de Destino: " + moedaDestino +
                "\nÚltima Atualização: " + ultimaAtualizacao+
                "\nPróxima Atualização: " + proximaAtualizacao +
                "\nTaxa de Conversão: " + df.format(taxaDeConversao) +
                "\nResultado da Conversão: " + df.format(valor);
    }

    public double converterMoeda(){
        return getValor();
    }
}
