import entities.Produto_controller;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Produto_controller produto_controller = new Produto_controller(scanner);

        produto_controller.menu(scanner);

        scanner.close();
    }
}