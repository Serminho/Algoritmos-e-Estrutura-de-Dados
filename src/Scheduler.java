public class Scheduler {
    private ListaDeProcessos listaAlta = new ListaDeProcessos();
    private ListaDeProcessos listaMedia = new ListaDeProcessos();
    private ListaDeProcessos listaBaixa = new ListaDeProcessos();
    private ListaDeProcessos listaBloqueados = new ListaDeProcessos();
    private int numeroCiclo = 1;
    private int contadorAlta = 0;

    public Scheduler() {
    }

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
        if (!listaBloqueados.estaVazia()) {
            Processo Desbloqueado = listaBloqueados.removerInicio();
            System.out.println("Desbloqueando processo: " + Desbloqueado.getNome());
            adicionarProcesso(Desbloqueado);
        }
        
        Processo processoAtual = null;
        if (contadorAlta >= 5) {
            if (!listaMedia.estaVazia()) {
                processoAtual = listaMedia.removerInicio();
                contadorAlta = 0;
            } else if (!listaBaixa.estaVazia()) {
                processoAtual = listaBaixa.removerInicio();
                contadorAlta = 0;
            }
        }
        if (processoAtual == null) {
            if (!listaAlta.estaVazia()) {
                processoAtual = listaAlta.removerInicio();
                contadorAlta++;
            } else if (!listaMedia.estaVazia()) {
                processoAtual = listaMedia.removerInicio();
                contadorAlta = 0;
            } else if (!listaBaixa.estaVazia()) {
                processoAtual = listaBaixa.removerInicio();
                contadorAlta = 0;
            }
            else {
                System.out.println("Nenhum processo para executar no ciclo " + numeroCiclo);
                numeroCiclo++;
                return;
            }
        }

        if (processoAtual != null) {
            if (processoAtual.getRecursoN().equalsIgnoreCase("DISCO") && !processoAtual.isRequisitado()) {
                processoAtual.setRequisitado(true);
                listaBloqueados.adicionarFinal(processoAtual);
                System.out.println("Processo " + processoAtual.getNome() + " está bloqueado aguardando recurso.");
                processoAtual = null;
            }
        }

        if (processoAtual != null) {
            System.out.println("\n| Ciclo numero: " + numeroCiclo + " | Executando processo: " + processoAtual.getNome());
            System.out.println("|");
            processoAtual.setCiclosNecessarios(processoAtual.getCiclosNecessarios() - 1);
            if (processoAtual.getCiclosNecessarios() > 0) {
                adicionarProcesso(processoAtual);
            }
            else {
                System.out.println("| O processo " + processoAtual.getNome() + " foi finalizado.");
            }
        }
        System.out.println("| Estado das listas no final do ciclo: " + numeroCiclo);
        System.out.print("| Alta: \n");
        listaAlta.percorrerLista();
        System.out.print("| Média: \n");
        listaMedia.percorrerLista();
        System.out.print("| Baixa: \n");
        listaBaixa.percorrerLista();
        System.out.print("| Bloqueados: \n");
        listaBloqueados.percorrerLista();
        System.out.println("\n|========================================");
        numeroCiclo++;

    }


    public void teste() {
        while (!listaAlta.estaVazia() || !listaMedia.estaVazia() || !listaBaixa.estaVazia()) {
            executarCiclo();
        }
        System.out.println("Todos os processos foram concluídos.");
    }
}

