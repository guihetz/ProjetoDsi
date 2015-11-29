/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.tabela;

import br.com.hotel.modelo.Hospede;
import br.com.hotel.modelo.TipoAcomodacao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author daylton
 */
public class TableModelHospedes extends AbstractTableModel{
    private String[] nomesColunas = {"NOME", "CPF","ENDEREÇO", "TELEFONE", "EMAIL", "DATA NASCIMENTO"};
    private ArrayList<Hospede> listaHospedes;
    
    public TableModelHospedes(){
        listaHospedes = new ArrayList<>();
    }
    
    public void preencherLista(ArrayList<Hospede> listaHospedes){
        this.listaHospedes.addAll(listaHospedes);
    }
    
    public Hospede retornarObjetoSelecionado(int linha){
        return listaHospedes.get(linha);
    } 
    
    @Override
    public int getRowCount() {
        return listaHospedes.size();
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
        Hospede h = listaHospedes.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return h.getNome();
            case 1:
                return h.getCpf();
            case 2:
                return h.getEndereco();
            case 3:
                return h.getTelefone();
            case 4:
                return h.getEmail();
            case 5:
                return new SimpleDateFormat("dd/MM/yyyy").format(h.getDataNascimento());
            default:
                throw new UnsupportedOperationException("Operation not Suport!");    
        }
    }
    
}
