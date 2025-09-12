public class ListaDeProcessos {
    Node cabeca;
    Node cauda;
    int tamanho;
    
    public void adicionarFinal(Processo processo) {
        Node novoNo = new Node();
        if (cabeca == null) {
            cabeca = novoNo;
            cauda = novoNo;
        } else {
            cauda.proximo = novoNo;
            cauda = novoNo;
            tamanho++;
        }
    }
    public Processo removerInicio() {
        if (cabeca == null) {
            return null;
        } else 
        }
    }
}
