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
public class Acomodacao {
    private int acomodacaoId;
    private int numAcomodacao;
    private int andar;
    private int tipoAcomodacaoId;
    private boolean reservado;

    public int getAcomodacaoId() {
        return acomodacaoId;
    }

    public void setAcomodacaoId(int acomodacaoId) {
        this.acomodacaoId = acomodacaoId;
    }

    public int getNumAcomodacao() {
        return numAcomodacao;
    }

    public void setNumAcomodacao(int numAcomodacao) {
        this.numAcomodacao = numAcomodacao;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public int getTipoAcomodacaoId() {
        return tipoAcomodacaoId;
    }

    public void setTipoAcomodacaoId(int tipoAcomodacaoId) {
        this.tipoAcomodacaoId = tipoAcomodacaoId;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    @Override
    public String toString() {
        return String.valueOf(this.numAcomodacao);
    }
    
    
}
