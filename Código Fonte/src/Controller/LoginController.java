/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ConnectionFactory.ConnectionFactory;
import DAO.LoginDAO;
import DAO.UltimoLoginDAO;
import DAO.UsuarioDAO;
import DAO.cronogramaEstudosDAO;
import Model.LoginM;
import Model.Sessao;
import Model.UltimoLogin;
import Model.UsuarioM;
import Model.cronogramaEstudos;
import Stage.Admin;
import Stage.Login;
import Stage.TextFieldFormatter;
import Stage.Usuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;

/**
 *
 * @author Anderson
 */
public class LoginController implements Initializable {
    @FXML private AnchorPane paneLogin;
    @FXML private Button buttonEntrar;
    @FXML private Hyperlink linkCadasro;
    @FXML
    private AnchorPane paneCadastro;
    @FXML
    private TextField tfTelefone;
    @FXML
    private PasswordField tfConfirmarSenha;
    @FXML
    private TextField tfSobrenome;
    @FXML
    private Button btSair;
    @FXML
    private Button btSalvar;
    @FXML
    private TextField tfNome;
    @FXML
    private PasswordField tfSenha;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfEmailLogin;
    @FXML
    private PasswordField tfSenhaLogin;
    @FXML
    private Circle circle;
    @FXML
    private CheckBox checkBoxLogin;
    @FXML
    private MenuItem btLimpar;
    
    private String criarPossiblidades;
    private Connection con;
    
