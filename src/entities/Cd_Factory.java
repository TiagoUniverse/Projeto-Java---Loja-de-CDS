package entities;

import java.util.Scanner;

public class Cd_Factory {

    public static Cds adicionar_cd(Scanner scanner){

        System.out.print("Insira o nome do cd: ");
        String nome = scanner.nextLine(); //cd

        System.out.print("Insira o preço do cd: ");
        double valor = scanner.nextDouble();

        scanner.nextLine();
        System.out.println("Insira o nome do artista: ");
        String nome_artista = scanner.next();
        scanner.nextLine();



        return new Cds( nome, valor, nome_artista);

    }
}
