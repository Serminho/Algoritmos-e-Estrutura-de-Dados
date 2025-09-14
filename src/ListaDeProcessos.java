public class ListaDeProcessos {
    Node cabeca;
    Node cauda;
    int tamanho;
    
    public void adicionarFinal(Processo processo) {
        Node novoNo = new Node(processo);
        if (cauda == null) {
            cabeca = novoNo;
            cauda = novoNo;
        } else {
            cauda.proximo = novoNo;
            cauda = novoNo;
            tamanho++;
        }
    }

    public void removerInicio() {
        if (cabeca == null) {
            return;
        }
        cabeca = cabeca.proximo;
        if (cabeca != null) {
            cabeca.anterior = null;
        } else {
            cauda = null;
        }
    }

    public int estaVazia() {
        return tamanho == 0 ? 1 : 0;
    }

    public int getTamanho() {
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
