/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.tabela;

import br.com.hotel.dao.ConnectionFactory;
import br.com.hotel.dao.TipoAcomodacaoDao;
import br.com.hotel.modelo.Acomodacao;
import br.com.hotel.modelo.Hospede;
import br.com.hotel.modelo.TipoAcomodacao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author daylton
 */
public class TableModelAcomodacoes extends AbstractTableModel{
    private String[] nomesColunas = {"NUMERO", "ANDAR","TIPO", "ESTÁ RESERVADA"};
    private ArrayList<Acomodacao> listaAcomodacoes;
    
    public TableModelAcomodacoes(){
        listaAcomodacoes = new ArrayList<>();
    }
    
    public void preencherLista(ArrayList<Acomodacao> listaAcomodacoes){
        this.listaAcomodacoes.addAll(listaAcomodacoes);
    }
    
    public Acomodacao retornarObjetoSelecionado(int linha){
        return listaAcomodacoes.get(linha);
    } 
    
    @Override
    public int getRowCount() {
        return listaAcomodacoes.size();
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
        Acomodacao a = listaAcomodacoes.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return a.getNumAcomodacao();
            case 1:
                return a.getAndar();
            case 2:
                TipoAcomodacaoDao tad = new TipoAcomodacaoDao(new ConnectionFactory().getConnection());
                TipoAcomodacao ta = tad.buscarTipoAcomodacao(a.getAcomodacaoId());
                return ta.getDescricao();
            case 3:
                if(a.isReservado()){
                    return "Reservado";
                }else{
                    return "Não Reservado";
                }
            default:
                throw new UnsupportedOperationException("Operation not Suport!");    
        }
    }
    
}
