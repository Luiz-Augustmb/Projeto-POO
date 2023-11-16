import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
    private ChoiceBox<String> categoriaProduto;

    private String[] categorias = {"Smartphone", "Notebook", "Tablet", "Acessórios", "Periféricos"};
    private String selectedCategoria;

    @FXML
    void fazerLogin(ActionEvent event) {
        String usuario = usuarioLogin.getText();
        String senha = senhaLogin.getText();

        if(usuario.equals("admin") && senha.equals("senha")){
            System.out.println("Login Feito com Sucesso!");
            toIndex(event);
        }else{
            Alert loginInvalido = new Alert(Alert.AlertType.ERROR);
            loginInvalido.setTitle("Login Inválido");
            loginInvalido.setHeaderText("Usuário ou senha incorretos");
            loginInvalido.setContentText("Por favor, verifique seus dados e tente novamente.");
            loginInvalido.show();
        }
    }

    @FXML
    void initialize() {

        categoriaProduto.getItems().addAll(categorias);
        categoriaProduto.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedCategoria = newValue;
        });

    }

    public void addProduto(){
        // Obtendo os valores dos campos de texto
        String inputMarca = marcaProduto.getText();
        String inputModelo = modeloProduto.getText();
        String inputPreco = precoProduto.getText();
        String inputQtd = qtdProduto.getText();

        // Imprimindo os valores no console (substitua isso pelo que você quiser fazer)
        System.out.println("Categoria: " + selectedCategoria);
        System.out.println("Marca: " + inputMarca);
        System.out.println("Modelo: " + inputModelo);
        System.out.println("Preço: " + inputPreco);
        System.out.println("Quantidade: " + inputQtd);
    }

    

}
