/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hotel.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author guilherme
 */
public class ConnectionFactory {
    public Connection getConnection(){
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOTEL", "root", "root");
            conn.setAutoCommit(false);
            return  conn;
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
