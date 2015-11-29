/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.tabela;

import br.com.hotel.dao.ConnectionFactory;
import br.com.hotel.dao.TipoAcomodacaoDao;
import br.com.hotel.modelo.Acomodacao;
import br.com.hotel.modelo.Acompanhante;
import br.com.hotel.modelo.Hospede;
import br.com.hotel.modelo.TipoAcomodacao;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author daylton
 */
public class TableModelAcompanhantes extends AbstractTableModel{
    private String[] nomesColunas = {"NOME", "IDADE"};
    private ArrayList<Acompanhante> listaAcompanhantes;
    
    public TableModelAcompanhantes(){
        listaAcompanhantes = new ArrayList<>();
        
    }
    
    public void preencherLista(ArrayList<Acompanhante> listaAcompanhantes){
        this.listaAcompanhantes.addAll(listaAcompanhantes);
    }
    
    public Acompanhante retornarObjetoSelecionado(int linha){
        return listaAcompanhantes.get(linha);
    } 
    
    @Override
    public int getRowCount() {
        return listaAcompanhantes.size();
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
        Acompanhante a = listaAcompanhantes.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return a.getNome();
            case 1:
                return a.getIdade();
            default:
                throw new UnsupportedOperationException("Operation not Suport!");    
        }
    }
    
}
