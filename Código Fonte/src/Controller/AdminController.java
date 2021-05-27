/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AgendaDAO;
import DAO.LinksDAO;
import DAO.MateriasDAO;
import DAO.PerguntasDAO;
import DAO.RankingDAO;
import DAO.UsuarioDAO;
import Model.Agenda;
import Model.Links;
import Model.Materias;
import Model.Perguntas;
import Model.Ranking;
import Model.Sessao;
import Model.UsuarioM;
import Stage.Admin;
import Stage.Login;
import Stage.TextFieldFormatter;
import java.awt.Toolkit;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.net.URL;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Anderson
 */
public class AdminController implements Initializable {

    @FXML
    private BorderPane paneUsuario;
    @FXML
    private StackPane stackNavegacao;
    @FXML
    private Label lbPainelNavegacao;
    @FXML
    private AnchorPane anchorAdministradores;
    @FXML
    private Button btSairAdmin;
    @FXML
    private Button btSalvarAdmin;
    @FXML
    private Button btNovoAdmin;
    @FXML
    private Button btCancelarNovoAdmin;
    @FXML
    private Label lbNome;
    @FXML
    private TextField tfNome;
    @FXML
    private Label lbSobrenome;
    @FXML
    private TextField tfSobrenome;
    @FXML
    private Label lbTelefone;
    @FXML
    private Label lbConfirmarSenha;
    @FXML
    private TextField tfTelefone;
    @FXML
    private PasswordField tfConfirmarSenha;
    @FXML
    private Label lbSenha;
    @FXML
    private PasswordField tfSenha;
    @FXML
    private Label lbEmail;
    @FXML
    private TextField tfEmail;
    @FXML
    private GridPane gpAdministradores;
    @FXML
    private Label lbMostrarTelefone;
    @FXML
    private Label lbMostrarEmail;
    @FXML
    private Label lbMostrarSobrenome;
    @FXML
    private Label lbmostrarNome;
    @FXML
    private Label lbDadosPessoaisOuCadastro;
    @FXML
    private AnchorPane anchorUsuarios;
    @FXML
    private TableView<UsuarioM> tvAdministradores;
    @FXML
    private TableColumn<UsuarioM, String> clmNomeAdministrador;
    @FXML
    private TableColumn<UsuarioM, String> clmSobrenomeAdministrador;
    @FXML
    private TableView<UsuarioM> tvUsuarios;
    @FXML
    private TableColumn<UsuarioM, String> clmNomeUsuario;
    @FXML
    private TableColumn<UsuarioM, String> clmSobrenomeUsuario;
    @FXML
    private TableView<Materias> tvMaterias;
    @FXML
    private TableColumn<Materias, String> clmMaterias;
    @FXML
    private TableView<Links> tvLinks;
    @FXML
    private TableColumn<Links, String> clmDescricaoLink;
    @FXML
    private TableColumn<Links, String> clmLink;
    @FXML
    private TableView<Ranking> tvRanking;
    @FXML
    private TableColumn<Ranking, String> clmPosicao;
    @FXML
    private TableColumn<Ranking, String> clmNomeNoRanking;
    @FXML
    private TableColumn<Ranking, String> clmSobrenomeNoRanking;
    @FXML
    private TableColumn<Ranking, String> clmPontuacaoDoDia;
    @FXML
    private TableColumn<Ranking, String> clmPontuacaoTotal;
    @FXML
    private TableColumn<Ranking, Integer> clmAcertos;
    @FXML
    private TableColumn<Ranking, Integer> clmErros;
    @FXML
    private TableColumn<Ranking, Integer> clmIgnorados;
    @FXML
    private TableColumn<Ranking, Integer> clmTotalSimulados;
    @FXML
    private TableView<Perguntas> tvPerguntas;
    @FXML
    private TableColumn<Perguntas, String> clmMateriaPerguntas;
    @FXML
    private TableColumn<Perguntas, String> clmDescricaoPerguntas;
    @FXML
    private ComboBox<Materias> cbDisciplina;
    @FXML
    private Button btDesabilitarUsuario;
    @FXML
    private Button btHabilitarUsuario;
    @FXML
    private Button btSairUsuarios;
    @FXML
    private Label lbMostrarTelefoneUsuario;
    @FXML
    private Label lbMostrarEmailUsuario;
    @FXML
    private Label lbMostrarSobrenomeUsuario;
    @FXML
    private Label lbmostrarNomeUsuario;
    @FXML
    private Label lbMostrarSItuacao;
    @FXML
    private AnchorPane anchorMaterias;
    @FXML
    private Button btSairMaterias;
    @FXML
    private Button btNovaMateria;
    @FXML
    private Button btCancelarNovaMateria;
    @FXML
    private Button btAdicionarMateria;
    @FXML
    private AnchorPane anchorPerguntas;
    @FXML
    private Button btCancelarPergunta;
    @FXML
    private Button btAdicionarQuestao;
    @FXML
    private Button btSairDePerguntas;
    @FXML
    private Slider sliderDificuldade;
    @FXML
    private Slider sliderValor;
    @FXML
    private TextArea taQuestao;
    @FXML
    private TextArea tfAlternativaA;
    @FXML
    private TextArea tfAlternativaE;
    @FXML
    private TextArea tfAlternativaD;
    @FXML
    private TextArea tfAlternativaC;
    @FXML
    private TextArea tfAlternativaB;
    @FXML
    private Label lbDificuldade;
    @FXML
    private Label lbValor;
    @FXML
    private RadioButton rbE;
    @FXML
    private RadioButton rbD;
    @FXML
    private RadioButton rbC;
    @FXML
    private RadioButton rbB;
    @FXML
    private RadioButton rbA;
    @FXML
    private ToggleGroup tGroupAlternativas;
    @FXML
    private AnchorPane anchorLinks;
    @FXML
    private Button btAdicionarLink;
    @FXML
    private MenuItem btSairDeLinks;
    @FXML
    private Label lbmostrarNomeUsuarioLink;
    @FXML
    private Label lbMostrarDescricao;
    @FXML
    private Label lbMostrarLink;
    @FXML
    private TextField tfDescricao;
    @FXML
    private TextField tfLink;
    @FXML
    private Button btCopiarLink;
    @FXML
    private Button btExcluirLink;
    @FXML
    private Button btSalvarLink;
    @FXML
    private Button btCancelarLink;
    @FXML
    private Button btEditarLink;
    @FXML
    private Button btSalvarLinkAlterado;
    @FXML
    private AnchorPane anchorRanking;
    @FXML
    private Button btSairDoRanking;
    @FXML
    private MenuItem btMinhaConta;
    @FXML
    private MenuItem btEditarSenha;
    @FXML
    private AnchorPane anchorMinhaConta;
    @FXML
    private Button btSairMinhaConta;
    @FXML
    private Button btEditarMinhaConta;
    @FXML
    private Button btSalvarMinhaConta;
    @FXML
    private Button btCancelarMinhaConta;
    @FXML
    private Label lbDadosPessoais;
    @FXML
    private Label lbNomeMinhaConta;
    @FXML
    private Label lbSobrenomeMinhaConta;
    @FXML
    private Label lbEmailMinhaConta;
    @FXML
    private Label lbTelefoneMinhaConta;
    @FXML
    private Label lbSenhaMinhaConta;
    @FXML
    private TextField tfNomeMinhaConta;
    @FXML
    private TextField tfSobrenomeMinhaConta;
    @FXML
    private TextField tfEmailMinhaConta;
    @FXML
    private TextField tfTelefoneMinhaConta;
    @FXML
    private PasswordField tfSenhaMinhaConta;
    @FXML
    private Label lbMostrarTelefoneMinhaConta;
    @FXML
    private Label lbMostrarEmailMinhaConta;
    @FXML
    private Label lbMostrarSobrenomeMinhaConta;
    @FXML
    private Label lbmostrarNomeMinhaConta;
    @FXML
    private AnchorPane anchorEditarSenha;
    @FXML
    private Button btSalvarAlterarSenha;
    @FXML
    private Button btCancelarAlterarSenha;
    @FXML
    private Label lbDadosPessoaisOuCadastro1;
    @FXML
    private Label lbSenhaAtual;
    @FXML
    private Label lbNovaSenha;
    @FXML
    private Label lbConfirmarNovaSenha;
    @FXML
    private PasswordField tfNovaSenha;
    @FXML
    private PasswordField tfConfirmarNovaSenha;
    @FXML
    private PasswordField tfSenhaAtual;
    @FXML
    private Menu menuBarTitle;
    @FXML
    private Button btExcluirMateria;
    @FXML
    private Label lbmostrarNomeMateria;
    @FXML
    private Label lbNovaMateria;
    @FXML
    private TextField tfNovaMateria;
    @FXML
    private Label lbDetalhesLink;
    @FXML
    private Button btListarPerguntas;
    @FXML
    private Button btSalvarEdicao;
    @FXML
    private Button btCancelarEdicao;
    @FXML
    private AnchorPane anchorListarPerguntas;
    @FXML
    private Button btExcluirQuestao;
    @FXML
    private Button btEditarQuestao;
    @FXML
    private Button btSairListarPerguntas;
    @FXML
    private Button btHabilitarMateria;
    @FXML
    private Label lbmostrarStatusMateria;
    @FXML
    private Button btDesabilitarMateria;
    @FXML
    private Label lbStatusMateria;
    @FXML
    private ComboBox<Materias> cbFiltroPerguntas;
    @FXML
    private TextField tfBuscarPerguntas;
    @FXML
    private TextField tfBuscarAdministrador;
    @FXML
    private Button btDesabilitarAdministradores;
    @FXML
    private Button btHabilitarAdministradores;
    @FXML
    private Button btExcluirAdministrador;
    @FXML
    private ComboBox<?> cbBuscarAdministradores;
    @FXML
    private ComboBox<?> cbBuscarUsuario;
    @FXML
    private TextField tfBuscarUsuario;
    @FXML
    private ComboBox<?> cbBuscarMateria;
    @FXML
    private TextField tfBuscarMateria;
    @FXML
    private Label lbStatusAdministrador;
    @FXML
    private Label lbMostrarStatusAdministrador;
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
    
    
    private static int INIT_VALOR = 1;
    private static int INIT_DIFICULDADE = 1;
    private UsuarioM selecionandoUsuario;
    private Links selecionandoLinks;
    private Materias selecionandoMaterias;
    private String alternativaSelecionada;
    private Perguntas selecionandoPerguntas;
    private Agenda selecionandoAgenda;
    
