
# Loja de CDS

## Visão Geral

Este repositório vai armazenar o projeto final do curso de JAVA,  aonde irei criar um programa para uma loja de CDS. Este programa permitirá, como por exemplo, comprar e adicionar novos cds ao programa. Além disso, a implementação é orientada a objetos, utilizando conceitos como classes, herança, polimorfismo e encapsulamento. O objetivo é proporcionar uma experiência prática no desenvolvimento de software, aplicando os princípios fundamentais da programação orientada a objetos (POO).


## Estrutura do Projeto

O projeto é organizado em classes distintas para facilitar a manutenção e extensibilidade do código. As principais classes são:

- **Main:** Classe principal que inicia a execução do programa. Instancia um `Cds_controller` para gerenciar a interação com o usuário.

- **Cds_controller:** Responsável por orquestrar as operações da loja, exibir o menu e processar as escolhas do usuário. Mantém uma instância da classe `LojaCds`.

- **LojaCds:** Gerencia o estoque de cds, armazenando uma lista de produtos. Contém métodos para adicionar, exibir e remover cds, bem como para gerar IDs sequenciais.

- **Produto:** Classe abstrata que representa um produto genérico. Possui atributos comuns a todos os produtos, como nome, ID e preço.

- **CD:** Subclasse de `Produto`, especializada para representar cds. Adiciona atributos específicos, como o nome do autor.

- **CD_Factory:** Implementa um Factory Method para criar instâncias de cds, facilitando a criação de objetos de maneira consistente.

## Funcionalidades Principais

### 1. Adição de CDS

A classe `Cds_Controller` permite ao usuário adicionar novos cds à loja. Utiliza o Factory Method `CD_Factory.criaCD` para criar instâncias de cds.

### 2. Exibição do Estoque

O usuário pode visualizar o estoque atual da loja, exibindo informações sobre cada cd.

### 3. Pesquisa de CDS

A classe `LojaCds` fornece métodos para buscar CDS pelo ID.

### 4. Compra de CDS

Permite ao usuário comprar um cd, removendo-o do estoque.

### 5. Remoção de CDS

Possibilidade de remover um cd do estoque, seja por ID ou pelo objeto cd.

### 6. Geração Automática de IDs

A classe `LojaCds` implementa um método para gerar IDs sequenciais automaticamente, facilitando a criação de novos produtos.

### 7. Manipulação de Exceções

Introdução de uma exceção personalizada, `CDNaoEncontradoException`, para lidar com casos em que um cd não é encontrado.

## Uso Básico

1. **Exibir o Estoque:**
    - Selecione a opção `1` no menu.
    - Visualize as informações sobre os cds no estoque.

2.  **Adicionar um CD:**
    - Escolha a opção `2` no menu.
    - Insira o nome, preço e autor do produto quando solicitado.

3. **Exibir o Estoque:**
    - Selecione a opção `1` no menu.
    - Visualize as informações sobre os cds no estoque.

4. **Pesquisar um CD:**
    - Escolha a opção `3` no menu.
    - Insira o ID do cd desejado.

5. **Comprar um CD:**
    - Selecione a opção `4` no menu.
    - Insira o ID do cd que você deseja comprar.

6. **Remover um CD:**
    - Escolha a opção `5` no menu.
    - Insira o ID do CD que você deseja remover.

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

Este projeto me proporcionou uma grande experiência em aprimorar os meus conhecimentos essenciais de Java e praticá-lo em um programa. O projeto utiliza os principais conhecimentos de POO que adquiri nesta jornada de aprendizado, que com certeza são importantes no mercado de trabalho.

