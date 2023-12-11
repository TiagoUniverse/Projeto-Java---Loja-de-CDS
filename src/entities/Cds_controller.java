package entities;

import java.util.Scanner;

public class Cds_controller {

    public int menu(Scanner scanner){
        System.out.println("====== Loja de CDS =======");
        System.out.println("Seja bem vindo à loja de CDS. Selecione uma opção abaixo e boa compra! \n");
        System.out.println("================================");
        System.out.println("Selecione uma opção: \n");
        System.out.println("1- Exibir o estoque ");
        System.out.println("2- Adicionar um CD");
        System.out.println("3- Pesquisar um CD");
        System.out.println("4- Comprar um CD");
        System.out.println("5- Remover um CD");
        System.out.println("0 - Encerrar o programa");

        int escolha = scanner.nextInt();

        return escolha;
    }

}
