/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConnectionFactory.ConnectionFactory;
import Model.Ranking;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anderson
 */
public class RankingDAO {
    private PreparedStatement stmt;
    private Connection con;
    private ResultSet rs;
    
    public RankingDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    public boolean insert(Ranking r){
        String sql = "INSERT INTO Ranking (ID_Usuario, scoreDia, scoreTotal,"
                + " erros, acertos, ignorados, data, totalSimulados)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, r.getID_Usuario());
            stmt.setInt(2, r.getScoreDia());
            stmt.setInt(3, r.getScoreTotal());
            stmt.setInt(4, r.getErros());
            stmt.setInt(5, r.getAcertos());
            stmt.setInt(6, r.getIgnorados());
            stmt.setString(7, r.getData());
            stmt.setInt(8, r.getTotalSimulados());
            
            stmt.execute();
            
            return true;
            
        } catch (SQLException e) {
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean update(Ranking r){
        String sql = "UPDATE ranking SET scoreDia = ?, scoreTotal = ?,"
                + "erros = ?, acertos = ?, ignorados = ?, data = ?,"
                + "totalSimulados = ? WHERE ID_Usuario = ?;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, r.getScoreDia());
            stmt.setInt(2, r.getScoreTotal());
            stmt.setInt(3, r.getErros());
            stmt.setInt(4, r.getAcertos());
            stmt.setInt(5, r.getIgnorados());
            stmt.setString(6, r.getData());
            stmt.setInt(7, r.getTotalSimulados());
            stmt.setInt(8, r.getID_Usuario());
            
            stmt.execute();
            
            return true;
            
        } catch (Exception e) {
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean delete(Ranking r){
        String sql = "DELETE FROM ranking WHERE ID_Usuario = ?;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, r.getID_Usuario());
            
            stmt.execute();
            
            return true;
            
        } catch (SQLException ex) {
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean updateData(Ranking r){
        java.util.Date data = new java.util.Date();
        SimpleDateFormat formatarData = new SimpleDateFormat("yyyy-MM-dd");
        String dataFormatada = formatarData.format(data);
        
        String sql = "UPDATE Ranking SET scoreDia = 0 "
                + "WHERE data < '" + dataFormatada + "';";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.execute();
            
            return true;
            
        } catch (Exception e) {
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Ranking> getListForUser(){
        List<Ranking> ranking = new ArrayList<>();
        String sql = "select usuario.nome, usuario.sobrenome, ranking.* "
                + "from ranking, usuario where ranking.id_usuario = usuario.id_usuario "
                + "and usuario.usuarioAtivo = 1 "
                + "and ranking.totalsimulados != 0 ORDER BY scoreTotal desc;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Ranking r = new Ranking();
                r.setID_Ranking(rs.getInt("ID_Ranking"));
                r.setID_Usuario(rs.getInt("ID_Usuario"));
                r.setScoreDia(rs.getInt("scoreDia"));
                r.setScoreTotal(rs.getInt("scoreTotal"));
                r.setErros(rs.getInt("erros"));
                r.setAcertos(rs.getInt("acertos"));
                r.setIgnorados(rs.getInt("ignorados"));
                r.setTotalSimulados(rs.getInt("totalSimulados"));
                r.setData(rs.getString("data"));
                r.setPosicao(rs.getRow());
                r.setNome(rs.getString("Nome"));
                r.setSobrenome(rs.getString("Sobrenome"));
                
                ranking.add(r);
            }
            
        } catch (SQLException ex) {
            return null;
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return ranking;
    }
    
    public List<Ranking> getListForAdm(){
        List<Ranking> ranking = new ArrayList<>();
        String sql = "select usuario.nome, usuario.sobrenome, ranking.* "
                + "from ranking, usuario where ranking.id_usuario = usuario.id_usuario "
                + "and ranking.totalsimulados != 0 ORDER BY scoreTotal desc;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Ranking r = new Ranking();
                r.setID_Ranking(rs.getInt("ID_Ranking"));
                r.setID_Usuario(rs.getInt("ID_Usuario"));
                r.setScoreDia(rs.getInt("scoreDia"));
                r.setScoreTotal(rs.getInt("scoreTotal"));
                r.setErros(rs.getInt("erros"));
                r.setAcertos(rs.getInt("acertos"));
                r.setIgnorados(rs.getInt("ignorados"));
                r.setTotalSimulados(rs.getInt("totalSimulados"));
                r.setData(rs.getString("data"));
                r.setPosicao(rs.getRow());
                r.setNome(rs.getString("Nome"));
                r.setSobrenome(rs.getString("Sobrenome"));
                
                ranking.add(r);
            }
            
        } catch (SQLException ex) {
            return null;
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return ranking;
    }
    
    public List<Ranking> getUsuario(int id){
        List<Ranking> ranking = new ArrayList<>();
        String sql = "SELECT * FROM ranking WHERE ID_Usuario = " +id+ ";";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Ranking r = new Ranking();
                r.setID_Ranking(rs.getInt("ID_Ranking"));
                r.setID_Usuario(rs.getInt("ID_Usuario"));
                r.setScoreDia(rs.getInt("scoreDia"));
                r.setScoreTotal(rs.getInt("scoreTotal"));
                r.setErros(rs.getInt("erros"));
                r.setAcertos(rs.getInt("acertos"));
                r.setIgnorados(rs.getInt("ignorados"));
                r.setTotalSimulados(rs.getInt("totalSimulados"));
                r.setData(rs.getString("data"));
                
                ranking.add(r);
            }
            
        } catch (SQLException ex) {
            return null;
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return ranking;
    }
}
