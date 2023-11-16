import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class AddController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField qtdProduto;

    @FXML
    private TextField marcaProduto;

    @FXML
    private TextField precoProduto;

    @FXML
    private TextField modeloProduto;

    @FXML
    private ChoiceBox<?> categoriaProduto;

    @FXML
    void initialize() {
        
    }
}
