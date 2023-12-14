package entities;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Vinil_Factory {

    public static Vinil adicionar_vinil(Scanner scanner) {

        System.out.print("Insira o nome do vinil: ");
        String nome = scanner.nextLine();


        double valor;
        int validacao = 0;
        do {
            try {
                System.out.print("Insira o preço do vinil: ");
                valor = scanner.nextDouble();
                scanner.nextLine();
                validacao = 1;

            } catch (InputMismatchException e) {
                System.out.println("\n Preço do produto inválido. Por favor, insira um valor inteiro ou decimal (Ex: 35.99)");
                scanner.nextLine();
                valor = 0;
                validacao = 0;
            }
        } while (validacao == 0);


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


        return new Vinil(nome, valor, ano);
    }
}
