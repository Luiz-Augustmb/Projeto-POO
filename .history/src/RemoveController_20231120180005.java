import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class RemoveController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField textFildCategoria;

    @FXML
    private TextField textFieldPreco;

    @FXML
    private Button removerButton;

    @FXML
    private TextField textFieldQuantidade;

    @FXML
    private TextField textFieldMarca;

    @FXML
    private Button atualizarButton;

    @FXML
    private TextField textFieldModelo;

    @FXML
    void removerProduto(ActionEvent event) {
        Alert alertaRemover = new Alert(Alert.AlertType.CONFIRMATION);
        alertaRemover.setContentText("Deseja remover o produto?");
        alertaRemover.setHeaderText(null);
        alertaRemover.setTitle("Remover Produto");
        alertaRemover.initOwner(removerButton.getScene().getWindow()); // Definir o dono (janela pai) do Alert
        alertaRemover.showAndWait();
        
        // Comparando o resultado com ButtonType.OK
        if (alertaRemover.getResult() == javafx.scene.control.ButtonType.OK) {
            // Ação a ser realizada quando o usuário clicar em "OK"
            System.out.println("Produto removido");
        } else {
            // Ação a ser realizada se o usuário clicar em "Cancelar" ou fechar o alerta
            System.out.println("Operação cancelada");
        }
        
    }

    private Produto produtoSelecionado;

    public void setProdutoSelecionado(Produto produto) {
        this.produtoSelecionado = produto;
        preencherCamposComProduto();
    }

    private void preencherCamposComProduto() {
        // Preencha os campos de texto com os dados do produtoSelecionado
        if (produtoSelecionado != null) {
            textFieldPreco.setText(String.valueOf(produtoSelecionado.getPreco()));
            textFieldQuantidade.setText(String.valueOf(produtoSelecionado.getQtd()));
            textFildCategoria.setText(produtoSelecionado.getCategoria());
            textFieldMarca.setText(produtoSelecionado.getMarca());
            textFieldModelo.setText(produtoSelecionado.getModelo());
        }
    }

    @FXML
    void initialize() {

    }
}
