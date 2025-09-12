public class Processo {
    String nome;
    int id;
    int prioridade;
    String recursoN;
    boolean requisitado = false;

    public Processo(String nome, int id, int prioridade, String recursoN) {
        this.nome = nome;
        this.id = id;
        this.prioridade = prioridade;
        this.recursoN = recursoN;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public String getRecursoN() {
        return recursoN;
    }
    public void setRecursoN(String recursoN) {
        this.recursoN = recursoN;
    }

    public boolean isRequisitado() {
        return requisitado;
    }
    public void setRequisitado(boolean requisitado) {
        this.requisitado = requisitado;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " | ID: " + id + " | Prioridade: " + prioridade + " | Recurso: " + recursoN + " | Requisitado: " + requisitado;
    }
    
}