    Sessao sessao;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        retornaUltimoLogin();
        autoComplete();
        testeConexao();
    }    
    
    public void teste(){
        cronogramaEstudos c = new cronogramaEstudos();
        cronogramaEstudosDAO daoC = new cronogramaEstudosDAO();
        
        c.setID_Usuario(1);
        c.setSegunda1("aa");
        c.setSegunda2(null);
        
        daoC.update(c);
    }
    
    /**
     * Método que testa se ocorreu uma conexão com o banco de dados
     * circulo ficará verde se a conexão estiver "OK"
     * circulo ficará vermelho se houver "FALHA"
     */
    public void testeConexao(){
        this.con = new ConnectionFactory().getConnection();
        if (con != null) {
            circle.setFill(Paint.valueOf("#08eb31"));
            sessao = Sessao.getInstancia();
        }else{
            circle.setFill(Paint.valueOf("#ea1809"));
        }
    }
    
    /**
     * Método que sugere emails utilizados anteriormente
     */
    public void autoComplete(){
        String conteudo = "";
        String caminho = "User Data/Histórico.temp";
        
        try {
            FileReader arq = new FileReader(caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";
            try {
                linha = lerArq.readLine();
                while (linha != null) {                    
                    conteudo += linha;
                    linha = lerArq.readLine();
                    
                    criarPossiblidades += conteudo + ",";
                    
                    String[] possibilidades = {conteudo};
                    
                    
                    
                    conteudo = "";
                    
                    TextFields.bindAutoCompletion(tfEmailLogin, possibilidades); 
                }
                arq.close();
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
        
    }
    
    public void autoCompleteSenha(){
        LoginDAO daoL = new LoginDAO();
        List<LoginM> login = daoL.getList();
        
        for(int x = 0; x < login.size(); x++){
            if(tfEmailLogin.getText().equals(login.get(x).getEmail())){
                tfSenhaLogin.setText(login.get(x).getSenha());
                x = login.size();
            }else{
                tfSenhaLogin.setText("");
            }
        }
    }
    
    /**
     * Método para abrir a tela de cadastro de usuário
     * @param event 
     */
    @FXML
    private void painelCadastro(ActionEvent event){
        tfNome.setText("");
        tfSobrenome.setText("");
        tfEmail.setText("");
        tfTelefone.setText("");
        tfSenha.setText("");
        tfConfirmarSenha.setText("");
        
        paneCadastro.setVisible(true);
    }
    
    /**
     * Método responsável por abrir a tela do Usuário(Ou Administrador)
     * @param event 
     */
    @FXML
    private void login(ActionEvent event) {
        UsuarioDAO daoU = new UsuarioDAO();
        List<UsuarioM> usuario = daoU.getList();
        
        for(int x = 0; x < usuario.size(); x++){
            sessao.setID_Usuario(usuario.get(x).getID_Usuario());
            sessao.setNome(usuario.get(x).getNome());
            sessao.setSobrenome(usuario.get(x).getSobrenome());
            sessao.setEmail(usuario.get(x).getEmail());
            sessao.setTelefone(usuario.get(x).getTelefone());
            sessao.setSenha(usuario.get(x).getSenha());
            sessao.setIsAdm(usuario.get(x).getIsAdm());
            sessao.setUsuarioAtivo(usuario.get(x).getUsuarioAtivo());
            
            LoginM l = new LoginM();
            LoginDAO daoL = new LoginDAO();
            
            if(checkBoxLogin.isSelected()){
                UltimoLogin ul = new UltimoLogin();
                UltimoLoginDAO daoUl = new UltimoLoginDAO();

                daoUl.deleteTudo(ul);
                
                l.setID_Usuario(usuario.get(x).getID_Usuario());
                l.setEmail(usuario.get(x).getEmail());
                l.setSenha(usuario.get(x).getSenha());

                daoL.insert(l);
                ultimoLogin();
            }
            
            
            if(tfEmailLogin.getText().equals(usuario.get(x).getEmail())){
                if (tfSenhaLogin.getText().equals(usuario.get(x).getSenha())) {
                    if (usuario.get(x).getUsuarioAtivo() == 1) {
                        if (usuario.get(x).getIsAdm() == 0) {
                            
                            Usuario u = new Usuario();
                            Login.getStage().hide();
                            try {
                                u.start(new Stage());
                            } catch (Exception e) {
                            }
                        } else {
                            Admin admin = new Admin();
                            Login.getStage().hide();
                            try {
                                admin.start(new Stage());
                            } catch (Exception e) {
                            }
                        }
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Sistema Acadêmico de Estudos");
                        alert.setHeaderText("Conta desabilitada.");
                        alert.setContentText("Contate o administrador do sistema.");
                        alert.show();
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Sistema Acadêmico de Estudos");
                    alert.setHeaderText("Senha inválida.");
                    alert.setContentText("Verifique se os dados foram digitados corretamente.");
                    alert.show();
                }
                x = usuario.size();
                
                txtPossibilidades();
            }else{
                
                if(x == usuario.size()-1){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Sistema Acadêmico de Estudos");
                    alert.setHeaderText("Email inválido.");
                    alert.setContentText("Verifique se os dados foram digitados corretamente.");
                    alert.show();
                }else{
                }
            }
        }
    }
    
    public void txtPossibilidades(){
        criarPossiblidades = criarPossiblidades.replaceAll("null", "");
        
        if(criarPossiblidades.toLowerCase().contains(tfEmailLogin.getText().trim().toLowerCase())){
            criarPossiblidades += "";
        }else{
            criarPossiblidades += tfEmailLogin.getText().trim();
        }
        
        String possibilidades[] = criarPossiblidades.split(",");
        
        new File("User Data").mkdir();
            try {
                FileWriter fw = new FileWriter("User Data/Histórico.temp");
                PrintWriter pw = new PrintWriter(fw);

                for(int x = 0; x < possibilidades.length; x++){
                    if(possibilidades[x] != ""){
                        pw.println(possibilidades[x]);
                    }
                }

                pw.flush();
                pw.close();
                fw.close();
            } catch (IOException ex) {
            }
    }

    @FXML
    private void sairDeCadastro(ActionEvent event) {
        paneCadastro.setVisible(false);
    }

    @FXML
    private void salvarCadastro(ActionEvent event) {
        boolean verificarEmail = true;
        
        try {
            if(tfEmail.getText().length() >= 1){
                UsuarioDAO daoU = new UsuarioDAO();
                List<UsuarioM> usuario = daoU.checkEmail(tfEmail.getText());
                
                if(usuario.get(0).getEmail().equalsIgnoreCase(tfEmail.getText())){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Sistema Acadêmico de Estudos");
                    alert.setHeaderText("Este email já existe.");
                    alert.setContentText("Por favor, tente outro email.");
                    alert.show();
                    verificarEmail = false;
                }
            }
        } catch (Exception e) {
        }
        
        String senha = tfSenha.getText().trim();
        String confirmarSenha = tfConfirmarSenha.getText().trim();
        
        UsuarioM u = new UsuarioM();
        
        if(verificarEmail == true){
            if(tfNome.getText().length() >= 1 && tfSobrenome.getText().length() >= 1
                && tfEmail.getText().length() >= 1 && tfSenha.getText().length() >= 1
                && tfConfirmarSenha.getText().length() >= 1){
                if(senha.equals(confirmarSenha)){
                u.setNome(tfNome.getText().trim());
                u.setSobrenome(tfSobrenome.getText().trim());
                u.setSenha(tfSenha.getText().trim());
                u.setEmail(tfEmail.getText().trim());
                u.setTelefone(tfTelefone.getText().trim());
                u.setIsAdm(0);

                UsuarioDAO uDAO = new UsuarioDAO();
                uDAO.insert(u);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Sistema Acadêmico de Estudos");
                alert.setHeaderText("Cadastrado com sucesso!");
                alert.showAndWait();

                paneCadastro.setVisible(false);
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Sistema Acadêmico de Estudos");
                alert.setHeaderText("Senha incorreta.");
                alert.setContentText("Verifique se você digitou a senha corretamente.");
                alert.show();
            }
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Sistema Acadêmico de Estudos");
                alert.setHeaderText("Campos obrigatórios.");
                alert.setContentText("Por favor, preencha todos os campos.");
                alert.show();
            }
        }
    }

    @FXML
    private void tfTelefoneFormat(KeyEvent event) {
        TextFieldFormatter formatar = new TextFieldFormatter();
        formatar.setMask("(##)#####-####");
        formatar.setCaracteresValidos("0123456789");
        formatar.setTf(tfTelefone);
        formatar.formatter();
    }

    @FXML
    private void autoCompletarOnMouseEnteredEmail(MouseEvent event) {
        autoCompleteSenha();
    }

    @FXML
    private void autoCompletarOnMouseEnteredSenha(MouseEvent event) {
        autoCompleteSenha();
    }
    
    /**
     * Salva o ultimo login no banco de dados
     * para que possa ser preenchido automaticamente toda vez que abrir o app
     */
    public void ultimoLogin(){
        UltimoLogin u = new UltimoLogin();
        UltimoLoginDAO daoU = new UltimoLoginDAO();
        
        u.setID_UltimoLogin(1);
        u.setEmail(tfEmailLogin.getText().trim());
        u.setSenha(tfSenhaLogin.getText().trim());
        
        daoU.insert(u);
    }
    
    public void retornaUltimoLogin(){
        UltimoLoginDAO daoU = new UltimoLoginDAO();
        List<UltimoLogin> uLogin = daoU.getList();
        
        for(int x = 0; x < uLogin.size(); x++){
            tfEmailLogin.setText(uLogin.get(x).getEmail());
            tfSenhaLogin.setText(uLogin.get(x).getSenha());
            x = uLogin.size();
        }
    }

    @FXML
    private void limparHistoricoLogin(ActionEvent event) {
        try {
            FileWriter fw = new FileWriter("User Data/Histórico.temp");
            PrintWriter pw = new PrintWriter(fw);
            
            pw.println("");
            pw.flush();
            pw.close();
        } catch (Exception e) {
        }
        
        LoginM l = new LoginM();
        UltimoLogin u = new UltimoLogin();
        LoginDAO daoL = new LoginDAO();
        UltimoLoginDAO daoU = new UltimoLoginDAO();
        
        daoL.deleteTudo(l);
        daoU.deleteTudo(u);
        
        tfEmailLogin.setText("");
        tfSenhaLogin.setText("");
        
        autoComplete();
    }

    @FXML
    private void detectarEmailExistente(MouseEvent event) {
        try {
            if(tfEmail.getText().length() >= 1){
                UsuarioDAO daoU = new UsuarioDAO();
                List<UsuarioM> usuario = daoU.checkEmail(tfEmail.getText());
                
                if(usuario.get(0).getEmail().equalsIgnoreCase(tfEmail.getText())){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Sistema Acadêmico de Estudos");
                    alert.setHeaderText("Este email já existe.");
                    alert.setContentText("Por favor, tente outro email.");
                    alert.show();
                }
            }
        } catch (Exception e) {
        }
    }
}
