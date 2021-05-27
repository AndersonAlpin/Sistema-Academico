/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import ConnectionFactory.ConnectionFactory;
import Model.Links;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anderson
 */
public class LinksDAO {
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    public LinksDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    public boolean insert(Links l){
        String sql = "INSERT INTO links (ID_Usuario, Descricao, Link, Nome) "
                + "VALUES (?, ?, ?, ?);";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, l.getID_Usuario());
            stmt.setString(2, l.getDescricao());
            stmt.setString(3, l.getLink());
            stmt.setString(4, l.getNome());
            
            stmt.execute();
            
            return true;
            
        } catch (SQLException e) {
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean update(Links l){
        String sql = "UPDATE links SET Descricao = ?, Link = ? WHERE ID_Link = ?;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, l.getDescricao());
            stmt.setString(2, l.getLink());
            stmt.setInt(3, l.getID_Link());
            
            stmt.execute();
            
            return true;
            
        } catch (Exception e) {
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean delete(Links l){
        String sql = "DELETE FROM links WHERE ID_Link = ?;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, l.getID_Link());
            
            stmt.execute();
            
            return true;
            
        } catch (Exception e) {
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean deleteUserLink(Links l){
        String sql = "DELETE FROM links WHERE ID_Usuario = ?;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, l.getID_Usuario());
            
            stmt.execute();
            
            return true;
            
        } catch (Exception e) {
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Links> getList(){
        List<Links> links = new ArrayList<>();
        String sql = "SELECT * FROM links ORDER BY ID_Link desc;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Links l = new Links();
                l.setID_Link(rs.getInt("ID_Link"));
                l.setID_Usuario(rs.getInt("ID_Usuario"));
                l.setDescricao(rs.getString("Descricao"));
                l.setLink(rs.getString("Link"));
                l.setNome(rs.getString("Nome"));
                
                links.add(l);
            }
            
        } catch (SQLException ex) {
            return null;
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return links;
    }
}
