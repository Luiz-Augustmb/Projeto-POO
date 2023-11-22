import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("addUserLayout.fxml"));
            Parent root = loader.load();

            AddUserController addUserController = loader.getController();

            Stage stage = new Stage();
            stage.setTitle("Adicionar Usuário");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
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
