<h1 align="center"> Desafio Place TI </h1>

# Descrição
Este projeto implementa um CRUD (Create, Read, Update, Delete) para as entidades Marca e Modelo, como parte do desafio da PlaceTI. A aplicação oferece funcionalidades para criação, leitura, atualização e exclusão de registros nas tabelas Marca e Modelo.

# Tecnologias Utilizadas
* Java
* Spring Framework
* Banco de Dados PostgreSQL
* Docker

# Autenticação da API

A API utiliza autenticação Basic Auth para acessar os endpoints. As credenciais de autenticação são: <br>
Usuário: placeti <br>
Senha: placeti <br>

# Instruções de uso

* Certifique-se de ter o Docker instalado.
* Clone o repositório do projeto.
* Navegue até o diretório do projeto e execute ```docker-compose up -d``` para iniciar o banco de dados PostgreSQL.
* Execute a aplicação Spring Boot.
* Utilize os endpoints da API conforme documentado acima, autenticando-se com as credenciais fornecidas.

# Endpoints Disponíveis

### GET
* Lista todas as marcas: **/api/marcas**
* Retorna detalhes de uma marca específica pelo ID: **/api/marcas/{id}**
* Lista todos os modelos: **/api/modelos**
* Retorna detalhes de um modelo específico pelo ID: **/api/modelos/{id}**

### POST
* Cria uma nova marca: **/api/marcas** 
* Cria um novo modelo: **/api/modelos**

### PUT (Update)
* Atualiza uma marca existente pelo ID: **/api/marcas/{id}**
* Atualiza um modelo existente pelo ID: **/api/modelos/{id}**

### DELETE
* Deleta uma marca pelo ID: **/api/marcas/{id}**
* Deleta um modelo pelo ID: **/api/modelos/{id}**
  
## Exemplo do corpo da requisição POST

* Marca:
  ```
  {
        "nome": "Renault",
        "codigoDenatran": "123456",
        "ativo": true
  }
  ```
* Modelo:
  ```
  {
    "nome": "X1",
    "ano": "2022",
    "ativo": true,
    "marca": {
            "id": 102,
            "nome": "BMW",
            "codigoDenatran": "123",
            "ativo": true
            }}
