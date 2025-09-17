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
                    System.out.println("| Processo invalido (estão faltando os campos): " + linha);
                    continue;
                }

                
                String nome = dados[0].isEmpty() ? "Sem mome" : dados[0];
                
                int id;
                try {
                    id = Integer.parseInt(dados[1]);
                } catch (NumberFormatException e) {
                    System.out.println("| ID inválido, processo ignorado: " + linha);
                    continue;
                }

                int prioridade;
                try {
                    prioridade = Integer.parseInt(dados[2]);
                } catch (NumberFormatException e) {
                    System.out.println("| Prioridade inválida, processo ignorado: " + linha);
                    continue;
                }

                String recursoN = dados[3].isEmpty() ? "Sem recurso" : dados[3];

                int ciclosNecessarios;
                try {
                    ciclosNecessarios = Integer.parseInt(dados[4]);
                } catch (NumberFormatException e) {
                    System.out.println("Ciclos inválidos, processo ignorado: " + linha);
                    continue;
                }

                Processo processo = new Processo(nome, id, prioridade, recursoN, ciclosNecessarios);

                if (prioridade == 1) {
                    scheduler.adicionarProcesso(processo);
                    System.out.println("| Adicionando processo de alta prioridade:  " + processo);
                } else if (prioridade == 2) {
                    scheduler.adicionarProcesso(processo);
                    System.out.println("| Adicionando processo de media prioridade: " + processo);
                } else if (prioridade == 3) {
                    scheduler.adicionarProcesso(processo);
                    System.out.println("| Adicionando processo de baixa prioridade: " + processo);
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
