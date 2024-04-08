# Gerenciamento de Tarefas

Este é um projeto de exemplo para demonstrar um sistema de gerenciamento de tarefas utilizando Java e Spring Boot.

## Configuração do Projeto

### Requisitos

- Java 17
- Maven
- PostgreSQL

### Dependências do Projeto

O projeto utiliza as seguintes dependências:

- **Spring Boot Starter Data JPA:** Facilita a configuração do acesso a dados com o Spring Data JPA.
- **Spring Boot Starter Web:** Fornece recursos para desenvolvimento de aplicativos da web com Spring MVC.
- **Dozer Core:** Biblioteca para mapeamento de objetos Java.
- **Spring Boot DevTools:** Fornece ferramentas de desenvolvimento para facilitar o ciclo de desenvolvimento.
- **Project Lombok:** Biblioteca que simplifica a codificação em Java, eliminando a necessidade de escrever código repetitivo.
- **Spring Boot Starter Tomcat:** Starter para integrar o Tomcat como contêiner incorporado em aplicativos Spring Boot.
- **Spring Boot Starter Test:** Fornece dependências para testes automatizados em aplicativos Spring Boot.

### Configuração do Banco de Dados

O projeto está configurado para usar o PostgreSQL como banco de dados. Certifique-se de ter um servidor PostgreSQL em execução e configure as credenciais no arquivo `application.properties`.

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/seu-banco-de-dados
spring.datasource.username=seu-usuario
spring.datasource.password=sua-senha


```
# Executando Projeto
O aplicativo estará disponível em http://localhost:8080.
```
mvn clean install
java -jar target/task-management-0.0.1-SNAPSHOT.war


GET /tasks: Retorna todas as tarefas cadastradas.
GET /tasks/{id}: Retorna uma tarefa específica pelo ID.
POST /tasks: Cria uma nova tarefa.
PUT /tasks/{id}: Atualiza uma tarefa existente pelo ID.
DELETE /tasks/{id}: Exclui uma tarefa pelo ID



