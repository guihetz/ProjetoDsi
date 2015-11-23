/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.tabela;

import br.com.hotel.modelo.TipoAcomodacao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author daylton
 */
public class TableModelTipoAcomodacao extends AbstractTableModel{
    private String[] nomesColunas = {"DESCRIÇÃO", "QNT QUARTOS","VALOR DIARIA", "ADULTOS", "CRIANÇAS"};
    private ArrayList<TipoAcomodacao> tipoAcomodacoes;
    
    public TableModelTipoAcomodacao(){
        tipoAcomodacoes = new ArrayList<>();
    }
    
    public void preencherLista(ArrayList<TipoAcomodacao> listaTipoAcomodacoes){
        tipoAcomodacoes.addAll(listaTipoAcomodacoes);
    }
    
    public TipoAcomodacao retornarObjetoSelecionado(int linha){
        return tipoAcomodacoes.get(linha);
    } 
    
    @Override
    public int getRowCount() {
        return tipoAcomodacoes.size();
    }

    @Override
    public int getColumnCount() {
        return nomesColunas.length;
    }
    
    @Override
    public String getColumnName(int column) {
        return nomesColunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TipoAcomodacao tpa = tipoAcomodacoes.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return tpa.getDescricao();
            case 1:
                return tpa.getQtdeAcomodacoes();
            case 2:
                return tpa.getValorDiaria();
            case 3:
                return tpa.getNumAdultos();
            case 4:
                return tpa.getNumCriancas();
            default:
                throw new UnsupportedOperationException("Operation not Suport!");    
        }
    }
    
}
