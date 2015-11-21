/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.dao;

import br.com.hotel.modelo.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daylton e Guilherme
 */
public class CategoriaDao {
    private Connection conn;
    
    public CategoriaDao(Connection conn){
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
    
    public boolean inserirCategoria(Categoria c){
        PreparedStatement ps = null;
        String sql = "INSERT INTO categorias(nome_categoria) VALUES(?) ";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, c.getNomeCategoria());
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
    
    public boolean alterarCategoria(Categoria c){
        PreparedStatement ps = null;
        String sql = "UPDATE categorias SET nome_categoria = ? WHERE categoria_id = ? ";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, c.getNomeCategoria());
            ps.setInt(2, c.getCategoriaId());
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
    
    public Categoria buscarCategoria(int categoriaId){
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM categorias WHERE categoria_id = ? ";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, categoriaId);
            rs = ps.executeQuery();
            Categoria c = new Categoria();
            while(rs.next()){
                c.setCategoriaId(rs.getInt("categoria_id"));
                c.setNomeCategoria("nome_categoria");
            }
            return c;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally{
            liberarRecursos(conn, ps, rs);
        }
    }
    
    public ArrayList<Categoria> listarCategorias(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Categoria> categorias = null;
        String sql = "SELECT * FROM categorias ";
        
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            categorias = new ArrayList<>();
            while(rs.next()){
                Categoria c = new Categoria();
                c.setCategoriaId(rs.getInt("categoria_id"));
                c.setNomeCategoria(rs.getString("nome_categoria"));
                categorias.add(c);
            }
            return categorias;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally{
            liberarRecursos(conn, ps, rs);
        } 
    }
    
    public void excluirCategoria(int categoriaId){
        PreparedStatement ps = null;
        String sql = "DELETE FROM categorias WHERE categoria_id = ? ";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, categoriaId);
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
