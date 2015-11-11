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
public class TipoPagamento {
    private int tipoPagamentoId;
    private String tipo;

    public int getTipoPagamentoId() {
        return tipoPagamentoId;
    }

    public void setTipoPagamentoId(int tipoPagamentoId) {
        this.tipoPagamentoId = tipoPagamentoId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return this.tipo;
    }
    
    
}
