/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.dao;

import br.com.hotel.modelo.Reserva;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daylton e Guilherme
 */
public class ReservaDao {
    private Connection conn;
    
    public ReservaDao(Connection conn){
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
    
    public void inserirReserva(Reserva r){
        PreparedStatement ps = null;
        String sql = "INSERT INTO reservas(data_chegada, data_saida, hospede_id, acomodacao_id, valor_diaria, taxa_multa, cartao_id, desconto) "
                   + "VALUES(?,?,?,?,?,?,?,?) ";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setDate(1, new Date(r.getDataChegada().getTimeInMillis()));
            ps.setDate(2, new Date(r.getDataSaida().getTimeInMillis()));
            ps.setInt(3, r.getHospedeId());
            ps.setInt(4, r.getAcomodacaoId());
            ps.setDouble(5, r.getValorDiaria());
            ps.setDouble(6, r.getTaxaMulta());
            ps.setInt(7, r.getCartaoId());
            ps.setDouble(8, r.getDesconto());
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
    
    public ArrayList<Reserva> listarReservas(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Reserva> reservas = null;
        String sql = "SELECT * FROM reservas ";
        
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            reservas = new ArrayList<>();
            while(rs.next()){
                Reserva r = new Reserva();
                r.setReservaId(rs.getInt("reserva_id"));
                GregorianCalendar gc = new GregorianCalendar();
                gc.setTime(rs.getDate("data_chegada"));
                r.setDataChegada(gc);
                gc.setTime(rs.getDate("data_saida"));
                r.setDataSaida(gc);
                r.setHospedeId(rs.getInt("hospede_id"));
                r.setAcomodacaoId(rs.getInt("acomodacao_id"));
                r.setValorDiaria(rs.getDouble("valor_diaria"));
                r.setTaxaMulta(rs.getDouble("taxa_multa"));
                r.setCartaoId(rs.getInt("cartao_id"));
                r.setDesconto(rs.getDouble("desconto"));
                reservas.add(r);
            }
            return reservas;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally{
            liberarRecursos(conn, ps, rs);
        }
    }
    
    public ArrayList<Reserva> listarReservasEncerradas(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Reserva> reservas = null;
        String sql = "SELECT * FROM reservas_encerradas ";
        
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            reservas = new ArrayList<>();
            while(rs.next()){
                Reserva r = new Reserva();
                r.setReservaId(rs.getInt("reserva_id"));
                GregorianCalendar gc = new GregorianCalendar();
                gc.setTime(rs.getDate("data_chegada"));
                r.setDataChegada(gc);
                gc.setTime(rs.getDate("data_saida"));
                r.setDataSaida(gc);
                r.setHospedeId(rs.getInt("hospede_id"));
                r.setAcomodacaoId(rs.getInt("acomodacao_id"));
                r.setValorDiaria(rs.getDouble("valor_diaria"));
                r.setTaxaMulta(rs.getDouble("taxa_multa"));
                r.setCartaoId(rs.getInt("cartao_id"));
                r.setDesconto(rs.getDouble("desconto"));
                reservas.add(r);
            }
            return reservas;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally{
            liberarRecursos(conn, ps, rs);
        }
    }
    
    public ArrayList<Reserva> listarReservasPorHospede(int hospedeId){
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Reserva> reservas = null;
        String sql = "SELECT * FROM reservas WHERE hospede_id = ? ";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, hospedeId);
            rs = ps.executeQuery();
            reservas = new ArrayList<>();
            while(rs.next()){
                Reserva r = new Reserva();
                r.setReservaId(rs.getInt("reserva_id"));
                GregorianCalendar gc = new GregorianCalendar();
                gc.setTime(rs.getDate("data_chegada"));
                r.setDataChegada(gc);
                gc.setTime(rs.getDate("data_saida"));
                r.setDataSaida(gc);
                r.setHospedeId(rs.getInt("hospede_id"));
                r.setAcomodacaoId(rs.getInt("acomodacao_id"));
                r.setValorDiaria(rs.getDouble("valor_diaria"));
                r.setTaxaMulta(rs.getDouble("taxa_multa"));
                r.setCartaoId(rs.getInt("cartao_id"));
                r.setDesconto(rs.getDouble("desconto"));
                reservas.add(r);
            }
            return reservas;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally{
            liberarRecursos(conn, ps, rs);
        }
    }
    
    public void atualizarReserva(Reserva r){
        PreparedStatement ps = null;
        String sql = "UPDATE reservas SET data_chegada = ?, data_saida = ?, hospede_id =?, acomodacao_id = ?, valor_diaria = ?, taxa_multa = ?, cartao_id = ?, desconto = ? "
                   + "WHERE reserva_id = ? ";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setDate(1, new Date(r.getDataChegada().getTimeInMillis()));
            ps.setDate(2, new Date(r.getDataSaida().getTimeInMillis()));
            ps.setInt(3, r.getHospedeId());
            ps.setInt(4, r.getAcomodacaoId());
            ps.setDouble(5, r.getValorDiaria());
            ps.setDouble(6, r.getTaxaMulta());
            ps.setInt(7, r.getCartaoId());
            ps.setDouble(8, r.getDesconto());
            ps.setInt(9, r.getReservaId());
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
    
    public void excluirReserva(int reservaId){
        PreparedStatement ps = null;
        String sql = "DELETE FROM reservas WHERE reserva_id = ? ";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, reservaId);
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
