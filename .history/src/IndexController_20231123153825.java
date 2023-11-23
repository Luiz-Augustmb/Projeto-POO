import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class IndexController implements Initializable{

    @FXML
    private ImageView add;

    @FXML
    private ImageView menuBar;

    @FXML
    private ImageView exit;

    @FXML
    private Pane navBar;

    @FXML
    private ImageView search;

    @FXML
    private VBox vBox;

    @FXML
    private ImageView user;

    @FXML
    private ImageView remove;

    @FXML
    private ImageView home;

    @FXML
    private ImageView logOutImg;

    @FXML
    private StackPane contentArea;

    @FXML
    void goToHomePage(MouseEvent event) throws IOException {
        homeImg();
    }

    @FXML
    void goToSearchPage(MouseEvent event) throws IOException {
        searchImg();
    }

    @FXML
    void goToAddPage(MouseEvent event) throws IOException {
        addImg();
    }

    @FXML
    void goToUsersPage(MouseEvent event) throws IOException {
        userImg();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try{            
            Parent fxml = FXMLLoader.load(getClass().getResource("homeLayout.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml);
        } catch(IOException e){
            Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public void homeImg() throws IOException{
        Parent fxml = FXMLLoader.load(getClass().getResource("homeLayout.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);            
    }

    public void searchImg() throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("searchLayout.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);            
    }

    public void addImg() throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("addLayout.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);            
    }

    public void userImg() throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("usersLayout.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);            
    }

}

