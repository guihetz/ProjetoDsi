/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.dao;

import br.com.hotel.modelo.TipoAcomodacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author guilherme
 */
public class TipoAcomodacaoDao {
    private Connection conn;
    
    public TipoAcomodacaoDao(Connection conn){
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
    
    public void inserirTipoAcomodacao(TipoAcomodacao ta){
        PreparedStatement ps = null;
        String sql = "insert into tipo_acomodacao(descricao, qtde_acomodacoes, valor_diaria, num_adultos, num_criancas) values(?,?,?,?,?);";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, ta.getDescricao());
            ps.setInt(2, ta.getQtdeAcomodacoes());
            ps.setDouble(3, ta.getValorDiaria());
            ps.setInt(4, ta.getNumAdultos());
            ps.setInt(5, ta.getNumCriancas());
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
    
    public ArrayList<TipoAcomodacao> listarTipoAcomodacao(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<TipoAcomodacao> tipos = null;
        String sql = "select * from tipo_acomodacao;";
        
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            tipos = new ArrayList<>();
            while(rs.next()){
                TipoAcomodacao ta = new TipoAcomodacao();
                ta.setTipoAcomodacaoId(rs.getInt("tipo_acomodacao_id"));
                ta.setDescricao(rs.getString("descricao"));
                ta.setQtdeAcomodacoes(rs.getInt("qtde_acomodacoes"));
                ta.setNumAdultos(rs.getInt("num_adultos"));
                ta.setNumCriancas(rs.getInt("num_criancas"));
                ta.setValorDiaria(rs.getDouble("valor_diaria"));
                tipos.add(ta);
            }
            return tipos;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally{
            liberarRecursos(conn, ps, rs);
        }
    }
    
    public TipoAcomodacao buscarTipoAcomodacao(int tipoAcomodacaoId){
        PreparedStatement ps = null;
        ResultSet rs = null;
        TipoAcomodacao ta = null;
        String sql = "select * from tipo_acomodacao where tipo_acomodacao_id = ?;";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, tipoAcomodacaoId);
            ta = new TipoAcomodacao();
            rs = ps.executeQuery();
            while(rs.next()){
                ta.setTipoAcomodacaoId(rs.getInt("tipo_acomodacao_id"));
                ta.setDescricao(rs.getString("descricao"));
                ta.setQtdeAcomodacoes(rs.getInt("qtde_acomodacoes"));
                ta.setNumAdultos(rs.getInt("num_adultos"));
                ta.setNumCriancas(rs.getInt("num_criancas"));
                ta.setValorDiaria(rs.getDouble("valor_diaria"));
            }
            return ta;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally{
            liberarRecursos(conn, ps, rs);
        }
    }
    
    public TipoAcomodacao buscarTipoAcomodacao(String descricao){
        PreparedStatement ps = null;
        ResultSet rs = null;
        TipoAcomodacao ta = null;
        String sql = "select * from tipo_acomodacao where descricao = ?;";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, descricao);
            ta = new TipoAcomodacao();
            rs = ps.executeQuery();
            while(rs.next()){
                ta.setTipoAcomodacaoId(rs.getInt("tipo_acomodacao_id"));
                ta.setDescricao(rs.getString("descricao"));
                ta.setQtdeAcomodacoes(rs.getInt("qtde_acomodacoes"));
                ta.setNumAdultos(rs.getInt("num_adultos"));
                ta.setNumCriancas(rs.getInt("num_criancas"));
                ta.setValorDiaria(rs.getDouble("valor_diaria"));
            }
            return ta;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally{
            liberarRecursos(conn, ps, rs);
        }
    }
    
    public void atualizarTipoAcomodacao(TipoAcomodacao ta, int id){
        PreparedStatement ps = null;
        String sql = "update tipo_acomodacao set descricao = ?, qtde_acomodacoes = ?, valor_diaria = ?, num_adultos = ?, num_criancas = ? where tipo_acomodacao_id = ?;";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, ta.getDescricao());
            ps.setInt(2, ta.getQtdeAcomodacoes());
            ps.setDouble(3, ta.getValorDiaria());
            ps.setInt(4, ta.getNumAdultos());
            ps.setInt(5, ta.getNumCriancas());
            ps.setInt(6, id);
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
    
    public void excluirTipoAcomodacao(int tipoAcomodacaoId){
        PreparedStatement ps = null;
        String sql = "delete from tipo_acomodacao where tipo_acomodacao_id = ?;";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, tipoAcomodacaoId);
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
