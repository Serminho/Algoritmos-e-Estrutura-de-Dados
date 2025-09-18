// Importações necessarias para ler os arquivos de texto
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Classe responsavel por ler os processos de um arquivo de texto
public class Leitor {
    // Metodo para carregar os processos do arquivo e adicionar ao escalonador
    public static void carregarProcessos(String nomeArquivo, Scheduler scheduler) {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
             // Lê o arquivo linha por linha e ignora linhas vazias
            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty()) {
                    continue;
                }

                // Determina que linha do arquivo seja dividida em partes por ";"
                String[] dados = linha.split(";");
                // Verifica se o processo possui os 5 campos obrigatorios
                if (dados.length < 5) {
                    System.out.println("| Processo invalido (estão faltando os campos): " + linha);
                    continue;
                }

                // Pega o nome do processo ou nomeia como "Sem nome" caso esteja vazio
                String nome = dados[0].isEmpty() ? "Sem mome" : dados[0];
                
                // Converte a String do campo ID para um inteiro
                int id;
                try {
                    id = Integer.parseInt(dados[1]);
                } catch (NumberFormatException e) {
                    System.out.println("| ID inválido, processo ignorado: " + linha);
                    continue;
                }

                // Converte a String do campo Prioridade para um inteiro
                int prioridade;
                try {
                    prioridade = Integer.parseInt(dados[2]);
                } catch (NumberFormatException e) {
                    System.out.println("| Prioridade inválida, processo ignorado: " + linha);
                    continue;
                }

                // Pega o nome do recurso ou nomeia como "Sem recurso" caso esteja vazio
                String recursoN = dados[3].isEmpty() ? "Sem recurso" : dados[3];

                // Converte a String do campo Ciclos para um inteiro
                int ciclosNecessarios;
                try {
                    ciclosNecessarios = Integer.parseInt(dados[4]);
                } catch (NumberFormatException e) {
                    System.out.println("Ciclos inválidos, processo ignorado: " + linha);
                    continue;
                }

                // Criação do objeto Processo
                Processo processo = new Processo(nome, id, prioridade, recursoN, ciclosNecessarios);

                // Chama o processo que adicona na fila certa conforme a prioridade
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
            // Avisa caso o arquivo não for encontrado ou não puder ser lido
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

    }
}
