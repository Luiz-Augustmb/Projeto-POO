import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SearchController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Produto, String> colunaCategoria;

    @FXML
    private TableColumn<Produto, String> colunaModelo;

    @FXML
    private TableColumn<Produto, Double> colunaPreco;

    @FXML
    private TableColumn<Produto, String> colunaMarca;

    @FXML
    private TableColumn<Produto, Integer> colunaQuantidade;

    @FXML
    private TableView<Produto> tabelaProdutos;
    
    @FXML
    private ChoiceBox<String> choiceBoxCategoria;

    // Implementando opções de categorias na ChoiceBox
    private String[] categorias = { "Smartphone", "Notebook", "Tablet", "Acessórios", "Periféricos", "Todas" };

    private ArquivoProdutos arquivoProdutos = new ArquivoProdutos();
    private ArrayList<Produto> arrayProdutos = new ArrayList<>();

    private ObservableList<Produto> dadosDaTabela = FXCollections.observableArrayList();


    @FXML
    void initialize() {

        arrayProdutos = arquivoProdutos.ler();

        choiceBoxCategoria.getItems().addAll(categorias);
        choiceBoxCategoria.setValue("Todas");

        colunaCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colunaMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colunaModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        colunaPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        colunaQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));

        tabelaProdutos.setItems(dadosDaTabela);
        dadosDaTabela.addAll(arrayProdutos);

    }
}
