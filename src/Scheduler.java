// Classe para o escalonamento e execução dos processos
public class Scheduler {
    // Listas separadas por prioridade
    private ListaDeProcessos listaAlta = new ListaDeProcessos();
    private ListaDeProcessos listaMedia = new ListaDeProcessos();
    private ListaDeProcessos listaBaixa = new ListaDeProcessos();
    private ListaDeProcessos listaBloqueados = new ListaDeProcessos();
    // Controle do ciclo atual e contagem dos processos de alta/media prioridade em cadeia
    private int numeroCiclo = 1;
    private int contadorAlta = 0;
    private int contadorMedia = 0;

    // Construtor para chamado vazio
    public Scheduler() {
    }

    // Adiciona o processo na lista certa conforme a prioridade
    public void adicionarProcesso(Processo processo) {
        if (processo.getPrioridade() == 1) {
            listaAlta.adicionarFinal(processo);
        } else if (processo.getPrioridade() == 2) {
            listaMedia.adicionarFinal(processo);
        } else if (processo.getPrioridade() == 3) {
            listaBaixa.adicionarFinal(processo);
        } else {
            System.out.println("A prioridade é invalida para o processo");
        }
    }

    // Metodo principal para executar 1 ciclo de escalonamento
    public void executarCiclo() {
         // Desbloqueia o processo mais antigo da lista de bloqueados
        if (!listaBloqueados.estaVazia()) {
            Processo desbloqueado = listaBloqueados.removerInicio();
            System.out.println("| Desbloqueando processo: " + desbloqueado.getNome());
            adicionarProcesso(desbloqueado);
        }
        
        Processo processoAtual = null;
        // Verificação para evitar a Starvation de processos com menor prioridade
        if (contadorMedia >= 5 && !listaBaixa.estaVazia()) {
            processoAtual = listaBaixa.removerInicio();
            contadorMedia = 0;
        }
        if (processoAtual == null && contadorAlta >= 5) {
            if (!listaMedia.estaVazia()) {
                processoAtual = listaMedia.removerInicio();
                contadorAlta = 0;
            } else if (!listaBaixa.estaVazia()) {
                processoAtual = listaBaixa.removerInicio();
                contadorAlta = 0;
            }
        }
        // Caso não estiver inibindo algum processo, faz a execução normal
        if (processoAtual == null) {
            if (!listaAlta.estaVazia()) {
                processoAtual = listaAlta.removerInicio();
                contadorAlta++;
                contadorMedia = 0;
            } else if (!listaMedia.estaVazia()) {
                processoAtual = listaMedia.removerInicio();
                contadorMedia++;
                contadorAlta = 0;
            } else if (!listaBaixa.estaVazia()) {
                processoAtual = listaBaixa.removerInicio();
                contadorAlta = 0;
                contadorMedia = 0;
            }
            // Avisa quando não há mais processos
            else {
                System.out.println("Nenhum processo para executar no ciclo " + numeroCiclo);
                numeroCiclo++;
                return;
            }
        }

        // Verifica se o processo precisa do "DISCO" (Verificação para bloqueio)
        if (processoAtual != null) {
            if (processoAtual.getRecursoN().equalsIgnoreCase("DISCO") && !processoAtual.isRequisitado()) {
                processoAtual.setRequisitado(true);
                listaBloqueados.adicionarFinal(processoAtual);
                System.out.println("| Processo " + processoAtual.getNome() + " está bloqueado aguardando recurso.");
                processoAtual = null;
            }
        }

        // Executa o processo (Se não estiver bloqueado)
        if (processoAtual != null) {
            System.out.println("\n| Ciclo numero: " + numeroCiclo + " | Executando processo: " + processoAtual.getNome());
            System.out.println("|");
            processoAtual.setCiclosNecessarios(processoAtual.getCiclosNecessarios() - 1);
            // Retorna o processo para o fim da fila se ainda restar ciclos
            if (processoAtual.getCiclosNecessarios() > 0) {
                adicionarProcesso(processoAtual);
            }
            // Finaliza o processo se não for necessario mais ciclos
            else {
                System.out.println("| O processo " + processoAtual.getNome() + " foi finalizado.");
            }
        }

        // Imprime o estado atual das listas
        StringBuilder estado = new StringBuilder();
        estado.append("| Estado das listas no final do ciclo: ").append(numeroCiclo).append("\n");
        estado.append("| Alta: ").append(listaAlta).append("\n");
        estado.append("| Média: ").append(listaMedia).append("\n");
        estado.append("| Baixa: ").append(listaBaixa).append("\n");
        estado.append("| Bloqueados: ").append(listaBloqueados).append("\n");
        estado.append("\n+========================================+");
        System.out.println(estado.toString());
        numeroCiclo++;

    }

    // Metodo que roda ate todos os processos terminarem (Main)
    public void teste() {
        while (!listaAlta.estaVazia() || !listaMedia.estaVazia() || !listaBaixa.estaVazia() || !listaBloqueados.estaVazia()) {
            executarCiclo();
        }
        System.out.println("|Todos os processos foram concluídos.");
        System.out.println("+========================================+");
    }
}

