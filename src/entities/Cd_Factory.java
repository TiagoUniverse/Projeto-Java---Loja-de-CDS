package entities;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cd_Factory {

    public static Cds adicionar_cd(Scanner scanner) {

        System.out.print("Insira o nome do cd: ");
        String nome = scanner.nextLine();


        double valor;
        int validacao = 0;
        do {
            try {
                System.out.print("Insira o preço do cd: ");
                valor = scanner.nextDouble();
                validacao = 1;

            } catch (InputMismatchException e) {
                System.out.println("\n Preço do produto inválido. Por favor, insira um valor inteiro ou decimal (Ex: 35.99)");
                scanner.nextLine();
                valor = 0;
                validacao = 0;
            }
        } while (validacao == 0);


        scanner.nextLine();
        System.out.print("Insira o nome do artista: ");
        String nome_artista = scanner.nextLine();
//        scanner.nextLine();


        return new Cds(nome, valor, nome_artista);

    }


}
