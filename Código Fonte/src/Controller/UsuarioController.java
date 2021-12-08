/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AgendaDAO;
import DAO.ContadorDAO;
import javafx.scene.control.Menu;
import javafx.scene.control.TableColumn;
import DAO.LinksDAO;
import DAO.LoginDAO;
import DAO.MateriasDAO;
import DAO.PerguntasDAO;
import DAO.RankingDAO;
import javafx.scene.input.KeyEvent;
import DAO.UsuarioDAO;
import DAO.cronogramaEstudosDAO;
import Model.Agenda;
import Model.Contador;
import Model.Links;
import Model.LoginM;
import Model.Materias;
import Model.Perguntas;
import Model.Ranking;
import Model.Sessao;
import Model.UsuarioM;
import Model.cronogramaEstudos;
import Stage.Login;
import Stage.TextFieldFormatter;
import Stage.Usuario;
import java.awt.Toolkit;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Anderson
 */
public class UsuarioController implements Initializable {

    @FXML private BorderPane paneUsuario;
    @FXML private AnchorPane anchorEdicaoSimulado;
    @FXML private Label lbPainelNavegacao;
    @FXML private Slider snPerguntas;
    @FXML private Label lbnPerguntas;
    @FXML private Slider sDificuldade;
    @FXML private Label lbDificuldade;
    @FXML private AnchorPane paneSimulado;
    @FXML private AnchorPane paneCronogramaAcademico;
    @FXML private StackPane stackNavegacao;
    @FXML private AnchorPane paneCronogramaEstudos;
    @FXML private Label lbSegunda1;
    @FXML private TextArea taSegunda1;
    @FXML private MenuItem btSalvarCronogramaDeEstudos;
    @FXML private MenuItem btCancelarCronogramaDeEstudos;
    @FXML private MenuItem btExcluirCronogramaEstudos;
    @FXML private Label lbSexta7;
    @FXML private Label lbSabado2;
    @FXML private Label lbSabado1;
    @FXML private Label lbSexta2;
    @FXML private Label lbSabado3;
    @FXML private Label lbSabado7;
    @FXML private Label lbSabado4;
    @FXML private Label lbSexta4;
    @FXML private Label lbDomingo3;
    @FXML private Label lbDomingo1;
    @FXML private Label lbQuarta7;
    @FXML private Label lbSegunda7;
    @FXML private Label lbSexta6;
    @FXML private Label lbTerca7;
    @FXML private Label lbSabado8;
    @FXML private Label lbDomingo8;
    @FXML private Label lbQuinta7;
    @FXML private Label lbSexta8;
    @FXML private Label lbDomingo4;
    @FXML private Label lbSabado5;
    @FXML private Label lbSabado6;
    @FXML private Label lbDomingo5;
    @FXML private Label lbDomingo6;
    @FXML private Label lbDomingo2;
    @FXML private Label lbDomingo7;
    @FXML private Label lbSexta1;
    @FXML private Label lbSexta3;
    @FXML private Label lbSexta5;
    @FXML private Label lbQuinta5;
    @FXML private Label lbQuinta3;
    @FXML private Label lbQuarta1;
    @FXML private Label lbQuinta1;
    @FXML private Label lbTerca1;
    @FXML private Label lbSegunda3;
    @FXML private Label lbTerca3;
    @FXML private Label lbQuarta3;
    @FXML private Label lbSegunda5;
    @FXML private Label lbTerca5;
    @FXML private Label lbQuarta5;
    @FXML private Label lbQuinta2;
    @FXML private Label lbQuarta2;
    @FXML private Label lbTerca2;
    @FXML private Label lbSegunda2;
    @FXML private Label lbSegunda4;
    @FXML private Label lbTerca4;
    @FXML private Label lbQuarta4;
    @FXML private Label lbQuinta4;
    @FXML private Label lbSegunda8;
    @FXML private Label lbTerca8;
    @FXML private Label lbQuarta8;
    @FXML private Label lbQuinta8;
    @FXML private Label lbQuinta6;
    @FXML private Label lbQuarta6;
    @FXML private Label lbTerca6;
    @FXML private Label lbSegunda6;
    @FXML private TextArea taSegunda2;
    @FXML private TextArea taSegunda3;
    @FXML private TextArea taSegunda4;
    @FXML private TextArea taSegunda5;
    @FXML private TextArea taSegunda6;
    @FXML private TextArea taSegunda7;
    @FXML private TextArea taSegunda8;
    @FXML private TextArea taTerca1;
    @FXML private TextArea taTerca2;
    @FXML private TextArea taTerca3;
    @FXML private TextArea taTerca4;
    @FXML private TextArea taTerca5;
    @FXML private TextArea taTerca6;
    @FXML private TextArea taTerca7;
    @FXML private TextArea taTerca8;
    @FXML private TextArea taQuarta1;
    @FXML private TextArea taQuarta2;
    @FXML private TextArea taQuarta8;
    @FXML private TextArea taQuarta7;
    @FXML private TextArea taQuarta6;
    @FXML private TextArea taQuarta5;
    @FXML private TextArea taQuarta4;
    @FXML private TextArea taQuarta3;
    @FXML private TextArea taSexta1;
    @FXML private TextArea taSabado1;
    @FXML private TextArea taSexta7;
    @FXML private TextArea taSexta2;
    @FXML private TextArea taSabado2;
    @FXML private TextArea taDomingo8;
    @FXML private TextArea taSexta3;
    @FXML private TextArea taSabado3;
    @FXML private TextArea taSabado8;
    @FXML private TextArea taSexta4;
    @FXML private TextArea taSabado4;
    @FXML private TextArea taSexta8;
    @FXML private TextArea taSexta5;
    @FXML private TextArea taSabado5;
    @FXML private TextArea taSabado7;
    @FXML private TextArea taSexta6;
    @FXML private TextArea taSabado6;
    @FXML private TextArea taDomingo7;
    @FXML private TextArea taQuinta8;
    @FXML private TextArea taQuinta7;
    @FXML private TextArea taDomingo6;
    @FXML private TextArea taDomingo5;
    @FXML private TextArea taDomingo3;
    @FXML private TextArea taDomingo1;
    @FXML private TextArea taDomingo2;
    @FXML private TextArea taDomingo4;
    @FXML private TextArea taQuinta6;
    @FXML private TextArea taQuinta5;
    @FXML private TextArea taQuinta4;
    @FXML private TextArea taQuinta3;
    @FXML private TextArea taQuinta2;
    @FXML private TextArea taQuinta1;
    @FXML private Label lbSeg1;
    @FXML private Label lbSeg2;
    @FXML private Label lbSeg3;
    @FXML private Label lbSeg4;
    @FXML private Label lbTer1;
    @FXML private Label lbQuar1;
    @FXML private Label lbQuin1;
    @FXML private Label lbSex1;
    @FXML private Label lbTer3;
    @FXML private Label lbQuar3;
    @FXML private Label lbQuin3;
    @FXML private Label lbSex3;
    @FXML private Label lbSab1;
    @FXML private Label lbSab3;
    @FXML private Label lbTer2;
    @FXML private Label lbQuar2;
    @FXML private Label lbQuin2;
    @FXML private Label lbSex2;
    @FXML private Label lbSab2;
    @FXML private Label lbTer4;
    @FXML private Label lbQuar4;
    @FXML private Label lbQuin4;
    @FXML private Label lbSex4;
    @FXML private Label lbSab4;
    @FXML private TextArea taSeg1;
    @FXML private TextArea taSeg2;
    @FXML private TextArea taSeg3;
    @FXML private TextArea taSeg4;
    @FXML private TextArea taTer4;
    @FXML private TextArea taQuar4;
    @FXML private TextArea taQuin4;
    @FXML private TextArea taSex4;
    @FXML private TextArea taTer3;
    @FXML private TextArea taSab1;
    @FXML private TextArea taSex2;
    @FXML private TextArea taSex3;
    @FXML private TextArea taTer2;
    @FXML private TextArea taSab4;
    @FXML private TextArea taSab2;
    @FXML private TextArea taTer1;
    @FXML private TextArea taSab3;
    @FXML private TextArea taQuar1;
    @FXML private TextArea taSex1;
    @FXML private TextArea taQuin1;
    @FXML private TextArea taQuar2;
    @FXML private TextArea taQuin2;
    @FXML private TextArea taQuar3;
    @FXML private TextArea taQuin3;
    @FXML private MenuItem btEditarCronogramaAcademico;
    @FXML private MenuItem btSalvarCronogramaAcademico;
    @FXML private MenuItem btCancelarCronogramaAcademico;
    @FXML private Label lbCurso;
    @FXML private Label lbSemestre;
    @FXML private Label lbCodigoCurso;
    @FXML private Label lbAnoPeriodo;
    @FXML private TextField tfCurso;
    @FXML private TextField tfSemestre;
    @FXML private TextField tfAnoPeriodo;
    @FXML private TextField tfCodigoCurso;
    @FXML private AnchorPane anchorMinhaConta;
    @FXML private Button btSairMinhaConta;
    @FXML private Label lbNome;
    @FXML private TextField tfNome;
    @FXML private Label lbSobrenome;
    @FXML private TextField tfSobrenome;
    @FXML private Label lbTelefone;
    @FXML private TextField tfTelefone;
    @FXML private Label lbSenha;
    @FXML private PasswordField tfSenha;
    @FXML private Label lbEmail;
    @FXML private TextField tfEmail;
    @FXML private Button btEditarMinhaConta;
    @FXML private Button btSalvarMinhaConta;
    @FXML private Button btCancelarMinhaConta;
    @FXML private MenuItem btEditarCurso;
    @FXML private Label lbDadosPessoaisOuCadastro;
    @FXML private Label lbMostrarTelefone;
    @FXML private Label lbMostrarEmail;
    @FXML private Label lbMostrarSobrenome;
    @FXML private Label lbmostrarNome;
    @FXML private AnchorPane anchorEditarSenha;
    @FXML private Label lbDadosPessoaisOuCadastro1;
    @FXML private Label lbSenhaAtual;
    @FXML private Label lbNovaSenha;
    @FXML private Label lbConfirmarNovaSenha;
    @FXML private PasswordField tfNovaSenha;
    @FXML private PasswordField tfConfirmarNovaSenha;
    @FXML private PasswordField tfSenhaAtual;
    @FXML private Button btSalvarAlterarSenha;
    @FXML private Button btCancelarAlterarSenha;
    @FXML private MenuItem btMinhaContaUsuario;
    @FXML private MenuItem btEditarSenha;
    @FXML private Label lbQuestaoAtual;
    @FXML private ToggleGroup tGroupAlternativas;
    @FXML private Button btQuestaoAnterior;
    @FXML private Button btQuestaoSeguinte;
    @FXML private AnchorPane anchorLinks;
    @FXML private TableView<Links> tvLinks;
    @FXML private TableColumn<Links, String> clmDescricaoLink;
    @FXML private TableColumn<Links, String> clmLinks;
    @FXML private TableView<Materias> tvMateriasConfig;
    @FXML private TableColumn<Materias, String> clmMateriasConfig;
    @FXML
    private TableView<Ranking> tvRanking;
    @FXML
    private TableColumn<Ranking, String> clmPosicao;
    @FXML
    private TableColumn<Ranking, String> clmNomeUsuarioRanking;
    @FXML
    private TableColumn<Ranking, String> clmPontuacaoDia;
    @FXML
    private TableColumn<Ranking, String> clmPontuacaoTotal;
    @FXML
    private TableColumn<Ranking, String> clmSobrenomeUsuarioRanking;
    @FXML private Button btAdicionarLink;
    @FXML private MenuItem btSairDeLinks;
    @FXML private Label lbmostrarNomeUsuario;
    @FXML private Label lbMostrarDescricao;
    @FXML private Label lbMostrarLink;
    @FXML private TextField tfDescricao;
    @FXML private TextField tfLink;
    @FXML private Button btCopiarLink;
    @FXML private Button btExcluirLink;
    @FXML private Button btSalvarLink;
    @FXML private Button btCancelarLink;
    @FXML private Button btEditarLink;
    @FXML private Button btExcluirMinhaConta;
    @FXML private Button btSalvarLinkAlterado;
    @FXML private Menu menuBarTitle;
    @FXML
    private TextArea taQuestao;
    @FXML
    private TextArea taAlternativaA;
    @FXML
    private TextArea taAlternativaB;
    @FXML
    private TextArea taAlternativaC;
    @FXML
    private TextArea taAlternativaD;
    @FXML
    private TextArea taAlternativaE;
    @FXML
    private Button btIniciarSimulado;
    @FXML
    private RadioButton rbA;
    @FXML
    private RadioButton rbB;
    @FXML
    private RadioButton rbC;
    @FXML
    private RadioButton rbD;
    @FXML
    private RadioButton rbE;
    @FXML
    private Button btFinalizarSimulado;
    @FXML
    private AnchorPane anchorHistoricoSimulados;
    @FXML
    private Label lbNome1;
    @FXML
    private Label lbSobrenome1;
    @FXML
    private Label lbEmail1;
    @FXML
    private Label lbTelefone1;
    @FXML
    private Label lbSenha1;
    @FXML
    private Label lbTelefone11;
    @FXML
    private Label lbTelefone12;
    @FXML
    private Label lbAcertos;
    @FXML
    private Label lbPontuacaoTotal;
    @FXML
    private Label lbPontuacaoDia;
    @FXML
    private Label lbTotalSimulados;
    @FXML
    private Label lbErros;
    @FXML
    private Label lbIgnorados;
    @FXML
    private MenuItem btHistoricoSimulados;
    @FXML
    private AnchorPane anchorAgenda;
    @FXML
    private TableView<Agenda> tvAgenda;
    @FXML
    private TableColumn<Agenda, String> clmDescricaoAgenda;
    @FXML
    private TableColumn<Agenda, String> clmDataAgenda;
    @FXML
    private Button btAdicionarAgenda;
    @FXML
    private Label lbDescricaoAgenda;
    @FXML
    private Label lbDataAgenda;
    @FXML
    private TextField tfAgenda;
    @FXML
    private DatePicker calendarAgenda;
    @FXML
    private Button btExcluirAgenda;
    @FXML
    private Button btSalvarAgenda;
    @FXML
    private Button btSalvarAgendaAlterada;
    @FXML
    private Button btCancelarAgenda;
    @FXML
    private Button btEditarAgenda;
    @FXML
    private MenuItem btSairAgenda;
    
    
    private int questaoInicial = 1;
    private static int INIT_PERG = 5;//Número de perguntas iniciao no simulado
    private static int INIT_DIF = 1;//Dificuldade inicial no simulado
    
