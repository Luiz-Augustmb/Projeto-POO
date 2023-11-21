public class Produto {
    
    private static int ultimoId = lerUltimoId(); // Inicializa o último ID ao iniciar o programa
    private int id;
    private String categoria;
    private String marca;
    private String modelo;
    private double preco;
    private int qtd;

    public Produto(String categoria, String marca, String modelo, double preco, int qtd) {
        this.id++;
        this.categoria = categoria;
        this.marca = marca;
        this.modelo = modelo;
        this.preco = preco;
        this.qtd = qtd;
        System.out.println(id);
    }

    public Produto(){
        
    }

    private static int lerUltimoId() {
        // Implementação para ler o último ID do arquivo
        return 0; // Exemplo: você precisa implementar a leitura real do arquivo
    }

    private static void salvarUltimoId() {
        // Implementação para salvar o último ID no arquivo
        // Exemplo: você precisa implementar a escrita real no arquivo
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
