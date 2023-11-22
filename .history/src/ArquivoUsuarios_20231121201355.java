import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class ArquivoUsuarios {
    // Configurando o método de escrever no Arquivo
    public void escrever(Usuario usuario) {

        // Criando as estruturas que permitirão escrever o arquivo
        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;

        // try catch para possíveis erros
        try {

            // Informamos o nome do arquivo onde queremos armazernar nossas informações
            os = new FileOutputStream("Usuários.txt", true);
            // Ponte que transforma de stream para caracteres para stream de bytes
            osw = new OutputStreamWriter(os);
            // Em bw escreveremos a informação que queremos salvar no nosso txt
            bw = new BufferedWriter(osw);

            // Escrevendo uma linha referência
            bw.write("--- Usuário ---");
            bw.newLine();
            // Pegando os dados do Usuário e escrevendo no arquivo
            bw.write(usuario.getNome() + "\n");
            bw.write(usuario.getUsuario() + "\n");
            bw.write(usuario.getSenha() + "\n");

        } catch (Exception e) {
            System.out.println("ERRO: " + e);
        } finally {
            try {
                bw.close();
            } catch (Exception e) {
            }
        }

    }

    public ArrayList<Usuario> ler() {

        // Classes básicas para realizar a leitura de dados de um arquivo
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        // Variável auxiliar para ler as informações
        String linhaLer;

        // Array que vai armazer os jogadores encontrados no arquivo
        ArrayList<Usuario> arrayUsuarios = new ArrayList<>();

        try {

            is = new FileInputStream("Usuários.txt");
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            linhaLer = br.readLine(); // Coloca o cursor no inicio do arquivo .txt

            // Enquanto tiver informações no .txt seguimos lendo as informações
            while (linhaLer != null) {

                // Verificando se a string encontrou a flag
                if (linhaLer.contains("--- Usuário ---")) {

                    // Variavel auxiliar de usuário, que servirá para salvar o usuário no arquivo
                    Usuario aux = new Usuario();

                    // Preenchendo as informações do usuário
                    aux.setNome(br.readLine());
                    aux.setUsuario(br.readLine());
                    aux.setSenha(br.readLine());

                    // Colocando o produto no arraylist
                    arrayUsuarios.add(aux);
                }

                // Voltando a variável novamente ao inicio do arquivo
                linhaLer = br.readLine();
            }

        } catch (Exception e) {
            System.out.println(e);

        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        // Retornando o arraylist para a main
        return arrayUsuarios;
    }

    public void atualizar(Usuario usuarioParaAtualizar, Usuario usuarioAtualizado) {
        ArrayList<Usuario> usuarios = ler(); // Ler todos os produtos do arquivo

        // Encontrar o usuário a ser atualizado
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usuario = usuarios.get(i);
            if (usuario.getNome().equals(usuarioParaAtualizar.getNome()) &&
                usuario.getUsuario().equals(usuarioParaAtualizar.getUsuario()) &&
                usuario.getSenha().equals(usuarioParaAtualizar.getSenha())
            ) 
            { 
                usuarios.set(i, usuarioAtualizado);
                break;
            }
        }
        // Reescrever todas as informações atualizadas no arquivo
        reescreverArquivo(usuarios);
    }

    public void excluir(Usuario usuarioParaExcluir) {
        System.out.println("TESTE");
        ArrayList<Usuario> usuarios = ler(); // Ler todos os usuários do arquivo

        // Encontrar o usuário a ser excluído
        usuarios.removeIf(usuario -> usuario.getNome().equals(usuarioParaExcluir.getNome()) &&
                          usuario.getUsuario().equals(usuarioParaExcluir.getUsuario()) &&
                          usuario.getSenha().equals(usuarioParaExcluir.getSenha())
        );

        // Reescrever o arquivo excluindo o usuário
        reescreverArquivo(usuarios);
    }

    private void reescreverArquivo(ArrayList<Usuario> usuarios) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Produtos.txt"))) {
            for (Usuario usuario : usuarios) {
                bw.write("--- Usuários ---");
                bw.newLine();
                bw.write(usuario.getNome() + "\n");
                bw.write(usuario.getUsuario() + "\n");
                bw.write(usuario.getSenha() + "\n");
                
            }
        } catch (IOException e) {
            System.out.println("Erro ao reescrever o arquivo: " + e.getMessage());
        }
    }
}
