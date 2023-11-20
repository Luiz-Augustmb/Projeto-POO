public class Smartphone extends Produto {

    private String categoria;
    private String marca;
    private String modelo;
    private double preco;
    private int qtd;

    public Smartphone(String categoria, String marca, String modelo, double preco, int qtd) {
        this.categoria = categoria;
        this.marca = marca;
        this.modelo = modelo;
        this.preco = preco;
        this.qtd = qtd;
    }
    
}
