# API de Logística

API REST desenvolvida em **Java + Spring Boot** para gerenciamento de entregas, pedidos, motoristas e clientes.

## Sobre o projeto

Esta aplicação permite cadastrar clientes, motoristas e pedidos, além de controlar entregas e registrar o histórico de movimentações do sistema.

O projeto foi desenvolvido utilizando arquitetura em camadas, separando responsabilidades entre **Controller**, **Service**, **Repository**, **DTO** e **Mapper**, seguindo boas práticas de desenvolvimento de APIs REST.

## Funcionalidades

- Cadastro de clientes
- Cadastro de motoristas
- Cadastro de pedidos
- Controle de entregas
- Atualização de status da entrega
- Histórico de movimentações
- Relatórios operacionais
- Validação de dados
- Tratamento global de exceções
- Documentação automática com Swagger

## Tecnologias utilizadas

- Java 21
- Spring Boot 4.1.1
- Spring Web MVC
- Spring Validation
- Spring Data (Repository)
- Lombok
- SpringDoc OpenAPI (Swagger)
- Maven

## Estrutura do projeto
│
├── controller      # Endpoints da API
├── service         # Regras de negócio
├── repository      # Acesso aos dados
├── entity          # Entidades do sistema
├── dto             # Objetos de requisição e resposta
├── mapper          # Conversão entre Entity e DTO
└── exception       # Tratamento de erros
```

## Como executar

### Pré-requisitos

- Java 21
- Maven 3.9+

### Clone o repositório

```bash
git clone https://github.com/seu-usuario/api-logistica.git
```

### Entre na pasta

```bash
cd api-logistica
```

### Execute o projeto

```bash
./mvnw spring-boot:run
```

Ou no Windows:

```bash
mvnw.cmd spring-boot:run
```

A aplicação será iniciada em:

```text
http://localhost:8089
```

## 📘 Documentação da API

Após iniciar o projeto, acesse:

| Ferramenta | URL |

| Swagger UI | `http://localhost:8089/swagger-ui.html`
| OpenAPI JSON | `http://localhost:8089/v3/api-docs`
