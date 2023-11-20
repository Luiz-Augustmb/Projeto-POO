import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SearchController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> colunaCategoria;

    @FXML
    private TableColumn<?, ?> colunaModelo;

    @FXML
    private TableColumn<?, ?> colunaPreco;

    @FXML
    private TableColumn<?, ?> colunaMarca;

    @FXML
    private TableColumn<?, ?> colunaQuantidade;

    @FXML
    private TableView<?> tabelaProdutos;

    @FXML
    private ChoiceBox<Produto> choiceBoxCategoria;

    // Implementando opções de categorias na ChoiceBox
    private String[] categorias = { "Smartphone", "Notebook", "Tablet", "Acessórios", "Periféricos", "Todas" };

    // Variáveis auxilares dos campos
    private String categoriaSelecionada;

    private ArquivoProdutos arquivoProdutos = new ArquivoProdutos();
    private ArrayList<Produto> arrayProdutos = new ArrayList<>();


    @FXML
    void initialize() {

       choiceBoxCategoria.getItems().addAll(categorias);

    }
}
