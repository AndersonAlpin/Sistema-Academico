/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConnectionFactory.ConnectionFactory;
import Model.Materias;
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
public class MateriasDAO {
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    public MateriasDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    public boolean insert(Materias m){
        String sql = "INSERT INTO Materia (Nome) VALUES (?);";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, m.getNome());
            
            stmt.execute();
            
            return true;
            
        } catch (SQLException e) {
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean delete(Materias m){
        String sql = "DELETE FROM materia WHERE ID_Materia = ?;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, m.getID_Materia());
            
            stmt.execute();
            
            return true;
            
        } catch (Exception e) {
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean habilitarDesabilitar(Materias m){
        String sql = "UPDATE materia SET isAtiva = ? WHERE ID_Materia = ?;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, m.getIsAtiva());
            stmt.setInt(2, m.getID_Materia());
            
            stmt.execute();
            
            return true;
            
        } catch (Exception e) {
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Materias> getList(){
        List<Materias> materias = new ArrayList<>();
        String sql = "SELECT * FROM materia ORDER BY ID_Materia desc;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Materias m = new Materias();
                m.setID_Materia(rs.getInt("ID_Materia"));
                m.setNome(rs.getString("Nome"));
                m.setIsAtiva(rs.getInt("isAtiva"));
                
                materias.add(m);
            }
            
        } catch (SQLException ex) {
            return null;
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return materias;
    }
    
    public List<Materias> getMateriaAtiva(int isAtiva){
        List<Materias> materias = new ArrayList<>();
        String sql = "SELECT * FROM materia WHERE isAtiva = " + isAtiva + " "
                + "order by nome asc;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Materias m = new Materias();
                m.setID_Materia(rs.getInt("ID_Materia"));
                m.setNome(rs.getString("Nome"));
                m.setIsAtiva(rs.getInt("isAtiva"));
                
                materias.add(m);
            }
            
        } catch (SQLException ex) {
            return null;
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return materias;
    }
    
    public List<Materias> getMateriaEspecifica(String nome){
        List<Materias> materias = new ArrayList<>();
        String sql = "SELECT * FROM materia WHERE nome like '" + nome + "%' "
                + "order by nome asc;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Materias m = new Materias();
                m.setID_Materia(rs.getInt("ID_Materia"));
                m.setNome(rs.getString("Nome"));
                m.setIsAtiva(rs.getInt("isAtiva"));
                
                materias.add(m);
            }
            
        } catch (SQLException ex) {
            return null;
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return materias;
    }
    
    public List<Materias> getMateriasSimulado(int dificuldade){
        List<Materias> materias = new ArrayList<>();
        String sql = "SELECT DISTINCT materia.* FROM materia, perguntas WHERE"
                + " materia.id_materia = perguntas.id_materia and "
                + "perguntas.dificuldade = " + dificuldade + " "
                + "and materia.isAtiva = 1;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Materias m = new Materias();
                m.setID_Materia(rs.getInt("ID_Materia"));
                m.setNome(rs.getString("Nome"));
                
                materias.add(m);
            }
            
        } catch (SQLException ex) {
            return null;
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return materias;
    }
}
