import java.io.*;
import java.util.ArrayList;

public class ArquivoProdutos{

    //Configurando o método de escrever no Arquivo
    public void escrever (Produto produto){

        //Criando as estruturas que permitirão escrever o arquivo
        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;

        //try catch para possíveis erros
        try{

            //Informamos o nome do arquivo onde queremos armazernar nossas informações
            os = new FileOutputStream("Produtos.txt",true);
            //Ponte que transforma de stream para caracteres para stream de bytes
            osw = new OutputStreamWriter(os);
            //Em bw escreveremos a informação que queremos salvar no nosso txt
            bw = new BufferedWriter(osw);

            //Escrevendo uma linha referência
            bw.write("--- Produto ---");
            bw.newLine();
            //Pegando os dados do produtos e escrevendo no arquivo
            bw.write(produto.getCategoria() + "\n");
            bw.write(produto.getMarca() + "\n");
            bw.write(produto.getModelo() + "\n");
            bw.write(produto.getPreco() + "\n");
            bw.write(produto.getQtd() + "\n");


        }catch (Exception e){
            System.out.println("ERRO: " + e);
        }finally {
            try {
                bw.close();
            }catch (Exception e){}
        }

    }

    public ArrayList<Produto> ler(){

        //Classes básicas para realizar a leitura de dados de um arquivo
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        //Variável auxiliar para ler as informações
        String linhaLer;

        //Array que vai armazer os jogadores encontrados no arquivo
        ArrayList<Produto> arrayProdutos = new ArrayList<>();

        try{

            is = new FileInputStream("Produtos.txt");
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            linhaLer = br.readLine(); //Coloca o cursor no inicio do arquivo .txt

            //Enquanto tiver informações no .txt seguimos lendo as informações
            while (linhaLer != null){

                //Verificando se a string encontrou a flag
                if(linhaLer.contains("--- Produto ---")){

                    //Variavel auxiliar de produto, que servirá para salvar o produto no arquivo
                    Produto aux = new Produto();

                    //Preenchendo as informações do produto
                    aux.setCategoria(br.readLine());
                    aux.setMarca(br.readLine());
                    aux.setModelo(br.readLine());
                    aux.setPreco(Double.parseDouble(br.readLine()));
                    aux.setQtd(Integer.parseInt(br.readLine()));

                    //Colocando o produto no arraylist
                    arrayProdutos.add(aux);
                }

                //Voltando a variável novamente ao inicio do arquivo
                linhaLer = br.readLine();
            }

        }catch (Exception e) {
            System.out.println(e);

        } finally {
            try {
                br.close();
            }catch (Exception e){
                System.out.println(e);
            }
        }

        //Retornando o arraylist para a main
        return  arrayProdutos;
    }

    public void atualizar(Produto produtoAtualizado) {
        ArrayList<Produto> arrayProdutos = ler();
    
        for (int i = 0; i < arrayProdutos.size(); i++) {
            Produto produtoExistente = arrayProdutos.get(i);
            if (produtoExistente.getCategoria().equals(produtoAtualizado.getCategoria()) &&
                produtoExistente.getMarca().equals(produtoAtualizado.getMarca()) &&
                produtoExistente.getModelo().equals(produtoAtualizado.getModelo())) {
                
                arrayProdutos.set(i, produtoAtualizado);
                escrever(arrayProdutos);
                break; // Interrompe o loop após encontrar e atualizar o produto
            }
        }
    }
    
    public void apagar(Produto produtoExcluir) {
        ArrayList<Produto> arrayProdutos = ler();
    
        arrayProdutos.removeIf(produto -> 
            produto.getCategoria().equals(produtoExcluir.getCategoria()) &&
            produto.getMarca().equals(produtoExcluir.getMarca()) &&
            produto.getModelo().equals(produtoExcluir.getModelo())
        );
    
        escrever(arrayProdutos);
    }
}