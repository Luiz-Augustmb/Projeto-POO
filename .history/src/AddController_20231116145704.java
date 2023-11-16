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
        assert qtdProduto != null : "fx:id=\"qtdProduto\" was not injected: check your FXML file 'addLayout.fxml'.";
        assert marcaProduto != null : "fx:id=\"marcaProduto\" was not injected: check your FXML file 'addLayout.fxml'.";
        assert precoProduto != null : "fx:id=\"precoProduto\" was not injected: check your FXML file 'addLayout.fxml'.";
        assert modeloProduto != null : "fx:id=\"modeloProduto\" was not injected: check your FXML file 'addLayout.fxml'.";
        assert categoriaProduto != null : "fx:id=\"categoriaProduto\" was not injected: check your FXML file 'addLayout.fxml'.";

    }
}
