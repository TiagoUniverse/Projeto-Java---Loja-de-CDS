package entities;

public class Cds extends Produto {

    private  String nome_artista;
    public Cds(String nome, double valor, String nome_artista) {
        super(nome, valor);
        this.nome_artista = nome_artista;
    }

    public String getNome_artista() {
        return nome_artista;
    }

    public void setNome_artista(String nome_artista) {
        this.nome_artista = nome_artista;
    }

    @Override
    public int exibirInfo(){
        System.out.println("Nome: " + getNome());
        System.out.println("ID: " + getId());
        System.out.println("Preço: " + getValor());
        System.out.println("Nome do artista: " + getNome_artista());
        return 0;
    }

}
