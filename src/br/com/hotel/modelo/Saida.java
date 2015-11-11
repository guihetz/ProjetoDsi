/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.modelo;

import java.util.GregorianCalendar;

/**
 *
 * @author guilherme
 */
public class Saida {
    private int saidaId;
    private int numAcomodacao;
    private GregorianCalendar dataSaida;
    private int numDiarias;
    private double valorServicos;
    private double desconto;
    private boolean estadiaPaga;
    private int tipoPagamentoId;

    public int getSaidaId() {
        return saidaId;
    }

    public void setSaidaId(int saidaId) {
        this.saidaId = saidaId;
    }

    public int getNumAcomodacao() {
        return numAcomodacao;
    }

    public void setNumAcomodacao(int numAcomodacao) {
        this.numAcomodacao = numAcomodacao;
    }

    public GregorianCalendar getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(GregorianCalendar dataSaida) {
        this.dataSaida = dataSaida;
    }

    public int getNumDiarias() {
        return numDiarias;
    }

    public void setNumDiarias(int numDiarias) {
        this.numDiarias = numDiarias;
    }

    public double getValorServicos() {
        return valorServicos;
    }

    public void setValorServicos(double valorServicos) {
        this.valorServicos = valorServicos;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public boolean isEstadiaPaga() {
        return estadiaPaga;
    }

    public void setEstadiaPaga(boolean estadiaPaga) {
        this.estadiaPaga = estadiaPaga;
    }

    public int getTipoPagamentoId() {
        return tipoPagamentoId;
    }

    public void setTipoPagamentoId(int tipoPagamentoId) {
        this.tipoPagamentoId = tipoPagamentoId;
    }

    @Override
    public String toString() {
        return String.valueOf(this.saidaId);
    }
    
    
}
