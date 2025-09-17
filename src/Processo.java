public class Processo {
    private String nome;
    private int id;
    private int prioridade;
    private String recursoN;
    private boolean requisitado = false;
    private int ciclosNecessarios;
    private int prioridadeOriginal;

    public Processo(String nome, int id, int prioridade, String recursoN, int ciclosNecessarios) {
        this.nome = nome;
        this.id = id;
        this.prioridade = prioridade;
        this.recursoN = recursoN;
        this.ciclosNecessarios = ciclosNecessarios;
        this.requisitado = false;
        this.prioridadeOriginal = prioridade;
    }

    public String getNome() {
        return nome;
    }
 
    public int getId() {
        return id;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public String getRecursoN() {
        return recursoN;
    }

    public boolean isRequisitado() {
        return requisitado;
    }
    public void setRequisitado(boolean requisitado) {
        this.requisitado = requisitado;
    }

    public int getCiclosNecessarios() {
        return ciclosNecessarios;
    }
    public void setCiclosNecessarios(int ciclosNecessarios) {
        this.ciclosNecessarios = ciclosNecessarios;
    }

    public int getPrioridadeOriginal(){
        return prioridadeOriginal;
    }


    @Override
    public String toString() {
        return "| Nome: " + nome + " | ID: " + id + " | Prioridade: " + prioridade + " | Ciclos Necessarios: " + ciclosNecessarios + " | Recurso: " + recursoN;
    }
    
}
