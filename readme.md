# 🌦️ Clima API

API REST desenvolvida em **Java + Spring Boot** para consulta e persistência de informações climáticas.

---

## Objetivo do Projeto

Demonstrar conhecimentos práticos em:

- Desenvolvimento de APIs REST com **Spring Boot**
- Integração com **PostgreSQL**
- Uso de **Spring Data JPA / Hibernate**
- Containerização com **Docker e Docker Compose**
- Organização de projeto e documentação

O projeto simula um cenário real de backend, priorizando clareza de domínio, simplicidade e possibilidade de evolução futura.

---

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 4.x**
- **Spring Data JPA**
- **Hibernate ORM**
- **PostgreSQL 15**
- **Docker & Docker Compose**
- **Maven**

---

## Estrutura do Projeto

```text
clima-api/
├── src/main/java
│   └── com.clima.api
│       ├── controller    # Camada de entrada (REST)
│       ├── service       # Regras de negócio
│       ├── repository    # Acesso a dados (JPA)
│       ├── domain         # Entidades JPA
│       └── ClimaApiApplication.java
├── src/main/resources
│   └── application.properties
├── docker-compose.yml
├── Dockerfile
├── .env.example
└── README.md
```

Essa separação facilita manutenção, testes e entendimento do fluxo da aplicação.

---

##  Executando o Projeto com Docker (Recomendado)

### 1️ Pré-requisitos

- **Docker**
- **Docker Compose**

---

### 2️ Configuração das variáveis de ambiente

Crie um arquivo `.env` baseado no exemplo:

```bash
cp .env.example .env
```

Exemplo de conteúdo:

```env
POSTGRES_DB=clima
POSTGRES_USER=postgres
POSTGRES_PASSWORD=postgres
SPRING_DATASOURCE_URL=jdbc:postgresql://clima-postgres:5432/clima
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=postgres
```

---

### 3️ Subindo a aplicação

```bash

docker compose up --build
```

Ao final do processo:

- PostgreSQL estará disponível internamente na porta **5432**
- API com a interface do Swagger estará disponível em **[http://localhost:8080/swagger-ui/index.html](http://localhost:8080)**

---

## Endpoints

> *(Endpoints simples apenas para fins de demonstração do fluxo REST)*

| Método | Endpoint          | Descrição                                                   |
|--------|-------------------|-------------------------------------------------------------|
| POST   | `/clima/{cidade}` | Busca informações do clima e salva no database.             |
| GET    | `/clima`          | Lista todas as informações que já foram salvas no database. |
| GET    | `/clima/{cidade}` | Lista os dados que foram salvos da cidade informada.        |

*(Novos endpoints podem ser adicionados facilmente seguindo o padrão Controller → Service → Repository)*

---


## Possíveis Evoluções

- Integração com API externa de clima (OpenWeather, WeatherAPI, etc.)
- Implementação de testes unitários
- Paginação e filtros
- Segurança com Spring Security

---

## Autor

**Alessandro Sousa**\
Desenvolvedor Full Stack\
Java | Spring Boot | APIs REST | PostgreSQL

---


