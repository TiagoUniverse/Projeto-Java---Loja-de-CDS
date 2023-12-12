package entities;

public class Cds extends Produto {

    public Cds(String nome, double valor) {
        super(nome, valor);
    }

    @Override
    public void exibirInfo(){
        System.out.println("Nome: " + getNome());
        System.out.println("ID: " + getId());
        System.out.println("Preço: " + getValor());
    }

}
