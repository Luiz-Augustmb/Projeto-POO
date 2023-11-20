import java.io.*;
import java.util.ArrayList;

public class ArquivoProdutos{

    //Configurando o método de escrever no Arquivo
    public void escrever (Jogador jogador){

        //Criando as estruturas que permitirão escrever o arquivo
        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;

        //try catch para possíveis erros
        try{

            //Informamos o nome do arquivo onde queremos armazernar nossas informações
            os = new FileOutputStream("Jogadores.txt",true);
            //Ponte que transforma de stream para caracteres para stream de bytes
            osw = new OutputStreamWriter(os);
            //Em bw escreveremos a informação que queremos salvar no nosso txt
            bw = new BufferedWriter(osw);

            //Escrevendo uma linha referência
            bw.write("--- Jogador ---");
            bw.newLine();
            //Pegando os dados do jogador e escrevendo no arquivo
            bw.write(jogador.getNome() + "\n");
            bw.write(jogador.getNumero() + "\n");
            bw.write(jogador.getPosicao() + "\n");


        }catch (Exception e){
            System.out.println("ERRO: " + e);
        }finally {
            try {
                bw.close();
            }catch (Exception e){}
        }

    }

    public ArrayList<Jogador> ler(){

        //Classes básicas para realizar a leitura de dados de um arquivo
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        //Variável auxiliar para ler as informações
        String linhaLer;

        //Array que vai armazer os jogadores encontrados no arquivo
        ArrayList<Jogador> arrayJogadores = new ArrayList<>();

        try{

            is = new FileInputStream("Jogadores.txt");
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            linhaLer = br.readLine(); //Coloca o cursor no inicio do arquivo .txt

            //Enquanto tiver informações no .txt seguimos lendo as informações
            while (linhaLer != null){

                //Verificando se a string encontrou a flag
                if(linhaLer.contains("--- Jogador ---")){

                    //Variavel auxiliar de jogador, que servirá para salvar o Jogador no arquivo
                    Jogador aux = new Jogador();

                    //Preenchendo as informações do jogador
                    aux.setNome(br.readLine());
                    aux.setNumero(Integer.parseInt(br.readLine()));
                    aux.setPosicao(br.readLine());

                    //Colocando o jogador no arraylist
                    arrayJogadores.add(aux);
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
        return  arrayJogadores;
    }
}