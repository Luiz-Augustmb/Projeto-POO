import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
    private String[] categorias = { "Smartphone", "Notebook", "Tablet", "Acessórios", "Periféricos" };

    // Variáveis auxilares dos campos
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

        if (categoriaSelecionada != null && inputMarca != null && inputModelo != null && inputPreco != null && inputQtd != null) {
            if (!inputPreco.isEmpty() && !inputQtd.isEmpty()) {
                try {
                    Produto auxProduto = new Produto(categoriaSelecionada, inputMarca, inputModelo, Double.valueOf(inputPreco),
                            Integer.valueOf(inputQtd));
        
                    arquivoProdutos.escrever(auxProduto);
        
                    Alert alertaConfirmacao = new Alert(Alert.AlertType.INFORMATION);
                    alertaConfirmacao.setContentText("Produto Adicionado com sucesso!");
                    alertaConfirmacao.setHeaderText(null);
                    alertaConfirmacao.setTitle("Cadastro de Produtos");
                    alertaConfirmacao.showAndWait();
        
                    if (alertaConfirmacao.getResult() == ButtonType.OK) {
                        reinicializarCampos();
                    }
                } catch (NumberFormatException e) {
                    // Tratar exceção se a conversão para Double ou Integer falhar
                    System.out.println("Erro na conversão de valores: " + e.getMessage());
                }
            } else {
                // Mostrar alerta indicando que os campos de preço ou quantidade estão vazios
                Alert alertaErro = new Alert(Alert.AlertType.ERROR);
                alertaErro.setContentText("Campos de preço ou quantidade estão vazios!");
                alertaErro.setHeaderText(null);
                alertaErro.setTitle("Erro ao adicionar produto");
                alertaErro.showAndWait();
            }
        } else {
            // Se algum dos campos estiver null (não preenchido), entra a exception,
            // evitando o crash e forçando o usuário a entrar com todos os campos
            System.out.println("Erro no cadastro de produto");
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setContentText("Campos não preenchidos!");
            alertaErro.setHeaderText(null);
            alertaErro.setTitle("Erro ao adicionar produto");
            alertaErro.showAndWait();
        
            // Reinicializa os campos após o usuário clicar em OK no alerta de erro
            if (alertaErro.getResult() == ButtonType.OK) {
                reinicializarCampos();
            }
        }
           
    }


    private void reinicializarCampos() {
        categoriaProduto.getSelectionModel().clearSelection();
        marcaProduto.clear();
        modeloProduto.clear();
        precoProduto.clear();
        qtdProduto.clear();
    }

    @FXML
    void initialize() {

        categoriaProduto.getItems().addAll(categorias);
        categoriaProduto.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            categoriaSelecionada = newValue;
        });

    }

}
