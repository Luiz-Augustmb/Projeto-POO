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

        try {
            // ... seu código atual ...
            arrayProdutos = arquivoProdutos.ler();
            System.out.println(arrayProdutos.size());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
