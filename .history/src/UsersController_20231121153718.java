import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

public class UsersController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> colunaUsuario;

    @FXML
    private TableView<?> tabelaUsuarios;

    @FXML
    private Button logOutButton;

    @FXML
    private TableColumn<?, ?> colunaFuncionario;

    @FXML
    private BorderPane screen;

    @FXML
    private TableColumn<?, ?> colunaSenha;

    @FXML
    void initialize() {

    }
}
