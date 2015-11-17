/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.dao;

import br.com.hotel.modelo.Consumo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guilherme
 */
public class ConsumoDao {
    private Connection conn;
    
    public ConsumoDao(Connection conn){
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
    
    public void inserirConsumo(Consumo c){
        PreparedStatement ps = null;
        String sql = "insert into consumos(data_consumo, num_acomodacao, item_id, qtde_consumida) values(?,?,?,?);";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setDate(1, new Date(c.getDataConsumo().getTime()));
            ps.setInt(2, c.getNumAcomodacao());
            ps.setInt(3, c.getItemId());
            ps.setInt(4, c.getQtdeConsumida());
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
    
    public ArrayList<Consumo> listarConsumos(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Consumo> consumos;
        String sql = "select * from consumos;";
        
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            consumos = new ArrayList<>();
            while(rs.next()){
                Consumo c = new Consumo();
                c.setConsumoId(rs.getInt("consumo_id"));
                c.setDataConsumo(rs.getDate("data_consumo"));
                c.setItemId(rs.getInt("item_id"));
                c.setQtdeConsumida(rs.getInt("qtde_consumida"));
                consumos.add(c);
            }
            return consumos;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally{
            liberarRecursos(conn, ps, rs);
        }
        
    }
    
    public ArrayList<Consumo> listarConsumoPorAcomodacao(int numeroAcomodacao){
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Consumo> consumos;
        String sql = "select * from consumos where num_acomodacao = ?;";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, numeroAcomodacao);
            rs = ps.executeQuery();
            consumos = new ArrayList<>();
            while(rs.next()){
                Consumo c = new Consumo();
                c.setConsumoId(rs.getInt("consumo_id"));
                c.setDataConsumo(rs.getDate("data_consumo"));
                c.setItemId(rs.getInt("item_id"));
                c.setQtdeConsumida(rs.getInt("qtde_consumida"));
                consumos.add(c);
            }
            return consumos;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally{
            liberarRecursos(conn, ps, rs);
        }
    }
    
    public Consumo buscarConsumo(int consumoId){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Consumo c = null;
        String sql = "select * from consumos where consumo_id = ?;";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, consumoId);
            rs = ps.executeQuery();
            c = new Consumo();
            while(rs.next()){
                c.setConsumoId(rs.getInt("consumo_id"));
                c.setDataConsumo(rs.getDate("data_consumo"));
                c.setItemId(rs.getInt("item_id"));
                c.setQtdeConsumida(rs.getInt("qtde_consumida"));
            }
            return c;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally{
            liberarRecursos(conn, ps, rs);
        }
    }
    
    public void atualizarConsumo(Consumo c){
        PreparedStatement ps = null;
        String sql = "update consumos set data_consumo = ?, num_acomodacao = ?, item_id = ?, qtde_consumida = ? where consumo_id = ?;";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setDate(1, new Date(c.getDataConsumo().getTime()));
            ps.setInt(2, c.getNumAcomodacao());
            ps.setInt(3, c.getItemId());
            ps.setInt(4, c.getQtdeConsumida());
            ps.setInt(5, c.getConsumoId());
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
    
    public void excluirConsumo(int consumoId){
        PreparedStatement ps = null;
        String sql = "delete from consumos where consumo_id = ?;";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, consumoId);
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
