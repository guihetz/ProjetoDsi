/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.modelo;

import java.util.Date;

/**
 *
 * @author guilherme
 */
public class Consumo {
    private int consumoId;
    private Date dataConsumo;
    private int numAcomodacao;
    private int itemId;
    private int qtdeConsumida;

    public int getConsumoId() {
        return consumoId;
    }

    public void setConsumoId(int consumoId) {
        this.consumoId = consumoId;
    }

    public Date getDataConsumo() {
        return dataConsumo;
    }

    public void setDataConsumo(Date dataConsumo) {
        this.dataConsumo = dataConsumo;
    }

    public int getNumAcomodacao() {
        return numAcomodacao;
    }

    public void setNumAcomodacao(int numAcomodacao) {
        this.numAcomodacao = numAcomodacao;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQtdeConsumida() {
        return qtdeConsumida;
    }

    public void setQtdeConsumida(int qtdeConsumida) {
        this.qtdeConsumida = qtdeConsumida;
    }

    @Override
    public String toString() {
        return String.valueOf(this.itemId);
    }
    
    
}
