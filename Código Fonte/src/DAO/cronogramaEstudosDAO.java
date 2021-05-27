/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConnectionFactory.ConnectionFactory;
import Model.cronogramaEstudos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anderson
 */
public class cronogramaEstudosDAO {
    private PreparedStatement stmt;
    private Connection con;
    private ResultSet rs;
    
    public cronogramaEstudosDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    public boolean insert(cronogramaEstudos c) {
        String sql = "CALL insertCronogramaEstudos (?, ?, ?, ?, ?, ?, ?, ?, ?,"
                + " ?, ?, ?, ?, ?, ?, ?, ?,"
                + " ?, ?, ?, ?, ?, ?, ?, ?,"
                + " ?, ?, ?, ?, ?, ?, ?, ?,"
                + " ?, ?, ?, ?, ?, ?, ?, ?,"
                + " ?, ?, ?, ?, ?, ?, ?, ?,"
                + " ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, c.getID_Usuario());
            stmt.setString(2, c.getSegunda1());
            stmt.setString(3, c.getSegunda2());
            stmt.setString(4, c.getSegunda3());
            stmt.setString(5, c.getSegunda4());
            stmt.setString(6, c.getSegunda5());
            stmt.setString(7, c.getSegunda6());
            stmt.setString(8, c.getSegunda7());
            stmt.setString(9, c.getSegunda8());
            
            stmt.setString(10, c.getTerca1());
            stmt.setString(11, c.getTerca2());
            stmt.setString(12, c.getTerca3());
            stmt.setString(13, c.getTerca4());
            stmt.setString(14, c.getTerca5());
            stmt.setString(15, c.getTerca6());
            stmt.setString(16, c.getTerca7());
            stmt.setString(17, c.getTerca8());
            
            stmt.setString(18, c.getQuarta1());
            stmt.setString(19, c.getQuarta2());
            stmt.setString(20, c.getQuarta3());
            stmt.setString(21, c.getQuarta4());
            stmt.setString(22, c.getQuarta5());
            stmt.setString(23, c.getQuarta6());
            stmt.setString(24, c.getQuarta7());
            stmt.setString(25, c.getQuarta8());
            
            stmt.setString(26, c.getQuinta1());
            stmt.setString(27, c.getQuinta2());
            stmt.setString(28, c.getQuinta3());
            stmt.setString(29, c.getQuinta1());
            stmt.setString(30, c.getQuinta5());
            stmt.setString(31, c.getQuinta6());
            stmt.setString(32, c.getQuinta7());
            stmt.setString(33, c.getQuinta8());
            
            stmt.setString(34, c.getSexta1());
            stmt.setString(35, c.getSexta2());
            stmt.setString(36, c.getSexta3());
            stmt.setString(37, c.getSexta4());
            stmt.setString(38, c.getSexta5());
            stmt.setString(39, c.getSexta6());
            stmt.setString(40, c.getSexta7());
            stmt.setString(41, c.getSexta8());
            
            stmt.setString(42, c.getSabado1());
            stmt.setString(43, c.getSabado2());
            stmt.setString(44, c.getSabado3());
            stmt.setString(45, c.getSabado4());
            stmt.setString(46, c.getSabado5());
            stmt.setString(47, c.getSabado6());
            stmt.setString(48, c.getSabado7());
            stmt.setString(49, c.getSabado8());
            
            stmt.setString(50, c.getDomingo1());
            stmt.setString(51, c.getDomingo2());
            stmt.setString(52, c.getDomingo3());
            stmt.setString(53, c.getDomingo4());
            stmt.setString(54, c.getDomingo5());
            stmt.setString(55, c.getDomingo6());
            stmt.setString(56, c.getDomingo7());
            stmt.setString(57, c.getDomingo8());
            
            stmt.execute();
            
            return true;
            
        } catch (Exception e) {
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
     public boolean update(cronogramaEstudos c) {
        String sql = "UPDATE Cronograma_Estudos SET segunda1 = ?, segunda2 = ?, segunda3 = ?, segunda4 = ?," +
"		 segunda5 = ?, segunda6 = ?, segunda7 = ?, segunda8 = ?"
                + " WHERE ID_Usuario = ?;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, c.getSegunda1());
            stmt.setString(2, c.getSegunda2());
            stmt.setString(3, c.getSegunda3());
            stmt.setString(4, c.getSegunda4());
            stmt.setString(5, c.getSegunda5());
            stmt.setString(6, c.getSegunda6());
            stmt.setString(7, c.getSegunda7());
            stmt.setString(8, c.getSegunda8());
            
            stmt.setInt(9, c.getID_Usuario());
            
            /**stmt.setString(17, c.getQuarta1());
            stmt.setString(18, c.getQuarta2());
            stmt.setString(19, c.getQuarta3());
            stmt.setString(20, c.getQuarta4());
            stmt.setString(21, c.getQuarta5());
            stmt.setString(22, c.getQuarta6());
            stmt.setString(23, c.getQuarta7());
            stmt.setString(24, c.getQuarta8());
            
            stmt.setString(25, c.getQuinta1());
            stmt.setString(26, c.getQuinta2());
            stmt.setString(27, c.getQuinta3());
            stmt.setString(28, c.getQuinta1());
            stmt.setString(29, c.getQuinta5());
            stmt.setString(30, c.getQuinta6());
            stmt.setString(31, c.getQuinta7());
            stmt.setString(32, c.getQuinta8());
            
            stmt.setString(33, c.getSexta1());
            stmt.setString(34, c.getSexta2());
            stmt.setString(35, c.getSexta3());
            stmt.setString(36, c.getSexta4());
            stmt.setString(37, c.getSexta5());
            stmt.setString(38, c.getSexta6());
            stmt.setString(39, c.getSexta7());
            stmt.setString(40, c.getSexta8());
            
            stmt.setString(41, c.getSabado1());
            stmt.setString(42, c.getSabado2());
            stmt.setString(43, c.getSabado3());
            stmt.setString(44, c.getSabado4());
            stmt.setString(45, c.getSabado5());
            stmt.setString(46, c.getSabado6());
            stmt.setString(47, c.getSabado7());
            stmt.setString(48, c.getSabado8());
            
            stmt.setString(49, c.getDomingo1());
            stmt.setString(50, c.getDomingo2());
            stmt.setString(51, c.getDomingo3());
            stmt.setString(52, c.getDomingo4());
            stmt.setString(53, c.getDomingo5());
            stmt.setString(54, c.getDomingo6());
            stmt.setString(55, c.getDomingo7());
            stmt.setString(56, c.getDomingo8());**/
            
            stmt.setInt(57, c.getID_Usuario());
            
            stmt.execute();
            
            return true;
            
        } catch (Exception e) {
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
     
    public List<cronogramaEstudos> getCronogramaEstudos(int ID){
        List<cronogramaEstudos> cronoEstudos = new ArrayList<>();
        String sql = "SELECT * FROM cronograma_estudos WHERE ID_Usuario = " + ID + ";";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                cronogramaEstudos c = new cronogramaEstudos();
                
                c.setSegunda1(rs.getString("Segunda1"));
                c.setSegunda2(rs.getString("Segunda2"));
                c.setSegunda3(rs.getString("Segunda3"));
                c.setSegunda4(rs.getString("Segunda4"));
                c.setSegunda5(rs.getString("Segunda5"));
                c.setSegunda6(rs.getString("Segunda6"));
                c.setSegunda7(rs.getString("Segunda7"));
                c.setSegunda8(rs.getString("Segunda8"));
                
                c.setTerca1(rs.getString("Terca1"));
                c.setTerca2(rs.getString("Terca2"));
                c.setTerca3(rs.getString("Terca3"));
                c.setTerca4(rs.getString("Terca4"));
                c.setTerca5(rs.getString("Terca5"));
                c.setTerca6(rs.getString("Terca6"));
                c.setTerca7(rs.getString("Terca7"));
                c.setTerca8(rs.getString("Terca8"));
                
                c.setQuarta1(rs.getString("Quarta1"));
                c.setQuarta2(rs.getString("Quarta2"));
                c.setQuarta3(rs.getString("Quarta3"));
                c.setQuarta4(rs.getString("Quarta4"));
                c.setQuarta5(rs.getString("Quarta5"));
                c.setQuarta6(rs.getString("Quarta6"));
                c.setQuarta7(rs.getString("Quarta7"));
                c.setQuarta8(rs.getString("Quarta8"));
                
                c.setQuinta1(rs.getString("Quinta1"));
                c.setQuinta2(rs.getString("Quinta2"));
                c.setQuinta3(rs.getString("Quinta3"));
                c.setQuinta4(rs.getString("Quinta4"));
                c.setQuinta5(rs.getString("Quinta5"));
                c.setQuinta6(rs.getString("Quinta6"));
                c.setQuinta7(rs.getString("Quinta7"));
                c.setQuinta8(rs.getString("Quinta8"));
                
                c.setSexta1(rs.getString("Sexta1"));
                c.setSexta2(rs.getString("Sexta2"));
                c.setSexta3(rs.getString("Sexta3"));
                c.setSexta4(rs.getString("Sexta4"));
                c.setSexta5(rs.getString("Sexta5"));
                c.setSexta6(rs.getString("Sexta6"));
                c.setSexta7(rs.getString("Sexta7"));
                c.setSexta8(rs.getString("Sexta8"));
                
                c.setSabado1(rs.getString("Sabado1"));
                c.setSabado2(rs.getString("Sabado2"));
                c.setSabado3(rs.getString("Sabado3"));
                c.setSabado4(rs.getString("Sabado4"));
                c.setSabado5(rs.getString("Sabado5"));
                c.setSabado6(rs.getString("Sabado6"));
                c.setSabado7(rs.getString("Sabado7"));
                c.setSabado8(rs.getString("Sabado8"));
                
                c.setDomingo1(rs.getString("Domingo1"));
                c.setDomingo2(rs.getString("Domingo2"));
                c.setDomingo3(rs.getString("Domingo3"));
                c.setDomingo4(rs.getString("Domingo4"));
                c.setDomingo5(rs.getString("Domingo5"));
                c.setDomingo6(rs.getString("Domingo6"));
                c.setDomingo7(rs.getString("Domingo7"));
                c.setDomingo8(rs.getString("Domingo8"));
                
                cronoEstudos.add(c);
            }
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return cronoEstudos;
    }
    
    public boolean delete(cronogramaEstudos c){
        String sql = "DELETE FROM cronograma_estudos WHERE ID_Usuario = ?";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, c.getID_Usuario());
            
            stmt.execute();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
