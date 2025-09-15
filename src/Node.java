public class Node {
    Processo processo;
    Node proximo;
    
    public Node(Processo processo) {
        this.processo = processo;
        this.proximo = null;
    }

    public Processo getProcesso() {
        return processo;
    }

    public Node getProximo() {
        return proximo;
    }
    public void setProximo(Node proximo) {
        this.proximo = proximo;
    }
    
}