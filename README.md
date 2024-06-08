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

# Endpoints Disponíveis

<h3> GET </h3>
* /api/marcas: Lista todas as marcas.
* /api/marcas/{id}: Retorna detalhes de uma marca específica pelo ID.
* /api/modelos: Lista todos os modelos.
* /api/modelos/{id}: Retorna detalhes de um modelo específico pelo ID.
