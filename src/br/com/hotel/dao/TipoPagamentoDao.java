/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.dao;

import br.com.hotel.modelo.TipoPagamento;
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
public class TipoPagamentoDao {
    private Connection conn;
    
    public TipoPagamentoDao(Connection conn){
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
    
    public void inserirTipoPagamneto(TipoPagamento tp){
        PreparedStatement ps = null;
        String sql = "insert into tipos_pagamento(tipo) values(?);";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, tp.getTipo());
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
    
    public ArrayList<TipoPagamento> listarTiposPagamento(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<TipoPagamento> tiposPagamento;
        String sql = "select * from tipos_pagamento;";
        
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            tiposPagamento = new ArrayList<>();
            while(rs.next()){
                TipoPagamento tp = new TipoPagamento();
                tp.setTipoPagamentoId(rs.getInt("tipo_pagamento_id"));
                tp.setTipo(rs.getString("tipo"));
                tiposPagamento.add(tp);
            }
            return tiposPagamento;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally{
            liberarRecursos(conn, ps, rs);
        }
    }
    
    public TipoPagamento buscarTipoPagamento(int tipoPagamentoId){
        PreparedStatement ps = null;
        ResultSet rs = null;
        TipoPagamento tp = null;
        String sql = "select * from tipos_pagamento where tipo_pagamento_id = ?;";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, tipoPagamentoId);
            rs = ps.executeQuery();
            tp = new TipoPagamento();
            while(rs.next()){
                tp.setTipoPagamentoId(rs.getInt("tipo_pagamento_id"));
                tp.setTipo(rs.getString("tipo"));
            }
            return tp;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally{
            liberarRecursos(conn, ps, rs);
        }
    }
    
    public TipoPagamento buscarTipoPagamentoPorNome(String tipo){
        PreparedStatement ps = null;
        ResultSet rs = null;
        TipoPagamento tp = null;
        String sql = "select * from tipos_pagamento where tipo = ?;";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, tipo);
            rs = ps.executeQuery();
            tp = new TipoPagamento();
            while(rs.next()){
                tp.setTipoPagamentoId(rs.getInt("tipo_pagamento_id"));
                tp.setTipo(rs.getString("tipo"));
            }
            return tp;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }finally{
            liberarRecursos(conn, ps, rs);
        }
    }
    
    public void atualizarTipoPagamento(TipoPagamento tp){
        PreparedStatement ps = null;
        String sql = "update tipos_pagamento set tipo = ? where tipo_pagamento_id = ?;";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, tp.getTipo());
            ps.setInt(2, tp.getTipoPagamentoId());
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
    
    public void excluirTipoPagamento(int tipoPagamentoId){
        PreparedStatement ps = null;
        String sql = "delete from tipos_pagamento where tipo_pagamento_id = ?";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, tipoPagamentoId);
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
