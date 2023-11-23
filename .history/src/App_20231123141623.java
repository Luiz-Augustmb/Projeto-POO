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
        primaryStage.getIcons().add(new Image("@images/icone.png"));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("loginLayout.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);

        primaryStage.setTitle("Login");
        primaryStage.setScene(tela);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
