package entities;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import static sun.util.locale.LocaleUtils.isEmpty;

public class Loja {

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


    public Produto procurar_produto(int id){
        for(Produto produto : lista_cds){
            if (produto.getId() == id){
                produto.exibirInfo();
                return produto;
            }
        }
        System.out.println("O id pesquisado não existe.");
       return null;

    }



    public void exibirEstoque(){
        if (lista_cds.isEmpty()){
            System.out.println("A loja está vazia. Por favor, cadastre alguns produtos. \n");
        } else{
            for (Produto produto : lista_cds) {
                produto.exibirInfo();
                System.out.println("");
            }
        }

    }
}
