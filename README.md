# Projeto: Sistema de Cadastro de Usuários, Posts e Comentários

## Descrição

Este projeto foi desenvolvido durante um workshop utilizando Spring Boot e MongoDB. O sistema permite o cadastro de usuários, criação de posts e comentários em posts. A arquitetura é baseada em APIs REST para gerenciar essas funcionalidades de forma eficiente.

## Funcionalidades

- Cadastro de usuários
- Criação de posts pelos usuários
- Possibilidade de listar posts de um usuário específico
- Sistema de comentários nos posts
- CRUD completo para usuários e posts

## Tecnologias Utilizadas

- **Java**
- **Spring Boot**
- **Spring Data MongoDB**
- **MongoDB**
- **REST API**
- **Maven**

## Estrutura dos Controladores

### UserController

- **GET** `/users`: Retorna todos os usuários cadastrados.
- **GET** `/users/{id}`: Retorna um usuário específico pelo seu ID.
- **POST** `/users`: Cadastra um novo usuário.
- **PUT** `/users/{id}`: Atualiza um usuário existente.
- **DELETE** `/users/{id}`: Exclui um usuário.
- **GET** `/users/{id}/posts`: Retorna todos os posts de um usuário específico.

### PostController

- **GET** `/posts/{id}`: Retorna um post específico pelo ID.

## Entidades

### User (Usuário)

| Atributo | Tipo      | Descrição                                          |
|----------|-----------|----------------------------------------------------|
| id       | String    | Identificador único do usuário                     |
| name     | String    | Nome do usuário                                    |
| email    | String    | Email do usuário                                   |
| posts    | List<Post> | Lista de posts do usuário (carregamento lazy)      |

### Post (Postagem)

| Atributo  | Tipo           | Descrição                                       |
|-----------|----------------|-------------------------------------------------|
| id        | String          | Identificador único do post                    |
| date      | Date            | Data de criação do post                        |
| title     | String          | Título do post                                 |
| body      | String          | Conteúdo do post                               |
| author    | AuthorDTO       | Dados do autor do post                         |
| comments  | List<CommentDTO> | Lista de comentários associados ao post        |

### AuthorDTO (Autor)

| Atributo | Tipo   | Descrição                   |
|----------|--------|-----------------------------|
| id       | String | Identificador único do autor |
| name     | String | Nome do autor                |

### CommentDTO (Comentário)

| Atributo  | Tipo   | Descrição                    |
|-----------|--------|------------------------------|
| text      | String | Conteúdo do comentário        |
| date      | Date   | Data do comentário            |
| author    | AuthorDTO | Autor do comentário         |

## Como Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/HirokiAsano1/workshop-spring-boot-mongodb
   



