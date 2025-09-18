// Classe principal que inicia e chama o programa
public class Main {
    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();
        Leitor.carregarProcessos("processos.txt", scheduler);
        scheduler.teste();
    }
}
