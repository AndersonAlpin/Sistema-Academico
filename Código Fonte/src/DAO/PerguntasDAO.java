/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConnectionFactory.ConnectionFactory;
import Model.Perguntas;
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
public class PerguntasDAO {
    private PreparedStatement stmt;
    private Connection con;
    private ResultSet rs;
    
    public PerguntasDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    public boolean insert(Perguntas p){
        String sql = "INSERT INTO perguntas (ID_Materia, descricao, alternativaA,"
                + " alternativaB, alternativaC, alternativaD, alternativaE,"
                + " alternativaCorreta, dificuldade, valor)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, p.getID_Materia());
            stmt.setString(2, p.getDescricao());
            stmt.setString(3, p.getAlternativaA());
            stmt.setString(4, p.getAlternativaB());
            stmt.setString(5, p.getAlternativaC());
            stmt.setString(6, p.getAlternativaD());
            stmt.setString(7, p.getAlternativaE());
            stmt.setString(8, p.getAlternativaCorreta());
            stmt.setInt(9, p.getDificuldade());
            stmt.setInt(10, p.getValor());
            
            stmt.execute();
            
            return true;
            
        } catch (SQLException e) {
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean update(Perguntas p){
        String sql = "UPDATE perguntas SET Descricao = ?, alternativaA = ?,"
                + "alternativaB = ?, alternativaC = ?, alternativaD = ?,"
                + "alternativaE = ?, alternativaCorreta = ?,"
                + "Dificuldade = ?, Valor = ? WHERE ID_Perguntas = ?;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, p.getDescricao());
            stmt.setString(2, p.getAlternativaA());
            stmt.setString(3, p.getAlternativaB());
            stmt.setString(4, p.getAlternativaC());
            stmt.setString(5, p.getAlternativaD());
            stmt.setString(6, p.getAlternativaE());
            stmt.setString(7, p.getAlternativaCorreta());
            stmt.setInt(8, p.getDificuldade());
            stmt.setInt(9, p.getValor());
            stmt.setInt(10, p.getID_Pergunta());
            
            stmt.execute();
            
            return true;
            
        } catch (Exception e) {
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean delete(Perguntas p){
        String sql = "DELETE FROM perguntas WHERE ID_Perguntas = ?;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, p.getID_Pergunta());
            
            stmt.execute();
            
            return true;
            
        } catch (Exception e) {
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Perguntas> getList(int id, int limit, int dif){
        List<Perguntas> perguntas = new ArrayList<>();
        String sql = "select perguntas.*from perguntas, materia "
                + "where materia.id_materia = perguntas.id_materia "
                + "and materia.id_materia = " +id
                + " and perguntas.dificuldade = " + dif + " "
                + "order by rand() limit " + limit + ";";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Perguntas p = new Perguntas();
                p.setID_Pergunta(rs.getInt("ID_Perguntas"));
                p.setID_Materia(rs.getInt("ID_Materia"));
                p.setDificuldade(rs.getInt("Dificuldade"));
                p.setValor(rs.getInt("Valor"));
                p.setDescricao(rs.getString("Descricao"));
                p.setAlternativaA(rs.getString("alternativaA"));
                p.setAlternativaB(rs.getString("alternativaB"));
                p.setAlternativaC(rs.getString("alternativaC"));
                p.setAlternativaD(rs.getString("alternativaD"));
                p.setAlternativaE(rs.getString("alternativaE"));
                p.setAlternativaCorreta(rs.getString("alternativaCorreta"));
                
                perguntas.add(p);
            }
            
        } catch (SQLException ex) {
            return null;
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return perguntas;
    }
    
    public List<Perguntas> getListAll(){
        List<Perguntas> perguntas = new ArrayList<>();
        String sql = "select materia.nome, perguntas.* from perguntas, materia "
                + "where materia.id_materia = perguntas.id_materia "
                + "order by materia.nome asc;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Perguntas p = new Perguntas();
                p.setID_Pergunta(rs.getInt("ID_Perguntas"));
                p.setID_Materia(rs.getInt("ID_Materia"));
                p.setDificuldade(rs.getInt("Dificuldade"));
                p.setValor(rs.getInt("Valor"));
                p.setDescricao(rs.getString("Descricao"));
                p.setAlternativaA(rs.getString("alternativaA"));
                p.setAlternativaB(rs.getString("alternativaB"));
                p.setAlternativaC(rs.getString("alternativaC"));
                p.setAlternativaD(rs.getString("alternativaD"));
                p.setAlternativaE(rs.getString("alternativaE"));
                p.setAlternativaCorreta(rs.getString("alternativaCorreta"));
                p.setNome(rs.getString("Nome"));
                
                perguntas.add(p);
            }
            
        } catch (SQLException ex) {
            return null;
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return perguntas;
    }
    
    public List<Perguntas> getListFiltrado(int idMat){
        List<Perguntas> perguntas = new ArrayList<>();
        String sql = "select materia.nome, perguntas.* from perguntas, materia "
                + "where materia.id_materia = perguntas.id_materia "
                + "and perguntas.id_materia = " + idMat + ";";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Perguntas p = new Perguntas();
                p.setID_Pergunta(rs.getInt("ID_Perguntas"));
                p.setID_Materia(rs.getInt("ID_Materia"));
                p.setDificuldade(rs.getInt("Dificuldade"));
                p.setValor(rs.getInt("Valor"));
                p.setDescricao(rs.getString("Descricao"));
                p.setAlternativaA(rs.getString("alternativaA"));
                p.setAlternativaB(rs.getString("alternativaB"));
                p.setAlternativaC(rs.getString("alternativaC"));
                p.setAlternativaD(rs.getString("alternativaD"));
                p.setAlternativaE(rs.getString("alternativaE"));
                p.setAlternativaCorreta(rs.getString("alternativaCorreta"));
                p.setNome(rs.getString("Nome"));
                
                perguntas.add(p);
            }
            
        } catch (SQLException ex) {
            return null;
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return perguntas;
    }
    
    public List<Perguntas> getListBuscar(String Mat){
        List<Perguntas> perguntas = new ArrayList<>();
        String sql = "select materia.nome, perguntas.* from perguntas, materia "
                + "where materia.id_materia = perguntas.id_materia "
                + "and materia.nome like '" + Mat + "%';";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Perguntas p = new Perguntas();
                p.setID_Pergunta(rs.getInt("ID_Perguntas"));
                p.setID_Materia(rs.getInt("ID_Materia"));
                p.setDificuldade(rs.getInt("Dificuldade"));
                p.setValor(rs.getInt("Valor"));
                p.setDescricao(rs.getString("Descricao"));
                p.setAlternativaA(rs.getString("alternativaA"));
                p.setAlternativaB(rs.getString("alternativaB"));
                p.setAlternativaC(rs.getString("alternativaC"));
                p.setAlternativaD(rs.getString("alternativaD"));
                p.setAlternativaE(rs.getString("alternativaE"));
                p.setAlternativaCorreta(rs.getString("alternativaCorreta"));
                p.setNome(rs.getString("Nome"));
                
                perguntas.add(p);
            }
            
        } catch (SQLException ex) {
            return null;
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return perguntas;
    }
    
}
