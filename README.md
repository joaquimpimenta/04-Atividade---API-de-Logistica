# 🚚 API de Logística

API REST desenvolvida em **Java + Spring Boot** para gerenciamento de entregas, pedidos, motoristas e clientes. O projeto simula um sistema utilizado por uma empresa de logística para controlar o fluxo completo de entregas e gerar relatórios operacionais.

## 📖 Sobre o projeto

Esta aplicação permite cadastrar clientes, motoristas e pedidos, além de controlar entregas e registrar o histórico de movimentações do sistema.

O projeto foi desenvolvido utilizando arquitetura em camadas, separando responsabilidades entre **Controller**, **Service**, **Repository**, **DTO** e **Mapper**, seguindo boas práticas de desenvolvimento de APIs REST.

## ✨ Funcionalidades

- ✅ Cadastro de clientes
- ✅ Cadastro de motoristas
- ✅ Cadastro de pedidos
- ✅ Controle de entregas
- ✅ Atualização de status da entrega
- ✅ Histórico de movimentações
- ✅ Relatórios operacionais
- ✅ Validação de dados
- ✅ Tratamento global de exceções
- ✅ Documentação automática com Swagger

## 🛠️ Tecnologias utilizadas

- Java 21
- Spring Boot 4.1.1
- Spring Web MVC
- Spring Validation
- Spring Data (Repository)
- Lombok
- SpringDoc OpenAPI (Swagger)
- Maven

## 📂 Estrutura do projeto

```text
src/main/java/com/br/api_logistica
│
├── controller      # Endpoints da API
├── service         # Regras de negócio
├── repository      # Acesso aos dados
├── entity          # Entidades do sistema
├── dto             # Objetos de requisição e resposta
├── mapper          # Conversão entre Entity e DTO
└── exception       # Tratamento de erros
```

## 🚀 Como executar

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
|------------|-----|
| Swagger UI | `http://localhost:8089/swagger-ui.html` |
| OpenAPI JSON | `http://localhost:8089/v3/api-docs` |

## 📌 Principais recursos

| Recurso | Descrição |
|----------|-----------|
| Clientes | Gerenciamento dos clientes |
| Motoristas | Cadastro e consulta de motoristas |
| Pedidos | Controle dos pedidos realizados |
| Entregas | Gerenciamento das entregas e status |
| Histórico | Registro das movimentações |
| Relatórios | Informações consolidadas da operação |

## 🧱 Arquitetura

O projeto utiliza uma arquitetura em camadas:

```text
Cliente HTTP
      │
      ▼
 Controller
      │
      ▼
  Service
      │
      ▼
 Repository
      │
      ▼
 Entidades
```

Os **DTOs** são utilizados para comunicação com a API e os **Mappers** realizam a conversão entre DTO e Entity.

## 👨‍💻 Autor

**Joaquim Augusto**

Projeto desenvolvido como atividade prática de desenvolvimento Back-end utilizando Spring Boot.
