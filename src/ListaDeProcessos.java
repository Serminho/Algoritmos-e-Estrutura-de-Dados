public class ListaDeProcessos {
    private Node cabeca;
    private Node cauda;
    private int tamanho;
    
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

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int tamanho() {
        return tamanho;
    }

    public void percorrerLista() {
        Node atual = cabeca;
        while (atual != null) {
            System.out.println(atual.processo);
            atual = atual.proximo;
        }
    }
    
}