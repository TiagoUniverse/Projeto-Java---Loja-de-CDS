package entities;

public class Vinil extends Produto {

    private int ano;

    public Vinil(String nome, double valor, int ano) {
        super(nome, valor);
        this.ano = ano;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public int exibirInfo() {
        System.out.println("Nome: " + getNome());
        System.out.println("ID: " + getId());
        System.out.println("Preço: " + getValor());
        System.out.println("Ano de lançamento: " + getAno() );
        return 0;
    }
}
