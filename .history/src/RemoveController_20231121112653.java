import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
            arquivoProdutos.excluir(produtoSelecionado);
            ((Stage) removerButton.getScene().getWindow()).close();
        } else {
            // Ação a ser realizada se o usuário clicar em "Cancelar" ou fechar o alerta
            System.out.println("Operacao cancelada");
        }
    }

    @FXML
    void atualizarProduto(ActionEvent event) {
        String categoriaAtualizadoProduto = textFildCategoria.getText();
        String marcaAtualizadoProduto = textFieldMarca.getText();
        String modeloAtualizadoProduto = textFieldModelo.getText();
        double precoAtualizadoProduto = Double.parseDouble(textFieldPreco.getText());
        int qtdAtualizadoProduto = Integer.parseInt(textFieldQuantidade.getText());

        if (produtoSelecionado.getCategoria().equals(categoriaAtualizadoProduto)
                && produtoSelecionado.getMarca().equals(marcaAtualizadoProduto)
                && produtoSelecionado.getModelo().equals(modeloAtualizadoProduto)
                && produtoSelecionado.getPreco() == precoAtualizadoProduto
                && produtoSelecionado.getQtd() == qtdAtualizadoProduto) {
            System.out.println("ERRO NA ATUALIZACAO DO PRODUTO");
            Alert alertaErro = new Alert(Alert.AlertType.ERROR);
            alertaErro.setContentText("Não houve Alteração!");
            alertaErro.setHeaderText(null);
            alertaErro.setTitle("Erro ao atualizar produto");
            alertaErro.initOwner(atualizarButton.getScene().getWindow());
            alertaErro.showAndWait();
        } else {
            Produto produtoAtualizado = new Produto(categoriaAtualizadoProduto, marcaAtualizadoProduto,
                    modeloAtualizadoProduto, precoAtualizadoProduto, qtdAtualizadoProduto);

            if (produtoAtualizado.getQtd() == 0) {
                Alert alertaRemover = new Alert(Alert.AlertType.CONFIRMATION);
                alertaRemover.setContentText("Deseja remover o produto?");
                alertaRemover.setHeaderText(null);
                alertaRemover.setTitle("Remover Produto");
                alertaRemover.initOwner(removerButton.getScene().getWindow()); // Definir o dono (janela pai) do Alert
                alertaRemover.showAndWait();

                // Comparando o resultado com ButtonType.OK
                if (alertaRemover.getResult() == javafx.scene.control.ButtonType.OK) {
                    // Ação a ser realizada quando o usuário clicar em "OK"
                    arquivoProdutos.excluir(produtoSelecionado);
                    
                    Platform.runLater(() -> {
                        try {
                            searchController.atualizarTabela();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });

                    ((Stage) removerButton.getScene().getWindow()).close();
                } else {
                    // Ação a ser realizada se o usuário clicar em "Cancelar" ou fechar o alerta
                    System.out.println("Operacao cancelada");
                }
            } else if (produtoAtualizado.getQtd() > 0) {
                Alert alertaAtualizar = new Alert(Alert.AlertType.CONFIRMATION);
                alertaAtualizar.setContentText("Deseja atualizar o produto?");
                alertaAtualizar.setHeaderText(null);
                alertaAtualizar.setTitle("Atualizar Produto");
                alertaAtualizar.initOwner(removerButton.getScene().getWindow()); // Definir o dono (janela pai) do Alert
                alertaAtualizar.showAndWait();
                // Comparando o resultado com ButtonType.OK
                if (alertaAtualizar.getResult() == javafx.scene.control.ButtonType.OK) {
                    // Ação a ser realizada quando o usuário clicar em "OK"
                    System.out.println("Produto atualizado");
                    arquivoProdutos.atualizar(produtoSelecionado, produtoAtualizado);
                    
                    Platform.runLater(() -> {
                        try {
                            searchController.atualizarTabela();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });

                    ((Stage) removerButton.getScene().getWindow()).close();
                } else {
                    // Ação a ser realizada se o usuário clicar em "Cancelar" ou fechar o alerta
                    System.out.println("Operacao cancelada");
                }
            } else {
                System.out.println("Valor de quantidade inválida");
            }
        }

    }

    private Produto produtoSelecionado;
    private ArquivoProdutos arquivoProdutos = new ArquivoProdutos();
    private SearchController searchController;
    

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
