/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.dao;

import br.com.hotel.modelo.Entrada;
import br.com.hotel.modelo.Reserva;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guilherme
 */
public class EntradaDao {
    private Connection conn;
    
    public EntradaDao(Connection conn){
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
    
    public void inserirEntrada(Entrada e){
        PreparedStatement ps = null;
        String sql = "insert into entradas(data_chegada, data_saida, reserva_id) values(?,?,?);";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setDate(1, new Date(e.getDataChegada().getTimeInMillis()));
            ps.setDate(2, new Date(e.getDataSaida().getTimeInMillis()));
            ps.setInt(3, e.getReservaId());
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
    
    private ArrayList<Entrada> listarEntradas(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Entrada> entradas;
        String sql = "select * from entradas;";
        
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            entradas = new ArrayList<>();
            while(rs.next()){
                Entrada e = new Entrada();
                e.setEntradaId(rs.getInt("entrada_id"));
                GregorianCalendar gc = new GregorianCalendar();
                gc.setTime(rs.getDate("data_chegada"));
                e.setDataChegada(gc);
                gc.setTime(rs.getDate("data_saida"));
                e.setDataSaida(gc);
                e.setReservaId(rs.getInt("entrada_id"));
                entradas.add(e);
            }
            return entradas;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally{
            liberarRecursos(conn, ps, rs);
        }
    }
    
    public Entrada buscarEntradaPorReservaId(Reserva r){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Entrada e = null;
        String sql = "select * from entradas where reserva_id = ?;";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, r.getReservaId());
            rs = ps.executeQuery();
            e = new Entrada();
            while(rs.next()){
                e.setEntradaId(rs.getInt("entrada_id"));
                GregorianCalendar gc = new GregorianCalendar();
                gc.setTime(rs.getDate("data_chegada"));
                e.setDataChegada(gc);
                gc.setTime(rs.getDate("data_saida"));
                e.setDataSaida(gc);
                e.setReservaId(rs.getInt("entrada_id"));
            }
            return e;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally{
            liberarRecursos(conn, ps, rs);
        }
    }
}
