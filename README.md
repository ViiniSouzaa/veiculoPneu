# API de Veículos e Pneus

Esta é uma aplicação construída com **Spring Boot** e **PostgreSQL** que oferece endpoints para consulta, criação e gerenciamento de veículos e pneus. A aplicação utiliza **Flyway** para migração do banco de dados e está configurada para rodar em contêineres Docker.

## Funcionalidades

1. **Consultar todos os veículos**:
   - Endpoint: `GET /veiculos`
   - Retorna todos os veículos cadastrados no banco de dados (sem incluir os pneus).

2. **Consultar um veículo específico com pneus**:
   - Endpoint: `GET /veiculos/{id}`
   - Retorna um veículo específico e os pneus aplicados, incluindo a posição de cada pneu no veículo.

3. **Criar um veículo**:
   - Endpoint: `POST /veiculos`
   - Cria um novo veículo com os dados fornecidos no corpo da requisição.

4. **Criar um pneu**:
   - Endpoint: `POST /pneus`
   - Cria um novo pneu com status "INATIVO" por padrão.

## Tecnologias Utilizadas

- **Spring Boot**: Framework para construção de aplicações Java.
- **PostgreSQL**: Banco de dados relacional.
- **Flyway**: Ferramenta para migração de banco de dados.
- **Docker**: Para configurar o ambiente de execução da aplicação e do banco de dados.
- **JUnit**: Framework para testes unitários.

## Pré-requisitos

Certifique-se de ter os seguintes pré-requisitos antes de rodar o projeto:

- **Java 17 ou superior**
- **Docker** (para rodar o banco de dados PostgreSQL e a aplicação)
- **Maven** (para construir o projeto, caso não use o Docker)


## Antes de Rodar o Projeto 

### Tutorial: Como Criar o Banco de Dados para a Aplicação

Antes de iniciar a aplicação, é necessário garantir que o banco de dados esteja configurado corretamente. Abaixo estão as instruções para criar o banco de dados veiculosdb e garantir que a aplicação funcione corretamente.

1. Configurar Banco de Dados PostgreSQL

1.1 Instalar o PostgreSQL

Se você ainda não tem o PostgreSQL instalado, siga as instruções para instalar o PostgreSQL:

1.2 Criar o Banco de Dados

Após a instalação do PostgreSQL, você pode criar o banco de dados veiculosdb executando os seguintes comandos.

Abra o terminal ou o console de comando do PostgreSQL (psql).

Conecte-se ao PostgreSQL com o usuário postgres:


      psql -U postgres

Crie o banco de dados veiculosdb:

      CREATE DATABASE veiculosdb;

Verifique se o banco de dados foi criado com sucesso:

      \l

Isso irá listar todos os bancos de dados. Verifique se o veiculosdb está na lista.

1.3 Verificar a Conexão
Certifique-se de que você pode se conectar ao banco de dados com o usuário criado:

      psql -U veiculo_user -d veiculosdb

Se tudo estiver correto, você verá o prompt de comandos do PostgreSQL.

## Como Rodar o Projeto

### 1. Rodando com Docker

1. Clone o repositório:
   
       git clone https://github.com/SEU-USUARIO/veiculoPneu.git

       cd .\veiculoPneu\.\veiculoPneu\
   
2. Construa e inicie os containers Docker:
         
        ./mvnw clean package
        docker-compose up --build

Isso irá:

- Criar e configurar o contêiner para o banco de dados PostgreSQL.

- Criar e configurar o contêiner para a aplicação Spring Boot.

A API estará disponível no seguinte endpoint:
  
    http://localhost:8080

O banco de dados será iniciado com as tabelas e dados de exemplo através do Flyway.

### 2. Rodando sem Docker
   
Se você preferir rodar a aplicação sem o Docker, siga os seguintes passos:

Instale o PostgreSQL em sua máquina local e crie o banco de dados veiculosdb.

Modifique as configurações de conexão com o banco de dados no arquivo src/main/resources/application.properties para corresponder ao seu ambiente local:


    spring.datasource.url=jdbc:postgresql://localhost:5432/veiculosdb
    spring.datasource.username=seu_usuario
    spring.datasource.password=sua_senha
    
Use o Maven para construir e rodar a aplicação:

    mvn clean spring-boot:run

A API estará disponível em 
        
    http://localhost:8080.

## Swagger - Documentação da API

Esta aplicação integra o Swagger para oferecer uma interface interativa de documentação da API. Você pode acessar a documentação da API diretamente pelo seguinte link:

  URL:   
      
      http://localhost:8080/swagger-ui.html

No Swagger UI, você pode explorar todos os endpoints da API, ver os detalhes das requisições e respostas, e até mesmo fazer testes de chamadas diretamente pela interface.


## Testes

A aplicação inclui testes unitários para validar a lógica de negócios. Você pode rodá-los utilizando o Maven:

    mvn test

