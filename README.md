
# Loja de CDS

## Visão Geral

Este repositório vai armazenar o projeto final do curso de JAVA,  aonde irei criar um programa para uma loja de CDS. Este programa permitirá, como por exemplo, comprar e adicionar novos cds ao programa. Além disso, a implementação é orientada a objetos, utilizando conceitos como classes, herança, polimorfismo e encapsulamento. O objetivo é proporcionar uma experiência prática no desenvolvimento de software, aplicando os princípios fundamentais da programação orientada a objetos (POO).


## Estrutura do Projeto

O projeto é organizado em classes distintas para facilitar a manutenção e extensibilidade do código. As principais classes são:

- **Main:** Classe principal que inicia a execução do programa. Instancia um `Produto_controller` para gerenciar a interação com o usuário.

```java
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
`````

- **Produto_controller:** Responsável por orquestrar as operações da loja, exibir o menu e processar as escolhas do usuário. Mantém uma instância da classe `Loja`.


```java
package entities;

import Exceptions.ProdutoNaoEncontradoException;
import Exceptions.TipoIncorretoDeInputException;

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

    public void menu(Scanner scanner) throws ProdutoNaoEncontradoException, TipoIncorretoDeInputException {
        adicionar_cds_iniciais();
        header_inicial();
        int escolha;
        do {
            try {
                listar_opcoes();
                escolha = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                // Um tipo inválido para resetar o menu
                escolha = 99;
                scanner.nextLine();
                throw new TipoIncorretoDeInputException("Tipo de escolha incorreto. Por favor, escolha um valor numérico (Ex: 1) \n");
            }

            processarOpcoes(escolha, scanner);

        } while (escolha != 0);

    }


    public void processarOpcoes(int escolha, Scanner scanner) throws ProdutoNaoEncontradoException, TipoIncorretoDeInputException {
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
                        scanner.nextLine();
                        escolha_produto = 0;
                        throw new TipoIncorretoDeInputException("\n Escolha inválida. Por favor, digite uma resposta numérica (Ex: 1) \n");
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
                        validacao = 0;
                        scanner.nextLine();
                        throw new TipoIncorretoDeInputException("Tipo de id inválido. Por favor, digite um valor numérico (Ex: 1)");
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
                        validacao = 0;
                        scanner.nextLine();
                        throw new TipoIncorretoDeInputException("Tipo de id inválido. Por favor, digite um valor numérico (Ex: 1)");
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
                        validacao = 0;
                        scanner.nextLine();
                        throw new TipoIncorretoDeInputException("Tipo de id inválido. Por favor, digite um valor numérico (Ex: 1)");
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
                        validacao = 0;
                        scanner.nextLine();
                        throw new TipoIncorretoDeInputException("Tipo de id inválido. Por favor, digite um valor numérico (Ex: 1)");
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
``````

- **Loja:** Gerencia o estoque dos produtos, armazenando uma lista de produtos. Contém métodos para adicionar, exibir e remover produtos, bem como para gerar IDs sequenciais.

```java
package entities;

import Exceptions.ProdutoNaoEncontradoException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static sun.util.locale.LocaleUtils.isEmpty;

public class Loja {

    protected static List<Produto> lista_cds = new ArrayList<>();

    protected static int proximoId = 0;

    public void adicionar_produto (Produto produto){
        lista_cds.add(produto);
    }

    public void remover_cd (Produto cd){
        lista_cds.remove(cd);
    }

    public static int gerarProximoID(){
        for (Produto produto : lista_cds ) {
            if (produto.getId() == proximoId ){
                proximoId++;
                return gerarProximoID();
            }

        }
        return proximoId;
    }


    public Produto procurar_produto(int id) throws ProdutoNaoEncontradoException {
        for(Produto produto : lista_cds){
            if (produto.getId() == id){
                produto.exibirInfo();
                return produto;
            }
        }
         throw new ProdutoNaoEncontradoException("O id " + id + " não foi encontrado no estoque.");
    }



    public void exibirEstoque(){
        if (lista_cds.isEmpty()){
            System.out.println("A loja está vazia. Por favor, cadastre alguns produtos. \n");
        } else{
            for (Produto produto : lista_cds) {
                produto.exibirInfo();
                System.out.println("");
            }
        }

    }


