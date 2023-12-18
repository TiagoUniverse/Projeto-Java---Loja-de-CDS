package entities;

public abstract class Produto {

    protected int id;
    protected String nome;
    protected double valor;

    public Produto( String nome, double valor) {
        this.id = Loja.gerarProximoID();
        this.nome = nome;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract int exibirInfo();
}
