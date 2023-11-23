import java.io.File;
import java.io.InputStream;

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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("loginLayout.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);

        InputStream stream = getClass().getResourceAsStream("/images/icon.png");
        if (stream != null) {
            Image image = new Image(stream);
            primaryStage.getIcons().add(image);
        }        
        primaryStage.setTitle("Login");
        primaryStage.setScene(tela);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
