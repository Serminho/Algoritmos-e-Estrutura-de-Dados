// É a estrutura da lista encadeada usada para armazenar os processos
public class ListaDeProcessos {
    private Node cabeca;
    private Node cauda;
    private int tamanho;

    public ListaDeProcessos(){
        this.cabeca = null;
        this.cauda = null;
        this.tamanho = 0;
    }
    
    // Adiciona um processo no final da lista
    public void adicionarFinal(Processo processo) {
        Node novoNo = new Node(processo);
        if (cauda == null) {
            cabeca = novoNo;
            cauda = novoNo;
        } else {
            cauda.proximo = novoNo;
            cauda = novoNo;
        }
        tamanho++;
    }

    // Remove o processo do inicio da lista
    public Processo removerInicio() {
        if (cabeca == null) {
            return null;
        }
        Processo processoR = cabeca.processo;
        cabeca = cabeca.proximo;
        if (cabeca == null) {
            cauda = null;
        }
        tamanho--;
        return processoR;
    }

    // Verifica se a lista esta vazia (Usado pra simplificar o codigo)
    public boolean estaVazia() {
        return tamanho == 0;
    }

    // Retorna o tamanho da lista
    public int tamanho() {
        return tamanho;
    }

    // Percorre a lista enquanto mostra os processos
    public void percorrerLista() {
        Node atual = cabeca;
        while (atual != null) {
            System.out.println(atual.processo);
            atual = atual.proximo;
        }
    }

    // Verifica se o item atual da lista contem um ID
    public boolean contemId(int id){
        Node atual = cabeca;
        while (atual != null) {
            if (atual.processo.getId() == id) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    @Override
    public String toString() {
        if (cabeca == null) return "vazia";

        StringBuilder sb = new StringBuilder();
        Node atual = cabeca;
        int mostrando = 0;
        final int mostrarMax = 20;

        while (atual != null && mostrando < mostrarMax) {
            Processo p = atual.processo;

            sb.append("\n| " + p.getNome())
            .append(" | ID: ").append(p.getId())
            .append(" | Ciclos: ").append(p.getCiclosNecessarios());
            mostrando++;
            atual = atual.proximo;
        }
        if (atual != null) {
            int restantes = 0;
            Node temp = atual;
            while (temp != null) {
                restantes++;
                temp = temp.proximo;
            }
            sb.append("\n| ... e mais ").append(restantes).append(" processos.");
        }
        return sb.toString();
    }
    
}