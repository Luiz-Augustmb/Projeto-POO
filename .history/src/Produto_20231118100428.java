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

    public Produto(){
        
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

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

}
