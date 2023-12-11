package entities;

public abstract class Cds {

    private int id;

    private String nome;

    private String artista;

    public Cds( String nome, String artista) {
        this.id = id;
        this.nome = nome;
        this.artista = artista;
    }


    public int gerarId (){
        return id + 1;
    }
}
