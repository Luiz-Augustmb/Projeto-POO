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
        
        for (Produto produto : arrayProdutos) {
                // Utilizando os métodos getters de Produto para cada Produto dentro de arrayProdutos
                String auxCategoria = produto.getCategoria();
                String auxMarca = produto.getMarca();
                String auxModelo = produto.getModelo();
                double auxPreco = produto.getPreco();
                int auxQtd = produto.getQtd();

            if (produto.getCategoria().equals("Smartphone")) {
                Smartphone auxSmartphone = new Smartphone(auxCategoria, auxMarca, auxModelo, auxPreco, auxQtd);
                arraySmartphone.add(auxSmartphone);
                System.out.println(auxSmartphone.getModelo());

            } else if (produto.getCategoria().equals("Notebook")){
                Notebook auxNotebook = new Notebook(auxCategoria, auxMarca, auxModelo, auxPreco, auxQtd);
                arrayNotebook.add(auxNotebook);
                System.out.println(auxNotebook.getModelo());

            } else if (produto.getCategoria().equals("Tablet")){
                Tablet auxTablet = new Tablet(auxCategoria, auxMarca, auxModelo, auxPreco, auxQtd);
                arrayTablet.add(auxTablet);
                System.out.println(auxTablet.getModelo());

            } else if (produto.getCategoria().equals("Periféricos")){
                Perifericos auxPerifericos = new Perifericos(auxCategoria, auxMarca, auxModelo, auxPreco, auxQtd);
                arrayPerifericos.add(auxPerifericos);
                System.out.println(auxPerifericos.getModelo());

            } else if (produto.getCategoria().equals("Acessórios")){
                Acessorios auxAcessorios = new Acessorios(auxCategoria, auxMarca, auxModelo, auxPreco, auxQtd);
                arrayAcessorios.add(auxAcessorios);
                System.out.println(auxAcessorios.getModelo());
                
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
