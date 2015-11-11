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
public class Entrada {
    private int entradaId;
    private GregorianCalendar dataChegada;
    private GregorianCalendar dataSaida;
    private int reservaId;

    public int getEntradaId() {
        return entradaId;
    }

    public void setEntradaId(int entradaId) {
        this.entradaId = entradaId;
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

    public int getReservaId() {
        return reservaId;
    }

    public void setReservaId(int reservaId) {
        this.reservaId = reservaId;
    }

    @Override
    public String toString() {
        return String.valueOf(this.entradaId);
    }
    
    
}
