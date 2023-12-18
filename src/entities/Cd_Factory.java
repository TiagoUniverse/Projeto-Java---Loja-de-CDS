package entities;

import Exceptions.TipoIncorretoDeInputException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cd_Factory {

    public static Cds adicionar_cd(Scanner scanner) throws TipoIncorretoDeInputException {

        System.out.print("Insira o nome do cd: ");
        String nome = scanner.nextLine();


        double valor;
        int validacao = 0;
        do {
            try {
                System.out.print("Insira o preço do cd: ");
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


        System.out.print("Insira o nome do artista: ");
        String nome_artista = scanner.nextLine();

        return new Cds(nome, valor, nome_artista);

    }

}
