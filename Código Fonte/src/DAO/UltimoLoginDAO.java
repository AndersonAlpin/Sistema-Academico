/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConnectionFactory.ConnectionFactory;
import Model.UltimoLogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anderson
 */
public class UltimoLoginDAO {
    private Connection con;
    
    /**
     * Método de conexão com o banco de dados
     */
    public UltimoLoginDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    public boolean insert(UltimoLogin u){
        String sql = "INSERT INTO ultimoLogin (ID_UltimoLogin, Email, Senha) VALUES (1, ?, ?);";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, u.getEmail());
            stmt.setString(2, u.getSenha());
            
            stmt.execute();
            stmt.close();
            con.close();
            
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public List<UltimoLogin> getList(){
        List<UltimoLogin> ultimoLogin = new ArrayList<>();
        String sql = "SELECT * FROM ultimoLogin;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                UltimoLogin u = new UltimoLogin();
                u.setEmail(rs.getString("Email"));
                u.setSenha(rs.getString("Senha"));
                u.setID_UltimoLogin(rs.getInt("ID_UltimoLogin"));
                
                ultimoLogin.add(u);
            }
            
            stmt.close();
            rs.close();
            con.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();   
            return null;
        }
        return ultimoLogin;
    }
    
    public boolean deleteTudo(UltimoLogin u){
        String sql = "DELETE FROM ultimoLogin;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.execute();
            stmt.close();
            con.close();
            
            return true;
            
        } catch (SQLException ex) {
            
            return false;   
        } 
    }
}
