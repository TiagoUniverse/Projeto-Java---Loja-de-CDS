package entities;

import java.util.InputMismatchException;
import java.util.Scanner;



public class Cds_controller {
    private Scanner scanner;
    private Loja loja;

    public Cds_controller(Scanner scanner) {
        this.scanner = scanner;
        this.loja = new Loja();
    }

    public void listar_opcoes(){
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
        System.out.println("================================");

    }

    public void menu (Scanner scanner){
        int escolha;
        do{
            try{
                listar_opcoes();
                escolha = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e){
                System.out.println("Tipo de escolha incorreto. Por favor, escolha um valor numérico (Ex: 1) \n");
                // Um tipo inválido para resetar o menu
                escolha = 99;
                scanner.nextLine();
            }

        processarOpcoes(escolha, scanner);


        } while (escolha != 0);

    }


    public void processarOpcoes(int escolha, Scanner scanner){
        switch(escolha){
            case 1:
                loja.exibirEstoque();
                break;
            case 2:
                System.out.println("Adicionar cd: ");
                Produto  novoCD = Cd_Factory.adicionar_cd(scanner);
                loja.adicionar_cd(novoCD);
                System.out.println(" \n Cadastro de novo CD com sucesso! \n");
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 0:
                System.out.println("Encerrando o programa.");
                break;
            default:
                System.out.println("Erro na escolha");
                break;
        }
    }

}
