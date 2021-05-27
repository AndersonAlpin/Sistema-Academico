/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConnectionFactory.ConnectionFactory;
import Model.UsuarioM;
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
public class UsuarioDAO {
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    public UsuarioDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    /**
     * Método que insere um novo usuário ao banco de dados
     * @param u(Usuario)
     * @return verdadeiro ou falso
     */
    public boolean insert(UsuarioM u){
        String sql = "INSERT INTO usuario (Nome, Sobrenome, Senha,"
                + " Email, Telefone, isAdm) VALUES (?, ?, ?, ?, ?, ?);";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getSobrenome());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getTelefone());
            stmt.setInt(6, u.getIsAdm());
            
            stmt.execute();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    /**
     * Método que atualiza valores no banco de dados
     * @param u(Usuario)
     * @return verdadeiro ou falso
     */
    public boolean update(UsuarioM u){
        String sql = "UPDATE usuario SET Nome = ?, Sobrenome = ?, Email = ?, Telefone = ?, Senha = ? WHERE ID_Usuario = ?";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getSobrenome());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getTelefone());
            stmt.setString(5, u.getSenha());
            stmt.setInt(6, u.getID_Usuario());
            
            stmt.execute();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean habilitarDesabilitar(UsuarioM u){
        String sql = "UPDATE usuario SET usuarioAtivo = ? WHERE ID_Usuario = ?";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, u.getUsuarioAtivo());
            stmt.setInt(2, u.getID_Usuario());
            
            stmt.execute();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    /**
     * Método que exclui valores do banco de dados
     * @param u(Usuario)
     * @return verdadeiro ou falso
     */
    public boolean delete(UsuarioM u){
        String sql = "DELETE FROM usuario WHERE ID_Usuario = ?;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, u.getID_Usuario());
            
            stmt.execute();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    /**
     * Método de busca de dados específicos no banco de dados
     * @return uma lista com um único dado
     */
    public boolean checkLogin(String email, String senha ){
        boolean check = false;
        
        try {
            String sql = "SELECT * FROM usuario WHERE Email = ? and Senha = ?;";
            
            stmt.setString(1, email);
            stmt.setString(2, senha);
            
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                check = true;
            }
            
        } catch (SQLException e) {
        
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return check;
    }
    
    /**
     * Método que retorna uma lista de usuários com todos os seus dados
     * @return Lista de usuários
     */
    public List<UsuarioM> getList(){
        List<UsuarioM> usuario = new ArrayList<>();
        String sql = "SELECT * FROM usuario order by nome asc;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                UsuarioM u = new UsuarioM();
                u.setEmail(rs.getString("Email"));
                u.setSenha(rs.getString("Senha"));
                u.setNome(rs.getString("Nome"));
                u.setSobrenome(rs.getString("Sobrenome"));
                u.setID_Usuario(rs.getInt("ID_Usuario"));
                u.setIsAdm(rs.getInt("isAdm"));
                u.setUsuarioAtivo(rs.getInt("usuarioAtivo"));
                u.setTelefone(rs.getString("Telefone"));
                
                usuario.add(u);
            }
            
            stmt.close();
            rs.close();
            con.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();   
            return null;
        }
        return usuario;
    }
    
    public List<UsuarioM> getAdministradoresAtivos(int isAtivo){
        List<UsuarioM> usuario = new ArrayList<>();
        String sql = "SELECT * FROM usuario WHERE isAdm = 1 "
                + "and usuarioAtivo = " + isAtivo + " order by nome asc;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                UsuarioM u = new UsuarioM();
                u.setEmail(rs.getString("Email"));
                u.setSenha(rs.getString("Senha"));
                u.setNome(rs.getString("Nome"));
                u.setSobrenome(rs.getString("Sobrenome"));
                u.setID_Usuario(rs.getInt("ID_Usuario"));
                u.setIsAdm(rs.getInt("isAdm"));
                u.setUsuarioAtivo(rs.getInt("usuarioAtivo"));
                u.setTelefone(rs.getString("Telefone"));
                
                usuario.add(u);
            }
            
            stmt.close();
            rs.close();
            con.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();   
            return null;
        }
        return usuario;
    }
    
    public List<UsuarioM> getUsuariosAtivos(int isAtivo){
        List<UsuarioM> usuario = new ArrayList<>();
        String sql = "SELECT * FROM usuario WHERE isAdm = 0 "
                + "and usuarioAtivo = " + isAtivo + " order by nome asc;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                UsuarioM u = new UsuarioM();
                u.setEmail(rs.getString("Email"));
                u.setSenha(rs.getString("Senha"));
                u.setNome(rs.getString("Nome"));
                u.setSobrenome(rs.getString("Sobrenome"));
                u.setID_Usuario(rs.getInt("ID_Usuario"));
                u.setIsAdm(rs.getInt("isAdm"));
                u.setUsuarioAtivo(rs.getInt("usuarioAtivo"));
                u.setTelefone(rs.getString("Telefone"));
                
                usuario.add(u);
            }
            
            stmt.close();
            rs.close();
            con.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();   
            return null;
        }
        return usuario;
    }
    
    public List<UsuarioM> getAdministradorEspecifico(String nome){
        List<UsuarioM> usuario = new ArrayList<>();
        String sql = "SELECT * FROM usuario WHERE isAdm = 1 "
                + "and nome like '" + nome + "%' order by nome asc;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                UsuarioM u = new UsuarioM();
                u.setEmail(rs.getString("Email"));
                u.setSenha(rs.getString("Senha"));
                u.setNome(rs.getString("Nome"));
                u.setSobrenome(rs.getString("Sobrenome"));
                u.setID_Usuario(rs.getInt("ID_Usuario"));
                u.setIsAdm(rs.getInt("isAdm"));
                u.setUsuarioAtivo(rs.getInt("usuarioAtivo"));
                u.setTelefone(rs.getString("Telefone"));
                
                usuario.add(u);
            }
            
            stmt.close();
            rs.close();
            con.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();   
            return null;
        }
        return usuario;
    }
    
    public List<UsuarioM> getUsuarioEspecifico(String nome){
        List<UsuarioM> usuario = new ArrayList<>();
        String sql = "SELECT * FROM usuario WHERE isAdm = 0 "
                + "and nome like '" + nome + "%' order by nome asc;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                UsuarioM u = new UsuarioM();
                u.setEmail(rs.getString("Email"));
                u.setSenha(rs.getString("Senha"));
                u.setNome(rs.getString("Nome"));
                u.setSobrenome(rs.getString("Sobrenome"));
                u.setID_Usuario(rs.getInt("ID_Usuario"));
                u.setIsAdm(rs.getInt("isAdm"));
                u.setUsuarioAtivo(rs.getInt("usuarioAtivo"));
                u.setTelefone(rs.getString("Telefone"));
                
                usuario.add(u);
            }
            
            stmt.close();
            rs.close();
            con.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();   
            return null;
        }
        return usuario;
    }
    
    public List<UsuarioM> checkEmail(String email){
        List<UsuarioM> usuario = new ArrayList<>();
        String sql = "SELECT * FROM usuario WHERE Email = '" + email + "' "
                + "order by nome asc;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                UsuarioM u = new UsuarioM();
                u.setEmail(rs.getString("Email"));
                u.setSenha(rs.getString("Senha"));
                u.setNome(rs.getString("Nome"));
                u.setSobrenome(rs.getString("Sobrenome"));
                u.setID_Usuario(rs.getInt("ID_Usuario"));
                u.setIsAdm(rs.getInt("isAdm"));
                u.setUsuarioAtivo(rs.getInt("usuarioAtivo"));
                u.setTelefone(rs.getString("Telefone"));
                
                usuario.add(u);
            }
            
            stmt.close();
            rs.close();
            con.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();   
            return null;
        }
        return usuario;
    }
    
    public List<UsuarioM> getListUsuarios(){
        List<UsuarioM> usuario = new ArrayList<>();
        String sql = "SELECT * FROM usuario WHERE isAdm = 0 "
                + "order by nome asc;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                UsuarioM u = new UsuarioM();
                u.setEmail(rs.getString("Email"));
                u.setSenha(rs.getString("Senha"));
                u.setNome(rs.getString("Nome"));
                u.setSobrenome(rs.getString("Sobrenome"));
                u.setID_Usuario(rs.getInt("ID_Usuario"));
                u.setIsAdm(rs.getInt("isAdm"));
                u.setUsuarioAtivo(rs.getInt("usuarioAtivo"));
                u.setTelefone(rs.getString("Telefone"));
                
                usuario.add(u);
            }
            
            stmt.close();
            rs.close();
            con.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();   
            return null;
        }
        return usuario;
    }
    
    public List<UsuarioM> getListAdministradores(){
        List<UsuarioM> usuario = new ArrayList<>();
        String sql = "SELECT * FROM usuario WHERE isAdm = 1 "
                + "order by nome asc;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                UsuarioM u = new UsuarioM();
                u.setEmail(rs.getString("Email"));
                u.setSenha(rs.getString("Senha"));
                u.setNome(rs.getString("Nome"));
                u.setSobrenome(rs.getString("Sobrenome"));
                u.setID_Usuario(rs.getInt("ID_Usuario"));
                u.setIsAdm(rs.getInt("isAdm"));
                u.setUsuarioAtivo(rs.getInt("usuarioAtivo"));
                u.setTelefone(rs.getString("Telefone"));
                
                usuario.add(u);
            }
            
            stmt.close();
            rs.close();
            con.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();   
            return null;
        }
        return usuario;
    }
}
