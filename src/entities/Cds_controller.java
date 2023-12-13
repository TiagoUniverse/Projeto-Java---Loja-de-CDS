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

    public void header_inicial() {
        System.out.println("====== Loja de CDS =======");
        System.out.println("Seja bem vindo à loja de CDS. Selecione uma opção abaixo e boa compra! \n");
        System.out.println("================================");
    }

    public void listar_opcoes() {
        System.out.println("Selecione uma opção:");
        System.out.println("1- Exibir o estoque ");
        System.out.println("2- Adicionar um CD");
        System.out.println("3- Pesquisar um CD");
        System.out.println("4- Comprar um CD");
        System.out.println("5- Remover um CD");
        System.out.println("0 - Encerrar o programa");
//        System.out.println("================================");
    }

    public void adicionar_cds_iniciais() {
        loja.adicionar_cd(new Cds("Born To Die", 25, "Lana del rey"));
    }

    public void menu(Scanner scanner) {
        adicionar_cds_iniciais();
        header_inicial();
        int escolha;
        do {
            try {
                listar_opcoes();
                escolha = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Tipo de escolha incorreto. Por favor, escolha um valor numérico (Ex: 1) \n");
                // Um tipo inválido para resetar o menu
                escolha = 99;
                scanner.nextLine();
            }

            processarOpcoes(escolha, scanner);


        } while (escolha != 0);

    }


    public void processarOpcoes(int escolha, Scanner scanner) {
        int validacao = 0;
        int id = 0;
        switch (escolha) {
            case 1:
                loja.exibirEstoque();
                break;
            case 2:
                System.out.println("Adicionar cd: ");
                Produto novoCD = Cd_Factory.adicionar_cd(scanner);
                loja.adicionar_cd(novoCD);
                System.out.println(" \n Cadastro de novo CD com sucesso! \n");
                break;
            case 3:
                do {
                    try {
                        System.out.print("Qual o id do produto: ");
                        id = scanner.nextInt();
                        scanner.nextLine();
                        validacao = 1;
                    } catch (InputMismatchException e) {
                        System.out.println("Tipo de id inválido. Por favor, digite um valor numérico (Ex: 1)");
                        validacao = 0;
                        scanner.nextLine();
                    }
                } while (validacao == 0);

                loja.procurar_produto(id);
                System.out.println("");
                break;
            case 4:
                break;
            case 5:
                do {
                    try {
                        System.out.print("Qual o id do produto: ");
                        id = scanner.nextInt();
                        scanner.nextLine();
                        validacao = 1;
                    } catch (InputMismatchException e) {
                        System.out.println("Tipo de id inválido. Por favor, digite um valor numérico (Ex: 1)");
                        validacao = 0;
                        scanner.nextLine();
                    }
                } while (validacao == 0);

                Produto produto_buscado = loja.procurar_produto(id);
                System.out.println("");

                if (produto_buscado != null) {
                    System.out.println("\n Deseja remover este produto( S/N): ");
                    char resposta = scanner.nextLine().toUpperCase().charAt(0);

                    if (resposta == 'S') {
                        System.out.println("\n Removendo produto! \n");

                        loja.remover_cd(produto_buscado);
                    } else if (resposta == 'N') {
                        System.out.println("\n Operação cancelada. \n");
                    } else {
                        System.out.println("\n Escolha inválida. Operação cancelada. \n");
                    }
                }
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
