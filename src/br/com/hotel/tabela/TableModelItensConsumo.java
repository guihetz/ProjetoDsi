/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.tabela;

import br.com.hotel.dao.ConnectionFactory;
import br.com.hotel.dao.ItemConsumoDao;
import br.com.hotel.modelo.ItemConsumo;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author daylton
 */
public class TableModelItensConsumo extends AbstractTableModel{
    private String[] nomesColunas = {"Descrição", "Categoria","Valor"};
    private ArrayList<ItemConsumo> itensConsumo;
    
    public TableModelItensConsumo(){
        itensConsumo = new ArrayList<>();
    }
    
    public void preencherLista(ArrayList<ItemConsumo> listaItensConsumo){
        itensConsumo.addAll(listaItensConsumo);
    }
    
    public ItemConsumo retornarObjetoSelecionado(int linha){
        return itensConsumo.get(linha);
    } 
    
    @Override
    public int getRowCount() {
        return itensConsumo.size();
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
        ItemConsumoDao dao = new ItemConsumoDao(new ConnectionFactory().getConnection());
        ItemConsumo ic = itensConsumo.get(rowIndex);        
        
        switch(columnIndex){
            case 0:
                return ic.getDescricao();
            case 1:
                return dao.getCategoria(ic.getCategoriaId());
            case 2:
                return ic.getValor();
            default:
                throw new UnsupportedOperationException("Operation not Suport!");    
        }
    }
    
}
