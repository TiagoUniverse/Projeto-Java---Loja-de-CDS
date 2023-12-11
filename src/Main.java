import entities.Cds;
import entities.Cds_controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Cds_controller cd_controller = new Cds_controller();

       cd_controller.menu(scanner);



        scanner.close();
    }
}