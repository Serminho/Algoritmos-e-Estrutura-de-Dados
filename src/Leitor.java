import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Leitor {
    public static void carregarProcessos(String nomeArquivo, Scheduler scheduler) {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty()) {
                    continue;
                }
                String[] dados = linha.split(";");
                if (dados.length < 5) {
                    continue;
                }
                String nome = dados[0];
                int id = Integer.parseInt(dados[1]);
                int prioridade = Integer.parseInt(dados[2]);
                String recursoN = dados[3];
                int ciclosNecessarios = Integer.parseInt(dados[4]);
                Processo processo = new Processo(nome, id, prioridade, recursoN, ciclosNecessarios);

                if (prioridade == 1) {
                    scheduler.adicionarProcesso(processo);
                    System.out.println("Adicionando processo de alta prioridade:  " + processo);
                } else if (prioridade == 2) {
                    scheduler.adicionarProcesso(processo);
                    System.out.println("Adicionando processo de media prioridade: " + processo);
                } else if (prioridade == 3) {
                    scheduler.adicionarProcesso(processo);
                    System.out.println("Adicionando processo de baixa prioridade: " + processo);
                } else {
                    System.out.println("Prioridade inválida para o processo: " + processo);
                }
            }

        }
        catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

    }
}
