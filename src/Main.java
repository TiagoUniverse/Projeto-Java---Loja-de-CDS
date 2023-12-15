import Exceptions.ProdutoNaoEncontradoException;
import Exceptions.TipoIncorretoDeInputException;
import entities.Produto_controller;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ProdutoNaoEncontradoException, TipoIncorretoDeInputException {

        Scanner scanner = new Scanner(System.in);

        Produto_controller produto_controller = new Produto_controller(scanner);

        boolean validacao = true;
        do{
            try{
                produto_controller.menu(scanner);
                validacao = true;
            } catch(TipoIncorretoDeInputException e){
                System.out.println(e.getMessage());
                validacao = false;
            } catch(ProdutoNaoEncontradoException e){
                System.out.println(e.getMessage());
                validacao = false;
            }
        } while (!validacao);



        scanner.close();
    }
}