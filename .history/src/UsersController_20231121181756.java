import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

    private ObservableList<Usuario> dadosTabelaUsuarios = FXCollections.observableArrayList();


    @FXML
    void addUser(MouseEvent event) {
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
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("loginLayout.fxml"));
            Parent root = loader.load();

            AddUserController addUserController = loader.getController();
            addUserController.setUsersController(this); // Set the reference

            Stage stage = new Stage();
            stage.setTitle("Login");
            stage.setScene(new Scene(root));
            ((Stage) logOutImg.getScene().getWindow()).close();
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {

        arrayUsuarios = arquivoUsuarios.ler();

        colunaFuncionario.setCellValueFactory(new PropertyValueFactory<Usuario, String>("nome"));
        colunaUsuario.setCellValueFactory(new PropertyValueFactory<Usuario, String>("usuario"));
        colunaSenha.setCellValueFactory(new PropertyValueFactory<Usuario, String>("senha"));

        tabelaUsuarios.setItems(dadosTabelaUsuarios);
        dadosTabelaUsuarios.addAll(arrayUsuarios);

    }

    private ArrayList<Usuario> arrayUsuarios = new ArrayList<>();
    private ArquivoUsuarios arquivoUsuarios = new ArquivoUsuarios();

    public void atualizarTabela() {
        Platform.runLater(() -> {
            dadosTabelaUsuarios.clear();
            initialize();
        });
    }
}
