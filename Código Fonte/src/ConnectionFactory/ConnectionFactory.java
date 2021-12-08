/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;

/**
 *Classe responsável por abrir e fechar as conexões com o banco de dados
 * @author Anderson
 */
public class ConnectionFactory {
    
    public Connection getConnection(){
        String usuario = "root";
        String senha = "";
        String nomeBanco = "sistemaacademico";
        String endereco = "localhost";
        
                
        try {
            return DriverManager.getConnection("jdbc:mysql://"+endereco+
                    "/"+nomeBanco, usuario, senha);
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Sistema Acadêmico de Estudos");
            alert.setHeaderText("Erro na conexão.");
            alert.setContentText("O servidor está offline.");
            alert.showAndWait();
        }
        return null;
    }
    
    public static void closeConnection(Connection con){
        if(con != null){
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt){
        
        closeConnection(con);
            
        try {
            if(stmt != null){
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        
        closeConnection(con, stmt);
        
        try {
            if(rs != null){
                rs.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
