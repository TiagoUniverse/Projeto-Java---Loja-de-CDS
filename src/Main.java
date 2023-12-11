import entities.Cds_controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Cds_controller cd_controller = new Cds_controller();

        int escolha;
        do{

            try{
                escolha = cd_controller.menu(scanner);
            } catch (InputMismatchException e){
                System.out.println("Tipo de escolha incorreto. Por favor, escolha um valor numérico (Ex: 1) \n");
                // Um tipo inválido para resetar o menu
                escolha = 99;
                scanner.nextLine();
            }

            } while (escolha != 0);
           



        scanner.close();
    }
}