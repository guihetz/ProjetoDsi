/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.dao;

import br.com.hotel.modelo.Acompanhante;
import java.sql.Connection;
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
public class AcompanhanteDao {
    private Connection conn;
    
    public AcompanhanteDao(Connection conn){
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
    
    public void inserirAcompanhante(Acompanhante a){
        PreparedStatement ps = null;
        String sql = "insert into acompanhantes(nome, idade, reserva_id) values(?,?,?);";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, a.getNome());
            ps.setInt(2, a.getIdade());
            ps.setInt(3, a.getReservaId());
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
    
    public ArrayList<Acompanhante> listarAcompanhantes(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Acompanhante> acompanhantes = null;
        String sql = "select * from acompanhantes;";
        
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            acompanhantes = new ArrayList<>();
            while(rs.next()){
                Acompanhante a = new Acompanhante();
                a.setAcompanhanteId(rs.getInt("acompanhante_id"));
                a.setNome(rs.getString("nome"));
                a.setIdade(rs.getInt("idade"));
                a.setReservaId(rs.getInt("reserva_id"));
                acompanhantes.add(a);
            }
            return acompanhantes;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally{
            liberarRecursos(conn, ps, rs);
        }
    }
    
    public Acompanhante buscarAcompanhante(int acompanhanteId){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Acompanhante a = null;
        String sql = "select * from acompanhantes where acompanhante_id = ?;";
        
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            a = new Acompanhante();
            while(rs.next()){
                a.setAcompanhanteId(rs.getInt("acompanhante_id"));
                a.setNome(rs.getString("nome"));
                a.setIdade(rs.getInt("idade"));
                a.setReservaId(rs.getInt("reserva_id"));
            }
            return a;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally{
            liberarRecursos(conn, ps, rs);
        }
        
    }
    
    public void atualizarAcompanhante(Acompanhante a){
        PreparedStatement ps = null;
        String sql = "update acompanhantes set nome = ?, idade = ?, reserva_id = ? where acompanhante_id = ?;";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, a.getNome());
            ps.setInt(2, a.getIdade());
            ps.setInt(3, a.getReservaId());
            ps.setInt(4, a.getAcompanhanteId());
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
    
    public void excluirAcompanhante(int acompanhanteId){
        PreparedStatement ps = null;
        String sql = "delete from acompanhantes where acompanhante_id = ?;";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, acompanhanteId);
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
    
    public ArrayList<Acompanhante> listarAcompanhantesPorReserva(int reservaId){
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Acompanhante> acompanhantes = null;
        String sql = "select * from acompanhantes where reserva_id = ?;";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, reservaId);
            rs = ps.executeQuery();
            acompanhantes = new ArrayList<>();
            while(rs.next()){
                Acompanhante a = new Acompanhante();
                a.setAcompanhanteId(rs.getInt("acompanhante_id"));
                a.setNome(rs.getString("nome"));
                a.setIdade(rs.getInt("idade"));
                a.setReservaId(rs.getInt("reserva_id"));
                acompanhantes.add(a);
            }
            return acompanhantes;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally{
            liberarRecursos(conn, ps, rs);
        }
        
       
    }
}
