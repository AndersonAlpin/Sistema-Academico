/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import ConnectionFactory.ConnectionFactory;
import Model.Agenda;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anderson
 */
public class AgendaDAO {
    private PreparedStatement stmt;
    private Connection con;
    private ResultSet rs;
    
    public AgendaDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    public boolean insert(int ID, String descricao, String data ){
       String sql = "CALL insertAgenda (" + ID + ", '" + descricao + "', '" + data + "');";
       
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.execute();
            
            return true;
            
        } catch (SQLException e) {
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean update(Agenda a){
        String sql = "UPDATE Agenda SET Descricao = ?, Data = ? WHERE ID_Agenda = ?;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, a.getDescricao());
            stmt.setString(2, a.getDate());
            stmt.setInt(3, a.getID_Agenda());
            
            stmt.execute();
            
            return true;
            
        } catch (Exception e) {
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean delete(Agenda a){
        String sql = "DELETE FROM Agenda WHERE ID_Agenda = ?;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, a.getID_Agenda());
            
            stmt.execute();
            
            return true;
            
        } catch (Exception e) {
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean deleteAll(Agenda a){
        String sql = "DELETE FROM Agenda WHERE ID_Usuario = ?;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, a.getID_Usuario());
            
            stmt.execute();
            
            return true;
            
        } catch (Exception e) {
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Agenda> getList(int id){
        List<Agenda> agenda = new ArrayList<>();
        String sql = "SELECT * FROM Agenda WHERE ID_Usuario = " + id +" ORDER BY data asc;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Agenda a = new Agenda();
                a.setID_Agenda(rs.getInt("ID_Agenda"));
                a.setID_Usuario(rs.getInt("ID_Usuario"));
                a.setDescricao(rs.getString("Descricao"));
                a.setData(rs.getDate("Data"));
                agenda.add(a);
            }
            
        } catch (SQLException ex) {
            return null;
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return agenda;
    }
}
