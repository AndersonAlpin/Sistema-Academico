/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConnectionFactory.ConnectionFactory;
import Model.Contador;
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
public class ContadorDAO {
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    public ContadorDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    public List<Contador> getContador(int id, int dif){
        List<Contador> contador = new ArrayList<>();
        String sql = "select count(*) as Cont from perguntas, materia "
                + "where materia.id_materia = perguntas.id_materia "
                + "and materia.id_materia = " + id + " "
                + "and perguntas.dificuldade = " + dif + ";";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Contador c = new Contador();
            
                c.setCont(rs.getInt("Cont"));

                contador.add(c);
            }
            
        } catch (SQLException ex) {
            return null;
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return contador;
    }
}
