# CodeBank - BackEnd

Este projeto foi desenvolvido utilizando Java 8 e SpringBoot, com as seguintes dependências: SpringWeb, SpringDevTools, H2 database, JPA, Validation e Lombok. A aplicação permite o gerenciamento de clientes e empréstimos, realizando operações CRUD em um banco de dados.

## Instalação e Execução

Antes de executar a aplicação, certifique-se de que o Java 8 ou superior, o Node.js e o Maven estão instalados em sua máquina. Em seguida, siga os seguintes passos:

1. Faça o clone deste repositório.
2. Abra o terminal na pasta raiz do projeto.
3. Execute o comando mvn spring-boot:run.
4. Aguarde até que a aplicação seja iniciada.

## Organização

A seguir, é apresentada a organização dos arquivos do projeto:

## Classes de Cliente

1. **Cliente**: Esta classe representa um cliente no banco de dados.

2. **ClienteRepository**: Esta interface estende o repositório JPA com métodos para interagir com o banco de dados de cliente.

3. **ClienteService**: Esta classe implementa as operações CRUD em clientes.

4. **ClienteController**: Esta classe fornece endpoints RESTful para operações CRUD em clientes.

## Classes de Empréstimo

1. **Emprestimo**: Esta classe representa um empréstimo no banco de dados.

2. **EmprestimoRepository**: Esta interface estende o repositório JPA com métodos para interagir com o banco de dados de  empréstimo.

3. **EmprestimoService**: Esta classe implementa as operações CRUD em empréstimos.

4. **EmprestimoController**: Esta classe fornece endpoints RESTful para operações CRUD em empréstimo.

## Banco de Dados

A aplicação utiliza o banco de dados H2, que é um banco de dados em memória. Isso significa que os dados não serão persistidos após o encerramento da aplicação.

## Lombok

A biblioteca Lombok é utilizada para reduzir a verbosidade do código, evitando a escrita de getters, setters, construtores e outros métodos repetitivos.