    /**
     * Variáveis destinadas a receber os valores 
     * que estão nas label do cronograma de estudos
     * {->
     */
    String varSegunda1;
    String varSegunda2;
    String varSegunda3;
    String varSegunda4;
    String varSegunda5;
    String varSegunda6;
    String varSegunda7;
    String varSegunda8;
    
    String varTerca1;
    String varTerca2;
    String varTerca3;
    String varTerca4;
    String varTerca5;
    String varTerca6;
    String varTerca7;
    String varTerca8;
    
    String varQuarta1;
    String varQuarta2;
    String varQuarta3;
    String varQuarta4;
    String varQuarta5;
    String varQuarta6;
    String varQuarta7;
    String varQuarta8;
    
    String varQuinta1;
    String varQuinta2;
    String varQuinta3;
    String varQuinta4;
    String varQuinta5;
    String varQuinta6;
    String varQuinta7;
    String varQuinta8;
    
    String varSexta1;
    String varSexta2;
    String varSexta3;
    String varSexta4;
    String varSexta5;
    String varSexta6;
    String varSexta7;
    String varSexta8;
    
    String varSabado1;
    String varSabado2;
    String varSabado3;
    String varSabado4;
    String varSabado5;
    String varSabado6;
    String varSabado7;
    String varSabado8;
    
    String varDomingo1;
    String varDomingo2;
    String varDomingo3;
    String varDomingo4;
    String varDomingo5;
    String varDomingo6;
    String varDomingo7;
    String varDomingo8;
    // <-}
    
    /**
     * Variáveis destinadas a receber os valores 
     * do cronograma Acadêmico e salvar em arquivo
     * {->
     */
    String varSeg1;
    String varSeg2;
    String varSeg3;
    String varSeg4;
    
    String varTer1;
    String varTer2;
    String varTer3;
    String varTer4;
    
    String varQuar1;
    String varQuar2;
    String varQuar3;
    String varQuar4;
    
    String varQuin1;
    String varQuin2;
    String varQuin3;
    String varQuin4;
    
    String varSex1; 
    String varSex2; 
    String varSex3; 
    String varSex4;
    
    String varSab1;
    String varSab2;
    String varSab3;
    String varSab4;
    
    String varCurso;
    String varSemestre;
    String varCodigoCurso;
    String varAnoPeriodo;
    //<-}
    
    
    int valores[];
    String corretas[];
    String[] alternativasSelecionadas;
    private Links selecionandoLinks;
    private Materias selecionandoMaterias;
    private Agenda selecionandoAgenda;
    
    List<Perguntas> simulado = new ArrayList<Perguntas>();
            
