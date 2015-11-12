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
public class Acompanhante {
    private int acompanhanteId;
    private String nome;
    private int idade;
    private int reservaId;

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return this.nome;
    }
    
    
}
