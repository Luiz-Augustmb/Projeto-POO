import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginControler {

    @FXML
    private PasswordField senhaLogin;

    @FXML
    private Button loginButton;

    @FXML
    private TextField usuarioLogin;

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

    private void toIndex(ActionEvent event) {
        try {
            FXMLLoader indexLoader = new FXMLLoader(getClass().getResource("indexLayout.fxml"));
            Parent root = indexLoader.load();
            Scene indexScene = new Scene(root);
    
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.setScene(indexScene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro de IO ao carregar a tela 'index': " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exceção inesperada ao carregar a tela 'index': " + e.getMessage());
        }
    }

}