    Sessao sessao = Sessao.getInstancia();
    
    
    public UsuarioController() {
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        menuBarTitle.setText(sessao.getNome() + " " + sessao.getSobrenome() + " ▼" );
        
        atualizarScoreDia();
        initTableRanking();
        inserirUsuarioNoRanking();
        insertCronogramaEstudos();
        initTableMateriasSimulado();
        initTableLinks();
        detectarDificuldade();
        detectarNPerguntas();
        
        
        snPerguntas.setOnMouseClicked((MouseEvent e)->{
            detectarNPerguntas();
        });
        
        sDificuldade.setOnMouseClicked((MouseEvent e)->{
            detectarDificuldade();
        });
        
        tvLinks.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selecionandoLinks = (Links) newValue;
                
                lbmostrarNomeUsuario.setText(selecionandoLinks.getNome());
                lbMostrarDescricao.setText(selecionandoLinks.getDescricao());
                lbMostrarLink.setText(selecionandoLinks.getLink());
                
                if(selecionandoLinks.getID_Usuario() == sessao.getID_Usuario()){
                    btEditarLink.setDisable(false);
                    btExcluirLink.setDisable(false);
                }else{
                    btEditarLink.setDisable(true);
                    btExcluirLink.setDisable(true);
                }
                
                lbmostrarNomeUsuario.setVisible(true);
                lbMostrarDescricao.setVisible(true);
                lbMostrarLink.setVisible(true);
                
                btAdicionarLink.setVisible(true);
                btEditarLink.setVisible(true);
                btExcluirLink.setVisible(true);
                
                btSalvarLinkAlterado.setVisible(false);
                btSalvarLink.setVisible(false);
                btCancelarLink.setVisible(false);
                
                tfDescricao.setVisible(false);
                tfLink.setVisible(false);
            }
        });
        
        tvMateriasConfig.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selecionandoMaterias = (Materias) newValue;
                configSimulado();
            }
        });
        
        tvAgenda.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selecionandoAgenda = (Agenda) newValue;
                
                lbDescricaoAgenda.setText(selecionandoAgenda.getDescricao());
                lbDataAgenda.setText(selecionandoAgenda.getData());
                
                if(selecionandoAgenda.getID_Usuario() == sessao.getID_Usuario()){
                    btEditarAgenda.setDisable(false);
                    btExcluirAgenda.setDisable(false);
                }else{
                    btEditarAgenda.setDisable(true);
                    btExcluirAgenda.setDisable(true);
                }
                
                btAdicionarAgenda.setVisible(true);
                btEditarAgenda.setVisible(true);
                btExcluirAgenda.setVisible(true);
                lbDescricaoAgenda.setVisible(true);
                lbDataAgenda.setVisible(true);
                
                btSalvarAgenda.setVisible(false);
                btSalvarAgendaAlterada.setVisible(false);
                btCancelarAgenda.setVisible(false);
                calendarAgenda.setVisible(false);
                tfAgenda.setVisible(false);
            }
        });
    }   
    
    public void configSimulado(){
        int x = 0;
                int y = Integer.valueOf(lbnPerguntas.getText());
                
                if(selecionandoMaterias != null){
                    btIniciarSimulado.setDisable(false);
                    ContadorDAO daoC = new ContadorDAO();
                    Contador c = new Contador();
                    
                    int id = selecionandoMaterias.getID_Materia();
                    
                    List<Contador> contador = daoC.getContador(id, INIT_DIF);
                    
                    for(int i = 0; i < contador.size(); i++){
                        c.setCont(contador.get(i).getCont());
                        int cont = c.getCont();
                        x = cont;
                        snPerguntas.setMax(cont);
                    }
                    
                    if(x < 5){
                        btIniciarSimulado.setDisable(true);
                    }else{
                        btIniciarSimulado.setDisable(false);
                    }
                    
                }else{
                    snPerguntas.setMax(30);
                }
                if(y > x){
                    lbnPerguntas.setText(x + "");
                }
                
                if(selecionandoMaterias == null){
                    lbnPerguntas.setText(30 + "");
                }
    }
    
    /**
     * Responsável por deslogar e voltar ao painel de login
     * @param event 
     */
    @FXML
    private void painelLogin(ActionEvent event) {
        try {
            Login login = new Login();
            login.start(new Stage());
            Usuario.getStage().close();
        } catch (Exception e) {
        }
    }
    
    /**
     * Responsável por abrir o painel de configuração do simulado
     * @param event 
     */
    @FXML
    private void painelEdicaoSimulado(ActionEvent event) {
        anchorEdicaoSimulado.setVisible(true);
        lbPainelNavegacao.setVisible(false);
        anchorMinhaConta.setVisible(false);
        anchorEditarSenha.setVisible(false);
        btHistoricoSimulados.setDisable(false);
        anchorHistoricoSimulados.setVisible(false);
        
        btMinhaContaUsuario.setDisable(false);
        
        cancelarMinhaConta(event);
        cancelarAlterarSenha(event);
    }
    
    /**
     * Responsável por sair do painel de configuração do simulado
     * @param event 
     */
    @FXML
    private void painelCancelarEdicaoSimulado(ActionEvent event) {
        anchorEdicaoSimulado.setVisible(false);
        lbPainelNavegacao.setVisible(true);
    }
    
    /**
     * Detectar o número de perguntas ao arrastar
     * @param event 
     */
    @FXML
    private void arrastarSlider(MouseEvent event) {
        detectarNPerguntas();
    }
    
    /**
     * Detectar o número de perguntas ao arrastar
     * @param event 
     */
    @FXML
    private void arrastarSlider1(DragEvent event) {
        detectarNPerguntas();
    }
    
    /**
     * Detectar o número de perguntas ao arrastar
     * @param event 
     */
    @FXML
    private void arrastarSlider2(DragEvent event) {
        detectarNPerguntas();
    }
    
    /**
     * Método para detectar o número de perguntas e usados nos métodos acima
     */
    public void detectarNPerguntas(){
        INIT_PERG = (int) snPerguntas.getValue();
        lbnPerguntas.setText(Integer.toString(INIT_PERG));
    }
    
    /**
     * Detectar o nível de dificuldade
     * @param event 
     */
    @FXML
    private void detectDificuldade1(MouseEvent event) {
        detectarDificuldade();
    }
    
    /**
     * Detectar o nível de dificuldade
     * @param event 
     */
    @FXML
    private void detectDificuldade2(DragEvent event) {
        detectarDificuldade();
    }
    
    /**
     * Detectar o nível de dificuldade
     * @param event 
     */
    @FXML
    private void detectDificuldade3(DragEvent event) {
        detectarDificuldade();
    }
    
    /**
     * Método para detectar o nível de dificuldade e usado nos métodos acima
     */
    public void detectarDificuldade(){
        INIT_DIF = (int) sDificuldade.getValue();
            switch(INIT_DIF){
                case 1:
                    lbDificuldade.setText("Fácil");
                    snPerguntas.setValue(5);
                    snPerguntas.setMin(5);
                    INIT_PERG = 5;
                    btIniciarSimulado.setDisable(true);
                    lbnPerguntas.setText(Integer.toString(INIT_PERG));
                    initTableMateriasSimulado();
                    break;
                case 2:
                    lbDificuldade.setText("Médio");
                    snPerguntas.setValue(5);
                    snPerguntas.setMin(5);
                    INIT_PERG = 5;
                    btIniciarSimulado.setDisable(true);
                    lbnPerguntas.setText(Integer.toString(INIT_PERG));
                    initTableMateriasSimulado();
                    break;
                case 3:
                    lbDificuldade.setText("Difícil");
                    snPerguntas.setValue(5);
                    snPerguntas.setMin(5);
                    INIT_PERG = 5;
                    btIniciarSimulado.setDisable(true);
                    lbnPerguntas.setText(Integer.toString(INIT_PERG));
                    initTableMateriasSimulado();
                    break;
            }
    }
    
    
    /**
     * Método para iniciar o simulado
     * @param event 
     */
    @FXML
    private void iniciarSimulado(ActionEvent event) {
        rbA.setSelected(false);
        rbB.setSelected(false);
        rbC.setSelected(false);
        rbD.setSelected(false);
        rbE.setSelected(false);
        
        alternativasSelecionadas = new String[INIT_PERG];
        
        for(int i = 0; i < INIT_PERG; i++){
            alternativasSelecionadas[i] = "null";
        }
        
        questaoInicial = 1;
        lbQuestaoAtual.setText(questaoInicial + "/" + INIT_PERG);
        
        paneUsuario.setVisible(false);
        paneSimulado.setVisible(true);
          
        PerguntasDAO daoP = new PerguntasDAO();
        List<Perguntas> p = daoP.getList(selecionandoMaterias.getID_Materia(), INIT_PERG, INIT_DIF);
        
        corretas = new String[p.size()];
        valores = new int[p.size()];
        
        for(int i = 0; i < p.size(); i++){
            simulado.addAll(p);
            corretas[i] = p.get(i).getAlternativaCorreta();
            valores[i] = p.get(i).getValor();
        }
        
        taQuestao.setText(simulado.get(questaoInicial -1).getDescricao());
        taAlternativaA.setText(simulado.get(questaoInicial -1).getAlternativaA());
        taAlternativaB.setText(simulado.get(questaoInicial -1).getAlternativaB());
        taAlternativaC.setText(simulado.get(questaoInicial -1).getAlternativaC());
        taAlternativaD.setText(simulado.get(questaoInicial -1).getAlternativaD());
        taAlternativaE.setText(simulado.get(questaoInicial -1).getAlternativaE());
        
        verificandoTextAreaVazia();
    }
    
    /**
     * Voltar para a questão anterior no simulado
     * @param event 
     */
    @FXML
    private void questaoAnterior(ActionEvent event) {
        if(questaoInicial > 1){
            questaoInicial -= 1;
            
            lbQuestaoAtual.setText(questaoInicial + "/" + INIT_PERG);
            
            taQuestao.setText(simulado.get(questaoInicial -1).getDescricao());
            taAlternativaA.setText(simulado.get(questaoInicial -1).getAlternativaA());
            taAlternativaB.setText(simulado.get(questaoInicial -1).getAlternativaB());
            taAlternativaC.setText(simulado.get(questaoInicial -1).getAlternativaC());
            taAlternativaD.setText(simulado.get(questaoInicial -1).getAlternativaD());
            taAlternativaE.setText(simulado.get(questaoInicial -1).getAlternativaE());
            
            questoesRespondidas();

            verificandoTextAreaVazia();
        }
        
        if(questaoInicial == 1){
            btQuestaoAnterior.setDisable(true);
        }
        
        if(questaoInicial == INIT_PERG){
            btQuestaoSeguinte.setVisible(false);
            btFinalizarSimulado.setVisible(true);
        }else{
            btQuestaoSeguinte.setVisible(true);
            btFinalizarSimulado.setVisible(false);
        }
    }
    
    /**
     * Ir para a questão seguinte no simulado
     * @param event 
     */
    @FXML
    private void questaoSeguinte(ActionEvent event) {
        
        if(questaoInicial < INIT_PERG){
            questaoInicial += 1;
            lbQuestaoAtual.setText(questaoInicial + "/" + INIT_PERG);
        }
        
        taQuestao.setText(simulado.get(questaoInicial -1).getDescricao());
        taAlternativaA.setText(simulado.get(questaoInicial -1).getAlternativaA());
        taAlternativaB.setText(simulado.get(questaoInicial -1).getAlternativaB());
        taAlternativaC.setText(simulado.get(questaoInicial -1).getAlternativaC());
        taAlternativaD.setText(simulado.get(questaoInicial -1).getAlternativaD());
        taAlternativaE.setText(simulado.get(questaoInicial -1).getAlternativaE());
        
        questoesRespondidas();
        
        verificandoTextAreaVazia();
        
        if(questaoInicial == INIT_PERG){
            btQuestaoSeguinte.setVisible(false);
            btFinalizarSimulado.setVisible(true);
        }else{
            btQuestaoSeguinte.setVisible(true);
            btFinalizarSimulado.setVisible(false);
        }
        
        if(questaoInicial > 1){
            btQuestaoAnterior.setDisable(false);
        }
    }
    
    @FXML
    private void A(MouseEvent event) {
        if(rbA.isSelected()){
            alternativasSelecionadas[questaoInicial -1] = rbA.getText();
        }else{
            alternativasSelecionadas[questaoInicial - 1] = "null";
        }
    }

    @FXML
    private void B(MouseEvent event) {
        if(rbB.isSelected()){
            alternativasSelecionadas[questaoInicial -1] = rbB.getText();
        }else{
            alternativasSelecionadas[questaoInicial - 1] = "null";
        }
    }

    @FXML
    private void C(MouseEvent event) {
        if(rbC.isSelected()){
            alternativasSelecionadas[questaoInicial -1] = rbC.getText();
        }else{
            alternativasSelecionadas[questaoInicial - 1] = "null";
        }
    }

    @FXML
    private void D(MouseEvent event) {
        if(rbD.isSelected()){
            alternativasSelecionadas[questaoInicial -1] = rbD.getText();
        }else{
            alternativasSelecionadas[questaoInicial - 1] = "null";
        }
    }

    @FXML
    private void E(MouseEvent event) {
        if(rbE.isSelected()){
            alternativasSelecionadas[questaoInicial -1] = rbE.getText();
        }else{
            alternativasSelecionadas[questaoInicial - 1] = "null";
        }
    }
    
    public void questoesRespondidas(){
       String teste = alternativasSelecionadas[questaoInicial -1];
        
        if(alternativasSelecionadas[questaoInicial -1] == "null"){
           rbA.setSelected(false);
           rbB.setSelected(false);
           rbC.setSelected(false);
           rbD.setSelected(false);
           rbE.setSelected(false);
       }
        
       switch(teste)
       {
           case "A":
               rbA.setSelected(true);
               break;
               
           case "B":
               rbB.setSelected(true);
               break;
               
           case "C":
               rbC.setSelected(true);
               break;
               
           case "D":
               rbD.setSelected(true);
               break;
               
           case "E":
               rbE.setSelected(true);
               break;
               
       }    
    }
    
    @FXML
    private void finalizarSimulado(ActionEvent event) {
        int scoreDia = 0;
        int scoreTotal = 0;
        int erros = 0;
        int acertos = 0;
        int ignorados = 0;
        int simulados = 0;
        
        java.util.Date data = new java.util.Date();
        SimpleDateFormat formatarData = new SimpleDateFormat("yyyy-MM-dd");
        String dataFormatada = formatarData.format(data);
        
        for(int i = 0; i < INIT_PERG; i++){
            if(alternativasSelecionadas[i].equals(corretas[i])){
                scoreDia += valores[i];
                scoreTotal += valores[i];
                acertos += 1;
            }else{
                if(alternativasSelecionadas[i].equals("null")){
                    ignorados += 1;
                }else{
                    erros += 1;
                }
            }
        }
        simulados += 1;
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Simulado");
        alert.setHeaderText("Pontuação: " + scoreDia );
        alert.setContentText("Você acertou " + acertos + " questões.");
        alert.showAndWait();
        
        RankingDAO dao = new RankingDAO();
        List<Ranking> ranking = dao.getUsuario(sessao.getID_Usuario());
        
        scoreDia += ranking.get(0).getScoreDia();
        scoreTotal += ranking.get(0).getScoreTotal();
        erros += ranking.get(0).getErros();
        acertos += ranking.get(0).getAcertos();
        ignorados += ranking.get(0).getIgnorados();
        simulados += ranking.get(0).getTotalSimulados();
        
        if(ranking.get(0).getID_Usuario() == sessao.getID_Usuario()){
            RankingDAO daoRa = new RankingDAO();
            Ranking ra = new Ranking();
            
            ra.setID_Usuario(sessao.getID_Usuario());
            ra.setScoreDia(scoreDia);
            ra.setScoreTotal(scoreTotal);
            ra.setErros(erros);
            ra.setAcertos(acertos);
            ra.setIgnorados(ignorados);
            ra.setTotalSimulados(simulados);
            ra.setData(dataFormatada);

            daoRa.update(ra);
        }
        
        paneUsuario.setVisible(true);
        lbPainelNavegacao.setVisible(true);
        paneSimulado.setVisible(false);
        anchorEdicaoSimulado.setVisible(true);
        sairMinhaConta(event);
        cancelarAlterarSenha(event);
        initTableRanking();
        
        simulado.clear();
    }
    
    public void inserirUsuarioNoRanking(){
        java.util.Date data = new java.util.Date();
        SimpleDateFormat formatarData = new SimpleDateFormat("yyyy-MM-dd");
        String dataFormatada = formatarData.format(data);
        
        RankingDAO daoR = new RankingDAO();
        Ranking r = new Ranking();

        r.setID_Usuario(sessao.getID_Usuario());
        r.setScoreDia(0);
        r.setScoreTotal(0);
        r.setErros(0);
        r.setAcertos(0);
        r.setIgnorados(0);
        r.setTotalSimulados(0);
        r.setData(dataFormatada);

        daoR.insert(r);
    }
    
    public void verificandoTextAreaVazia(){
        if(taAlternativaC.getText().length() < 1){
            taAlternativaC.setVisible(false);
            rbC.setVisible(false);
        }else{
          taAlternativaC.setVisible(true);  
          rbC.setVisible(true);  
        }
        
        if(taAlternativaD.getText().length() < 1){
            taAlternativaD.setVisible(false);
            rbD.setVisible(false);
        }else{
          taAlternativaD.setVisible(true);  
          rbD.setVisible(true);  
        }
        
        if(taAlternativaE.getText().length() < 1){
            taAlternativaE.setVisible(false);
            rbE.setVisible(false);
        }else{
          taAlternativaE.setVisible(true);  
          rbE.setVisible(true);  
        }
        
    }
    
    /**
     * Método para sair do simulado
     * @param event 
     */
    @FXML
    private void sairSimulado(ActionEvent event) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Simulado");
            alert.setHeaderText("Se sair agora, todo o progresso será perdido.");
            alert.setContentText("Você tem certeza disso?");
        
            ButtonType buttonTypeSim = new ButtonType("Sim");
            ButtonType buttonTypeCancelar = new ButtonType("Cancelar");
            
            alert.getButtonTypes().setAll(buttonTypeSim, buttonTypeCancelar);
        
            Optional<ButtonType> resultado = alert.showAndWait();
            if(resultado.get() == buttonTypeSim){
                paneUsuario.setVisible(true);
                lbPainelNavegacao.setVisible(true);
                paneSimulado.setVisible(false);
                anchorEdicaoSimulado.setVisible(true);
                sairMinhaConta(event);
                cancelarAlterarSenha(event);
                initTableRanking();
                
                simulado.clear();
            }else{
                alert.close();
            }
    }
    
    /**
     * Método para fechar a lista de matérias
     * @param event 
     */
    private void SairListarMaterias(ActionEvent event) {
        lbPainelNavegacao.setVisible(true);
        
    }    
    
    /**
     * Método para mostrar a lista de matérias
     * @param event 
     */
    private void listarMaterias(ActionEvent event) {
        anchorEdicaoSimulado.setVisible(false);
        anchorMinhaConta.setVisible(false);
        anchorEditarSenha.setVisible(false);
        btHistoricoSimulados.setDisable(false);
        anchorHistoricoSimulados.setVisible(false);
        
        btMinhaContaUsuario.setDisable(false);
        
        cancelarMinhaConta(event);
        cancelarAlterarSenha(event);
        
        lbPainelNavegacao.setVisible(false);
    }
    
    /**
     * Método para abrir o cronograma de estudos
     * @param event 
     */
    @FXML
    private void abrirCronogramaDeEstudos(ActionEvent event) {
        carregarCronogramaEstudos();
        paneUsuario.setVisible(false);
        paneCronogramaEstudos.setVisible(true);
        
        anchorEdicaoSimulado.setVisible(false);
        anchorEditarSenha.setVisible(false);
        anchorMinhaConta.setVisible(false);
        btHistoricoSimulados.setDisable(false);
        anchorHistoricoSimulados.setVisible(false);
        
        limparTextFieldsCronogramaEstudos();
        cancelarMinhaConta(event);
        cancelarAlterarSenha(event);
        cancelarCronogramaDeEstudos(event);
    }
    
    /**
     * Método para sair do cronograma de estudos e voltar a tela principal
     * @param event 
     */
    @FXML
    private void sairCronogramaDeDeEstudos(ActionEvent event) {
        paneUsuario.setVisible(true);
        lbPainelNavegacao.setVisible(true);
        paneCronogramaEstudos.setVisible(false);
        anchorEdicaoSimulado.setVisible(false);
        sairMinhaConta(event);
        cancelarAlterarSenha(event);
    }
    
    public void coletaDadosCronogramaAcadêmico(){
        
        //Cronograma
        taSeg1.setText(lbSeg1.getText().trim());
        taSeg2.setText(lbSeg2.getText().trim());
        taSeg3.setText(lbSeg3.getText().trim());
        taSeg4.setText(lbSeg4.getText().trim());
        
        taTer1.setText(lbTer1.getText().trim());
        taTer2.setText(lbTer2.getText().trim());
        taTer3.setText(lbTer3.getText().trim());
        taTer4.setText(lbTer4.getText().trim());
        
        taQuar1.setText(lbQuar1.getText().trim());
        taQuar2.setText(lbQuar2.getText().trim());
        taQuar3.setText(lbQuar3.getText().trim());
        taQuar4.setText(lbQuar4.getText().trim());
        
        taQuinta1.setText(lbQuin1.getText().trim());
        taQuinta2.setText(lbQuin2.getText().trim());
        taQuinta3.setText(lbQuin3.getText().trim());
        taQuinta4.setText(lbQuin4.getText().trim());
        
        taSex1.setText(lbSex1.getText().trim());
        taSex2.setText(lbSex2.getText().trim());
        taSex3.setText(lbSex3.getText().trim());
        taSex4.setText(lbSex4.getText().trim());
        
        taSab1.setText(lbSab1.getText().trim());
        taSab2.setText(lbSab2.getText().trim());
        taSab3.setText(lbSab3.getText().trim());
        taSab4.setText(lbSab4.getText().trim());
        
        //Curso
        tfAnoPeriodo.setText(lbAnoPeriodo.getText().trim());
        tfCodigoCurso.setText(lbCodigoCurso.getText().trim());
        tfCurso.setText(lbCurso.getText().trim());
        tfSemestre.setText(lbSemestre.getText().trim());    
    }
    
    /**
     * Método para abrir o Cronograma Acadêmico
     * @param event 
     */
    @FXML
    private void abrirCronogramaAcademico(ActionEvent event) {
        txtLerCronogramaAcademico();
        paneUsuario.setVisible(false);
        paneCronogramaAcademico.setVisible(true);
        
        anchorEdicaoSimulado.setVisible(false);
        anchorEditarSenha.setVisible(false);
        anchorMinhaConta.setVisible(false);
        btHistoricoSimulados.setDisable(false);
        anchorHistoricoSimulados.setVisible(false);
        
        cancelarMinhaConta(event);
        cancelarAlterarSenha(event);
        cancelarCronogramaAcademico(event);
    }
    
    /**
     * Método para sair do Cronograma Acadêmico e voltar a tela principal
     * @param event 
     */
    @FXML
    private void sairCronogramaAcademico(ActionEvent event) {
        paneUsuario.setVisible(true);
        lbPainelNavegacao.setVisible(true);
        paneCronogramaAcademico.setVisible(false);
        anchorEdicaoSimulado.setVisible(false);
        sairMinhaConta(event);
        cancelarAlterarSenha(event);
    }
    
    /**
     * Insere um cronograma vazio para o novo usuário
     */
    public void insertCronogramaEstudos() {
        cronogramaEstudos c = new cronogramaEstudos();
        cronogramaEstudosDAO daoC = new cronogramaEstudosDAO();
        
        c.setID_Usuario(sessao.getID_Usuario());
        
        daoC.insert(c);
    }
    
    /**
     * Exclui todos os dados de cronograma do usuário
     * @param event 
     */
    @FXML
    private void excluirCronogramaEstudos(ActionEvent event) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Cronograma de Estudos");
            alert.setHeaderText("Este cronograma será excluído.");
            alert.setContentText("Você tem certeza disso?");
        
            ButtonType buttonTypeSim = new ButtonType("Sim");
            ButtonType buttonTypeCancelar = new ButtonType("Cancelar");
            
            alert.getButtonTypes().setAll(buttonTypeSim, buttonTypeCancelar);
        
            Optional<ButtonType> resultado = alert.showAndWait();
            if(resultado.get() == buttonTypeSim){
                cronogramaEstudos c = new cronogramaEstudos();
                cronogramaEstudosDAO daoC = new cronogramaEstudosDAO();

                c.setID_Usuario(sessao.getID_Usuario());

                daoC.delete(c);

                insertCronogramaEstudos();
                limparLabelsCronogramaEstudos();
                limparTextFieldsCronogramaEstudos();
            }else{
                alert.close();
            }
    }
    
    /**
     * Limpa as Labels ao excluir o cronograma
     */
    public void limparLabelsCronogramaEstudos(){
        lbSegunda1.setText("");
        lbSegunda2.setText("");
        lbSegunda3.setText("");
        lbSegunda4.setText("");
        lbSegunda5.setText("");
        lbSegunda6.setText("");
        lbSegunda7.setText("");
        lbSegunda8.setText("");
        
        lbTerca1.setText("");
        lbTerca2.setText("");
        lbTerca3.setText("");
        lbTerca4.setText("");
        lbTerca5.setText("");
        lbTerca6.setText("");
        lbTerca7.setText("");
        lbTerca8.setText("");
        
        lbQuarta1.setText("");
        lbQuarta2.setText("");
        lbQuarta3.setText("");
        lbQuarta4.setText("");
        lbQuarta5.setText("");
        lbQuarta6.setText("");
        lbQuarta7.setText("");
        lbQuarta8.setText("");
        
        lbQuinta1.setText("");
        lbQuinta2.setText("");
        lbQuinta3.setText("");
        lbQuinta4.setText("");
        lbQuinta5.setText("");
        lbQuinta6.setText("");
        lbQuinta7.setText("");
        lbQuinta8.setText("");
        
        lbSexta1.setText("");
        lbSexta2.setText("");
        lbSexta3.setText("");
        lbSexta4.setText("");
        lbSexta5.setText("");
        lbSexta6.setText("");
        lbSexta7.setText("");
        lbSexta8.setText("");
        
        lbSabado1.setText("");
        lbSabado2.setText("");
        lbSabado3.setText("");
        lbSabado4.setText("");
        lbSabado5.setText("");
        lbSabado6.setText("");
        lbSabado7.setText("");
        lbSabado8.setText("");
        
        lbDomingo1.setText("");
        lbDomingo2.setText("");
        lbDomingo3.setText("");
        lbDomingo4.setText("");
        lbDomingo5.setText("");
        lbDomingo6.setText("");
        lbDomingo7.setText("");
        lbDomingo8.setText("");
    }
    
    /**
     * Limpa todas as textfields do cronograma para o caso
     * de outro usuário logar 
     */
    public void limparTextFieldsCronogramaEstudos(){
        taSegunda1.setText("");
        taSegunda2.setText("");
        taSegunda3.setText("");
        taSegunda4.setText("");
        taSegunda5.setText("");
        taSegunda6.setText("");
        taSegunda7.setText("");
        taSegunda8.setText("");
        
        taTerca1.setText("");
        taTerca2.setText("");
        taTerca3.setText("");
        taTerca4.setText("");
        taTerca5.setText("");
        taTerca6.setText("");
        taTerca7.setText("");
        taTerca8.setText("");
        
        taQuarta1.setText("");
        taQuarta2.setText("");
        taQuarta3.setText("");
        taQuarta4.setText("");
        taQuarta5.setText("");
        taQuarta6.setText("");
        taQuarta7.setText("");
        taQuarta8.setText("");
        
        taQuinta1.setText("");
        taQuinta2.setText("");
        taQuinta3.setText("");
        taQuinta4.setText("");
        taQuinta5.setText("");
        taQuinta6.setText("");
        taQuinta7.setText("");
        taQuinta8.setText("");
        
        taSexta1.setText("");
        taSexta2.setText("");
        taSexta3.setText("");
        taSexta4.setText("");
        taSexta5.setText("");
        taSexta6.setText("");
        taSexta7.setText("");
        taSexta8.setText("");
        
        taSabado1.setText("");
        taSabado2.setText("");
        taSabado3.setText("");
        taSabado4.setText("");
        taSabado1.setText("");
        taSabado6.setText("");
        taSabado7.setText("");
        taSabado8.setText("");
        
        taDomingo1.setText("");
        taDomingo2.setText("");
        taDomingo3.setText("");
        taDomingo4.setText("");
        taDomingo5.setText("");
        taDomingo6.setText("");
        taDomingo7.setText("");
        taDomingo8.setText("");
    }
    
    /**
     * Método para editar o cronograma de estudos
     * @param event 
     */
    @FXML
    void editarCronogramaDeEstudos(ActionEvent event) {
        taSegunda1.setVisible(true);
        taSegunda2.setVisible(true);
        taSegunda3.setVisible(true);
        taSegunda4.setVisible(true);
        taSegunda5.setVisible(true);
        taSegunda6.setVisible(true);
        taSegunda7.setVisible(true);
        taSegunda8.setVisible(true);
        
        taTerca1.setVisible(true);
        taTerca2.setVisible(true);
        taTerca3.setVisible(true);
        taTerca4.setVisible(true);
        taTerca5.setVisible(true);
        taTerca6.setVisible(true);
        taTerca7.setVisible(true);
        taTerca8.setVisible(true);
        
        taQuarta1.setVisible(true);
        taQuarta2.setVisible(true);
        taQuarta3.setVisible(true);
        taQuarta4.setVisible(true);
        taQuarta5.setVisible(true);
        taQuarta6.setVisible(true);
        taQuarta7.setVisible(true);
        taQuarta8.setVisible(true);
        
        taQuinta1.setVisible(true);
        taQuinta2.setVisible(true);
        taQuinta3.setVisible(true);
        taQuinta4.setVisible(true);
        taQuinta5.setVisible(true);
        taQuinta6.setVisible(true);
        taQuinta7.setVisible(true);
        taQuinta8.setVisible(true);
        
        taSexta1.setVisible(true);
        taSexta2.setVisible(true);
        taSexta3.setVisible(true);
        taSexta4.setVisible(true);
        taSexta5.setVisible(true);
        taSexta6.setVisible(true);
        taSexta7.setVisible(true);
        taSexta8.setVisible(true);
        
        taSabado1.setVisible(true);
        taSabado2.setVisible(true);
        taSabado3.setVisible(true);
        taSabado4.setVisible(true);
        taSabado5.setVisible(true);
        taSabado6.setVisible(true);
        taSabado7.setVisible(true);
        taSabado8.setVisible(true);
        
        taDomingo1.setVisible(true);
        taDomingo2.setVisible(true);
        taDomingo3.setVisible(true);
        taDomingo4.setVisible(true);
        taDomingo5.setVisible(true);
        taDomingo6.setVisible(true);
        taDomingo7.setVisible(true);
        taDomingo8.setVisible(true);
        
        taSegunda1.setText(lbSegunda1.getText());
        taSegunda2.setText(lbSegunda2.getText());
        taSegunda3.setText(lbSegunda3.getText());
        taSegunda4.setText(lbSegunda4.getText());
        taSegunda5.setText(lbSegunda5.getText());
        taSegunda6.setText(lbSegunda6.getText());
        taSegunda7.setText(lbSegunda7.getText());
        taSegunda8.setText(lbSegunda8.getText());
        
        taTerca1.setText(lbTerca1.getText());
        taTerca2.setText(lbTerca2.getText());
        taTerca3.setText(lbTerca3.getText());
        taTerca4.setText(lbTerca4.getText());
        taTerca5.setText(lbTerca5.getText());
        taTerca6.setText(lbTerca6.getText());
        taTerca7.setText(lbTerca7.getText());
        taTerca8.setText(lbTerca8.getText());
        
        taQuarta1.setText(lbQuarta1.getText());
        taQuarta2.setText(lbQuarta2.getText());
        taQuarta3.setText(lbQuarta3.getText());
        taQuarta4.setText(lbQuarta4.getText());
        taQuarta5.setText(lbQuarta5.getText());
        taQuarta6.setText(lbQuarta6.getText());
        taQuarta7.setText(lbQuarta7.getText());
        taQuarta8.setText(lbQuarta8.getText());
        
        taQuinta1.setText(lbQuinta1.getText());
        taQuinta2.setText(lbQuinta2.getText());
        taQuinta3.setText(lbQuinta3.getText());
        taQuinta4.setText(lbQuinta4.getText());
        taQuinta5.setText(lbQuinta5.getText());
        taQuinta6.setText(lbQuinta6.getText());
        taQuinta7.setText(lbQuinta7.getText());
        taQuinta8.setText(lbQuinta8.getText());
        
        taSexta1.setText(lbSexta1.getText());
        taSexta2.setText(lbSexta2.getText());
        taSexta3.setText(lbSexta3.getText());
        taSexta4.setText(lbSexta4.getText());
        taSexta5.setText(lbSexta5.getText());
        taSexta6.setText(lbSexta6.getText());
        taSexta7.setText(lbSexta7.getText());
        taSexta8.setText(lbSexta8.getText());
        
        taSabado1.setText(lbSabado1.getText());
        taSabado2.setText(lbSabado2.getText());
        taSabado3.setText(lbSabado3.getText());
        taSabado4.setText(lbSabado4.getText());
        taSabado5.setText(lbSabado5.getText());
        taSabado6.setText(lbSabado6.getText());
        taSabado7.setText(lbSabado7.getText());
        taSabado8.setText(lbSabado8.getText());
        
        taDomingo1.setText(lbDomingo1.getText());
        taDomingo2.setText(lbDomingo2.getText());
        taDomingo3.setText(lbDomingo3.getText());
        taDomingo4.setText(lbDomingo4.getText());
        taDomingo5.setText(lbDomingo5.getText());
        taDomingo6.setText(lbDomingo6.getText());
        taDomingo7.setText(lbDomingo7.getText());
        taDomingo8.setText(lbDomingo8.getText());
        
        btSalvarCronogramaDeEstudos.setDisable(false);
        btCancelarCronogramaDeEstudos.setDisable(false);
        btExcluirCronogramaEstudos.setDisable(true);
    }

    /**
     * Método para salvar as edições do cronograma de estudos
     * @param event 
     */
    @FXML
    private void salvarCronogramaDeEstudos(ActionEvent event) {
        cronogramaEstudos ce = new cronogramaEstudos();
        cronogramaEstudosDAO daoCE = new cronogramaEstudosDAO();
        
        ce.setID_Usuario(sessao.getID_Usuario());
        
        daoCE.delete(ce);
        
        cronogramaEstudos c = new cronogramaEstudos();
        cronogramaEstudosDAO daoC = new cronogramaEstudosDAO();
        
        c.setID_Usuario(sessao.getID_Usuario());
       
        c.setSegunda1(taSegunda1.getText().trim());
        c.setSegunda2(taSegunda2.getText().trim());
        c.setSegunda3(taSegunda3.getText().trim());
        c.setSegunda4(taSegunda4.getText().trim());
        c.setSegunda5(taSegunda5.getText().trim());
        c.setSegunda6(taSegunda6.getText().trim());
        c.setSegunda7(taSegunda7.getText().trim());
        c.setSegunda8(taSegunda8.getText().trim());
        
        c.setTerca1(taTerca1.getText().trim());
        c.setTerca2(taTerca2.getText().trim());
        c.setTerca3(taTerca3.getText().trim());
        c.setTerca4(taTerca4.getText().trim());
        c.setTerca5(taTerca5.getText().trim());
        c.setTerca6(taTerca6.getText().trim());
        c.setTerca7(taTerca7.getText().trim());
        c.setTerca8(taTerca8.getText().trim());
        
        c.setQuarta1(taQuarta1.getText().trim());
        c.setQuarta2(taQuarta2.getText().trim());
        c.setQuarta3(taQuarta3.getText().trim());
        c.setQuarta4(taQuarta4.getText().trim());
        c.setQuarta5(taQuarta5.getText().trim());
        c.setQuarta6(taQuarta6.getText().trim());
        c.setQuarta7(taQuarta7.getText().trim());
        c.setQuarta8(taQuarta8.getText().trim());
        
        c.setQuinta1(taQuinta1.getText().trim());
        c.setQuinta2(taQuinta2.getText().trim());
        c.setQuinta3(taQuinta3.getText().trim());
        c.setQuinta4(taQuinta4.getText().trim());
        c.setQuinta5(taQuinta5.getText().trim());
        c.setQuinta6(taQuinta6.getText().trim());
        c.setQuinta7(taQuinta7.getText().trim());
        c.setQuinta8(taQuinta8.getText().trim());
        
        c.setSexta1(taSexta1.getText().trim());
        c.setSexta2(taSexta2.getText().trim());
        c.setSexta3(taSexta3.getText().trim());
        c.setSexta4(taSexta4.getText().trim());
        c.setSexta5(taSexta5.getText().trim());
        c.setSexta6(taSexta6.getText().trim());
        c.setSexta7(taSexta7.getText().trim());
        c.setSexta8(taSexta8.getText().trim());
        
        c.setSabado1(taSabado1.getText().trim());
        c.setSabado2(taSabado2.getText().trim());
        c.setSabado3(taSabado3.getText().trim());
        c.setSabado4(taSabado4.getText().trim());
        c.setSabado5(taSabado5.getText().trim());
        c.setSabado6(taSabado6.getText().trim());
        c.setSabado7(taSabado7.getText().trim());
        c.setSabado8(taSabado8.getText().trim());
        
        c.setDomingo1(taDomingo1.getText().trim());
        c.setDomingo2(taDomingo2.getText().trim());
        c.setDomingo3(taDomingo3.getText().trim());
        c.setDomingo4(taDomingo4.getText().trim());
        c.setDomingo5(taDomingo5.getText().trim());
        c.setDomingo6(taDomingo6.getText().trim());
        c.setDomingo7(taDomingo7.getText().trim());
        c.setDomingo8(taDomingo8.getText().trim());
        
        daoC.insert(c);
        
        lbSegunda1.setText(taSegunda1.getText());
        lbSegunda2.setText(taSegunda2.getText());
        lbSegunda3.setText(taSegunda3.getText());
        lbSegunda4.setText(taSegunda4.getText());
        lbSegunda5.setText(taSegunda5.getText());
        lbSegunda6.setText(taSegunda6.getText());
        lbSegunda7.setText(taSegunda7.getText());
        lbSegunda8.setText(taSegunda8.getText());
        
        lbTerca1.setText(taTerca1.getText());
        lbTerca2.setText(taTerca2.getText());
        lbTerca3.setText(taTerca3.getText());
        lbTerca4.setText(taTerca4.getText());
        lbTerca5.setText(taTerca5.getText());
        lbTerca6.setText(taTerca6.getText());
        lbTerca7.setText(taTerca7.getText());
        lbTerca8.setText(taTerca8.getText());
        
        lbQuarta1.setText(taQuarta1.getText());
        lbQuarta2.setText(taQuarta2.getText());
        lbQuarta3.setText(taQuarta3.getText());
        lbQuarta4.setText(taQuarta4.getText());
        lbQuarta5.setText(taQuarta5.getText());
        lbQuarta6.setText(taQuarta6.getText());
        lbQuarta7.setText(taQuarta7.getText());
        lbQuarta8.setText(taQuarta8.getText());
        
        lbQuinta1.setText(taQuinta1.getText());
        lbQuinta2.setText(taQuinta2.getText());
        lbQuinta3.setText(taQuinta3.getText());
        lbQuinta4.setText(taQuinta4.getText());
        lbQuinta5.setText(taQuinta5.getText());
        lbQuinta6.setText(taQuinta6.getText());
        lbQuinta7.setText(taQuinta7.getText());
        lbQuinta8.setText(taQuinta8.getText());
        
        lbSexta1.setText(taSexta1.getText());
        lbSexta2.setText(taSexta2.getText());
        lbSexta3.setText(taSexta3.getText());
        lbSexta4.setText(taSexta4.getText());
        lbSexta5.setText(taSexta5.getText());
        lbSexta6.setText(taSexta6.getText());
        lbSexta7.setText(taSexta7.getText());
        lbSexta8.setText(taSexta8.getText());
        
        lbSabado1.setText(taSabado1.getText());
        lbSabado2.setText(taSabado2.getText());
        lbSabado3.setText(taSabado3.getText());
        lbSabado4.setText(taSabado4.getText());
        lbSabado5.setText(taSabado5.getText());
        lbSabado6.setText(taSabado6.getText());
        lbSabado7.setText(taSabado7.getText());
        lbSabado8.setText(taSabado8.getText());
        
        lbDomingo1.setText(taDomingo1.getText());
        lbDomingo2.setText(taDomingo2.getText());
        lbDomingo3.setText(taDomingo3.getText());
        lbDomingo4.setText(taDomingo4.getText());
        lbDomingo5.setText(taDomingo5.getText());
        lbDomingo6.setText(taDomingo6.getText());
        lbDomingo7.setText(taDomingo7.getText());
        lbDomingo8.setText(taDomingo8.getText());
        
        cancelarCronogramaDeEstudos(event);
    }
    
    /**
     * Método para cancelar as edições do cronograma de estudos
     * @param event 
     */
    @FXML
    private void cancelarCronogramaDeEstudos(ActionEvent event) {
        taSegunda1.setVisible(false);
        taSegunda2.setVisible(false);
        taSegunda3.setVisible(false);
        taSegunda4.setVisible(false);
        taSegunda5.setVisible(false);
        taSegunda6.setVisible(false);
        taSegunda7.setVisible(false);
        taSegunda8.setVisible(false);
        
        taTerca1.setVisible(false);
        taTerca2.setVisible(false);
        taTerca3.setVisible(false);
        taTerca4.setVisible(false);
        taTerca5.setVisible(false);
        taTerca6.setVisible(false);
        taTerca7.setVisible(false);
        taTerca8.setVisible(false);
        
        taQuarta1.setVisible(false);
        taQuarta2.setVisible(false);
        taQuarta3.setVisible(false);
        taQuarta4.setVisible(false);
        taQuarta5.setVisible(false);
        taQuarta6.setVisible(false);
        taQuarta7.setVisible(false);
        taQuarta8.setVisible(false);
        
        taQuinta1.setVisible(false);
        taQuinta2.setVisible(false);
        taQuinta3.setVisible(false);
        taQuinta4.setVisible(false);
        taQuinta5.setVisible(false);
        taQuinta6.setVisible(false);
        taQuinta7.setVisible(false);
        taQuinta8.setVisible(false);
        
        taSexta1.setVisible(false);
        taSexta2.setVisible(false);
        taSexta3.setVisible(false);
        taSexta4.setVisible(false);
        taSexta5.setVisible(false);
        taSexta6.setVisible(false);
        taSexta7.setVisible(false);
        taSexta8.setVisible(false);
        
        taSabado1.setVisible(false);
        taSabado2.setVisible(false);
        taSabado3.setVisible(false);
        taSabado4.setVisible(false);
        taSabado5.setVisible(false);
        taSabado6.setVisible(false);
        taSabado7.setVisible(false);
        taSabado8.setVisible(false);
        
        taDomingo1.setVisible(false);
        taDomingo2.setVisible(false);
        taDomingo3.setVisible(false);
        taDomingo4.setVisible(false);
        taDomingo5.setVisible(false);
        taDomingo6.setVisible(false);
        taDomingo7.setVisible(false);
        taDomingo8.setVisible(false);
        
        btSalvarCronogramaDeEstudos.setDisable(true);
        btCancelarCronogramaDeEstudos.setDisable(true);
        btExcluirCronogramaEstudos.setDisable(false);
    }
    
    /**
     * Método para editar o Cronograma Acadêmico
     * @param event 
     */
    @FXML
    private void editarCronogramaAcademico(ActionEvent event) {
        cancelarCronogramaAcademico(event);
        coletaDadosCronogramaAcadêmico();
        
        taSeg1.setVisible(true);
        taSeg2.setVisible(true);
        taSeg3.setVisible(true);
        taSeg4.setVisible(true);
        
        taTer1.setVisible(true);
        taTer2.setVisible(true);
        taTer3.setVisible(true);
        taTer4.setVisible(true);
        
        taQuar1.setVisible(true);
        taQuar2.setVisible(true);
        taQuar3.setVisible(true);
        taQuar4.setVisible(true);
        
        taQuin1.setVisible(true);
        taQuin2.setVisible(true);
        taQuin3.setVisible(true);
        taQuin4.setVisible(true);
        
        taSex1.setVisible(true);
        taSex2.setVisible(true);
        taSex3.setVisible(true);
        taSex4.setVisible(true);
        
        taSab1.setVisible(true);
        taSab2.setVisible(true);
        taSab3.setVisible(true);
        taSab4.setVisible(true);
        
        btEditarCronogramaAcademico.setDisable(true);
        btCancelarCronogramaAcademico.setDisable(false);
        btSalvarCronogramaAcademico.setDisable(false);
        btExcluirCronogramaEstudos.setDisable(false);
    }
    
    /**
     * Método para salvar as edições do Cronograma Acadêmico
     * @param event 
     */
    @FXML
    private void salvarCronogramaAcademico(ActionEvent event) {
        lbSeg1.setText(taSeg1.getText().trim());
        lbSeg2.setText(taSeg2.getText().trim());
        lbSeg3.setText(taSeg3.getText().trim());
        lbSeg4.setText(taSeg4.getText().trim());
        
        lbTer1.setText(taTer1.getText().trim());
        lbTer2.setText(taTer2.getText().trim());
        lbTer3.setText(taTer3.getText().trim());
        lbTer4.setText(taTer4.getText().trim());
        
        lbQuar1.setText(taQuar1.getText().trim());
        lbQuar2.setText(taQuar2.getText().trim());
        lbQuar3.setText(taQuar3.getText().trim());
        lbQuar4.setText(taQuar4.getText().trim());
        
        lbQuin1.setText(taQuin1.getText().trim());
        lbQuin2.setText(taQuin2.getText().trim());
        lbQuin3.setText(taQuin3.getText().trim());
        lbQuin4.setText(taQuin4.getText().trim());
        
        lbSex1.setText(taSex1.getText().trim());
        lbSex2.setText(taSex2.getText().trim());
        lbSex3.setText(taSex3.getText().trim());
        lbSex4.setText(taSex4.getText().trim());
        
        lbSab1.setText(taSab1.getText().trim());
        lbSab2.setText(taSab2.getText().trim());
        lbSab3.setText(taSab3.getText().trim());
        lbSab4.setText(taSab4.getText().trim());
        
        lbAnoPeriodo.setText(tfAnoPeriodo.getText().trim());
        lbCodigoCurso.setText(tfCodigoCurso.getText().trim());
        lbCurso.setText(tfCurso.getText().trim().trim());
        lbSemestre.setText(tfSemestre.getText().trim());
        
        varSeg1 = taSeg1.getText().trim();
        varSeg2 = taSeg2.getText().trim();
        varSeg3 = taSeg3.getText().trim();
        varSeg4 = taSeg4.getText().trim();
        
        varTer1 = taTer1.getText().trim();
        varTer2 = taTer2.getText().trim();
        varTer3 = taTer3.getText().trim();
        varTer4 = taTer4.getText().trim();
        
        varQuar1 = taQuar1.getText().trim();
        varQuar2 = taQuar2.getText().trim();
        varQuar3 = taQuar3.getText().trim();
        varQuar4 = taQuar4.getText().trim();
        
        varQuin1 = taQuin1.getText().trim();
        varQuin2 = taQuin2.getText().trim();
        varQuin3 = taQuin3.getText().trim();
        varQuin4 = taQuin4.getText().trim();
        
        varSex1 = taSex1.getText().trim();
        varSex2 = taSex2.getText().trim();
        varSex3 = taSex3.getText().trim();
        varSex4 = taSex4.getText().trim();
        
        varSab1 = taSab1.getText().trim();
        varSab2 = taSab2.getText().trim();
        varSab3 = taSab3.getText().trim();
        varSab4 = taSab4.getText().trim();
        
        varCurso = tfCurso.getText().trim();
        varSemestre = tfSemestre.getText().trim();
        varCodigoCurso = tfCodigoCurso.getText().trim();
        varAnoPeriodo = tfAnoPeriodo.getText().trim();
        
        txtGravarCronogramaAcademico();
        cancelarCronogramaAcademico(event);
    }
    
    /**
     * Método para cancelar as edições do Cronograma Acadêmico
     * @param event 
     */
    @FXML
    private void cancelarCronogramaAcademico(ActionEvent event) {
        taSeg1.setVisible(false);
        taSeg2.setVisible(false);
        taSeg3.setVisible(false);
        taSeg4.setVisible(false);
        
        taTer1.setVisible(false);
        taTer2.setVisible(false);
        taTer3.setVisible(false);
        taTer4.setVisible(false);
        
        taQuar1.setVisible(false);
        taQuar2.setVisible(false);
        taQuar3.setVisible(false);
        taQuar4.setVisible(false);
        
        taQuin1.setVisible(false);
        taQuin2.setVisible(false);
        taQuin3.setVisible(false);
        taQuin4.setVisible(false);
        
        taSex1.setVisible(false);
        taSex2.setVisible(false);
        taSex3.setVisible(false);
        taSex4.setVisible(false);
        
        taSab1.setVisible(false);
        taSab2.setVisible(false);
        taSab3.setVisible(false);
        taSab4.setVisible(false);
        
        tfAnoPeriodo.setVisible(false);
        tfCodigoCurso.setVisible(false);
        tfCurso.setVisible(false);
        tfSemestre.setVisible(false);
        
        btEditarCronogramaAcademico.setDisable(false);
        btEditarCurso.setDisable(false);
        btCancelarCronogramaAcademico.setDisable(true);
        btSalvarCronogramaAcademico.setDisable(true);
    }
    
    /**
     * Método para carregar o cronograma de estudos
     */
    private void carregarCronogramaEstudos(){
        
        cronogramaEstudosDAO daoC = new cronogramaEstudosDAO();
        List<cronogramaEstudos> cronoEstudos = daoC.getCronogramaEstudos(sessao.getID_Usuario());
        
        lbSegunda1.setText(cronoEstudos.get(0).getSegunda1());
        lbSegunda2.setText(cronoEstudos.get(0).getSegunda2());
        lbSegunda3.setText(cronoEstudos.get(0).getSegunda3());
        lbSegunda4.setText(cronoEstudos.get(0).getSegunda4());
        lbSegunda5.setText(cronoEstudos.get(0).getSegunda5());
        lbSegunda6.setText(cronoEstudos.get(0).getSegunda6());
        lbSegunda7.setText(cronoEstudos.get(0).getSegunda7());
        lbSegunda8.setText(cronoEstudos.get(0).getSegunda8());
        
        lbTerca1.setText(cronoEstudos.get(0).getTerca1());
        lbTerca2.setText(cronoEstudos.get(0).getTerca2());
        lbTerca3.setText(cronoEstudos.get(0).getTerca3());
        lbTerca4.setText(cronoEstudos.get(0).getTerca4());
        lbTerca5.setText(cronoEstudos.get(0).getTerca5());
        lbTerca6.setText(cronoEstudos.get(0).getTerca6());
        lbTerca7.setText(cronoEstudos.get(0).getTerca7());
        lbTerca8.setText(cronoEstudos.get(0).getTerca8());
        
        lbQuarta1.setText(cronoEstudos.get(0).getQuarta1());
        lbQuarta2.setText(cronoEstudos.get(0).getQuarta2());
        lbQuarta3.setText(cronoEstudos.get(0).getQuarta3());
        lbQuarta4.setText(cronoEstudos.get(0).getQuarta4());
        lbQuarta5.setText(cronoEstudos.get(0).getQuarta5());
        lbQuarta6.setText(cronoEstudos.get(0).getQuarta6());
        lbQuarta7.setText(cronoEstudos.get(0).getQuarta7());
        lbQuarta8.setText(cronoEstudos.get(0).getQuarta8());
        
        lbQuinta1.setText(cronoEstudos.get(0).getQuinta1());
        lbQuinta2.setText(cronoEstudos.get(0).getQuinta2());
        lbQuinta3.setText(cronoEstudos.get(0).getQuinta3());
        lbQuinta4.setText(cronoEstudos.get(0).getQuinta4());
        lbQuinta5.setText(cronoEstudos.get(0).getQuinta5());
        lbQuinta6.setText(cronoEstudos.get(0).getQuinta6());
        lbQuinta7.setText(cronoEstudos.get(0).getQuinta7());
        lbQuinta8.setText(cronoEstudos.get(0).getQuinta8());
        
        lbSexta1.setText(cronoEstudos.get(0).getSexta1());
        lbSexta2.setText(cronoEstudos.get(0).getSexta2());
        lbSexta3.setText(cronoEstudos.get(0).getSexta3());
        lbSexta4.setText(cronoEstudos.get(0).getSexta4());
        lbSexta5.setText(cronoEstudos.get(0).getSexta5());
        lbSexta6.setText(cronoEstudos.get(0).getSexta6());
        lbSexta7.setText(cronoEstudos.get(0).getSexta7());
        lbSexta8.setText(cronoEstudos.get(0).getSexta8());
        
        lbSabado1.setText(cronoEstudos.get(0).getSabado1());
        lbSabado2.setText(cronoEstudos.get(0).getSabado2());
        lbSabado3.setText(cronoEstudos.get(0).getSabado3());
        lbSabado4.setText(cronoEstudos.get(0).getSabado4());
        lbSabado5.setText(cronoEstudos.get(0).getSabado5());
        lbSabado6.setText(cronoEstudos.get(0).getSabado6());
        lbSabado7.setText(cronoEstudos.get(0).getSabado7());
        lbSabado8.setText(cronoEstudos.get(0).getSabado8());
        
        lbDomingo1.setText(cronoEstudos.get(0).getDomingo1());
        lbDomingo2.setText(cronoEstudos.get(0).getDomingo2());
        lbDomingo3.setText(cronoEstudos.get(0).getDomingo3());
        lbDomingo4.setText(cronoEstudos.get(0).getDomingo4());
        lbDomingo5.setText(cronoEstudos.get(0).getDomingo5());
        lbDomingo6.setText(cronoEstudos.get(0).getDomingo6());
        lbDomingo7.setText(cronoEstudos.get(0).getDomingo7());
        lbDomingo8.setText(cronoEstudos.get(0).getDomingo8());
    }
    
    /**
     * Método para salvar os dados do cronograma academico em arquivo
     */
    private void txtGravarCronogramaAcademico(){
        UsuarioM u = new UsuarioM();
        
        try {
            new File(sessao.getNome() + " " + sessao.getSobrenome()).mkdir();
            FileWriter fw = new FileWriter(sessao.getNome() + " " + sessao.getSobrenome() + "/Cronograma Acadêmico.dat");
            PrintWriter pw = new PrintWriter(fw);
            
            pw.println("1;" + this.varSeg1);
            pw.println("2;" + this.varSeg2);
            pw.println("3;" + this.varSeg3);
            pw.println("4;" + this.varSeg4);
            
            pw.println("5;" + this.varTer1);
            pw.println("6;" + this.varTer2);
            pw.println("7;" + this.varTer3);
            pw.println("8;" + this.varTer4);
            
            pw.println("9;" + this.varQuar1);
            pw.println("10;" + this.varQuar2);
            pw.println("11;" + this.varQuar3);
            pw.println("12;" + this.varQuar4);
            
            pw.println("13;" + this.varQuin1);
            pw.println("14;" + this.varQuin2);
            pw.println("15;" + this.varQuin3);
            pw.println("16;" + this.varQuin4);
            
            pw.println("17;" + this.varSex1);
            pw.println("18;" + this.varSex2);
            pw.println("19;" + this.varSex3);
            pw.println("20;" + this.varSex4);
            
            pw.println("21;" + this.varSab1);
            pw.println("22;" + this.varSab2);
            pw.println("23;" + this.varSab3);
            pw.println("24;" + this.varSab4);
            
            pw.println("25;" + this.varCurso);
            pw.println("26;" + this.varSemestre);
            pw.println("27;" + this.varCodigoCurso);
            pw.println("28;" + this.varAnoPeriodo);
            
            pw.flush();
            pw.close();
            fw.close();
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Salvo com sucesso!");
            alert.show();
            
        } catch (IOException ex) {
            
        }
    }
    
    /**
     * Método para ler o arquivo Cronograma Academico
     */
    private void txtLerCronogramaAcademico(){
        String conteudo = "";
        String caminho = sessao.getNome() + " " + sessao.getSobrenome() + "/Cronograma Acadêmico.dat";
        
        try {
            FileReader arq = new FileReader(caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";
            
            try {
                linha = lerArq.readLine();
                while (linha != null) {                    
                    conteudo += linha + "\n";
                    linha = lerArq.readLine();
                    
                    String IDCronogramaAcademico = conteudo.split(";")[0];
                    String nomeCronogramaAcademico = conteudo.split(";")[1];
                    
                    switch(IDCronogramaAcademico)
                    {
                        case "1":
                            lbSeg1.setText(nomeCronogramaAcademico + "");
                            break;
                        case "2":
                            lbSeg2.setText(nomeCronogramaAcademico + "");
                            break;
                        case "3":
                            lbSeg3.setText(nomeCronogramaAcademico + "");
                            break;
                        case "4":
                            lbSeg4.setText(nomeCronogramaAcademico + "");
                            break;
                            
                        case "5":
                            lbTer1.setText(nomeCronogramaAcademico + "");
                            break;
                        case "6":
                            lbTer2.setText(nomeCronogramaAcademico + "");
                            break;
                        case "7":
                            lbTer3.setText(nomeCronogramaAcademico + "");
                            break;
                        case "8":
                            lbTer4.setText(nomeCronogramaAcademico + "");
                            break; 
                            
                        case "9":
                            break;
                        case "10":
                            lbQuar2.setText(nomeCronogramaAcademico + "");
                            break;
                        case "11":
                            lbQuar3.setText(nomeCronogramaAcademico + "");
                            break;
                        case "12":
                            lbQuar4.setText(nomeCronogramaAcademico + "");
                            break; 
                            
                        case "13":
                            lbQuin1.setText(nomeCronogramaAcademico + "");
                            break;
                        case "14":
                            lbQuin2.setText(nomeCronogramaAcademico + "");
                            break;
                        case "15":
                            lbQuin3.setText(nomeCronogramaAcademico + "");
                            break;
                        case "16":
                            lbQuin4.setText(nomeCronogramaAcademico + "");
                            break;  
                            
                        case "17":
                            lbSex1.setText(nomeCronogramaAcademico + "");
                            break;
                        case "18":
                            lbSex2.setText(nomeCronogramaAcademico + "");
                            break;
                        case "19":
                            lbSex3.setText(nomeCronogramaAcademico + "");
                            break;
                        case "20":
                            lbSex4.setText(nomeCronogramaAcademico + "");
                            break; 
                            
                        case "21":
                            lbSab1.setText(nomeCronogramaAcademico + "");
                            break;
                        case "22":
                            lbSab2.setText(nomeCronogramaAcademico + "");
                            break;
                        case "23":
                            lbSab3.setText(nomeCronogramaAcademico + "");
                            break;
                        case "24":
                            lbSab4.setText(nomeCronogramaAcademico + "");
                            break; 
                        case "25":
                            lbCurso.setText(nomeCronogramaAcademico + "");
                            break;
                        case "26":
                            lbSemestre.setText(nomeCronogramaAcademico + "");
                            break; 
                        case "27":
                            lbCodigoCurso.setText(nomeCronogramaAcademico + "");
                            break;
                        case "28":
                            lbAnoPeriodo.setText(nomeCronogramaAcademico + "");
                            break;
                    }
                    conteudo = "";
                }
                arq.close();
            } catch (IOException e) {
            }
            
        } catch (FileNotFoundException e) {
        }
    }
    
    /**
     * Método para sair da tela Minha Conta
     * @param event 
     */
    @FXML
    private void sairMinhaConta(ActionEvent event) {
        anchorMinhaConta.setVisible(false);
        lbPainelNavegacao.setVisible(false);
        btMinhaContaUsuario.setDisable(false);
        cancelarMinhaConta(event);
        cancelarAlterarSenha(event);
    }
    
    /**
     * Método que prepara os campos para receberem 
     * os dados da conta a serem editados
     * @param event 
     */
    @FXML
    private void editarMinhaConta(ActionEvent event) {
        btSalvarMinhaConta.setVisible(true);
        btCancelarMinhaConta.setVisible(true);
        btEditarMinhaConta.setVisible(false);
        btSairMinhaConta.setVisible(false);
        btExcluirMinhaConta.setVisible(false);
        
        
        lbPainelNavegacao.setVisible(false);
        
        lbSenha.setVisible(true);
        
        lbmostrarNome.setVisible(false);
        lbMostrarSobrenome.setVisible(false);
        lbMostrarEmail.setVisible(false);
        lbMostrarTelefone.setVisible(false);
        
        tfNome.setVisible(true);
        tfSobrenome.setVisible(true);
        tfEmail.setVisible(true);
        tfTelefone.setVisible(true);
        tfSenha.setVisible(true);
        
        tfNome.setText(lbmostrarNome.getText().trim());
        tfSobrenome.setText(lbMostrarSobrenome.getText().trim());
        tfTelefone.setText(lbMostrarTelefone.getText().trim());
        tfEmail.setText(lbMostrarEmail.getText().trim());
    }
    
    /**
     * Método para excluir a conta do usuário
     * @param event 
     */
    @FXML
    private void excluirMinhaConta(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Minha Conta");
            alert.setHeaderText("Todos os seus dados serão excluídos.");
            alert.setContentText("Você tem certeza disso?");
        
            ButtonType buttonTypeSim = new ButtonType("Sim");
            ButtonType buttonTypeCancelar = new ButtonType("Cancelar");
            
            alert.getButtonTypes().setAll(buttonTypeSim, buttonTypeCancelar);
        
            Optional<ButtonType> resultado = alert.showAndWait();
            if(resultado.get() == buttonTypeSim){
                TextInputDialog excluir = new TextInputDialog();
        
                excluir.setTitle("Minha Conta");
                excluir.setHeaderText("Digite sua senha");
                excluir.setContentText("Senha:");

                Optional <String> result = excluir.showAndWait();

                if(result.isPresent()){
                    String validar = result.get();
                    if(validar.equals(sessao.getSenha())){
                        
                        UsuarioM u = new UsuarioM();
                        UsuarioDAO daoU = new UsuarioDAO();
                        u.setID_Usuario(sessao.getID_Usuario());

                        Ranking r = new Ranking();
                        RankingDAO daoR = new RankingDAO();
                        r.setID_Usuario(sessao.getID_Usuario());

                        Links l = new Links();
                        LinksDAO daoL = new LinksDAO();
                        l.setID_Usuario(sessao.getID_Usuario());

                        LoginM lo = new LoginM();
                        LoginDAO daoLo = new LoginDAO();
                        lo.setID_Usuario(sessao.getID_Usuario());

                        Agenda a = new Agenda();
                        AgendaDAO daoA = new AgendaDAO();
                        a.setID_Usuario(sessao.getID_Usuario());
                        
                        cronogramaEstudos c = new cronogramaEstudos();
                        cronogramaEstudosDAO daoC = new cronogramaEstudosDAO();
                        c.setID_Usuario(sessao.getID_Usuario());

                        try {
                            daoLo.deleteLoginUsuario(lo);
                            daoR.delete(r);
                            daoL.deleteUserLink(l);
                            daoA.deleteAll(a);
                            daoC.delete(c);
                            daoU.delete(u);

                            new File(sessao.getNome() + " " + sessao.getSobrenome()).mkdir();
                            FileWriter fw = new FileWriter(sessao.getNome() + " " + sessao.getSobrenome() + "/Cronograma de Estudos.dat");
                            PrintWriter pw = new PrintWriter(fw);
                            
                            FileWriter fw2 = new FileWriter(sessao.getNome() + " " + sessao.getSobrenome() + "/Cronograma Acadêmico.dat");
                            PrintWriter pw2 = new PrintWriter(fw);
                            
                            pw.flush();
                            pw.close();
                            fw.close();
                            
                            pw2.flush();
                            pw2.close();
                            fw2.close();
                            
                            Alert alert1 = new Alert(Alert.AlertType.WARNING);
                            alert1.setTitle("Sistema Acadêmico de Estudos");
                            alert1.setHeaderText("Conta excluída com sucesso.");
                            alert1.showAndWait();

                            Usuario.getStage().close();
                            Login login = new Login();
                            login.start(new Stage());
                        } catch (Exception e) {
                        }
                    }else{
                        Alert alert2 = new Alert(Alert.AlertType.WARNING);
                        alert2.setTitle("Sistema Acadêmico de Estudos");
                        alert2.setHeaderText("Senha inválida.");
                        alert2.showAndWait();
                    }
                }
            }else{
                alert.close();
            }
    }
    
    /**
     * Método para salvar os dados da conta
     * @param event 
     */
    @FXML
    private void salvarMinhaConta(ActionEvent event) {
        boolean verificarEmail = true;
        
        try {
            if(tfEmail.getText().length() >= 1){
                UsuarioDAO daoU = new UsuarioDAO();
                List<UsuarioM> usuario = daoU.checkEmail(tfEmail.getText());
                
                if(tfEmail.getText().trim().equals(sessao.getEmail())){
                    btSalvarMinhaConta.setDisable(false);
                }else{
                    if(usuario.get(0).getEmail().equalsIgnoreCase(tfEmail.getText())){
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Sistema Acadêmico de Estudos");
                        alert.setHeaderText("Este email já existe.");
                        alert.setContentText("Por favor, tente outro email.");
                        alert.show();
                        
                        verificarEmail = false;
                    }
                }
            }
        } catch (Exception e) {
        }
        
        
        String tfValidar = tfSenha.getText();
        String validarSenha = sessao.getSenha();
        
        if(verificarEmail == true){
            if(tfValidar.equals(validarSenha)){
                UsuarioM u = new UsuarioM();

                u.setID_Usuario(sessao.getID_Usuario());
                u.setNome(tfNome.getText().trim());
                u.setSobrenome(tfSobrenome.getText().trim());
                u.setEmail(tfEmail.getText().trim());
                u.setTelefone(tfTelefone.getText().trim());
                u.setSenha(sessao.getSenha());

                UsuarioDAO uDAO = new UsuarioDAO();

                uDAO.update(u);

                lbmostrarNome.setText(tfNome.getText().trim());
                lbMostrarSobrenome.setText(tfSobrenome.getText().trim());
                lbMostrarTelefone.setText(tfTelefone.getText().trim());
                lbMostrarEmail.setText(tfEmail.getText().trim());

                cancelarMinhaConta(event);
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Sistema Acadêmico de Estudos");
                alert.setHeaderText("Senha inválida.");
                alert.setContentText("Verifique se os dados foram digitados corretamente.");
                alert.show();
            }
        }
    }
    
    /**
     * Método para cancelar as alterações dos dados da conta
     * @param event 
     */
    @FXML
    private void cancelarMinhaConta(ActionEvent event) {
        btSalvarMinhaConta.setVisible(false);
        btCancelarMinhaConta.setVisible(false);
        btEditarMinhaConta.setVisible(true);
        btSairMinhaConta.setVisible(true);
        btExcluirMinhaConta.setVisible(true);
        
        lbPainelNavegacao.setVisible(false);
        
        btEditarMinhaConta.setVisible(true);
        btSairMinhaConta.setVisible(true);
        btSalvarMinhaConta.setVisible(false);
        btCancelarMinhaConta.setVisible(false);
        
        lbSenha.setVisible(false);
        
        lbmostrarNome.setVisible(true);
        lbMostrarSobrenome.setVisible(true);
        lbMostrarEmail.setVisible(true);
        lbMostrarTelefone.setVisible(true);
        
        tfNome.setVisible(false);
        tfSobrenome.setVisible(false);
        tfEmail.setVisible(false);
        tfTelefone.setVisible(false);
        tfSenha.setVisible(false);
        
        tfSenha.setText("");
    }
    
    /**
     * Método para mostrar a tela Minha Contta
     * @param event 
     */
    @FXML
    private void minhaContaUsuario(ActionEvent event) {
        
        lbmostrarNome.setText(sessao.getNome());
        lbMostrarSobrenome.setText(sessao.getSobrenome());
        lbMostrarEmail.setText(sessao.getEmail());
        lbMostrarTelefone.setText(sessao.getTelefone());
        
        anchorMinhaConta.setVisible(true);
        lbPainelNavegacao.setVisible(false);
        anchorEdicaoSimulado.setVisible(false);
        anchorEditarSenha.setVisible(false);
        btHistoricoSimulados.setDisable(false);
        anchorHistoricoSimulados.setVisible(false);
        
        btMinhaContaUsuario.setDisable(true);
        btEditarSenha.setDisable(false);
        
        cancelarMinhaConta(event);
    }
    
    /**
     * Método que prepara os campos para receberem 
     * os dados do curso a serem editados
     * @param event 
     */
    @FXML
    private void editarCurso(ActionEvent event) {
        cancelarCronogramaAcademico(event);
        coletaDadosCronogramaAcadêmico();
        
        tfAnoPeriodo.setVisible(true);
        tfCodigoCurso.setVisible(true);
        tfCurso.setVisible(true);
        tfSemestre.setVisible(true);
        
        btEditarCurso.setDisable(true);
        btCancelarCronogramaAcademico.setDisable(false);
        btSalvarCronogramaAcademico.setDisable(false);
    }
    
    /**
     * Método que abre a tela de alteração de senha
     * @param event 
     */
    @FXML
    private void editarSenha(ActionEvent event) {
        anchorEdicaoSimulado.setVisible(false);
        anchorMinhaConta.setVisible(false);
        anchorEditarSenha.setVisible(true);
        lbPainelNavegacao.setVisible(false);
        btHistoricoSimulados.setDisable(false);
        anchorHistoricoSimulados.setVisible(false);
        
        btMinhaContaUsuario.setDisable(false);
        btEditarSenha.setDisable(true);
    }
    
    /**
     * Método para salvar a nova senha
     * @param event 
     */
    @FXML
    private void salvarAlterarSenha(ActionEvent event) {
        UsuarioM u = new UsuarioM();
        UsuarioDAO daoU = new UsuarioDAO();
        
        String tfSenha = tfSenhaAtual.getText().trim();
        String validarSenha = sessao.getSenha();
        
        if(tfSenha.equals(validarSenha)){
            if(tfNovaSenha.getText().length() >= 1 &&
                    tfConfirmarNovaSenha.getText().length() >= 1){
                if(tfNovaSenha.getText().trim().equals(tfConfirmarNovaSenha.getText().trim())){
                    u.setEmail(sessao.getEmail());
                    u.setID_Usuario(sessao.getID_Usuario());
                    u.setNome(sessao.getNome());
                    u.setSobrenome(sessao.getSobrenome());
                    u.setTelefone(sessao.getTelefone());
                    u.setSenha(tfNovaSenha.getText().trim());

                    daoU.update(u);
                    
                    sessao.setSenha(tfNovaSenha.getText());

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Sistema Acadêmico de Estudos");
                    alert.setHeaderText("Senha alterada com sucesso.");
                    alert.showAndWait();

                    cancelarAlterarSenha(event);
                }else{
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Sistema Acadêmico de Estudos");
                    alert.setHeaderText("As senhas não coincidem.");
                    alert.showAndWait();
                }

                }else{
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Sistema Acadêmico de Estudos");
                    alert.setHeaderText("Por favor, preencha todos os campos.");
                    alert.showAndWait();
                }
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Sistema Acadêmico de Estudos");
                alert.setHeaderText("Senha atual inválida.");
                alert.showAndWait();
        }
    }
    
    /**
     * Método para cancelar a alteração de senha
     * @param event 
     */
    @FXML
    private void cancelarAlterarSenha(ActionEvent event) {
        anchorEditarSenha.setVisible(false);
        lbPainelNavegacao.setVisible(true);
        btEditarSenha.setDisable(false);
    }
    
    /**
     * Abrir a tela de links do usuário
     * @param event 
     */
    @FXML
    private void abrirLinks(ActionEvent event) {
        btMinhaContaUsuario.setDisable(false);
        btEditarSenha.setDisable(false);
        
        btHistoricoSimulados.setDisable(false);
        anchorHistoricoSimulados.setVisible(false);
        anchorLinks.setVisible(true);
        cancelarLink(event);
        tvLinks.getSelectionModel().clearSelection();
    }
    
    /**
     * Sair da tela de links
     * @param event 
     */
    @FXML
    private void sairDeLinks(ActionEvent event) {
        anchorLinks.setVisible(false);
        anchorEdicaoSimulado.setVisible(false);
        anchorMinhaConta.setVisible(false);
        sairMinhaConta(event);
        cancelarAlterarSenha(event);
    }
    
    /**
     * Preparar textfields e botões para receber um novo link
     * @param event 
     */
    @FXML
    private void adicionarLink(ActionEvent event) {
        btAdicionarLink.setVisible(false);
        btSairDeLinks.setVisible(false);
        btCopiarLink.setVisible(false);
        btExcluirLink.setVisible(false);
        btEditarLink.setVisible(false);
        btSalvarLink.setVisible(true);
        btCancelarLink.setVisible(true);
        tfDescricao.setVisible(true);
        tfLink.setVisible(true);
        
        tvLinks.getSelectionModel().clearSelection();
        
        lbmostrarNomeUsuario.setText(sessao.getNome() + " " + sessao.getSobrenome());
        
        tfDescricao.setText("");
        tfLink.setText("");
    }
    
    /**
     * Copiar um link para a área de transferência
     * @param event 
     */
    @FXML
    private void copiarLink(ActionEvent event) {
        java.awt.datatransfer.Clipboard copiar = Toolkit.getDefaultToolkit().getSystemClipboard();
        ClipboardOwner selecao = new StringSelection(lbMostrarLink.getText());
        copiar.setContents((Transferable) selecao, selecao);
    }

    /**
     * Excluir um link(só pode excluir o próprio link compartilhado)
     * @param event 
     */
    @FXML
    private void excluirLink(ActionEvent event) {
        LinksDAO daoL = new LinksDAO();
        
        daoL.delete(selecionandoLinks);
        
        
        lbmostrarNomeUsuario.setText("");
        lbMostrarDescricao.setText("");
        lbMostrarLink.setText("");
        
        tvLinks.getSelectionModel().clearSelection();
        
        initTableLinks();
    }
    
    @FXML
    private void editarLink(ActionEvent event) {
        tfDescricao.setText(lbMostrarDescricao.getText());
        tfLink.setText(lbMostrarLink.getText());
        
        lbMostrarDescricao.setVisible(false);
        lbMostrarLink.setVisible(false);
        
        tfLink.setVisible(true);
        tfDescricao.setVisible(true);
        
        btSalvarLinkAlterado.setVisible(true);
        btCancelarLink.setVisible(true);
        btEditarLink.setVisible(false);
        btExcluirLink.setVisible(false);
    }
    
    
    /**
     * Salvar o novo link
     * @param event 
     */
    @FXML
    private void salvarLink(ActionEvent event) {
        Links l = new Links();
        LinksDAO daoL = new LinksDAO();
        
        if(tfDescricao.getText().length() > 1 &&
                tfLink.getText().length() > 1){
            l.setID_Usuario(sessao.getID_Usuario());
            l.setNome(sessao.getNome() + " " + sessao.getSobrenome());
            l.setDescricao(tfDescricao.getText().trim());
            l.setLink(tfLink.getText().trim());

            daoL.insert(l);
            
            tvLinks.getSelectionModel().clearSelection();
            
            lbmostrarNomeUsuario.setText("");
            
            cancelarLink(event);
            
            initTableLinks();
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Links");
            alert.setContentText("Campo vazio.");
            alert.setHeaderText("Por favor, preencha todos os campos");
            alert.showAndWait();
        }
        
    }
    
    @FXML
    private void salvarLinkAlterado(ActionEvent event) {
        Links l = new Links();
        LinksDAO daoL = new LinksDAO();
        
        if(tfDescricao.getText().length() >= 1 && tfLink.getText().length() >= 1){
            l.setID_Link(selecionandoLinks.getID_Link());
            l.setDescricao(tfDescricao.getText().trim());
            l.setLink(tfLink.getText().trim());

            daoL.update(l);

            lbMostrarDescricao.setText(tfDescricao.getText().trim());
            lbMostrarLink.setText(tfLink.getText().trim());

            cancelarLink(event);

            initTableLinks();
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Links");
            alert.setContentText("Campo vazio.");
            alert.setHeaderText("Por favor, preencha todos os campos");
            alert.showAndWait();
        }
    }
    
    /**
     * Cancelar o salvamento do novo link
     * @param event 
     */
    @FXML
    private void cancelarLink(ActionEvent event) {
        btAdicionarLink.setVisible(true);
        btSairDeLinks.setVisible(true);
        btCopiarLink.setVisible(true);
        btExcluirLink.setVisible(true);
        btEditarLink.setVisible(true);
        btSalvarLink.setVisible(false);
        btSalvarLinkAlterado.setVisible(false);
        btCancelarLink.setVisible(false);
        tfDescricao.setVisible(false);
        tfLink.setVisible(false);
        
        lbMostrarDescricao.setVisible(true);
        lbMostrarLink.setVisible(true);
        
        tfLink.setVisible(false);
        tfDescricao.setVisible(false);
        
        lbmostrarNomeUsuario.setText("");
        lbMostrarDescricao.setText("");
        lbMostrarLink.setText("");
        
        if(tfDescricao.getText().length() < 1 || tfLink.getText().length() < 5){
            lbmostrarNomeUsuario.setText("");
            lbMostrarDescricao.setText("");
            lbMostrarLink.setText("");
        }
        
        if(selecionandoLinks != null){
            lbmostrarNomeUsuario.setText(selecionandoLinks.getNome());
            lbMostrarDescricao.setText(selecionandoLinks.getDescricao());
            lbMostrarLink.setText(selecionandoLinks.getLink());
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
    
    public void initTableLinks(){
        clmDescricaoLink.setCellValueFactory(new PropertyValueFactory("Descricao"));
        clmLinks.setCellValueFactory(new PropertyValueFactory("Link"));
        tvLinks.setItems(atualizaTabelaLinks());
    }
    
    public ObservableList<Links> atualizaTabelaLinks(){
        LinksDAO daoL = new LinksDAO();
        return FXCollections.observableArrayList(daoL.getList());
    }
    
    public void initTableMateriasSimulado(){
        clmMateriasConfig.setCellValueFactory(new PropertyValueFactory("Nome"));
        tvMateriasConfig.setItems(atualizaTabelasMateriasSimulado());
    }
    
    public ObservableList<Materias> atualizaTabelasMateriasSimulado(){
        MateriasDAO daoM = new MateriasDAO();
        return FXCollections.observableArrayList(daoM.getMateriasSimulado(INIT_DIF));
    }
    
    public void initTableRanking(){
        clmPosicao.setCellValueFactory(new PropertyValueFactory("Posicao"));
        clmNomeUsuarioRanking.setCellValueFactory(new PropertyValueFactory("Nome"));
        clmSobrenomeUsuarioRanking.setCellValueFactory(new PropertyValueFactory("Sobrenome"));
        clmPontuacaoDia.setCellValueFactory(new PropertyValueFactory("scoreDia"));
        clmPontuacaoTotal.setCellValueFactory(new PropertyValueFactory("scoreTotal"));
        tvRanking.setItems(atualizaTabelaRanking());
    }
    
    public ObservableList<Ranking> atualizaTabelaRanking(){
        RankingDAO daoR = new RankingDAO();
        return FXCollections.observableArrayList(daoR.getListForUser());
    }
    
    public void initTableAgenda(){
        clmDescricaoAgenda.setCellValueFactory(new PropertyValueFactory("Descricao"));
        clmDataAgenda.setCellValueFactory(new PropertyValueFactory("Data"));
        tvAgenda.setItems(atualizaTabelaAgenda());
    }
    
    public ObservableList<Agenda> atualizaTabelaAgenda(){
        AgendaDAO daoA = new AgendaDAO();
        return FXCollections.observableArrayList(daoA.getList(sessao.getID_Usuario()));
    }
    
    public void atualizarScoreDia(){
        Ranking r = new Ranking();
        RankingDAO daoR = new RankingDAO();
        daoR.updateData(r);
    }

    @FXML
    private void sairHistoricoSimulados(ActionEvent event) {
        btHistoricoSimulados.setDisable(false);
        anchorHistoricoSimulados.setVisible(false);
        anchorEdicaoSimulado.setVisible(false);
        anchorEditarSenha.setVisible(false);
        anchorLinks.setVisible(false);
        anchorMinhaConta.setVisible(false);
        lbPainelNavegacao.setVisible(true);
    }

    @FXML
    private void abrirHistoricoSimulados(ActionEvent event) {
        historicoSimulado();
        btMinhaContaUsuario.setDisable(false);
        btEditarSenha.setDisable(false);
        
        anchorHistoricoSimulados.setVisible(true);
        anchorEdicaoSimulado.setVisible(false);
        anchorEditarSenha.setVisible(false);
        anchorLinks.setVisible(false);
        anchorMinhaConta.setVisible(false);
        btHistoricoSimulados.setDisable(true);
    }
    
    public void historicoSimulado(){
        RankingDAO daoR = new RankingDAO();
        List<Ranking> ranking = daoR.getUsuario(sessao.getID_Usuario());
        
        lbAcertos.setText(ranking.get(0).getAcertos() + "");
        lbErros.setText(ranking.get(0).getErros()+ "");
        lbIgnorados.setText(ranking.get(0).getIgnorados()+ "");
        lbTotalSimulados.setText(ranking.get(0).getTotalSimulados()+ "");
        lbPontuacaoDia.setText(ranking.get(0).getScoreDia()+ "");
        lbPontuacaoTotal.setText(ranking.get(0).getScoreTotal()+ "");
    }

    @FXML
    private void detectarEmailExistente(MouseEvent event) {
        btSalvarMinhaConta.setDisable(false);
        
        try {
            if(tfEmail.getText().length() >= 1){
                UsuarioDAO daoU = new UsuarioDAO();
                List<UsuarioM> usuario = daoU.checkEmail(tfEmail.getText());
                
                if(tfEmail.getText().trim().equals(sessao.getEmail())){
                    btSalvarMinhaConta.setDisable(false);
                }else{
                    if(usuario.get(0).getEmail().equalsIgnoreCase(tfEmail.getText())){
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Sistema Acadêmico de Estudos");
                        alert.setHeaderText("Este email já existe.");
                        alert.setContentText("Por favor, tente outro email.");
                        alert.show();
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    @FXML
    private void abrirAgenda(ActionEvent event) {
        initTableAgenda();
        tvAgenda.getSelectionModel().clearSelection();
        
        anchorAgenda.setVisible(true);
        
        paneCronogramaEstudos.setVisible(false);
        anchorEdicaoSimulado.setVisible(false);
        anchorEditarSenha.setVisible(false);
        anchorMinhaConta.setVisible(false);
        btHistoricoSimulados.setDisable(false);
        anchorHistoricoSimulados.setVisible(false);
        
        cancelarAgenda(event);
        cancelarMinhaConta(event);
        cancelarAlterarSenha(event);
    }
    
    @FXML
    private void sairDeAgenda(ActionEvent event) {
        anchorAgenda.setVisible(false);
    }

    @FXML
    private void adicionarAgenda(ActionEvent event) {
        btAdicionarAgenda.setVisible(false);
        btExcluirAgenda.setVisible(false);
        btEditarAgenda.setVisible(false);
        btSalvarAgenda.setVisible(true);
        btCancelarAgenda.setVisible(true);
        tfAgenda.setVisible(true);
        calendarAgenda.setVisible(true);
        
        tvAgenda.getSelectionModel().clearSelection();
    }

    @FXML
    private void excluirAgenda(ActionEvent event) {
        if(selecionandoAgenda != null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Agenda");
            alert.setHeaderText("Este evento será excluído.");
            alert.setContentText("Você tem certeza disso?");
        
            ButtonType buttonTypeSim = new ButtonType("Sim");
            ButtonType buttonTypeCancelar = new ButtonType("Cancelar");
            
            alert.getButtonTypes().setAll(buttonTypeSim, buttonTypeCancelar);
        
            Optional<ButtonType> resultado = alert.showAndWait();
            if(resultado.get() == buttonTypeSim){
                AgendaDAO daoA = new AgendaDAO();
                daoA.delete(selecionandoAgenda);

                cancelarNovaAgenda();
                initTableAgenda();
            }else{
                alert.close();
            }
        }
    }

    @FXML
    private void salvarAgenda(ActionEvent event) {
        
        if(tfAgenda.getText().length() >= 1){
            java.sql.Date date =java.sql.Date.valueOf(calendarAgenda.getValue());
            
            Agenda a = new Agenda();
            AgendaDAO daoA = new AgendaDAO();

            daoA.insert(sessao.getID_Usuario(), tfAgenda.getText().trim(), date.toString());

            cancelarNovaAgenda();
            
            initTableAgenda();
            
            btEditarAgenda.setDisable(true);
            btExcluirAgenda.setDisable(true);
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Sistema Acadêmico de Estudos");
            alert.setHeaderText("Campo vazio.");
            alert.setContentText("Por favor, preencha todos os campos.");
            alert.show();
        }
    }

    @FXML
    private void salvarAgendaAlterada(ActionEvent event) {
        AgendaDAO daoA = new AgendaDAO();
        Agenda a = new Agenda();
        
        if(tfAgenda.getText().length() >= 1){
            java.sql.Date date =java.sql.Date.valueOf(calendarAgenda.getValue());
        
            a.setDescricao(tfAgenda.getText().trim());
            a.setDate(date.toString());
            a.setID_Agenda(selecionandoAgenda.getID_Agenda());

            daoA.update(a);

            initTableAgenda();

            btAdicionarAgenda.setVisible(true);
            btEditarAgenda.setVisible(true);
            btExcluirAgenda.setVisible(true);
            lbDataAgenda.setVisible(true);
            lbDescricaoAgenda.setVisible(true);

            btSalvarAgendaAlterada.setVisible(false);
            btCancelarAgenda.setVisible(false);
            tfAgenda.setVisible(false);
            calendarAgenda.setVisible(false);

            lbDescricaoAgenda.setText(tfAgenda.getText().trim());
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Agenda");
            alert.setHeaderText("Campo vazio.");
            alert.setContentText("Por favor, preencha todos os campos.");
            alert.show();
        }
    }

    @FXML
    private void cancelarAgenda(ActionEvent event) {
        cancelarNovaAgenda();
        
        if(selecionandoAgenda != null){
            lbDescricaoAgenda.setText(selecionandoAgenda.getDescricao());
            lbDataAgenda.setText(selecionandoAgenda.getData());
        }
    }
    
    public void cancelarNovaAgenda(){
        lbDescricaoAgenda.setVisible(true);
        lbDataAgenda.setVisible(true);
        
        btEditarAgenda.setVisible(true);
        btExcluirAgenda.setVisible(true);
        btAdicionarAgenda.setVisible(true);
        btSalvarAgenda.setVisible(false);
        btCancelarAgenda.setVisible(false);
        
        tfAgenda.setVisible(false);
        calendarAgenda.setVisible(false);
        
        lbDescricaoAgenda.setText("");
        lbDataAgenda.setText("");
        
        tfAgenda.setText("");
    }

    @FXML
    private void editarAgenda(ActionEvent event) {
        btEditarAgenda.setVisible(false);
        btExcluirAgenda.setVisible(false);
        btAdicionarAgenda.setVisible(false);
        
        btSalvarAgendaAlterada.setVisible(true);
        btCancelarAgenda.setVisible(true);
        tfAgenda.setVisible(true);
        
        lbDescricaoAgenda.setVisible(false);
        lbDataAgenda.setVisible(false);
        calendarAgenda.setVisible(true);
        
        tfAgenda.setText(lbDescricaoAgenda.getText().trim());
    }

}