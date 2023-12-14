package entities;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Produto_controller {
    private Scanner scanner;
    private Loja loja;

    public Produto_controller(Scanner scanner) {
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
        System.out.println("2- Adicionar um produto");
        System.out.println("3- Pesquisar um produto");
        System.out.println("4- Comprar um produto");
        System.out.println("5- Atualizar um produto");
        System.out.println("6- Remover um produto");
        System.out.println("0 - Encerrar o programa");
//        System.out.println("================================");
    }

    public void adicionar_cds_iniciais() {
        loja.adicionar_produto(new Cds("Born To Die", 25, "Lana del rey"));
        loja.adicionar_produto(new Cds("The Beatles", 75.79, "Beatles"));
        loja.adicionar_produto(new Cds("Thriller", 80.50, "Michael Jackson"));
        loja.adicionar_produto(new Cds("Back in Black", 45.70, "AC/DC"));
        loja.adicionar_produto(new Cds("21", 35.60, "Adele"));
        loja.adicionar_produto(new Vinil("Vinil: The Beatles", 150.99, 1978));
        loja.adicionar_produto(new Vinil("LP Vinil Luiz Gonzaga", 260.75, 1990));
        loja.adicionar_produto(new Vinil("Vinil Elvis Presley", 389.90, 1980));
        loja.adicionar_produto(new Vinil("Vinil: Tim Maia - Nobody can live forever", 560.37, 1970));
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
                System.out.println("================================");
                break;
            case 2:
                int escolha_produto;
                validacao = 0;
                do{
                    try{
                        System.out.println("Qual o tipo de produto que deseja adicionar? Digite '1' para CD ou '2' para Vinil: ");
                        escolha_produto = scanner.nextInt();
                        scanner.nextLine();
                        validacao = 1;
                    } catch(InputMismatchException e){
                        System.out.println("\n Escolha inválida. Por favor, digite uma resposta numérica (Ex: 1) \n");
                        scanner.nextLine();
                        escolha_produto = 0;
                    }
                } while(validacao == 0);

                switch(escolha_produto){
                    case 1:
                        System.out.println("Adicionar cd: ");
                        Produto novoCD = Cd_Factory.adicionar_cd(scanner);
                        loja.adicionar_produto(novoCD);
                        System.out.println(" \n Cadastro de novo CD com sucesso! \n");
                        break;
                    case 2:
                        System.out.println("Adicionar Vinil: ");
                        Produto novoVinil = Vinil_Factory.adicionar_vinil(scanner);
                        loja.adicionar_produto(novoVinil);
                        System.out.println(" \n Cadastro de novo VINIL com sucesso! \n");
                        break;
                    default:
                        System.out.println("\n Escolha inválida, logo a operação foi cancelada. \n");
                        break;
                }

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
                do {
                    try {
                        System.out.print("Qual o id do produto que deseja comprar: ");
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
                    System.out.println("\n Deseja comprar este produto( S/N): ");
                    char resposta = scanner.nextLine().toUpperCase().charAt(0);

                    if (resposta == 'S') {
                        System.out.println("\n Produto comprado! \n");

                        loja.remover_cd(produto_buscado);
                    } else if (resposta == 'N') {
                        System.out.println("\n Operação de compra cancelada. \n");
                    } else {
                        System.out.println("\n Escolha inválida. Operação de compra cancelada. \n");
                    }
                }

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

                Produto produtoAtualizar_buscado =  loja.procurar_produto(id);
                System.out.println("");

                if (produtoAtualizar_buscado != null) {
                    System.out.println("\n Deseja atualizar este produto( S/N): ");
                    char resposta = scanner.nextLine().toUpperCase().charAt(0);

                    if (resposta == 'S') {
                        System.out.println("\n Atualização de produto: \n");

                        loja.atualizar_produto(scanner, produtoAtualizar_buscado );
                    } else if (resposta == 'N') {
                        System.out.println("\n Operação cancelada. \n");
                    } else {
                        System.out.println("\n Escolha inválida. Operação cancelada. \n");
                    }
                }
                break;
            case 6:
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

                Produto produtoRemocao_buscado = loja.procurar_produto(id);
                System.out.println("");

                if (produtoRemocao_buscado != null) {
                    System.out.println("\n Deseja remover este produto( S/N): ");
                    char resposta = scanner.nextLine().toUpperCase().charAt(0);

                    if (resposta == 'S') {
                        System.out.println("\n Removendo produto! \n");

                        loja.remover_cd(produtoRemocao_buscado);
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
