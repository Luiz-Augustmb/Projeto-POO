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
        Parent fxml = FXMLLoader.load(getClass().getResource("searchLayout.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    @FXML
    void goToAddProduto(ActionEvent event) {

    }

    @FXML
    void goToUsers(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }
}
