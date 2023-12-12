package entities;

import java.util.ArrayList;
import java.util.List;

public class Loja {

    // é uma lista de cds, e nao de produtos
    protected static List<Produto> lista_cds = new ArrayList<>();

    protected static int proximoId = 0;

    public void adicionar_cd (Produto cd){
        lista_cds.add(cd);
    }

    public static int gerarProximoID(){
        for (Produto produto : lista_cds ) {
            if (produto.getId() == proximoId ){
                proximoId++;
                return gerarProximoID();
            }

        }
        return proximoId;
    }

    public void exibirEstoque(){
        for (Produto produto : lista_cds) {
            produto.exibirInfo();
            System.out.println("");
        }
    }
}
