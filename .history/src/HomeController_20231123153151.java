import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class HomeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addProdutoButton;

    @FXML
    private Button estoqueButton;

    @FXML
    private Button usuariosButton;

    @FXML
    private StackPane contentArea;

    @FXML
    void goToEstoque(ActionEvent event) {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("searchLayout.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    void goToAddProduto(ActionEvent event) {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("addLayout.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    void goToUsers(ActionEvent event) {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("usersLayout.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {

    }
}
