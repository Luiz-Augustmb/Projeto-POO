import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Caminho do ícone: " + new File("images/icon.png").getAbsolutePath());
        primaryStage.getIcons().add(new Image("file:images/icon.png"));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("loginLayout.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);

        primaryStage.setTitle("Login");
        primaryStage.setScene(tela);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
