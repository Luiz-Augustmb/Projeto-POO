import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private Button addProdutoButton;

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
    private ChoiceBox<String> categoriaProduto;

    // Implementando opções de categorias na ChoiceBox
    private String[] categorias = {"Smartphone", "Notebook", "Tablet", "Acessórios", "Periféricos"};
    
    //Variáveis auxilares dos campos
    private String categoriaSelecionada;
    private String inputMarca;
    private String inputModelo;
    private String inputPreco;
    private String inputQtd;

    private ArquivoProdutos arquivoProdutos = new ArquivoProdutos();
    private ArrayList<Produto> arrayProdutos = new ArrayList<>();

    // Metodo acionado ao clicar no addProdutoButton, e adicionando o produto
    @FXML
    public void addProduto(ActionEvent event) {
        // Obtendo os valores dos campos de texto para as variáveis auxiliares
        inputMarca = marcaProduto.getText();
        inputModelo = modeloProduto.getText();
        inputPreco = precoProduto.getText();
        inputQtd = qtdProduto.getText();

        // Imprimindo os valores no terminal
        System.out.println("Categoria: " + categoriaSelecionada);
        System.out.println("Marca: " + inputMarca);
        System.out.println("Modelo: " + inputModelo);
        System.out.println("Preço: R$" + Double.valueOf(inputPreco));
        System.out.println("Quantidade: " + Integer.valueOf(inputQtd));

        if(categoriaSelecionada!=null && inputMarca!=null && inputModelo!=null && inputPreco!=null && inputQtd!=null){
            Produto auxProduto = new Produto(categoriaSelecionada, inputMarca, inputModelo, Double.valueOf(inputPreco), Integer.valueOf(inputQtd));
            arquivoProdutos.escrever(auxProduto);
            Alert alertaConfirmacao = new Alert(Alert.AlertType.INFORMATION);
            alertaConfirmacao.setContentText("Produto Adicionado com sucesso!");
            alertaConfirmacao.showAndWait();
        }else{
            // Se algum dos campos estiver null (não preenchido), entra a exception, evitando o crash e forçando o usuário a entrar com todos os campos
            
        }    
    }
    
    @FXML
    void initialize() {

        categoriaProduto.getItems().addAll(categorias);
        categoriaProduto.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            categoriaSelecionada = newValue;
        });
        

    }

}
