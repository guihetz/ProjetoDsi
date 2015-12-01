/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.dao;

import br.com.hotel.modelo.Saida;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;


/**
 *
 * @author guilherme
 */
public class SaidaDao {
    private Connection conn;
    
    public SaidaDao(Connection conn){
        this.conn = conn;
    }
    
    public void liberarRecursos(Connection conn, PreparedStatement ps, ResultSet rs){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        if(ps != null){
            try {
                ps.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        if( rs != null){
            try {
                rs.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    
    public void inserirSaida(Saida s){
        PreparedStatement ps = null;
        String sql = "insert into saidas(num_acomodacao, data_saida, num_diarias, valor_servicos, desconto, estadia_paga, tipo_pagamento_id, reserva_id) values(?,?,?,?,?,?,?,?);";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, s.getNumAcomodacao());
            ps.setDate(2, new Date(s.getDataSaida().getTimeInMillis()));
            ps.setInt(3, s.getNumDiarias());
            ps.setDouble(4, s.getValorServicos());
            ps.setDouble(5, s.getDesconto());
            ps.setBoolean(6, s.isEstadiaPaga());
            ps.setInt(7, s.getTipoPagamentoId());
            ps.setInt(8, s.getReservaId());
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                throw new RuntimeException(ex1);
            }
            throw new RuntimeException(ex);
        }finally{
            liberarRecursos(conn, ps, null);
        }
    }
    
    public ArrayList<Saida> listarSaidas(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Saida> saidas = null;
        String sql = "select * from saidas;";
        
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            saidas = new ArrayList<>();
            while(rs.next()){
                Saida s = new Saida();
                s.setSaidaId(rs.getInt("saida_id"));
                s.setNumAcomodacao(rs.getInt("num_acomodacao"));
                GregorianCalendar gc = new GregorianCalendar();
                gc.setTime(rs.getDate("data_saida"));
                s.setDataSaida(gc);
                s.setNumDiarias(rs.getInt("num_diarias"));
                s.setValorServicos(rs.getDouble("valor_servicos"));
                s.setDesconto(rs.getDouble("desconto"));
                s.setEstadiaPaga(rs.getBoolean("estadia_paga"));
                s.setTipoPagamentoId(rs.getInt("tipo_pagamento_id"));
                s.setReservaId(rs.getInt("reserva_id"));
                saidas.add(s);
            }
            return saidas;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally{
            liberarRecursos(conn, ps, rs);
        }
    }
    
    public ArrayList<Saida> listarSaidasPorNumeroAcomodacao(int numAcomodacao){
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Saida> saidas = null;
        String sql = "select * from saidas where num_acomodacao = ?;";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, numAcomodacao);
            rs = ps.executeQuery();
            saidas = new ArrayList<>();
            while(rs.next()){
                Saida s = new Saida();
                s.setSaidaId(rs.getInt("saida_id"));
                s.setNumAcomodacao(rs.getInt("num_acomodacao"));
                GregorianCalendar gc = new GregorianCalendar();
                gc.setTime(rs.getDate("data_saida"));
                s.setDataSaida(gc);
                s.setNumDiarias(rs.getInt("num_diarias"));
                s.setValorServicos(rs.getDouble("valor_servicos"));
                s.setDesconto(rs.getDouble("desconto"));
                s.setEstadiaPaga(rs.getBoolean("estadia_paga"));
                s.setTipoPagamentoId(rs.getInt("tipo_pagamento_id"));
                s.setReservaId(rs.getInt("reserva_id"));
                saidas.add(s);
            }
            return saidas;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally{
            liberarRecursos(conn, ps, rs);
        }
    }
    
    public ArrayList<Saida> listarSaidasPorReserva(int reservaId){
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Saida> saidas = null;
        String sql = "select * from saidas where reserva_id = ?;";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, reservaId);
            rs = ps.executeQuery();
            saidas = new ArrayList<>();
            while(rs.next()){
                Saida s = new Saida();
                s.setSaidaId(rs.getInt("saida_id"));
                s.setNumAcomodacao(rs.getInt("num_acomodacao"));
                GregorianCalendar gc = new GregorianCalendar();
                gc.setTime(rs.getDate("data_saida"));
                s.setDataSaida(gc);
                s.setNumDiarias(rs.getInt("num_diarias"));
                s.setValorServicos(rs.getDouble("valor_servicos"));
                s.setDesconto(rs.getDouble("desconto"));
                s.setEstadiaPaga(rs.getBoolean("estadia_paga"));
                s.setTipoPagamentoId(rs.getInt("tipo_pagamento_id"));
                s.setReservaId(rs.getInt("reserva_id"));
                saidas.add(s);
            }
            return saidas;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally{
            liberarRecursos(conn, ps, rs);
        }
    }
    
    public void atualizarSaida(Saida s){
        PreparedStatement ps = null;
        String sql = "update saidas set num_acomodacao = ?, data_saida = ?, num_diarias = ?, valor_servicos = ?, desconto = ?, estadia_paga = ?, tipo_pagamento_id = ?, reserva_id = ? where saida_id = ?;";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, s.getNumAcomodacao());
            ps.setDate(2, new Date(s.getDataSaida().getTimeInMillis()));
            ps.setInt(3, s.getNumDiarias());
            ps.setDouble(4, s.getDesconto());
            ps.setBoolean(5, s.isEstadiaPaga());
            ps.setInt(6, s.getTipoPagamentoId());
            ps.setInt(7, s.getReservaId());
            ps.setInt(8, s.getSaidaId());
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                throw new RuntimeException(ex1);
            }
            throw new RuntimeException(ex);
        }finally{
            liberarRecursos(conn, ps, null);
        }
    }
    
    public void excluirSaida(int saidaId){
        PreparedStatement ps = null;
        String sql = "delete from saidas where saida_id = ?;";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, saidaId);
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                throw new RuntimeException(ex1);
            }
            throw new RuntimeException(ex);
        }finally{
            liberarRecursos(conn, ps, null);
        }
    }
}
