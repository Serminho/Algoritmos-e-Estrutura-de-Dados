public class Node {
    Processo processo;
    Node proximo;
    Node anterior;
    
    public Node(Processo processo) {
        this.processo = processo;
        this.proximo = null;
    }
}