    Sessao sessao = Sessao.getInstancia();
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        menuBarTitle.setText(sessao.getNome() + " " + sessao.getSobrenome() + " ▼" );
        
        initTableMaterias();
        initTableUsuarios();
        initTableLinks();
        initTableAdministradores();
        detectarDificuldade();
        detectarValorPerguntas();
        
        sliderDificuldade.setOnMouseClicked((MouseEvent e)->{
            detectarDificuldade();
        });
        
        sliderValor.setOnMouseClicked((MouseEvent e)->{
            detectarValorPerguntas();
        });
        
        tvUsuarios.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selecionandoUsuario = (UsuarioM) newValue;
                
                lbmostrarNomeUsuario.setText(selecionandoUsuario.getNome());
                lbMostrarSobrenomeUsuario.setText(selecionandoUsuario.getSobrenome());
                lbMostrarEmailUsuario.setText(selecionandoUsuario.getEmail());
                lbMostrarTelefoneUsuario.setText(selecionandoUsuario.getTelefone());
                
                if(selecionandoUsuario.getUsuarioAtivo() == 1){
                    btDesabilitarUsuario.setDisable(false);
                    btHabilitarUsuario.setDisable(true);
                    lbMostrarSItuacao.setText("Habilitado");
                }else{
                    btDesabilitarUsuario.setDisable(true);
                    btHabilitarUsuario.setDisable(false);
                    lbMostrarSItuacao.setText("Desabilitado"); 
                }
                
            }
        });
        
        tvAdministradores.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selecionandoUsuario = (UsuarioM) newValue;
                
                lbmostrarNome.setText(selecionandoUsuario.getNome());
                lbMostrarSobrenome.setText(selecionandoUsuario.getSobrenome());
                lbMostrarEmail.setText(selecionandoUsuario.getEmail());
                lbMostrarTelefone.setText(selecionandoUsuario.getTelefone());
                btExcluirAdministrador.setDisable(false);
                
                if(selecionandoUsuario.getUsuarioAtivo() == 1){
                    btDesabilitarAdministradores.setDisable(false);
                    btHabilitarAdministradores.setDisable(true);
                    lbMostrarStatusAdministrador.setText("Habilitado");
                }else{
                    btDesabilitarAdministradores.setDisable(true);
                    btHabilitarAdministradores.setDisable(false);
                    lbMostrarStatusAdministrador.setText("Desabilitado");
                }
                
                if(selecionandoUsuario.getID_Usuario() == 2){
                    btDesabilitarAdministradores.setDisable(true);
                    btExcluirAdministrador.setDisable(true);
                }
            }
        });
        
        tvLinks.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selecionandoLinks = (Links) newValue;
                
                lbmostrarNomeUsuarioLink.setText(selecionandoLinks.getNome());
                lbMostrarDescricao.setText(selecionandoLinks.getDescricao());
                lbMostrarLink.setText(selecionandoLinks.getLink());
                
                if(selecionandoLinks.getID_Usuario() == sessao.getID_Usuario()){
                    btEditarLink.setDisable(false);
                }else{
                    btEditarLink.setDisable(true);
                }
                
                if(selecionandoLinks != null){
                    btExcluirLink.setDisable(false);
                }else{
                    btExcluirLink.setDisable(true);
                }
                
                lbmostrarNomeUsuarioLink.setVisible(true);
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
        
        tvMaterias.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selecionandoMaterias = (Materias) newValue;
                
                lbmostrarNomeMateria.setText(selecionandoMaterias.getNome());
                
                
                
                if(selecionandoMaterias != null){
                    lbStatusMateria.setVisible(true);
                    lbmostrarStatusMateria.setVisible(true);
                    lbmostrarNomeMateria.setVisible(true);
                    
                    tfNovaMateria.setVisible(false);
                    
                    btDesabilitarMateria.setVisible(true);
                    btHabilitarMateria.setVisible(true);
                    btExcluirMateria.setDisable(false);
                    btNovaMateria.setVisible(true);
                    btSairMaterias.setVisible(true);
                    btAdicionarMateria.setVisible(false);
                    btCancelarNovaMateria.setVisible(false);
                    btExcluirMateria.setVisible(true);
                }else{
                    btExcluirMateria.setDisable(true);
                }
                
                if(selecionandoMaterias.getIsAtiva() == 0){
                    btHabilitarMateria.setDisable(false);
                    btDesabilitarMateria.setDisable(true);
                    lbmostrarStatusMateria.setText("Desabilitado");
                }else{
                    btHabilitarMateria.setDisable(true);
                    btDesabilitarMateria.setDisable(false);
                    lbmostrarStatusMateria.setText("Habilitado");
                }
            }
        });
        
        cbDisciplina.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selecionandoMaterias = (Materias) newValue;
            }
        });
        
        cbFiltroPerguntas.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selecionandoMaterias = (Materias) newValue;
                initTablePerguntasComboBox();
                if(selecionandoMaterias.getNome() != null){
                    tfBuscarPerguntas.setText(selecionandoMaterias.getNome());
                }
            }
        });
        
        cbBuscarAdministradores.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                tfBuscarAdministrador.setText("");
                initTableAdministradoresEspecificos();
                if(cbBuscarAdministradores.getSelectionModel().getSelectedIndex() == 2){
                    initTableAdministradores();
                }
            }
        });
        
        cbBuscarUsuario.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                tfBuscarUsuario.setText("");
                initTableUsuariosEspecificos();
                if(cbBuscarUsuario.getSelectionModel().getSelectedIndex() == 2){
                    initTableUsuarios();
                }
            }
        });
        
        cbBuscarMateria.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                tfBuscarMateria.setText("");
                initTableMateriasEspecificas();
                if(cbBuscarMateria.getSelectionModel().getSelectedIndex() == 2){
                    initTableMaterias();
                }
            }
        });
        
        tvPerguntas.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selecionandoPerguntas = (Perguntas) newValue;
                
                
                
                if(selecionandoPerguntas != null){
                    recuperandoQuestaoSelecionada();
                    btEditarQuestao.setDisable(false);
                    btExcluirQuestao.setDisable(false);
                }else{
                    btEditarQuestao.setDisable(true);
                    btExcluirQuestao.setDisable(true);
                }
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
    
    
    /**
     * Método para detectar o nível de dificuldade
     */
    public void detectarDificuldade(){
        INIT_DIFICULDADE = (int) sliderDificuldade.getValue();
            switch(INIT_DIFICULDADE){
                case 1:
                    lbDificuldade.setText("Fácil");
                    sliderValor.setMin(1);
                    sliderValor.setMax(10);
                    sliderValor.setValue(1);
                    detectarValorPerguntas();
                    break;
                case 2:
                    lbDificuldade.setText("Médio");
                    sliderValor.setMin(11);
                    sliderValor.setMax(20);
                    sliderValor.setValue(11);
                    detectarValorPerguntas();
                    break;
                case 3:
                    lbDificuldade.setText("Difícil");
                    sliderValor.setMin(21);
                    sliderValor.setMax(30);
                    sliderValor.setValue(21);
                    detectarValorPerguntas();
                    break;
            }
    }
    
    /**
     * Método para detectar o valor das perguntas
     */
    public void detectarValorPerguntas(){
        INIT_VALOR = (int) sliderValor.getValue();
        lbValor.setText(new Integer(INIT_VALOR).toString());
    }
    
    /**
     * Método para limapar os campos para que possa adicionar uma nova pergunta
     * cada vez que uma for salva
     */
    public void limparCamposPerguntas(){
        taQuestao.setText("");
        tfAlternativaA.setText("");
        tfAlternativaB.setText("");
        tfAlternativaC.setText("");
        tfAlternativaD.setText("");
        tfAlternativaE.setText("");
        rbA.setSelected(false);
        rbB.setSelected(false);
        rbC.setSelected(false);
        rbD.setSelected(false);
        rbE.setSelected(false);
    }
        
    /**
     * Método para abrir a tela Minha Conta
     * @param event 
     */
    @FXML
    private void minhaContaUsuario(ActionEvent event) {
        sairListarPerguntas(event);
        
        if(sessao.getID_Usuario() != 2){
            tfNomeMinhaConta.setEditable(false);
            tfSobrenomeMinhaConta.setEditable(false);
        }
        
        lbmostrarNomeMinhaConta.setText(sessao.getNome());
        lbMostrarSobrenomeMinhaConta.setText(sessao.getSobrenome());
        lbMostrarEmailMinhaConta.setText(sessao.getEmail());
        lbMostrarTelefoneMinhaConta.setText(sessao.getTelefone());
        
        lbPainelNavegacao.setVisible(false);
        
        btMinhaConta.setDisable(true);
        
        anchorMinhaConta.setVisible(true);
        anchorAdministradores.setVisible(false);
        anchorLinks.setVisible(false);
        anchorMaterias.setVisible(false);
        anchorPerguntas.setVisible(false);
        anchorRanking.setVisible(false);
        anchorUsuarios.setVisible(false);
        
        cancelarAlterarSenha(event);
        cancelarLink(event);
        cancelarMinhaConta(event);
        cancelarNovaMateria(event);
        cancelarNovoAdministrador(event);
        cancelarQuestao(event);
    }

    /**
     * Método para abrir a tela com a lista de administradores
     * @param event 
     */
    @FXML
    private void painelAdministradores(ActionEvent event) {
        if(sessao.getID_Usuario() == 2){
            anchorAdministradores.setVisible(true);
            anchorUsuarios.setVisible(false);
            anchorMaterias.setVisible(false);
            anchorLinks.setVisible(false);
            anchorPerguntas.setVisible(false);
            anchorRanking.setVisible(false);
            anchorMinhaConta.setVisible(false);

            btMinhaConta.setDisable(false);

            initComboBoxAdministradoresEUsuario();
            initTableAdministradores();
            sairListarPerguntas(event);
            cancelarAlterarSenha(event);
            cancelarNovaMateria(event);
            cancelarNovoAdministrador(event); 
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Administradores");
            alert.setHeaderText("Você não é o Administrador Geral.");
            alert.setContentText("Área restrita ao Administrador Geral.");
            alert.showAndWait();
        }
    }
    
    /**
     * Método para abrir a tela com a lista de usuarios
     * @param event 
     */
    @FXML
    private void painelUsuarios(ActionEvent event) {
        sairListarPerguntas(event);
        
        lbmostrarNomeUsuario.setText("");
        lbMostrarSobrenomeUsuario.setText("");
        lbMostrarEmailUsuario.setText("");
        lbMostrarTelefoneUsuario.setText("");
        lbMostrarSItuacao.setText("");
        
        anchorUsuarios.setVisible(true);
        anchorPerguntas.setVisible(false);
        anchorLinks.setVisible(false);
        anchorMaterias.setVisible(false);
        anchorAdministradores.setVisible(false);
        anchorRanking.setVisible(false);
        anchorMinhaConta.setVisible(false);

        btMinhaConta.setDisable(false);
        
        tvUsuarios.getSelectionModel().clearSelection();
        
        btHabilitarUsuario.setDisable(true);
        btDesabilitarUsuario.setDisable(true);
        
        cancelarAlterarSenha(event);
        cancelarNovaMateria(event);
        cancelarNovoAdministrador(event);
    }
    
    /**
     * Método para sair da lista de usuarios
     * @param event 
     */
    @FXML
    private void sairDeUsuarios(ActionEvent event) {
        anchorLinks.setVisible(false);
        anchorAdministradores.setVisible(false);
        anchorMaterias.setVisible(false);
        anchorPerguntas.setVisible(false);
        anchorUsuarios.setVisible(false);
    }
    
    /**
     * Método para abrir a tela de matérias
     * @param event 
     */
    @FXML
    private void painelMaterias(ActionEvent event) {
        initComboBoxMaterias();
        
        anchorMaterias.setVisible(true);
        anchorAdministradores.setVisible(false);
        anchorUsuarios.setVisible(false);
        anchorLinks.setVisible(false);
        anchorPerguntas.setVisible(false);
        anchorRanking.setVisible(false);
        anchorMinhaConta.setVisible(false);
        
        btMinhaConta.setDisable(false);
        
        sairListarPerguntas(event);
        cancelarAlterarSenha(event);
        cancelarNovaMateria(event);
        cancelarNovoAdministrador(event);
    }
    
    /**
     * Método para abrir a tela de cadastro de perguntas
     * @param event 
     */
    @FXML
    private void painelPerguntas(ActionEvent event) {
        sairListarPerguntas(event);
        anchorPerguntas.setVisible(true);
        anchorAdministradores.setVisible(false);
        anchorMaterias.setVisible(false);
        anchorUsuarios.setVisible(false);
        anchorLinks.setVisible(false);
        anchorRanking.setVisible(false);
        anchorMinhaConta.setVisible(false);
        
        btMinhaConta.setDisable(false);
        
        cancelarAlterarSenha(event);
        
        INIT_VALOR = 1;
        INIT_DIFICULDADE = 1;
        sliderDificuldade.setValue(1);
        sliderValor.setValue(1);
        sliderValor.setMax(10);
        detectarDificuldade();
        lbValor.setText(1 + "");
        cbDisciplina.setPromptText("Selecione");
        initTableMaterias();
    }
    
    /**
     * Método para abrir a tela de ranking
     * @param event 
     */
    @FXML
    private void painelRanking(ActionEvent event) {
        sairListarPerguntas(event);
        initTableRanking();
        
        anchorRanking.setVisible(true);
        anchorAdministradores.setVisible(false);
        anchorLinks.setVisible(false);
        anchorMaterias.setVisible(false);
        anchorPerguntas.setVisible(false);
        anchorUsuarios.setVisible(false);
        anchorMinhaConta.setVisible(false);
        
        btMinhaConta.setDisable(false);
        
        cancelarAlterarSenha(event);
        cancelarLink(event);
        cancelarNovaMateria(event);
        cancelarNovoAdministrador(event);
        cancelarQuestao(event);
        
    }
    
    /**
     * Método para abrir a tela de links
     * @param event 
     */
    @FXML
    private void painelLinks(ActionEvent event) {
        sairListarPerguntas(event);
        
        anchorLinks.setVisible(true);
        anchorAdministradores.setVisible(false);
        anchorMaterias.setVisible(false);
        anchorPerguntas.setVisible(false);
        anchorUsuarios.setVisible(false);
        anchorRanking.setVisible(false);
        anchorMinhaConta.setVisible(false);
        
        tvLinks.getSelectionModel().clearSelection();
        
        btMinhaConta.setDisable(false);
        
        cancelarAlterarSenha(event);
        cancelarLink(event);
        cancelarNovaMateria(event);
        cancelarNovoAdministrador(event);
        cancelarQuestao(event);
    }
    
    /**
     * Desabilitar um usuário para que ele não possa mais fazer login
     * @param event 
     */
    @FXML
    private void desabilitarUsuarios(ActionEvent event) {
        UsuarioDAO daoU = new UsuarioDAO();
        UsuarioM u = new UsuarioM();
        
        u.setUsuarioAtivo(0);
        u.setID_Usuario(selecionandoUsuario.getID_Usuario());
        daoU.habilitarDesabilitar(u);
        
        lbMostrarSItuacao.setText("Desabilitado");
        btHabilitarUsuario.setDisable(false);
        btDesabilitarUsuario.setDisable(true);
        
        selecionandoUsuario.setUsuarioAtivo(0);
    }
    
    /**
     * Habilitar um usuário para que ele possa voltar a fazer login
     * @param event 
     */
    @FXML
    private void habilitarUsuarios(ActionEvent event) {
        UsuarioDAO daoU = new UsuarioDAO();
        UsuarioM u = new UsuarioM();
        
        u.setUsuarioAtivo(1);
        u.setID_Usuario(selecionandoUsuario.getID_Usuario());
        daoU.habilitarDesabilitar(u);
        
        lbMostrarSItuacao.setText("Habilitado");
        btHabilitarUsuario.setDisable(true);
        btDesabilitarUsuario.setDisable(false);
        selecionandoUsuario.setUsuarioAtivo(1);
    }
    
    /**
     * Método para fechar a tela de administradores e voltar ao login
     * @param event 
     */
    @FXML
    private void sairPainelAdministrador(ActionEvent event) {
        Admin.getStage().close();
        Login login = new Login();
        try {
            login.start(new Stage());
        } catch (Exception e) {
        }
        cancelarNovoAdministrador(event);
    }
    
    /**
     * Método para fechar a lista de administradores
     * @param event 
     */
    @FXML
    private void sairDeAdministradores(ActionEvent event) {
        anchorLinks.setVisible(false);
        anchorAdministradores.setVisible(false);
        anchorMaterias.setVisible(false);
        anchorPerguntas.setVisible(false);
        anchorUsuarios.setVisible(false);
    }
    
    /**
     * Método para salvar um novo administrador
     * @param event 
     */
    @FXML
    private void salvarNovoAdministrador(ActionEvent event) {
        String senha = tfSenha.getText().trim();
        String confirmarSenha = tfConfirmarSenha.getText().trim();
        
        UsuarioM u = new UsuarioM();
        UsuarioDAO uDAO = new UsuarioDAO();
        
        if(tfNome.getText().length() >= 1 && tfSobrenome.getText().length() >= 1
                && tfEmail.getText().length() >= 1 
                && tfSenha.getText().length() >= 1 
                && tfConfirmarSenha.getText().length() >= 1){
            if(senha.equals(confirmarSenha)){
                u.setNome(tfNome.getText());
                u.setSobrenome(tfSobrenome.getText());
                u.setSenha(tfSenha.getText());
                u.setEmail(tfEmail.getText());
                u.setTelefone(tfTelefone.getText());
                u.setIsAdm(1);

                uDAO.insert(u);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Administradores");
                alert.setHeaderText("Cadastrado com sucesso!");
                alert.showAndWait();

                initTableAdministradores();
                cancelarNovoAdministrador(event);
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Administradores");
                alert.setHeaderText("Senha incorreta.");
                alert.setContentText("Verifique se você digitou a senha corretamente.");
                alert.show();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Administradores");
            alert.setHeaderText("Campo vazio.");
            alert.setContentText("Por favor, preencha todos os campos.");
            alert.show();
        }
    }
    
    /**
     * Método para preparar os campos para receber informações
     * do novo administrador a ser salvo
     * @param event 
     */
    @FXML
    private void novoAdministrador(ActionEvent event) {
        btNovoAdmin.setVisible(false);
        btSairAdmin.setVisible(false);
        btHabilitarAdministradores.setVisible(false);
        btDesabilitarAdministradores.setVisible(false);
        btExcluirAdministrador.setVisible(false);
        lbStatusAdministrador.setVisible(false);
        lbMostrarStatusAdministrador.setVisible(false);
        
        btSalvarAdmin.setVisible(true);
        btCancelarNovoAdmin.setVisible(true);
        
        lbMostrarEmail.setVisible(false);
        lbMostrarSobrenome.setVisible(false);
        lbMostrarTelefone.setVisible(false);
        lbmostrarNome.setVisible(false);
        
        lbSenha.setVisible(true);
        lbConfirmarSenha.setVisible(true);
        
        lbDadosPessoaisOuCadastro.setText("Novo Administrador");
        
        tfSenha.setVisible(true);
        tfConfirmarSenha.setVisible(true);
        tfEmail.setVisible(true);
        tfNome.setVisible(true);
        tfSobrenome.setVisible(true);
        tfTelefone.setVisible(true);
    }
    
    /**
     * Método para cancelar a inserção de um novo administrador
     * @param event 
     */
    @FXML
    private void cancelarNovoAdministrador(ActionEvent event) {
        btNovoAdmin.setVisible(true);
        btSairAdmin.setVisible(true);
        btHabilitarAdministradores.setVisible(true);
        btDesabilitarAdministradores.setVisible(true);
        btExcluirAdministrador.setVisible(true);
        lbStatusAdministrador.setVisible(true);
        
        btSalvarAdmin.setVisible(false);
        btCancelarNovoAdmin.setVisible(false);
        
        lbMostrarEmail.setVisible(true);
        lbMostrarSobrenome.setVisible(true);
        lbMostrarTelefone.setVisible(true);
        lbmostrarNome.setVisible(true);
        
        lbSenha.setVisible(false);
        lbConfirmarSenha.setVisible(false);
        
        lbDadosPessoaisOuCadastro.setText("Detalhes do Administrador");
        
        tfConfirmarSenha.setVisible(false);
        tfSenha.setVisible(false);
        tfEmail.setVisible(false);
        tfNome.setVisible(false);
        tfSobrenome.setVisible(false);
        tfTelefone.setVisible(false);
        
        btExcluirAdministrador.setDisable(true);
        btHabilitarAdministradores.setDisable(true);
        btDesabilitarAdministradores.setDisable(true);
        
        lbMostrarTelefone.setText("");
        lbMostrarEmail.setText("");
        lbMostrarSobrenome.setText("");
        lbmostrarNome.setText("");
        lbMostrarStatusAdministrador.setText("");
        
        tvAdministradores.getSelectionModel().clearSelection();
    }
    
    /**
     * Método para sair da tela de materias
     * @param event 
     */
    @FXML
    private void sairDeMaterias(ActionEvent event) {
        anchorLinks.setVisible(false);
        anchorAdministradores.setVisible(false);
        anchorMaterias.setVisible(false);
        anchorPerguntas.setVisible(false);
        anchorUsuarios.setVisible(false);
    }
    
    /**
     * Método para salvar uma nova matéria
     * @param event 
     */
    @FXML
    private void salvarNovaMateria(ActionEvent event) {
        if(tfNovaMateria.getText().length() > 1){
            Materias m = new Materias();
            MateriasDAO daoM = new MateriasDAO();

            m.setNome(tfNovaMateria.getText().trim());

            daoM.insert(m);

            tfNovaMateria.setText("");
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Matérias");
            alert.setHeaderText("Campo vazio.");
            alert.setContentText("Por favor, insira o nome da matéria.");
            alert.showAndWait();
        }
    }
    
    /**
     * Método que prepara os campos para receber informações
     * da nova materia a ser salva  
     * @param event 
     */
    @FXML
    private void novaMateria(ActionEvent event) {
        btNovaMateria.setVisible(false);
        btSairMaterias.setVisible(false);
        btExcluirMateria.setVisible(false);
        btHabilitarMateria.setVisible(false);
        btDesabilitarMateria.setVisible(false);
        
        btAdicionarMateria.setVisible(true);
        btCancelarNovaMateria.setVisible(true);
        
        lbmostrarNomeMateria.setVisible(false);
        
        tfNovaMateria.setVisible(true);
        
        tfNovaMateria.setText("");
        
        lbNovaMateria.setText("Nova Matéria");
        
        lbStatusMateria.setVisible(false);
        lbmostrarStatusMateria.setVisible(false);
        
        tvMaterias.getSelectionModel().clearSelection();
    }
    
    @FXML
    private void excluirMateria(ActionEvent event) {
        if(selecionandoMaterias != null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Matérias");
            alert.setHeaderText("Esta matéria será excluída.");
            alert.setContentText("Você tem certeza disso?");
        
            ButtonType buttonTypeSim = new ButtonType("Sim");
            ButtonType buttonTypeCancelar = new ButtonType("Cancelar");
            
            alert.getButtonTypes().setAll(buttonTypeSim, buttonTypeCancelar);
        
            Optional<ButtonType> resultado = alert.showAndWait();
            if(resultado.get() == buttonTypeSim){
                MateriasDAO daoM = new MateriasDAO();
                daoM.delete(selecionandoMaterias);
                
                tvMaterias.getSelectionModel().clearSelection();
                
                btExcluirMateria.setDisable(true);
                
                lbmostrarNomeMateria.setText("");
                
                initTableMaterias();
            }else{
                alert.close();
            }
        }
    }
    
    /**
     * Método que cancela a inserção de uma nova matéria
     * @param event 
     */
    @FXML
    private void cancelarNovaMateria(ActionEvent event) {
        btNovaMateria.setVisible(true);
        btSairMaterias.setVisible(true);
        btExcluirMateria.setVisible(true);
        btHabilitarMateria.setVisible(true);
        btDesabilitarMateria.setVisible(true);
        
        btAdicionarMateria.setVisible(false);
        btCancelarNovaMateria.setVisible(false);
        
        lbmostrarNomeMateria.setVisible(true);
        lbStatusMateria.setVisible(true);
        
        tfNovaMateria.setVisible(false);
        
        lbmostrarNomeMateria.setText("");
        lbNovaMateria.setText("Detalhes da Matéria");
    }
    
    /**
     * Método que cancela a inserção de uma nova questão
     * @param event 
     */
    
    public void recuperandoQuestaoSelecionada(){
        cbDisciplina.setPromptText(selecionandoPerguntas.getNome());
        sliderDificuldade.setValue(selecionandoPerguntas.getDificuldade());
        INIT_DIFICULDADE = selecionandoPerguntas.getDificuldade();
        sliderValor.setValue(selecionandoPerguntas.getValor());
        lbValor.setText(selecionandoPerguntas.getValor() + "");
        INIT_VALOR = selecionandoPerguntas.getValor();
        taQuestao.setText(selecionandoPerguntas.getDescricao());
        tfAlternativaA.setText(selecionandoPerguntas.getAlternativaA());
        tfAlternativaB.setText(selecionandoPerguntas.getAlternativaB());
        tfAlternativaC.setText(selecionandoPerguntas.getAlternativaC());
        tfAlternativaD.setText(selecionandoPerguntas.getAlternativaD());
        tfAlternativaE.setText(selecionandoPerguntas.getAlternativaE());
              
        switch(selecionandoPerguntas.getAlternativaCorreta())
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
    private void listarPerguntas(ActionEvent event) {
        anchorListarPerguntas.setVisible(true);
        initTablePerguntas();
        cancelarQuestao(event);
    }

    @FXML
    private void salvarEdicao(ActionEvent event) {
        if(taQuestao.getText().length() >= 1){
            if(tfAlternativaA.getText().length() >= 1){
                if(tfAlternativaB.getText().length() >= 1){
                    if(rbA.isSelected() || rbB.isSelected() || rbC.isSelected()
                            || rbD.isSelected() || rbE.isSelected()){
                        
                        alternativaSelecionada();
                        Perguntas p = new Perguntas();
                        PerguntasDAO daoP = new PerguntasDAO();
                        
                        p.setID_Pergunta(selecionandoPerguntas.getID_Pergunta());
                        p.setDescricao(taQuestao.getText().trim());
                        p.setAlternativaA(tfAlternativaA.getText().trim());
                        p.setAlternativaB(tfAlternativaB.getText().trim());
                        p.setAlternativaC(tfAlternativaC.getText().trim());
                        p.setAlternativaD(tfAlternativaD.getText().trim());
                        p.setAlternativaE(tfAlternativaE.getText().trim());
                        p.setAlternativaCorreta(alternativaSelecionada);
                        p.setDificuldade(INIT_DIFICULDADE);
                        p.setValor(INIT_VALOR);
                        
                        daoP.update(p);
                        
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Perguntas");
                        alert.setHeaderText("A questão foi atualizada.");
                        alert.showAndWait();
                        
                        limparCamposPerguntas();
                        initTablePerguntas();
                        
                        anchorListarPerguntas.setVisible(true);
                        
                    }else{
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Perguntas");
                        alert.setHeaderText("Nenhuma alternativa selecionada.");
                        alert.setContentText("Por favor, selecione a alternativa correta.");
                        alert.showAndWait();
                    }
                }else{
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Perguntas");
                    alert.setHeaderText("O Campo Alternativa A está vazio.");
                    alert.setContentText("Por favor, insira a Alternativa A.");
                    alert.showAndWait();
                }
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Perguntas");
                alert.setHeaderText("O Campo Alternativa A está vazio.");
                alert.setContentText("Por favor, insira a Alternativa A.");
                alert.showAndWait();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Perguntas");
            alert.setHeaderText("O Campo Questão está vazio.");
            alert.setContentText("Por favor, insira uma questão.");
            alert.showAndWait();
        }
    }

    @FXML
    private void cancelarEdicao(ActionEvent event) {
        anchorListarPerguntas.setVisible(true);
    }

    @FXML
    private void excluirQuestao(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Matérias");
            alert.setHeaderText("A questão será excluída.");
            alert.setContentText("Você tem certeza disso?");
        
            ButtonType buttonTypeSim = new ButtonType("Sim");
            ButtonType buttonTypeCancelar = new ButtonType("Cancelar");
            
            alert.getButtonTypes().setAll(buttonTypeSim, buttonTypeCancelar);
        
            Optional<ButtonType> resultado = alert.showAndWait();
            if(resultado.get() == buttonTypeSim){
                Perguntas p = new Perguntas();
                PerguntasDAO daoP = new PerguntasDAO();

                p.setID_Pergunta(selecionandoPerguntas.getID_Pergunta());

                daoP.delete(p);
                initTablePerguntas();
                tvPerguntas.getSelectionModel().clearSelection();
                btEditarQuestao.setDisable(true);
                btExcluirQuestao.setDisable(true);
            }else{
                alert.close();
            }
    }

    @FXML
    private void editarQuestao(ActionEvent event) {
        anchorListarPerguntas.setVisible(false);
        btAdicionarQuestao.setVisible(false);
        btCancelarPergunta.setVisible(false);
        btListarPerguntas.setVisible(false);
        btSairDePerguntas.setVisible(false);
        btSalvarEdicao.setVisible(true);
        btCancelarEdicao.setVisible(true);
    }

    @FXML
    private void sairListarPerguntas(ActionEvent event) {
        initTableMaterias();
        cbDisciplina.setPromptText("Selecione");
        INIT_VALOR = 1;
        INIT_DIFICULDADE = 1;
        detectarDificuldade();
        lbValor.setText(1 + "");
        sliderDificuldade.setValue(1);
        sliderValor.setValue(1);
        sliderValor.setMax(10);
        anchorListarPerguntas.setVisible(false);
        btAdicionarQuestao.setVisible(true);
        btCancelarPergunta.setVisible(true);
        btListarPerguntas.setVisible(true);
        btSairDePerguntas.setVisible(true);
        btSalvarEdicao.setVisible(false);
        btCancelarEdicao.setVisible(false);
        limparCamposPerguntas();
    }
    
    @FXML
    private void cancelarQuestao(ActionEvent event) {
        limparCamposPerguntas();
    }
    
    /**
     * Método para adicionar uma nova questão
     * @param event 
     */
    @FXML
    private void adicionarQuestao(ActionEvent event) {
        if(taQuestao.getText().length() >= 1){
            if(tfAlternativaA.getText().length() >= 1){
                if(tfAlternativaB.getText().length() >= 1){
                    if(rbA.isSelected() || rbB.isSelected() || rbC.isSelected()
                            || rbD.isSelected() || rbE.isSelected()){
                        
                        alternativaSelecionada();
                        Perguntas p = new Perguntas();
                        PerguntasDAO daoP = new PerguntasDAO();
                        
                        p.setID_Materia(selecionandoMaterias.getID_Materia());
                        p.setDescricao(taQuestao.getText().trim());
                        p.setAlternativaA(tfAlternativaA.getText().trim());
                        p.setAlternativaB(tfAlternativaB.getText().trim());
                        p.setAlternativaC(tfAlternativaC.getText().trim());
                        p.setAlternativaD(tfAlternativaD.getText().trim());
                        p.setAlternativaE(tfAlternativaE.getText().trim());
                        p.setAlternativaCorreta(alternativaSelecionada);
                        p.setDificuldade(INIT_DIFICULDADE);
                        p.setValor(INIT_VALOR);
                        
                        daoP.insert(p);
                        
                        limparCamposPerguntas();
                        
                    }else{
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Perguntas");
                        alert.setHeaderText("Nenhuma alternativa selecionada.");
                        alert.setContentText("Por favor, selecione a alternativa correta.");
                        alert.showAndWait();
                    }
                }else{
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Perguntas");
                    alert.setHeaderText("O Campo Alternativa A está vazio.");
                    alert.setContentText("Por favor, insira a Alternativa A.");
                    alert.showAndWait();
                }
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Perguntas");
                alert.setHeaderText("O Campo Alternativa A está vazio.");
                alert.setContentText("Por favor, insira a Alternativa A.");
                alert.showAndWait();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Perguntas");
            alert.setHeaderText("O Campo Questão está vazio.");
            alert.setContentText("Por favor, insira uma questão.");
            alert.showAndWait();
        }
        
    }

    /**
     * Método para sair da tela de perguntas
     * @param event 
     */
    @FXML
    private void sairDeQuestao(ActionEvent event) {
        anchorPerguntas.setVisible(false);
        anchorAdministradores.setVisible(false);
        anchorLinks.setVisible(false);
        anchorUsuarios.setVisible(false);
        anchorMaterias.setVisible(false);
    }
    
    public void alternativaSelecionada(){
        if(rbA.isSelected()){
            alternativaSelecionada = "A";
        }
        
        if(rbB.isSelected()){
            alternativaSelecionada = "B";
        }
        
        if(rbC.isSelected()){
            alternativaSelecionada = "C";
        }
        
        if(rbD.isSelected()){
            alternativaSelecionada = "D";
        }
        
        if(rbE.isSelected()){
            alternativaSelecionada = "E";
        }
    }
    
    @FXML
    private void acaoAlternativaDclicada(MouseEvent event) {
        if(tfAlternativaC.getText().length() >= 1){
            tfAlternativaD.setEditable(true);
        }
    }

    @FXML
    private void acaoAlternativaEclicada(MouseEvent event) {
        if(tfAlternativaC.getText().length() >= 1 && tfAlternativaD.getText().length() >= 1){
            tfAlternativaE.setEditable(true);
        }
    }
    
    @FXML
    private void rbASelecionado(MouseEvent event) {
        if(tfAlternativaA.getText().length() < 1){
            rbA.setSelected(false);
        }
    }

    @FXML
    private void rbBSelecionado(MouseEvent event) {
        if(tfAlternativaB.getText().length() < 1){
            rbB.setSelected(false);
        }
    }

    @FXML
    private void rbCSelecionado(MouseEvent event) {
        if(tfAlternativaC.getText().length() < 1){
            rbC.setSelected(false);
        }
    }

    @FXML
    private void rbDSelecionado(MouseEvent event) {
        if(tfAlternativaD.getText().length() < 1){
            rbD.setSelected(false);
        }
    }

    @FXML
    private void rbESelecionado(MouseEvent event) {
        if(tfAlternativaE.getText().length() < 1){
            rbE.setSelected(false);
        }
    }
    
    /**
     * Métodos abaixo responsáveis por detectar a movimentação dos slides
     * na tela de configuração do simulado
     * @param event 
     */
    @FXML
    private void detectDificuldade1(MouseEvent event) {
        detectarDificuldade();
    }

    @FXML
    private void detectDificuldade2(DragEvent event) {
        detectarDificuldade();
    }

    @FXML
    private void detectDificuldade3(DragEvent event) {
        detectarDificuldade();
    }

    @FXML
    private void arrastarSlider(MouseEvent event) {
        detectarValorPerguntas();
    }

    @FXML
    private void arrastarSlider1(DragEvent event) {
        detectarValorPerguntas();
    }

    @FXML
    private void arrastarSlider2(DragEvent event) {
        detectarValorPerguntas();
    }

    @FXML
    private void escolherDisciplina(ActionEvent event) {
        detectarValorPerguntas();
    }
    //Métodos acima responsáveis por detectar a movimentação dos slides
    //na tela de configuração do simulado
    

    /**
     * Método para preparar os campos para receber um novo link
     * @param event 
     */
    @FXML
    private void adicionarLink(ActionEvent event) {
        btAdicionarLink.setVisible(false);
        btSairDeLinks.setVisible(false);
        btExcluirLink.setVisible(false);
        btEditarLink.setVisible(false);
        btSalvarLink.setVisible(true);
        btCancelarLink.setVisible(true);
        
        lbMostrarDescricao.setVisible(false);
        lbMostrarLink.setVisible(false);
        
        tfDescricao.setVisible(true);
        tfLink.setVisible(true);
        
        tvLinks.getSelectionModel().clearSelection();
        
        lbmostrarNomeUsuarioLink.setText(sessao.getNome() + " " + sessao.getSobrenome());
        
        tfDescricao.setText("");
        tfLink.setText("");
        
        lbDetalhesLink.setText("Novo Link");
    }

    /**
     * Método para sair da tela de links
     * @param event 
     */
    @FXML
    private void sairDeLinks(ActionEvent event) {
        anchorLinks.setVisible(false);
        anchorAdministradores.setVisible(false);
        anchorMaterias.setVisible(false);
        anchorPerguntas.setVisible(false);
        anchorUsuarios.setVisible(false);
    }
    
    /**
     * Método para copiar o link para a área de transferência
     * @param event 
     */
    @FXML
    private void copiarLink(ActionEvent event) {
        java.awt.datatransfer.Clipboard copiar = Toolkit.getDefaultToolkit().getSystemClipboard();
        ClipboardOwner selecao = new StringSelection(lbMostrarLink.getText());
        copiar.setContents((Transferable) selecao, selecao);
    }
    
    /**
     * Método para excluir um link
     * @param event 
     */
    @FXML
    private void excluirLink(ActionEvent event) {
        if(selecionandoLinks != null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Matérias");
            alert.setHeaderText("Este link será excluído.");
            alert.setContentText("Você tem certeza disso?");
        
            ButtonType buttonTypeSim = new ButtonType("Sim");
            ButtonType buttonTypeCancelar = new ButtonType("Cancelar");
            
            alert.getButtonTypes().setAll(buttonTypeSim, buttonTypeCancelar);
        
            Optional<ButtonType> resultado = alert.showAndWait();
            if(resultado.get() == buttonTypeSim){
                LinksDAO daoL = new LinksDAO();
        
                daoL.delete(selecionandoLinks);
                
                btEditarLink.setDisable(true);
                btExcluirLink.setDisable(true);

                lbmostrarNomeUsuarioLink.setText("");
                lbMostrarDescricao.setText("");
                lbMostrarLink.setText("");

                tvLinks.getSelectionModel().clearSelection();

                initTableLinks();
            }else{
                alert.close();
            }
        }
    }
    
    /**
     * Método para salvar um novo link
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
            
            lbDetalhesLink.setText("Detalhes do Link");
            
            tvLinks.getSelectionModel().clearSelection();
            
            cancelarLink(event);
            
            initTableLinks();
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Links");
            alert.setHeaderText("Campo vazio.");
            alert.setContentText("Por favor, preencha todos os campos.");
            alert.showAndWait();
        }
    }
    
    /**
     * Método para cancelar o salvamento de um novo link
     * @param event 
     */
    @FXML
    private void cancelarLink(ActionEvent event) {
        btAdicionarLink.setVisible(true);
        btSairDeLinks.setVisible(true);
        btCopiarLink.setVisible(true);
        btEditarLink.setVisible(true);
        btExcluirLink.setVisible(true);
        btSalvarLink.setVisible(false);
        btSalvarLinkAlterado.setVisible(false);
        btCancelarLink.setVisible(false);
        
        tfDescricao.setVisible(false);
        tfLink.setVisible(false);
        
        lbMostrarDescricao.setVisible(true);
        lbMostrarLink.setVisible(true);
        
        lbDetalhesLink.setText("Detalhes do Link");
        
        if(tfDescricao.getText().length() < 1 || tfLink.getText().length() < 5){
            lbmostrarNomeUsuarioLink.setText("");
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
    private void editarLink(ActionEvent event) {
        btAdicionarLink.setVisible(false);
        btSairDeLinks.setVisible(false);
        btCopiarLink.setVisible(false);
        btEditarLink.setVisible(false);
        btExcluirLink.setVisible(false);
        btCancelarLink.setVisible(true);
        btSalvarLinkAlterado.setVisible(true);
        
        lbMostrarDescricao.setVisible(false);
        lbMostrarLink.setVisible(false);
        
        tfDescricao.setVisible(true);
        tfLink.setVisible(true);
        
        tfDescricao.setText(lbMostrarDescricao.getText().trim());
        tfLink.setText(lbMostrarLink.getText().trim());
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

            lbDetalhesLink.setText("Detalhes do Link");

            cancelarLink(event);

            initTableLinks();
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Links");
            alert.setHeaderText("Campo vazio.");
            alert.setContentText("Por favor, preencha todos os campos.");
            alert.showAndWait();
        }
    }

    @FXML
    private void sairDoRanking(ActionEvent event) {
        anchorRanking.setVisible(false);
    }
    
    /**
     * Método para abrir a tela de alteração de senha
     * @param event 
     */
    @FXML
    private void editarSenha(ActionEvent event) {
        sairListarPerguntas(event);
        
        lbPainelNavegacao.setVisible(false);
        
        anchorEditarSenha.setVisible(true);
        btEditarSenha.setDisable(true);
        btMinhaConta.setDisable(false);
        
        anchorAdministradores.setVisible(false);
        anchorLinks.setVisible(false);
        anchorMaterias.setVisible(false);
        anchorMinhaConta.setVisible(false);
        anchorPerguntas.setVisible(false);
        anchorRanking.setVisible(false);
        anchorUsuarios.setVisible(false);
        
        tfSenhaAtual.setText("");
        tfNovaSenha.setText("");
        tfConfirmarNovaSenha.setText("");
    }
    
    /**
     * Método para sair da tela minha conta
     * @param event 
     */
    @FXML
    private void sairMinhaConta(ActionEvent event) {
        anchorMinhaConta.setVisible(false);
        lbPainelNavegacao.setVisible(true);
        btMinhaConta.setDisable(false);
    }

    /**
     * Método que prepara os campos para receber valores a serem salvos
     * @param event 
     */
    @FXML
    private void editarMinhaConta(ActionEvent event) {
        btEditarMinhaConta.setVisible(false);
        btSairMinhaConta.setVisible(false);
        btSalvarMinhaConta.setVisible(true);
        btCancelarMinhaConta.setVisible(true);
        
        tfEmailMinhaConta.setVisible(true);
        tfNomeMinhaConta.setVisible(true);
        tfSenhaMinhaConta.setVisible(true);
        tfSobrenomeMinhaConta.setVisible(true);
        tfTelefoneMinhaConta.setVisible(true);
        
        lbMostrarEmailMinhaConta.setVisible(false);
        lbMostrarSobrenomeMinhaConta.setVisible(false);
        lbMostrarTelefoneMinhaConta.setVisible(false);
        lbmostrarNomeMinhaConta.setVisible(false);
        
        lbSenhaMinhaConta.setVisible(true);
        
        tfEmailMinhaConta.setText(lbMostrarEmailMinhaConta.getText().trim());
        tfNomeMinhaConta.setText(lbmostrarNomeMinhaConta.getText().trim());
        tfSobrenomeMinhaConta.setText(lbMostrarSobrenomeMinhaConta.getText().trim());
        tfTelefoneMinhaConta.setText(lbMostrarTelefoneMinhaConta.getText().trim());
    }
    
    /**
     * Método que salva os dados alterados
     * @param event 
     */
    @FXML
    private void salvarMinhaConta(ActionEvent event) {
        boolean verificarEmail = true;
        
        try {
            if(tfEmailMinhaConta.getText().length() >= 1){
                UsuarioDAO daoU = new UsuarioDAO();
                List<UsuarioM> usuario = daoU.checkEmail(tfEmailMinhaConta.getText());
                
                if(tfEmailMinhaConta.getText().trim().equals(sessao.getEmail())){
                    btSalvarMinhaConta.setDisable(false);
                }else{
                    if(usuario.get(0).getEmail().equalsIgnoreCase(tfEmailMinhaConta.getText())){
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
        
        
        String tfValidar = tfSenhaMinhaConta.getText();
        String validarSenha = sessao.getSenha();
        
        if(verificarEmail == true){
            if(tfValidar.equals(validarSenha)){
                UsuarioM u = new UsuarioM();

                u.setID_Usuario(sessao.getID_Usuario());
                u.setNome(tfNomeMinhaConta.getText().trim());
                u.setSobrenome(tfSobrenomeMinhaConta.getText().trim());
                u.setEmail(tfEmailMinhaConta.getText().trim());
                u.setTelefone(tfTelefoneMinhaConta.getText().trim());
                u.setSenha(sessao.getSenha());

                UsuarioDAO uDAO = new UsuarioDAO();

                uDAO.update(u);

                lbmostrarNomeMinhaConta.setText(tfNomeMinhaConta.getText().trim());
                lbMostrarSobrenomeMinhaConta.setText(tfSobrenomeMinhaConta.getText().trim());
                lbMostrarTelefoneMinhaConta.setText(tfTelefoneMinhaConta.getText().trim());
                lbMostrarEmailMinhaConta.setText(tfEmailMinhaConta.getText().trim());

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
     * Método responsável por excluir a conta do administrador
     * @param event 
     */
    private void excluirMinhaConta(ActionEvent event) {
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
                
                try {
                    daoU.delete(u);
                    
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Sistema Acadêmico de Estudos");
                    alert.setHeaderText("Conta excluída com sucesso.");
                    alert.showAndWait();
                    
                    Admin.getStage().close();
                    Login login = new Login();
                    login.start(new Stage());
                } catch (Exception e) {
                }
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Sistema Acadêmico de Estudos");
                alert.setHeaderText("Senha inválida.");
                alert.showAndWait();
            }
        }
    }
    
    /**
     * Método que cancela a alteração dos dados
     * @param event 
     */
    @FXML
    private void cancelarMinhaConta(ActionEvent event) {
        btEditarMinhaConta.setVisible(true);
        btSairMinhaConta.setVisible(true);
        btSalvarMinhaConta.setVisible(false);
        btCancelarMinhaConta.setVisible(false);
        
        tfEmailMinhaConta.setVisible(false);
        tfNomeMinhaConta.setVisible(false);
        tfSenhaMinhaConta.setVisible(false);
        tfSobrenomeMinhaConta.setVisible(false);
        tfTelefoneMinhaConta.setVisible(false);
        
        lbMostrarEmailMinhaConta.setVisible(true);
        lbMostrarSobrenomeMinhaConta.setVisible(true);
        lbMostrarTelefoneMinhaConta.setVisible(true);
        lbmostrarNomeMinhaConta.setVisible(true);
        
        lbSenhaMinhaConta.setVisible(false);
        
        tfSenhaMinhaConta.setText("");
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
     * Método para cancelar a mudança de senha
     * @param event 
     */
    @FXML
    private void cancelarAlterarSenha(ActionEvent event) {
        lbPainelNavegacao.setVisible(true);
        
        anchorEditarSenha.setVisible(false);
        btEditarSenha.setDisable(false);
        tfSenhaAtual.setText("");
        tfNovaSenha.setText("");
        tfConfirmarNovaSenha.setText("");
    }

    /**
     * Método que formata o campo de telefone
     * @param event 
     */
    @FXML
    private void tfTelefoneMinhaContaFormat(KeyEvent event) {
        TextFieldFormatter formatar = new TextFieldFormatter();
        formatar.setMask("(##)#####-####");
        formatar.setCaracteresValidos("0123456789");
        formatar.setTf(tfTelefoneMinhaConta);
        formatar.formatter();
    }
    
    /**
     * Método que preenche a tabela de usuários
     */
    public void initTableUsuarios(){
        clmNomeUsuario.setCellValueFactory(new PropertyValueFactory("Nome"));
        clmSobrenomeUsuario.setCellValueFactory(new PropertyValueFactory("Sobrenome"));
        tvUsuarios.setItems(atualizaTabelaUsuarios());
    }
    
    /**
     * Método que cria uma lista de usuários para ser usado 
     * no método initTableUsurios
     * @return 
     */
    public ObservableList<UsuarioM> atualizaTabelaUsuarios(){
        UsuarioDAO daoU = new UsuarioDAO();
        return FXCollections.observableArrayList(daoU.getListUsuarios());
    }
    
    //Retorna uma lista de administradorespara a tabela
    public void initTableAdministradores(){
        clmNomeAdministrador.setCellValueFactory(new PropertyValueFactory("Nome"));
        clmSobrenomeAdministrador.setCellValueFactory(new PropertyValueFactory("Sobrenome"));
        tvAdministradores.setItems(atualizaTabelaAdministradores());
    }
    
    public ObservableList<UsuarioM> atualizaTabelaAdministradores(){
        UsuarioDAO daoU = new UsuarioDAO();
        return FXCollections.observableArrayList(daoU.getListAdministradores());
    }
    
    //Lista de administradores ativos ou não através da combobox
    public void initTableAdministradoresEspecificos(){
        clmNomeAdministrador.setCellValueFactory(new PropertyValueFactory("Nome"));
        clmSobrenomeAdministrador.setCellValueFactory(new PropertyValueFactory("Sobrenome"));
        tvAdministradores.setItems(atualizaTabelaAdministradoresEspecificos());
    }
    
    public ObservableList<UsuarioM> atualizaTabelaAdministradoresEspecificos(){
        UsuarioDAO daoU = new UsuarioDAO();
        return FXCollections.observableArrayList(daoU.getAdministradoresAtivos(
                cbBuscarAdministradores.getSelectionModel().getSelectedIndex()));
    }
    
    //Lista de usuarios ativos ou não através da combobox
    public void initTableUsuariosEspecificos(){
        clmNomeUsuario.setCellValueFactory(new PropertyValueFactory("Nome"));
        clmSobrenomeUsuario.setCellValueFactory(new PropertyValueFactory("Sobrenome"));
        tvUsuarios.setItems(atualizaTabelaUsuariosEspecificos());
    }
    
    public ObservableList<UsuarioM> atualizaTabelaUsuariosEspecificos(){
        UsuarioDAO daoU = new UsuarioDAO();
        return FXCollections.observableArrayList(daoU.getUsuariosAtivos(
                cbBuscarUsuario.getSelectionModel().getSelectedIndex()));
    }
    
    //Lista de matérias ativas ou não através da combobox
    public void initTableMateriasEspecificas(){
        clmMaterias.setCellValueFactory(new PropertyValueFactory("Nome"));
        tvMaterias.setItems(atualizaTabelaMateriasEspecificas());
    }
    
    public ObservableList<Materias> atualizaTabelaMateriasEspecificas(){
        MateriasDAO daoM = new MateriasDAO();
        return FXCollections.observableArrayList(daoM.getMateriaAtiva(
                cbBuscarMateria.getSelectionModel().getSelectedIndex()));
    }
    
    public void initTableLinks(){
        clmDescricaoLink.setCellValueFactory(new PropertyValueFactory("Descricao"));
        clmLink.setCellValueFactory(new PropertyValueFactory("Link"));
        tvLinks.setItems(atualizaTabelaLinks());
    }
    
    public ObservableList<Links> atualizaTabelaLinks(){
        LinksDAO daoL = new LinksDAO();
        return FXCollections.observableArrayList(daoL.getList());
    }
    
    public void initTableMaterias(){
        clmMaterias.setCellValueFactory(new PropertyValueFactory("Nome"));
        tvMaterias.setItems(atualizaTabelaMaterias());
        cbDisciplina.setItems(atualizaTabelaMaterias());//preenche combobox disciplina
        cbFiltroPerguntas.setItems(atualizaTabelaMaterias());//preenche combobox tela Perguntas
    }
    
    public ObservableList<Materias> atualizaTabelaMaterias(){
        MateriasDAO daoM = new MateriasDAO();
        return FXCollections.observableArrayList(daoM.getList());
    }

    public void initTableRanking(){
        clmPosicao.setCellValueFactory(new PropertyValueFactory("Posicao"));
        clmNomeNoRanking.setCellValueFactory(new PropertyValueFactory("Nome"));
        clmSobrenomeNoRanking.setCellValueFactory(new PropertyValueFactory("Sobrenome"));
        clmPontuacaoDoDia.setCellValueFactory(new PropertyValueFactory("scoreDia"));
        clmPontuacaoTotal.setCellValueFactory(new PropertyValueFactory("scoreTotal"));
        clmAcertos.setCellValueFactory(new PropertyValueFactory("Acertos"));
        clmErros.setCellValueFactory(new PropertyValueFactory("Erros"));
        clmIgnorados.setCellValueFactory(new PropertyValueFactory("Ignorados"));
        clmTotalSimulados.setCellValueFactory(new PropertyValueFactory("totalSimulados"));
        tvRanking.setItems(atualizaTabelaRanking());
    }
    
    public ObservableList<Ranking> atualizaTabelaRanking(){
        RankingDAO daoR = new RankingDAO();
        return FXCollections.observableArrayList(daoR.getListForAdm());
    }
    
    public void initTablePerguntas(){
        clmMateriaPerguntas.setCellValueFactory(new PropertyValueFactory("Nome"));
        clmDescricaoPerguntas.setCellValueFactory(new PropertyValueFactory("Descricao"));
        tvPerguntas.setItems(atualizaTabelaPerguntas());
    }
    
    public ObservableList<Perguntas> atualizaTabelaPerguntas(){
        PerguntasDAO daoP = new PerguntasDAO();
        return FXCollections.observableArrayList(daoP.getListAll());
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
    
    //Retorna uma lista de perguntas de acordo com a materia selecionada
    public void initTablePerguntasComboBox(){
        clmMateriaPerguntas.setCellValueFactory(new PropertyValueFactory("Nome"));
        clmDescricaoPerguntas.setCellValueFactory(new PropertyValueFactory("Descricao"));
        tvPerguntas.setItems(atualizaTabelaPerguntasComboBox());
    }
    
    public ObservableList<Perguntas> atualizaTabelaPerguntasComboBox(){
        PerguntasDAO daoP = new PerguntasDAO();
        return FXCollections.observableArrayList(daoP.getListFiltrado(selecionandoMaterias.getID_Materia()));
    }
    
    //Retorna uma lista de administradores com nomes iniciados ao digitado
    public void initTableAdministradorPesquisado(){
        clmNomeAdministrador.setCellValueFactory(new PropertyValueFactory("Nome"));
        clmSobrenomeAdministrador.setCellValueFactory(new PropertyValueFactory("Sobrenome"));
        tvAdministradores.setItems(atualizaTabelaAdministradorPesquisado());
    }
    
    public ObservableList<UsuarioM> atualizaTabelaAdministradorPesquisado(){
        UsuarioDAO daoU = new UsuarioDAO();
        return FXCollections.observableArrayList(daoU.getAdministradorEspecifico(
        tfBuscarAdministrador.getText().trim()));
    }
    
    //Retorma uma lista de usuarios com nomes iniciados ao digitado
    public void initTableUsuarioPesquisado(){
        clmNomeUsuario.setCellValueFactory(new PropertyValueFactory("Nome"));
        clmSobrenomeUsuario.setCellValueFactory(new PropertyValueFactory("Sobrenome"));
        tvUsuarios.setItems(atualizaTabelaUsuarioPesquisado());
    }
    
    public ObservableList<UsuarioM> atualizaTabelaUsuarioPesquisado(){
        UsuarioDAO daoU = new UsuarioDAO();
        return FXCollections.observableArrayList(daoU.getUsuarioEspecifico(
        tfBuscarUsuario.getText().trim()));
    }
    
    //Retorma uma lista de matérias com nomes iniciados ao digitado
    public void initTableMateriaPesquisada(){
        clmMaterias.setCellValueFactory(new PropertyValueFactory("Nome"));
        tvMaterias.setItems(atualizaTabelaMateriaPesquisada());
    }
    
    public ObservableList<Materias> atualizaTabelaMateriaPesquisada(){
        MateriasDAO daoM = new MateriasDAO();
        return FXCollections.observableArrayList(daoM.getMateriaEspecifica(
        tfBuscarMateria.getText().trim()));
    }
    
    //Retorna uma lista de perguntas de acordo com a materia digitada
    public void initTablePerguntasBuscar(){
        clmMateriaPerguntas.setCellValueFactory(new PropertyValueFactory("Nome"));
        clmDescricaoPerguntas.setCellValueFactory(new PropertyValueFactory("Descricao"));
        tvPerguntas.setItems(atualizaTabelaPerguntasBuscar());
    }
    
    public ObservableList<Perguntas> atualizaTabelaPerguntasBuscar(){
        PerguntasDAO daoP = new PerguntasDAO();
        try {
            return FXCollections.observableArrayList(daoP.getListBuscar(tfBuscarPerguntas.getText()));
        } catch (Exception e) {
        }
        return FXCollections.observableArrayList(daoP.getListBuscar(tfBuscarPerguntas.getText()));
    }
    
    //Preenche 2 combobox para busca de habilitados e desabilitados
    //De aministrador e de usuario
    public void initComboBoxAdministradoresEUsuario(){
        List lista = new ArrayList();
        lista.add(0, "Desabilitados");
        lista.add(1, "Habilitados");
        lista.add(2, "Todos");
        lista.toString();
        cbBuscarAdministradores.setItems(FXCollections.observableArrayList(lista));
        cbBuscarUsuario.setItems(FXCollections.observableArrayList(lista));
    }
    
    //Preenche a combobox de busca de matérias
    public void initComboBoxMaterias(){
        List lista = new ArrayList();
        lista.add(0, "Desabilitados");
        lista.add(1, "Habilitados");
        lista.add(2, "Todos");
        lista.toString();
        cbBuscarMateria.setItems(FXCollections.observableArrayList(lista));
    }
    
    @FXML
    private void habilitarMateria(ActionEvent event) {
        Materias m = new Materias();
        MateriasDAO daoM = new MateriasDAO();
        
        m.setIsAtiva(1);
        m.setID_Materia(selecionandoMaterias.getID_Materia());
        
        daoM.habilitarDesabilitar(m);
        
        btHabilitarMateria.setDisable(true);
        btDesabilitarMateria.setDisable(false);
        
        lbmostrarStatusMateria.setText("Habilitados");
        selecionandoMaterias.setIsAtiva(1);
    }

    @FXML
    private void desabilitarMateria(ActionEvent event) {
        Materias m = new Materias();
        MateriasDAO daoM = new MateriasDAO();
        
        m.setIsAtiva(0);
        m.setID_Materia(selecionandoMaterias.getID_Materia());
        
        daoM.habilitarDesabilitar(m);
        
        btHabilitarMateria.setDisable(false);
        btDesabilitarMateria.setDisable(true);
        
        lbmostrarStatusMateria.setText("Desabilitados");
    }

    @FXML
    private void detectarFiltroPerguntas(MouseEvent event) {
        cbFiltroPerguntas.getSelectionModel().clearSelection();
        initTablePerguntasBuscar();
    }

    @FXML
    private void detectarFiltroPerguntarEnter(KeyEvent event) {
        cbFiltroPerguntas.getSelectionModel().clearSelection();
        initTablePerguntasBuscar();
    }

    @FXML
    private void detectarAdministradorDigitado(KeyEvent event) {
        cbBuscarAdministradores.getSelectionModel().clearSelection();
        initTableAdministradorPesquisado();
    }

    @FXML
    private void desabilitarAdministradores(ActionEvent event) {
        UsuarioDAO daoU = new UsuarioDAO();
        UsuarioM u = new UsuarioM();
        
        u.setUsuarioAtivo(0);
        u.setID_Usuario(selecionandoUsuario.getID_Usuario());
        daoU.habilitarDesabilitar(u);
        
        lbMostrarStatusAdministrador.setText("Desabilitado");
        btHabilitarAdministradores.setDisable(false);
        btDesabilitarAdministradores.setDisable(true);
        
        selecionandoUsuario.setUsuarioAtivo(0);
    }

    @FXML
    private void habilitarAdministradores(ActionEvent event) {
        UsuarioDAO daoU = new UsuarioDAO();
        UsuarioM u = new UsuarioM();
        
        u.setUsuarioAtivo(1);
        u.setID_Usuario(selecionandoUsuario.getID_Usuario());
        daoU.habilitarDesabilitar(u);
        
        lbMostrarStatusAdministrador.setText("Habilitado");
        btHabilitarAdministradores.setDisable(true);
        btDesabilitarAdministradores.setDisable(false);
        selecionandoUsuario.setUsuarioAtivo(1);
    }

    @FXML
    private void excluirAdministrador(ActionEvent event) {
        if(selecionandoUsuario != null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Administradores");
            alert.setHeaderText("Este administrador será removido.");
            alert.setContentText("Você tem certeza disso?");
        
            ButtonType buttonTypeSim = new ButtonType("Sim");
            ButtonType buttonTypeCancelar = new ButtonType("Cancelar");
            
            alert.getButtonTypes().setAll(buttonTypeSim, buttonTypeCancelar);
        
            Optional<ButtonType> resultado = alert.showAndWait();
            if(resultado.get() == buttonTypeSim){
                LinksDAO daoL = new LinksDAO();
                Links l = new Links();
                l.setID_Usuario(sessao.getID_Usuario());
                daoL.deleteUserLink(l);
                
                Agenda a = new Agenda();
                AgendaDAO daoA = new AgendaDAO();
                a.setID_Usuario(sessao.getID_Usuario());
                daoA.deleteAll(a);
                
                UsuarioDAO daoU = new UsuarioDAO();
                daoU.delete(selecionandoUsuario);
                
                cancelarNovoAdministrador(event);
                initTableAdministradores();
            }else{
                alert.close();
            }
        }
    }

    @FXML
    private void detectarUsuarioDigitado(KeyEvent event) {
        cbBuscarUsuario.getSelectionModel().clearSelection();
        initTableUsuarioPesquisado();
    }

    @FXML
    private void detectarMateriaDigitada(KeyEvent event) {
        cbBuscarMateria.getSelectionModel().clearSelection();
        initTableMateriaPesquisada();
    }

    @FXML
    private void detectarEmailExistente(MouseEvent event) {
        try {
            if(tfEmailMinhaConta.getText().length() >= 1){
                UsuarioDAO daoU = new UsuarioDAO();
                List<UsuarioM> usuario = daoU.checkEmail(tfEmailMinhaConta.getText());
                
                if(tfEmailMinhaConta.getText().trim().equals(sessao.getEmail())){
                    btSalvarMinhaConta.setDisable(false);
                }else{
                    if(usuario.get(0).getEmail().equalsIgnoreCase(tfEmailMinhaConta.getText())){
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

    @FXML
    private void sairDeAgenda(ActionEvent event) {
        anchorAgenda.setVisible(false);
    }

    @FXML
    private void abrirAgenda(ActionEvent event) {
        initTableAgenda();
        tvAgenda.getSelectionModel().clearSelection();
        
        anchorAgenda.setVisible(true);
        
        anchorAdministradores.setVisible(false);
        anchorLinks.setVisible(false);
        anchorEditarSenha.setVisible(false);
        anchorMinhaConta.setVisible(false);
        anchorListarPerguntas.setDisable(false);
        anchorMaterias.setVisible(false);
        anchorPerguntas.setVisible(false);
        anchorRanking.setVisible(false);
        anchorUsuarios.setVisible(false);
        
        cancelarAgenda(event);
        cancelarMinhaConta(event);
        cancelarAlterarSenha(event);
    }
}