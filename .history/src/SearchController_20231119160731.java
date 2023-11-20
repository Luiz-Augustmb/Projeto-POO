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
    private ArrayList<Smartphone> arraySmartphone = new ArrayList<>();
    private ArrayList<Notebook> arrayNotebook = new ArrayList<>();
    private ArrayList<Tablet> arrayTablet = new ArrayList<>();
    private ArrayList<Acessorios> arrayAcessorios = new ArrayList<>();
    private ArrayList<Perifericos> arrayPerifericos = new ArrayList<>(); 

    private ObservableList<Produto> dadosDaTabela = FXCollections.observableArrayList();


    @FXML
    void initialize() {

        arrayProdutos = arquivoProdutos.ler();
        System.out.println(arrayProdutos.get(1).getCategoria());
        
        for(int i = 0; i < arrayProdutos.size(); i++){
            if (arrayProdutos.get(i).getCategoria().equals("Smartphone")) {
                // variaveis auxiliares 
                String auxCategoria = arrayProdutos.get(i).getCategoria();
                String auxMarca = arrayProdutos.get(i).getMarca();
                String auxModelo = arrayProdutos.get(i).getModelo();
                double auxPreco = arrayProdutos.get(i).getPreco();
                int auxQtd = arrayProdutos.get(i).getQtd();

                Smartphone auxSmartphone = new Smartphone(auxCategoria, auxMarca, auxModelo, auxPreco, auxQtd);
                arraySmartphone.add(auxSmartphone);
                System.out.println(arraySmartphone.get(i).getModelo());
            }
        }

        choiceBoxCategoria.getItems().addAll(categorias);
        choiceBoxCategoria.setValue("Todas");

        colunaCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colunaMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colunaModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        colunaPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        colunaQuantidade.setCellValueFactory(new PropertyValueFactory<>("qtd"));

        tabelaProdutos.setItems(dadosDaTabela);
        dadosDaTabela.addAll(arrayProdutos);

    }
}
