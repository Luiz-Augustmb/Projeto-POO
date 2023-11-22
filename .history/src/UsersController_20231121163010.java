import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class UsersController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView addUserImg;

    @FXML
    private ImageView logOutImg;

    @FXML
    private TableView<Usuario> tabelaUsuarios;

    @FXML
    private TableColumn<Usuario, String> colunaUsuario;

    @FXML
    private TableColumn<Usuario, String> colunaFuncionario;

    @FXML
    private TableColumn<Usuario, String> colunaSenha;

    @FXML
    void addUser(MouseEvent event) {
        System.out.println("TESTE ADD");
    }

    @FXML
    void logOutApp(MouseEvent event) {
        System.out.println("TESTE LOG");
    }

    @FXML
    void initialize() {

    }

    ArquivoUsuarios arquivoUsuarios = new ArquivoUsuarios();

}
