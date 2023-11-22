import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateUserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField textFieldSenha;

    @FXML
    private Button updateUserButton;

    @FXML
    private TextField textFieldUsuario;

    @FXML
    private TextField textFieldNome;

    @FXML
    void updateUser(ActionEvent event) {
        if (usuarioSelecionado.getNome().equals(textFieldNome.getText())
                && usuarioSelecionado.getUsuario().equals(textFieldUsuario.getText())
                && usuarioSelecionado.getSenha().equals(textFieldSenha.getText())) {
            Alert alertaErroUsuario = new Alert(Alert.AlertType.ERROR);
            alertaErroUsuario.setContentText("Não houve Alteração!");
            alertaErroUsuario.setHeaderText(null);
            alertaErroUsuario.setTitle("Erro ao atualizar produto");
            alertaErroUsuario.initOwner(updateUserButton.getScene().getWindow());
            alertaErroUsuario.showAndWait();
        } else {
            Usuario usuarioAtualizado = new Usuario(textFieldNome.getText(), textFieldUsuario.getText(),
                    textFieldSenha.getText());

            updateArquivoUsuario.atualizar(usuarioSelecionado, usuarioAtualizado);     
            Alert usuarioAtualizadoAlert = new Alert(Alert.AlertType.INFORMATION);
            usuarioAtualizadoAlert.setTitle("Atualização bem sucedida!");
            usuarioAtualizadoAlert.setHeaderText("Alterações feitas com sucesso");
            usuarioAtualizadoAlert.setContentText("Usuário atualizado com Sucesso!");
            usuarioAtualizadoAlert.showAndWait();

            usersController.atualizarTabela();

            ((Stage) updateUserButton.getScene().getWindow()).close();
        }
    }

    @FXML
    void initialize() {

    }

    ArquivoUsuarios updateArquivoUsuario = new ArquivoUsuarios();
    private UsersController usersController;
    private Usuario usuarioSelecionado;

    public void setUsersController(UsersController usersController) {
        this.usersController = usersController;
    }

    public void setUsuarioSelecionado(Usuario usuario) {
        this.usuarioSelecionado = usuario;
        preencherCamposComUsuario();
    }

    private void preencherCamposComUsuario() {
        // Preencha os campos de texto com os dados do usuario selecionado para
        // alteração
        if (usuarioSelecionado != null) {
            textFieldNome.setText(usuarioSelecionado.getNome());
            textFieldUsuario.setText(usuarioSelecionado.getUsuario());
            textFieldSenha.setText(usuarioSelecionado.getSenha());
        }
    }
}
