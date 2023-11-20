import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.print.Collation;

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
        Collections.sort(arrayProdutos);

        for (int i = 0; i < arrayProdutos.size(); i++) {
            if(arrayProdutos!=null){
                System.out.println(arrayProdutos.get(i));
            }
        }

    }
}
