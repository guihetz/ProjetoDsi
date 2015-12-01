/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.tabela;

import br.com.hotel.dao.AcomodacaoDao;
import br.com.hotel.dao.ConnectionFactory;
import br.com.hotel.dao.HospedeDao;
import br.com.hotel.modelo.Acomodacao;
import br.com.hotel.modelo.Hospede;
import br.com.hotel.modelo.Reserva;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author daylton
 */
public class TableModelReservas extends AbstractTableModel{
    private String[] nomesColunas = {"Chegada", "Sáida", "Hospede", "Quarto", "Andar", "Diária", "Multa", "Desconto"};
    private ArrayList<Reserva> listaReservas;
    
    public TableModelReservas(){
        listaReservas = new ArrayList<>();
        
    }
    
    public void preencherLista(ArrayList<Reserva> listaReservas){
        this.listaReservas.addAll(listaReservas);
    }
    
    public Reserva retornarObjetoSelecionado(int linha){
        return listaReservas.get(linha);
    } 
    
    @Override
    public int getRowCount() {
        return listaReservas.size();
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
        Reserva r = listaReservas.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return new SimpleDateFormat("dd/MM/yyyy").format(r.getDataChegada().getTime());
            case 1:
                return new SimpleDateFormat("dd/MM/yyyy").format(r.getDataSaida().getTime());
            case 2:
                HospedeDao hd = new HospedeDao(new ConnectionFactory().getConnection());
                Hospede h = hd.buscarHospede(r.getHospedeId());
                return h.getNome();
            case 3:
                AcomodacaoDao ad = new AcomodacaoDao(new ConnectionFactory().getConnection());
                Acomodacao a = ad.buscarAcomodacao(r.getAcomodacaoId());
                return a.getNumAcomodacao();
            case 4:
                AcomodacaoDao ad2 = new AcomodacaoDao(new ConnectionFactory().getConnection());
                Acomodacao a2 = ad2.buscarAcomodacao(r.getAcomodacaoId());
                return a2.getAndar();
            case 5:
                return r.getValorDiaria();
            case 6:
                return r.getTaxaMulta();
            case 7:
                return r.getDesconto();
            default:
                throw new UnsupportedOperationException("Operation not Suport!");    
        }
    }
    
}
