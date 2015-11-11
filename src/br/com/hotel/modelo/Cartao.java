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
public class Cartao {
    private int cartaoId;
    private String numeroCartao;
    private String bandeira;
    private int hospedeId;

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public int getHospedeId() {
        return hospedeId;
    }

    public void setHospedeId(int hospedeId) {
        this.hospedeId = hospedeId;
    }
    
    public int getCartaoId() {
        return cartaoId;
    }

    public void setCartaoId(int cartaoId) {
        this.cartaoId = cartaoId;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    @Override
    public String toString() {
        return this.numeroCartao;
    }
    
    
}
