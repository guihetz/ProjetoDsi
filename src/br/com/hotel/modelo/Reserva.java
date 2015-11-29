/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.modelo;

import java.sql.Timestamp;
import java.util.GregorianCalendar;

/**
 *
 * @author guilherme
 */
public class Reserva {
    private int reservaId;
    private GregorianCalendar dataChegada;
    private GregorianCalendar dataSaida;
    private int hospedeId;
    private int AcomodacaoId;
    private double valorDiaria;
    private double taxaMulta;
    private int cartaoId;
    private double desconto;

    public int getReservaId() {
        return reservaId;
    }

    public void setReservaId(int reservaId) {
        this.reservaId = reservaId;
    }

    public GregorianCalendar getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(GregorianCalendar dataChegada) {
        this.dataChegada = dataChegada;
    }

    public GregorianCalendar getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(GregorianCalendar dataSaida) {
        this.dataSaida = dataSaida;
    }

    public int getHospedeId() {
        return hospedeId;
    }

    public void setHospedeId(int hospedeId) {
        this.hospedeId = hospedeId;
    }

    public int getAcomodacaoId() {
        return AcomodacaoId;
    }

    public void setAcomodacaoId(int tipoAcomodacaoId) {
        this.AcomodacaoId = tipoAcomodacaoId;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public double getTaxaMulta() {
        return taxaMulta;
    }

    public void setTaxaMulta(double taxaMulta) {
        this.taxaMulta = taxaMulta;
    }

    public int getCartaoId() {
        return cartaoId;
    }

    public void setCartaoId(int cartaoId) {
        this.cartaoId = cartaoId;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    @Override
    public String toString() {
        return String.valueOf(this.cartaoId);
    }
    
    
}
