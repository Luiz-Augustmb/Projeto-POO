import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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


        if(!nomeUsuario.isEmpty() && !usuario.isEmpty() && senhaUsuario.isEmpty()){
            System.out.println("TESTE");
        }

        Alert loginInvalido = new Alert(Alert.AlertType.INFORMATION);
            loginInvalido.setTitle("Usuário Adicionado");
            loginInvalido.setHeaderText("Novo usuário cadastrado");
            loginInvalido.setContentText("Usuário Adicionado com Sucesso!");
            loginInvalido.show();
    }

    @FXML
    void initialize() {

    }
}
