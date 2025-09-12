public class Node {
    Processo processo;
    Node proximo;
    
    public Node(Processo processo) {
        this.processo = processo;
        this.proximo = null;
    }
}