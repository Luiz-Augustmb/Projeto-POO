import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RemoveController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField textFieldPreco;

    @FXML
    private TextField textFieldQuantidade;

    @FXML
    private Button excluirButton;

    @FXML
    private TextField textFildCategoria;

    @FXML
    private TextField textFieldMarca;

    @FXML
    private Button atualizarButton;

    @FXML
    private TextField textFieldModelo;

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
