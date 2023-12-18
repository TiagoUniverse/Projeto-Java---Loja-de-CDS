package entities;

import Exceptions.TipoIncorretoDeInputException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Vinil_Factory {

    public static Vinil adicionar_vinil(Scanner scanner) throws TipoIncorretoDeInputException {

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
                scanner.nextLine();
                valor = 0;
                validacao = 0;
                throw new TipoIncorretoDeInputException("\n Preço do produto inválido. Por favor, insira um valor inteiro ou decimal (Ex: 35.99)");
            }
        } while (validacao == 0);

        int ano;
        validacao = 0;
        do {
            try {
                System.out.print("Insira o ano de lançamento do vinil: ");
                ano = scanner.nextInt();
                scanner.nextLine();
                validacao = 1;

            } catch (InputMismatchException e) {
                scanner.nextLine();
                ano = 0;
                validacao = 0;
                throw new TipoIncorretoDeInputException("\n Ano de lançamento inválido. Por favor, insira um número inteiro (Ex: 1998)");
            }
        } while (validacao == 0);

        return new Vinil(nome, valor, ano);
    }
}
