public class Produto {
    
    private  String categoria;
    private  String marca;
    private  String modelo;
    private  double preco;
    private  int qtd;
    
    public Produto(String categoria, String marca, String modelo, double preco, int qtd) {
        this.categoria = categoria;
        this.marca = marca;
        this.modelo = modelo;
        this.preco = preco;
        this.qtd = qtd;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPreco() {
        return preco;
    }

    public int getQtd() {
        return qtd;
    }

    // geters and setters   

    

}
