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
    private ChoiceBox<?> choiceBoxCategoria;

    @FXML
    private TableColumn<?, ?> colunaPreco;

    @FXML
    private TableColumn<?, ?> colunaMarca;

    @FXML
    private TableColumn<?, ?> colunaQuantidade;

    @FXML
    private TableView<> tabelaProdutos;

    private ArquivoProdutos arquivoProdutos = new ArquivoProdutos();
    private ArrayList<Produto> arrayProdutos = new ArrayList<>();


    @FXML
    void initialize() {

        try {
            arrayProdutos = arquivoProdutos.ler();
            for (int i = 0; i < arrayProdutos.size(); i++) {
                System.out.println(arrayProdutos.get(i).getCategoria());
            }
        } catch (Exception e) {
            System.out.println("TESTE");
            e.printStackTrace();
        }

    }
}
