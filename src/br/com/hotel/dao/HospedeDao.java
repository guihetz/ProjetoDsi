/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.dao;

import br.com.hotel.modelo.Hospede;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



/**
 *
 * @author Daylton e Guilherme
 */
public class HospedeDao {
    private Connection conn;
    
    public HospedeDao(Connection conn){
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
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    
    public boolean inserirHospede(Hospede h){
        PreparedStatement ps = null;
        String sql = "INSERT INTO hospedes(cpf, nome, endereco, telefone, email, data_nascimento) VALUES(?,?,?,?,?,?) ";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, h.getCpf());
            ps.setString(2, h.getNome());
            ps.setString(3, h.getEndereco());
            ps.setString(4, h.getTelefone());
            ps.setString(5, h.getEmail());
            ps.setDate(6, new Date(h.getDataNascimento().getTime()));
            ps.executeUpdate();
            conn.commit();
            
            return true;
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                throw new RuntimeException(ex1);
            }
            return false;
            //throw new RuntimeException(ex);
        }finally{
            liberarRecursos(conn, ps, null);
        }
    }
    
    public ArrayList<Hospede> listarHospedes(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Hospede> hospedes = null;
        String sql = "SELECT * FROM hospedes ";
        
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            hospedes = new ArrayList<>();
            while(rs.next()){
                Hospede h = new Hospede();
                h.setHospedeId(rs.getInt("hospede_id"));
                h.setCpf(rs.getString("cpf"));
                h.setNome(rs.getString("nome"));
                h.setEndereco(rs.getString("endereco"));
                h.setTelefone(rs.getString("telefone"));
                h.setEmail(rs.getString("email"));
                h.setDataNascimento(rs.getDate("data_nascimento"));
                hospedes.add(h);
            }
            return hospedes;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally{
            liberarRecursos(conn, ps, rs);
        }
    }
    
    public Hospede buscarHospede(int hospedeId){
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM hospedes WHERE hospede_id = ? ";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, hospedeId);
            rs = ps.executeQuery();
            Hospede h = new Hospede();
            while(rs.next()){
                h.setHospedeId(rs.getInt("hospede_id"));
                h.setCpf(rs.getString("cpf"));
                h.setNome(rs.getString("nome"));
                h.setEndereco(rs.getString("endereco"));
                h.setTelefone(rs.getString("telefone"));
                h.setEmail(rs.getString("email"));
                h.setDataNascimento(rs.getDate("data_nascimento"));
            }
            return h;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally{
            liberarRecursos(conn, ps, rs);
        }
    }
    
    public void excluirHospede(int hospedeId){
        PreparedStatement ps = null;
        String sql = "DELETE FROM hospedes WHERE hospede_id = ? ";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, hospedeId);
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
    
    public boolean atualizarHospede(Hospede h){
        PreparedStatement ps = null;
        String sql = "UPDATE hospedes SET cpf = ?, nome = ?, endereco = ?, telefone = ?, email = ?, data_nascimento = ? "
                   + "WHERE hospede_id = ? ";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, h.getCpf());
            ps.setString(2, h.getNome());
            ps.setString(3, h.getEndereco());
            ps.setString(4, h.getTelefone());
            ps.setString(5, h.getEmail());
            ps.setDate(6, new Date(h.getDataNascimento().getTime()));
            ps.setInt(7, h.getHospedeId());
            ps.executeUpdate();
            conn.commit();
            
            return true;
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                throw new RuntimeException(ex1);
            }
            return false;
            //throw new RuntimeException(ex);
        }finally{
            liberarRecursos(conn, ps, null);
        }
        
    }
}
