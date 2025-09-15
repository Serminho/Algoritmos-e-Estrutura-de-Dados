public class Scheduler {
    private ListaDeProcessos listaAlta = new ListaDeProcessos();
    private ListaDeProcessos listaMedia = new ListaDeProcessos();
    private ListaDeProcessos listaBaixa = new ListaDeProcessos();
    private int numeroCiclo = 1;

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

    public void executarCiclo() {
        Processo processoAtual = null;
        if (!listaAlta.estaVazia()) {
            processoAtual = listaAlta.removerInicio();
        } else if (!listaMedia.estaVazia()) {
            processoAtual = listaMedia.removerInicio();
        } else if (!listaBaixa.estaVazia()) {
            processoAtual = listaBaixa.removerInicio();
        } else {
            System.out.println("Nenhum processo para executar neste ciclo.");
        }

        if (processoAtual != null) {
            System.out.println("Ciclo numero: " + numeroCiclo + " | Executando processo: " + processoAtual.getNome());
            processoAtual.setCiclosNecessarios(processoAtual.getCiclosNecessarios() - 1);
            if (processoAtual.getCiclosNecessarios() > 0) {
                adicionarProcesso(processoAtual);
            } else {
                System.out.println("O processo " + processoAtual.getNome() + " foi concluido.");
            }
        }
        numeroCiclo++;

    }


    public void teste() {
        while (!listaAlta.estaVazia() || !listaMedia.estaVazia() || !listaBaixa.estaVazia()) {
            executarCiclo();
        }
        System.out.println("Todos os processos foram concluídos.");
    }
}

