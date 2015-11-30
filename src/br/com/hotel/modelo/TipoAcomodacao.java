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
public class TipoAcomodacao {
    private int tipoAcomodacaoId;
    private String descricao;
    private int qtdeAcomodacoes;
    private double valorDiaria;
    private int numAdultos;
    private int numCriancas;

    public int getTipoAcomodacaoId() {
        return tipoAcomodacaoId;
    }

    public void setTipoAcomodacaoId(int tipoAcomodacaoId) {
        this.tipoAcomodacaoId = tipoAcomodacaoId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtdeAcomodacoes() {
        return qtdeAcomodacoes;
    }

    public void setQtdeAcomodacoes(int qtdeAcomodacoes) {
        this.qtdeAcomodacoes = qtdeAcomodacoes;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public int getNumAdultos() {
        return numAdultos;
    }

    public void setNumAdultos(int numAdultos) {
        this.numAdultos = numAdultos;
    }

    public int getNumCriancas() {
        return numCriancas;
    }

    public void setNumCriancas(int numCriancas) {
        this.numCriancas = numCriancas;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}
