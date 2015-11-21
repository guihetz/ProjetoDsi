/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.dao;

import br.com.hotel.modelo.Acomodacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daylton e Guilherme
 */
public class AcomodacaoDao {
    private Connection conn;
    
    public AcomodacaoDao(Connection conn){
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
    
    public void inserirAcomodacao(Acomodacao a){
        PreparedStatement ps = null;
        String sql = "INSERT INTO acomodacoes(num_acomodacao, andar, tipo_acomodacao_id, reservado) VALUES(?,?,?,?) ";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, a.getNumAcomodacao());
            ps.setInt(2, a.getAndar());
            ps.setInt(3, a.getTipoAcomodacaoId());
            ps.setBoolean(4, a.isReservado());
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
    
    public ArrayList<Acomodacao> listarAcomodacoes(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Acomodacao> acomodacoes = null;
        String sql = "SELECT * FROM acomodacoes ";
        
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            acomodacoes = new ArrayList<>();
            while(rs.next()){
                Acomodacao a = new Acomodacao();
                a.setAcomodacaoId(rs.getInt("acomodacao_id"));
                a.setAndar(rs.getInt("andar"));
                a.setNumAcomodacao(rs.getInt("num_acomodacao"));
                a.setTipoAcomodacaoId(rs.getInt("tipo_acomodacao_id"));
                a.setReservado(rs.getBoolean("reservado"));
                acomodacoes.add(a);
            }
            return acomodacoes;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally{
            liberarRecursos(conn, ps, rs);
        }
    }
    
    public Acomodacao buscarAcomodacao(int acomodacaoId){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Acomodacao a = null;
        String sql = "SELECT * FROM acomodacoes WHERE acomodacao_id = ? ";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, acomodacaoId);
            rs = ps.executeQuery();
            a  = new Acomodacao();
            while(rs.next()){
                a.setAcomodacaoId(rs.getInt("acomodacao_id"));
                a.setAndar(rs.getInt("andar"));
                a.setNumAcomodacao(rs.getInt("num_acomodacao"));
                a.setTipoAcomodacaoId(rs.getInt("tipo_acomodacao_id"));
                a.setReservado(rs.getBoolean("reservado"));
            }
            return a;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally{
            liberarRecursos(conn, ps, rs);
        }
    }
    
    public void atualizarAcomodacao(Acomodacao a){
        PreparedStatement ps = null;
        String sql = "UPDATE acomodacoes SET num_acomodacao = ?, andar = ?, tipo_acomodacao_id = ?, reservado = ? "
                   + "WHERE acomodacao_id = ? ";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, a.getNumAcomodacao());
            ps.setInt(2, a.getAndar());
            ps.setInt(3, a.getTipoAcomodacaoId());
            ps.setBoolean(4, a.isReservado());
            ps.setInt(5, a.getAcomodacaoId());
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
    
    public void excluirAcomodacao(int acomodacaoId){
        PreparedStatement ps = null;
        String sql = "DELETE FROM acomodacoes WHERE acomodacao_id = ? ";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, acomodacaoId);
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
