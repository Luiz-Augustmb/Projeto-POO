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
    private String categoriaSelecionada;
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

        /*
            Dividindo o arrayProdutos em arrays respectivos da categoria de cada produto
            A tabela de produtos será atulizada a partir da categoria que o usuário selecionar 
        */
        for (Produto produto : arrayProdutos) {
            if (produto.getCategoria().equals("Smartphone")) {
                Smartphone auxSmartphone = new Smartphone(produto.getCategoria(), produto.getMarca(), produto.getModelo(), produto.getPreco(), produto.getQtd());
                arraySmartphone.add(auxSmartphone);
            }
            if(produto.getCategoria().equals("Notebook")){
                Notebook auxNotebook = new Notebook(produto.getCategoria(), produto.getMarca(), produto.getModelo(), produto.getPreco(), produto.getQtd());
                arrayNotebook.add(auxNotebook);
            }
            if(produto.getCategoria().equals("Tablet")){
                Tablet auxTablet = new Tablet(produto.getCategoria(), produto.getMarca(), produto.getModelo(), produto.getPreco(), produto.getQtd());
                arrayTablet.add(auxTablet);
            }
            if(produto.getCategoria().equals("Acessórios")){
                Acessorios auxAcessorios = new Acessorios(produto.getCategoria(), produto.getMarca(), produto.getModelo(), produto.getPreco(), produto.getQtd());
                arrayAcessorios.add(auxAcessorios);
            }
            if(produto.getCategoria().equals("Periféricos")){
                Perifericos auxPerifericos = new Perifericos(produto.getCategoria(), produto.getMarca(),produto.getModelo(),produto.getPreco(),produto.getQtd());
                arrayPerifericos.add(auxPerifericos);
            }
        }
       

        choiceBoxCategoria.getItems().addAll(categorias);
        choiceBoxCategoria.setValue("Todas");
        choiceBoxCategoria.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            categoriaSelecionada = newValue;
        });

        if (categoriaSelecionada.equals("Todas")) {
                        System.out.println("TESTE");

        }

        if(choiceBoxCategoria.equals("Todas")){
            System.out.println("TESTE");
            colunaCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
            colunaMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
            colunaModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
            colunaPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
            colunaQuantidade.setCellValueFactory(new PropertyValueFactory<>("qtd"));

            tabelaProdutos.setItems(dadosDaTabela);
            dadosDaTabela.addAll(arrayProdutos);
        }    

    }
}
