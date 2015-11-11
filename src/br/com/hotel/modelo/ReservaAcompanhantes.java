/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.modelo;

/**
 *
 * @author guilherme
 */
public class ReservaAcompanhantes {
    private int reservaAcompanhantesId;
    private int reservaId;
    private int acompanhanteId;

    public int getReservaAcompanhantesId() {
        return reservaAcompanhantesId;
    }

    public void setReservaAcompanhantesId(int reservaAcompanhantesId) {
        this.reservaAcompanhantesId = reservaAcompanhantesId;
    }

    public int getReservaId() {
        return reservaId;
    }

    public void setReservaId(int reservaId) {
        this.reservaId = reservaId;
    }

    public int getAcompanhanteId() {
        return acompanhanteId;
    }

    public void setAcompanhanteId(int acompanhanteId) {
        this.acompanhanteId = acompanhanteId;
    }

    @Override
    public String toString() {
        return String.valueOf(this.reservaId);
    }
    
    
}
