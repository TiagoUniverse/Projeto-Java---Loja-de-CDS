
# Loja de CDS

## Visão Geral

Este repositório vai armazenar o projeto final do curso de JAVA,  aonde irei criar um programa para uma loja de CDS. Este programa permitirá, como por exemplo, comprar e adicionar novos cds ao programa. Além disso, a implementação é orientada a objetos, utilizando conceitos como classes, herança, polimorfismo e encapsulamento. O objetivo é proporcionar uma experiência prática no desenvolvimento de software, aplicando os princípios fundamentais da programação orientada a objetos (POO).


## Estrutura do Projeto

O projeto é organizado em classes distintas para facilitar a manutenção e extensibilidade do código. As principais classes são:

- **Main:** Classe principal que inicia a execução do programa. Instancia um `Produto_controller` para gerenciar a interação com o usuário.

```java
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
`````

- **Produto_controller:** Responsável por orquestrar as operações da loja, exibir o menu e processar as escolhas do usuário. Mantém uma instância da classe `Loja`.

- **Loja:** Gerencia o estoque dos produtos, armazenando uma lista de produtos. Contém métodos para adicionar, exibir e remover produtos, bem como para gerar IDs sequenciais.

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

``````

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

### 7. Manipulação de Exceções

Introdução de exceções no sistema  para lidar com casos de erro de digitação do usuário, da inserção de valores inválido ou quando um produto não é encontrado.

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

4. **Mais exceções personalizadas**
    - Expansão do tratamento de exceções para criar personalização e mais mapeamento do uso de exceções.

## Conclusão

Este projeto me proporcionou uma grande experiência em aprimorar os meus conhecimentos essenciais de Java e praticá-lo em um programa. O projeto utiliza os principais conhecimentos de POO que adquiri nesta jornada de aprendizado, que com certeza são importantes no mercado de trabalho.

