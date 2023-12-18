package entities;

import Exceptions.ProdutoNaoEncontradoException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static sun.util.locale.LocaleUtils.isEmpty;

public class Loja {

    protected static List<Produto> lista_cds = new ArrayList<>();

    protected static int proximoId;

    public void adicionar_produto (Produto produto){
        produto.setId(gerarProximoID());
        lista_cds.add(produto);
    }

    public void remover_cd (Produto cd){
        lista_cds.remove(cd);
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


    public Produto procurar_produto(int id) throws ProdutoNaoEncontradoException {
        for(Produto produto : lista_cds){
            if (produto.getId() == id){
                produto.exibirInfo();
                return produto;
            }
        }
         throw new ProdutoNaoEncontradoException("O id " + id + " não foi encontrado no estoque.");
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


    public Produto atualizar_produto(Scanner scanner, Produto produtoAtualizar_buscado) {

        System.out.print("Insira o nome do produto: ");
        String nome = scanner.nextLine();


        double valor;
        int validacao = 0;
        do {
            try {
                System.out.print("Insira o preço do produto: ");
                valor = scanner.nextDouble();
                validacao = 1;

            } catch (InputMismatchException e) {
                System.out.println("\n Preço do produto inválido. Por favor, insira um valor inteiro ou decimal (Ex: 35.99)");
                scanner.nextLine();
                valor = 0;
            }
        } while (validacao == 0);


        scanner.nextLine();
        if (produtoAtualizar_buscado instanceof Cds){
            System.out.println("Insira o nome do artista: ");
            String nome_artista = scanner.next();
            scanner.nextLine();
            ((Cds) produtoAtualizar_buscado).setNome_artista(nome_artista);
        }

        if (produtoAtualizar_buscado instanceof Vinil){
            int ano;
            validacao = 0;
            do {
                try {
                    System.out.println("Insira o ano de lançamento do vinil: ");
                    ano = scanner.nextInt();
                    scanner.nextLine();
                    validacao = 1;

                } catch (InputMismatchException e) {
                    System.out.println("\n Ano de lançamento inválido. Por favor, insira um número inteiro (Ex: 1998)");
                    scanner.nextLine();
                    ano = 0;
                    validacao = 0;
                }
            } while (validacao == 0);

            ((Vinil) produtoAtualizar_buscado).setAno(ano);
        }


        produtoAtualizar_buscado.setNome(nome);
        produtoAtualizar_buscado.setValor(valor);
        System.out.println("");

        return produtoAtualizar_buscado;

    }


}
