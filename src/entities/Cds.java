package entities;

public class Cds extends Produto {

    public Cds(int id, String nome, double valor) {
        super(id, nome, valor);
    }

    @Override
    public String toString() {
        return "Cd:" +
                "id: " + id  + "\n" +
                ", nome: " + nome + "\n" +
                ", valor:" + valor + ". \n" ;
    }


}
