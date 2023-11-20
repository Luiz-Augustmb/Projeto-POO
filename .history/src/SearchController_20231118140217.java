import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;

public class SearchController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    private ArquivoProdutos arquivoProdutos = new ArquivoProdutos();
    private ArrayList<Produto> arrayProdutos = new ArrayList<>();


    @FXML
    void initialize() {

        arrayProdutos = arquivoProdutos.ler();

        for (int index = 0; index < arrayProdutos.size(); index++) {
            if(arrayProdutos!=null){
                System.out.println(arrayProdutos.get(i));
            }
        }

    }
}
