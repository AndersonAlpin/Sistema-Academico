/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Anderson
 */
public class Usuario extends Application {
    private static Stage stage;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/ViewUsuario.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setTitle("Sistema Acadêmico de Estudos");
        stage.setResizable(true);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
        setStage(stage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
        
    public static Stage getStage() {
        return stage;
    }
    
    public static void setStage(Stage stage) {
        Usuario.stage = stage;
    }    
}
