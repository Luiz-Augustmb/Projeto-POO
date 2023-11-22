import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class UpdateUserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField textFieldSenha;

    @FXML
    private Button updateUserButton;

    @FXML
    private TextField textFieldUsuario;

    @FXML
    private TextField textFieldNome;

    @FXML
    void updateUser(ActionEvent event) {

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

