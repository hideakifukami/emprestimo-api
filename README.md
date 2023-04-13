# CodeBank - BackEnd

Este projeto foi criado com a utilização de SpringBoot como framework para BackEnd. A Aplicação permite o gerenciamento de clientes e empréstimos, realizando operações CRUD em um banco de dados.

## Como rodar?

Tenha instalado em seu computador os seguintes softwares: Java 8 ou superior, Node.js e NPM, e Maven. Tendo isso, basta abrir o terminal no diretório do projeto e executar `mvn spring-boot:run`.

## Organização:

1. **Cliente**: Esta classe representa um cliente no banco de dados.

2. **ClienteRepository**: Esta interface extende o repositório JPA com métodos para interagir com o banco de dados de cliente.

3. **ClienteService**: Esta classe implementa as operações CRUD em clientes.

4. **ClienteController**: Esta classe fornece endpoints RESTful para operações CRUD em clientes.

5. **Emprestimo**: Esta classe representa um emprestimo no banco de dados.

6. **EmprestimoRepository**: Esta interface extende o repositório JPA com métodos para interagir com o banco de dados de emprestimo.

7. **EmprestimoService**: Esta classe implementa as operações CRUD em emprestimos.

8. **EmprestimoController**: Esta classe fornece endpoints RESTful para operações CRUD em emprestimo.