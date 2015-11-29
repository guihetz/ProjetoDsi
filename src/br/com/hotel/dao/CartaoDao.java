/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.dao;

import br.com.hotel.modelo.Cartao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daylton e Guilherme
 */
public class CartaoDao {
    private Connection conn;
    
    public CartaoDao(Connection conn){
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
    
    public void inserirCartao(Cartao c){
        PreparedStatement ps = null;
        String sql = "INSERT INTO cartoes(numero_cartao, bandeira, hospede_id) VALUES(?,?,?) ";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, c.getNumeroCartao());
            ps.setString(2, c.getBandeira());
            ps.setInt(3, c.getHospedeId());
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
    
    public ArrayList<Cartao> listarCartoes(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Cartao> cartoes = null;
        String sql = "SELECT * FROM cartoes ";
        
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            cartoes = new ArrayList<>();
            while(rs.next()){
                Cartao c = new Cartao();
                c.setCartaoId(rs.getInt("cartao_id"));
                c.setNumeroCartao(rs.getString("numero_cartao"));
                c.setBandeira(rs.getString("bandeira"));
                c.setHospedeId(rs.getInt("hospede_id"));
                cartoes.add(c);
            }
            return cartoes;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally{
            liberarRecursos(conn, ps, rs);
        }
    }
    
    public ArrayList<Cartao> listarCartoesPorHospede(int hospedeId){
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Cartao> cartoes = null;
        String sql = "SELECT * FROM cartoes WHERE hospede_id = ? ";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, hospedeId);
            rs = ps.executeQuery();
            cartoes = new ArrayList<>();
            while(rs.next()){
                Cartao c = new Cartao();
                c.setCartaoId(rs.getInt("cartao_id"));
                c.setNumeroCartao(rs.getString("numero_cartao"));
                c.setBandeira(rs.getString("bandeira"));
                c.setHospedeId(rs.getInt("hospede_id"));
                cartoes.add(c);
            }
            return cartoes;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally{
            liberarRecursos(conn, ps, rs);
        }
    }
    
    public Cartao buscarCartoesPorNumero(String numCartao){
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM cartoes WHERE numero_cartao = ? ";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, numCartao);
            rs = ps.executeQuery();
            Cartao c = new Cartao();
            while(rs.next()){
                c.setCartaoId(rs.getInt("cartao_id"));
                c.setNumeroCartao(rs.getString("numero_cartao"));
                c.setBandeira(rs.getString("bandeira"));
                c.setHospedeId(rs.getInt("hospede_id"));
            }
            return c;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally{
            liberarRecursos(conn, ps, rs);
        }
    }
    
    public Cartao buscarCartao(int cartaoId){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Cartao c = null;
        String sql = "SELECT * FROM cartoes WHERE cartao_id = ? ";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cartaoId);
            rs = ps.executeQuery();
            c= new Cartao();
            while(rs.next()){
                c.setCartaoId(rs.getInt("cartao_id"));
                c.setNumeroCartao(rs.getString("numero_cartao"));
                c.setBandeira(rs.getString("bandeira"));
                c.setHospedeId(rs.getInt("hospede_id"));
            }
            return c;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally{
            liberarRecursos(conn, ps, rs);
        }
    }
    
    public void atualizarCartao(Cartao c){
        PreparedStatement ps = null;
        String sql = "UPDATE cartoes SET numero_cartao = ?, bandeira = ?, hospede_id = ? WHERE cartao_id = ? ";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, c.getNumeroCartao());
            ps.setString(2, c.getBandeira());
            ps.setInt(3, c.getHospedeId());
            ps.setInt(4, c.getCartaoId());
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
    
    public void excluirCartao(int cartaoId){
        PreparedStatement ps = null;
        String sql = "DELETE FROM cartoes WHERE cartao_id = ? ";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cartaoId);
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