    public Produto atualizar_produto(Scanner scanner, Produto produtoAtualizar_buscado) {

        System.out.print("Insira o nome do produto: ");
        String nome = scanner.nextLine();


        double valor;
        int validacao = 0;
        do {
            try {
                System.out.print("Insira o preço do produto: ");
                valor = scanner.nextDouble();
                validacao = 1;

            } catch (InputMismatchException e) {
                System.out.println("\n Preço do produto inválido. Por favor, insira um valor inteiro ou decimal (Ex: 35.99)");
                scanner.nextLine();
                valor = 0;
            }
        } while (validacao == 0);


        scanner.nextLine();
        if (produtoAtualizar_buscado instanceof Cds){
            System.out.println("Insira o nome do artista: ");
            String nome_artista = scanner.next();
            scanner.nextLine();
            ((Cds) produtoAtualizar_buscado).setNome_artista(nome_artista);
        }

        if (produtoAtualizar_buscado instanceof Vinil){
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

            ((Vinil) produtoAtualizar_buscado).setAno(ano);
        }


        produtoAtualizar_buscado.setNome(nome);
        produtoAtualizar_buscado.setValor(valor);
        System.out.println("");

        return produtoAtualizar_buscado;

    }


}
``````


- **Produto:** Classe abstrata que representa um produto genérico. Possui atributos comuns a todos os produtos, como nome, ID e preço.

```java
package entities;

public abstract class Produto {

    protected int id;
    protected String nome;
    protected double valor;

    public Produto( String nome, double valor) {
        this.id = Loja.gerarProximoID();
        this.nome = nome;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public abstract int exibirInfo();
}


````````


- **CDS:** Subclasse de `Produto`, especializada para representar cds. Adiciona atributos específicos, como o nome do artista.

```java
package entities;

public class Cds extends Produto {

    private  String nome_artista;
    public Cds(String nome, double valor, String nome_artista) {
        super(nome, valor);
        this.nome_artista = nome_artista;
    }

    public String getNome_artista() {
        return nome_artista;
    }

    public void setNome_artista(String nome_artista) {
        this.nome_artista = nome_artista;
    }

    @Override
    public int exibirInfo(){
        System.out.println("Nome: " + getNome());
        System.out.println("ID: " + getId());
        System.out.println("Preço: " + getValor());
        System.out.println("Nome do artista: " + getNome_artista());
        return 0;
    }

}

``````


- **CD_Factory:** Implementa um Factory Method para criar instâncias de cds, facilitando a criação de objetos de maneira consistente.

```java
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
                validacao = 1;

            } catch (InputMismatchException e) {
                scanner.nextLine();
                valor = 0;
                validacao = 0;
                throw new TipoIncorretoDeInputException("\n Preço do produto inválido. Por favor, insira um valor inteiro ou decimal (Ex: 35.99)");
            }
        } while (validacao == 0);


        scanner.nextLine();
        System.out.print("Insira o nome do artista: ");
        String nome_artista = scanner.nextLine();

        return new Cds(nome, valor, nome_artista);

    }

}

``````

- **Vinil:** Subclasse de `Produto`, especializada para representar vinils. Adiciona atributos específicos, como o ano do lançamento.

```java
package entities;

public class Vinil extends Produto {
    private int ano;

    public Vinil(String nome, double valor, int ano) {
        super(nome, valor);
        this.ano = ano;
    }
    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public int exibirInfo() {
        System.out.println("Nome: " + getNome());
        System.out.println("ID: " + getId());
        System.out.println("Preço: " + getValor());
        System.out.println("Ano de lançamento: " + getAno() );
        return 0;
    }
}

``````

- **Vinil_Factory:** Implementa um Factory Method para criar instâncias de vinils, facilitando a criação de objetos de maneira consistente.

```java
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
                System.out.println("Insira o ano de lançamento do vinil: ");
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
``````

- **ProdutoNaoEncontradoException:** Um tratamento de exceção personalizado para tratar os casos em que o produto não foi encontrado no estoque do sistema, retornando uma mensagem ao usuário.

```java
package Exceptions;

public class ProdutoNaoEncontradoException extends  Exception {

    public ProdutoNaoEncontradoException(String message) {
        super(message);
    }
}
```

- **TipoIncorretoDeInputException:** Um tratamento de exceção personalizado para tratar os casos em que o valor digitado pelo usuário não está adequado, assim retornando uma mensagem ao usuário.

```java
package Exceptions;

