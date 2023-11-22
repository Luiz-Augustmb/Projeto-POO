import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddUserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField textFieldSenha;

    @FXML
    private Button addUserButton;

    @FXML
    private TextField textFieldUsuario;

    @FXML
    private TextField textFieldNome;

    @FXML
    void addNovoUsuario(ActionEvent event) {

        String nomeUsuario;
        String usuario;
        String senhaUsuario;

        nomeUsuario = textFieldNome.getText();
        usuario = textFieldUsuario.getText();
        senhaUsuario = textFieldSenha.getText();

        if (!nomeUsuario.isEmpty() && !usuario.isEmpty() && !senhaUsuario.isEmpty()) {
            Usuario novoUsuario = new Usuario(nomeUsuario, usuario, senhaUsuario);
            addArquivoUsuarios.escrever(novoUsuario);
            Alert usuarioAdicionado = new Alert(Alert.AlertType.INFORMATION);
            usuarioAdicionado.setTitle("Usuário Adicionado");
            usuarioAdicionado.setHeaderText("Novo usuário cadastrado");
            usuarioAdicionado.setContentText("Usuário Adicionado com Sucesso!");
            usuarioAdicionado.showAndWait();

            usersController.atualizarTabela();

            ((Stage) addUserButton.getScene().getWindow()).close();
        } else {
            Alert erroNovoUsuario = new Alert(Alert.AlertType.ERROR);
            erroNovoUsuario.setTitle("Erro!");
            erroNovoUsuario.setHeaderText("Erro ao adicionar novo usuário");
            erroNovoUsuario.setContentText("Campos não preenchidos");
            erroNovoUsuario.showAndWait();
        }
    }

    @FXML
    void initialize() {

    }

    ArquivoUsuarios addArquivoUsuarios = new ArquivoUsuarios();
    private UsersController usersController;

    public void setUsersController(UsersController usersController) {
        this.usersController = usersController;
    }
}
