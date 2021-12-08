/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import ConnectionFactory.ConnectionFactory;
import Model.LoginM;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anderson
 */
public class LoginDAO {
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    public LoginDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    public boolean insert(LoginM l){
        String sql = "INSERT INTO login (ID_Usuario, Email, Senha) VALUES (?, ?, ?);";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, l.getID_Usuario());
            stmt.setString(2, l.getEmail());
            stmt.setString(3, l.getSenha());
            
            stmt.execute();
            
            return true;
            
        } catch (Exception e) {
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<LoginM> getList(){
        List<LoginM> login = new ArrayList<>();
        String sql = "SELECT * FROM login;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                LoginM l = new LoginM();
                l.setEmail(rs.getString("Email"));
                l.setSenha(rs.getString("Senha"));
                
                login.add(l);
            }
            
            stmt.close();
            rs.close();
            con.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();   
            return null;
        }
        return login;
    }
    
    public boolean deleteTudo(LoginM l){
        String sql = "DELETE FROM login;";
        
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
    
    public boolean deleteLoginUsuario(LoginM l){
        String sql = "DELETE FROM login WHERE ID_Usuario = ?;";
        
       
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, l.getID_Usuario());
             
            stmt.execute();
            stmt.close();
            con.close();
            
            return true;
            
        } catch (SQLException ex) {
            
            return false;   
        } 
    }
}