public class TipoIncorretoDeInputException extends Exception{
    public TipoIncorretoDeInputException(String message) {
        super(message);
    }
}
```

## Funcionalidades Principais

### 1. Adição de Produtos

A classe `Produto_Controller` permite ao usuário adicionar novos cds ou novos vinils à loja. No caso de ser um cd, o sistema utiliza o Factory Method `CD_Factory.criaCD` para criar instâncias de cds. Já no outro caso, utiliza o Factory Method 'Vinil_Factory.criarVinil'.

### 2. Exibição do Estoque

O usuário pode visualizar o estoque atual da loja, exibindo informações sobre cada produto registrado na loja, seja cd ou seja um vinil.

### 3. Pesquisa de Produtos

A classe `Loja` fornece métodos para buscar CDS ou Vinils pelo ID.

### 4. Compra de Produtos

Permite ao usuário comprar um produto de cd ou vinil, removendo-o do estoque.

### 5. Remoção de Produtos

Possibilidade de remover um produto do estoque, seja por ID ou pelo seu objeto.

### 6. Geração Automática de IDs

A classe `Loja` implementa um método para gerar IDs sequenciais automaticamente, facilitando a criação de novos produtos.

### 7. Manipulação de Exceções personalizadas

Introdução do tratamento de exceções personalizadas no sistema. Essas exceções foram criadas para lidar com casos de erro de digitação do usuário, da inserção de valores inválido ou quando um produto não é encontrado.



## Uso Básico

1. **Exibir o Estoque:**
    - Selecione a opção `1` no menu.
    - Visualize as informações sobre os produtos no estoque.

2.  **Adicionar um Produto:**
    - Escolha a opção `2` no menu.
    - Seleciona o tipo de produto
    - Insira o nome, preço do produto.
    - Caso seja um cd, insira o nome do artista. Já caso seja um vinil, insira o ano de lançamento.

3. **Pesquisar um Produto:**
    - Escolha a opção `3` no menu.
    - Insira o ID do produto desejado.

4. **Comprar um Produto:**
    - Selecione a opção `4` no menu.
    - Insira o ID do poroduto que você deseja comprar.

5. **Atualizar um Produto:**
    - Escolha a opção `5` no menu.
    - Insira o ID do produto que você deseja atualizar.
    - Confirma a operação de atualização.
    - Insere as novas informações do produto que você deseja atualizar.

6. **Remover um Produto:**
    - Escolha a opção `6` no menu.
    - Insira o ID do produto que você deseja remover.

7. **Encerrar o Programa:**
    - Selecione a opção `0` no menu.



## Melhorias e Expansões Futuras

1. **Persistência de Dados:**
    - Adição de persistência de dados para salvar e carregar informações do estoque entre execuções do programa.
2. **Validação de Entradas:**
    - Implementação de verificações e validações para garantir que as entradas do usuário estejam corretas.

3. **Novos Tipos de Produtos:**
    - Expansão do sistema para lidar com diferentes tipos de produtos além de cds.


## Conclusão

Ter a oportunidade de estudar java neste curso foi muito importante para mim, pois pude conhecer uma nova linguagem de desenvolvimento e aprender conceitos fundamentais de POO. Eu não possuia prática de Java e muitos conhecimentos eu aprendi agora. Percebi que comecei como iniciante nesta linguagem e pude aprender muito com as aulas do curso + conectado. 

No começo não foi fácil se acostumar com a rotina de todo dia ter um horário pra estudar java, mas encarei o desafio. Sei que esse aprendizado é importante para mim e todo dia eu aprendia mais de java. Os assuntos novos me davam dúvidas, então quando possuía dúvidas eu perguntava no chat para não deixar as dúvidas acumularem.

Fico muito satisfeito e feliz em ver que consegui chegar até aqui. Consegui criar um projeto de sistema no estilo de CRUD onde posso usar o controller para direcionar o fluxo do sistema e fazer o seu funcionamento. Gostaria de destacar os conhecimentos de : Herança, Enuns, Exceptions, criação de classes Pai e filhos, classes Factory, encapsulamento, polimorfismo, asbtração de classes, Listas e arrays, estruturas de repetição e as famosas estruturas de condição.

Este projeto me proporcionou uma grande experiência em aprimorar os meus conhecimentos essenciais de Java e praticá-lo em um programa. O projeto utiliza os principais conhecimentos de POO que adquiri nesta jornada de aprendizado, que com certeza são importantes no mercado de trabalho.

