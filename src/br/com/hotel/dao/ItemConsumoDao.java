/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.dao;

import br.com.hotel.modelo.ItemConsumo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daylton e Guilherme
 */
public class ItemConsumoDao {
    private Connection conn;
    
    public ItemConsumoDao(Connection conn){
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
    
    public boolean inserirItemConsumo(ItemConsumo ic){
        PreparedStatement ps = null;
        String sql = "INSERT INTO itens_consumo(descricao, valor, categoria_id) VALUES(?,?,?) ";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, ic.getDescricao());
            ps.setDouble(2, ic.getValor());
            ps.setInt(3, ic.getCategoriaId());
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
    
    public ArrayList<ItemConsumo> listarItensConsumo(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<ItemConsumo> itens = null;
        String sql = "SELECT * FROM itens_consumo ";
        
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            itens = new ArrayList<>();
            while(rs.next()){
                ItemConsumo ic = new ItemConsumo();
                ic.setCategoriaId(rs.getInt("categoria_id"));
                ic.setItemId(rs.getInt("item_id"));
                ic.setDescricao(rs.getString("descricao"));
                ic.setValor(rs.getDouble("valor"));
                itens.add(ic);
            }
            return itens;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally{
            liberarRecursos(conn, ps, rs);
        }
    }
    
    public String getCategoria(int categoria_id){
        PreparedStatement ps = null;
        ResultSet rs = null;
        String categoria = null;
        String sql = "SELECT nome_categoria "
                   + "FROM itens_consumo i JOIN categorias c "
                   + "ON i.categoria_id = c.categoria_id "
                   + "WHERE i.categoria_id = ? ";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, categoria_id);
            rs = ps.executeQuery();
            while(rs.next()){
                categoria = rs.getString("nome_categoria");             
            }
            return categoria;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally{
            liberarRecursos(conn, ps, rs);
        }
    }
    
    public ItemConsumo buscarItemConsumo(int itemConsumoId){
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = " SELECT * FROM itens_consumo WHERE item_id = ? ";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, itemConsumoId);
            rs = ps.executeQuery();
            ItemConsumo ic = new ItemConsumo();
            while(rs.next()){
                ic.setItemId(rs.getInt("item_id"));
                ic.setCategoriaId(rs.getInt("categoria_id"));
                ic.setDescricao(rs.getString("descricao"));
                ic.setValor(rs.getDouble("valor"));
            }
            return ic;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally{
            liberarRecursos(conn, ps, rs);
        }
    }
    
    public boolean atualizarItemConsumo(ItemConsumo ic){
        PreparedStatement ps = null;
        String sql = "UPDATE itens_consumo SET descricao = ?, valor = ?, categoria_id = ? WHERE item_id = ? ";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, ic.getDescricao());
            ps.setDouble(2, ic.getValor());
            ps.setInt(3, ic.getCategoriaId());
            ps.setInt(4, ic.getItemId());
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
    
    public void excluirItemConsumo(int itemConsumoId){
        PreparedStatement ps = null;
        String sql = "DELETE FROM itens_consumo WHERE item_id = ? ";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, itemConsumoId);
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
