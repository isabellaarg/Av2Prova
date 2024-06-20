# Prova AV2

## Visão Geral
Este é um projeto Spring Boot para uma API REST JWT (JSON Web Token). A aplicação permite o registro de usuários, login e fornece endpoints protegidos para usuários autenticados e administradores. Utiliza o MongoDB como banco de dados e JWT para autenticação e autorização.
## Tecnologias Utilizadas
- Java 17
- Spring Boot
- Spring Security
- Spring Data MongoDB
- JWT (JSON Web Token)
- Maven

## Pré-requisitos
- JDK 17 ou superior
- Maven
- MongoDB

## Configuração

### Configuração do MongoDB

1. Certifique-se de que o MongoDB está instalado e em execução.
2. Configure o arquivo `application.properties`

## Endpoints
A aplicação estará disponível em http://localhost:8080

### Registro de Usuário
URL: /register
Método: POST

Corpo da Requisição:
{
  "username": "exemploUser",
  "password": "exemploPassword",
  "role": "user",
  "email" : "teste@gmail.com"
}
![image](https://github.com/isabellaarg/Aaw/blob/main/JWT_RestAPI/JWT_RestAPI/assets%20aaw/Captura%20de%20tela%202024-06-16%20192218.png)

### Login de Usuário
Login
URL: /login
Método: POST

Corpo da Requisição:
{
  "username": "exemploUser",
  "password": "exemploPassword"
}

![image](https://github.com/isabellaarg/Aaw/blob/main/JWT_RestAPI/JWT_RestAPI/assets%20aaw/Captura%20de%20tela%202024-06-16%20192343.png)

### Extrair Nome de Usuário do Token
URL: /username/{token}
Método: GET

Resposta:
{
  "username": "exemploUser"
}

![image](https://github.com/isabellaarg/Aaw/blob/main/JWT_RestAPI/JWT_RestAPI/assets%20aaw/Captura%20de%20tela%202024-06-16%20192410.png)

### Endpoint de Admin
URL: /admin
Método: GET
Cabeçalho: Authorization: Bearer {jwtToken}

Resposta:
{
  "username": "adminUser"
}

![image](https://github.com/isabellaarg/Aaw/blob/main/JWT_RestAPI/JWT_RestAPI/assets%20aaw/Captura%20de%20tela%202024-06-17%20211610.png)


## Diagrama
![image](https://github.com/isabellaarg/Aaw/blob/main/JWT_RestAPI/JWT_RestAPI/assets%20aaw/Diagrama%20de%20arquitetura%20JWT%20rest%20api.png)
