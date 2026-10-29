# ForumHub

API REST de fórum em Java 17 e Spring Boot, construída como desafio do Oracle Next Education (ONE). Gerencia tópicos com DTOs, validação, Spring Data JPA e migrations em MySQL.

> **Estado da autenticação:** o login e a emissão do JWT estão implementados; a validação do token nas requisições ainda não. `SecurityFilter` e `SecurityConfigurations` estão vazios e o login não confere senha. Não use este projeto como referência de autenticação — o [estudo de caso](CASE_STUDY.md) registra a decisão e o que falta.

## Endpoints

| Método | Rota | O que faz |
| --- | --- | --- |
| `POST` | `/login` | Devolve um JWT para o login informado, sem validar credenciais |
| `POST` | `/topicos` | Cadastra um tópico e recusa título + mensagem repetidos |
| `GET` | `/topicos` | Lista os tópicos cadastrados |
| `GET` | `/topicos/{id}` | Detalha um tópico |
| `PUT` | `/topicos/{id}` | Atualiza título, mensagem e curso |
| `DELETE` | `/topicos/{id}` | Remove um tópico |

## Stack

- Java 17
- Spring Boot 3.5 (Web, Data JPA, Validation, Security)
- Hibernate
- MySQL 8
- Flyway
- Maven
- `java-jwt` para emissão do token

## Como rodar

Pré-requisitos: JDK 17, MySQL em execução e as variáveis de ambiente abaixo.

```powershell
$env:DB_URL="jdbc:mysql://localhost:3306/challengehub"
$env:DB_USERNAME="root"
$env:DB_PASSWORD="sua-senha"
$env:JWT_SECRET="uma-chave-longa-e-aleatoria"

cd forumhub
./mvnw spring-boot:run
```

No Windows, use `mvnw.cmd spring-boot:run`. O banco precisa existir; o Flyway cria a tabela `topicos` a partir de `V1__create-table-topicos.sql`.

### Exemplo

```bash
curl -X POST http://localhost:8080/topicos \
  -H "Content-Type: application/json" \
  -d '{"titulo":"Dúvida com JPA","mensagem":"Como mapear um relacionamento?","autor":"Gilvam","curso":"Java"}'
```

## Testes

```bash
./mvnw test
```

Hoje a suíte tem apenas o teste de carregamento de contexto (`ForumhubApplicationTests`). Os endpoints ainda não têm teste de integração, e por isso o CI verde não valida o comportamento da API.

## Estrutura

```text
forumhub/src/main/java/com/example/forumhub/
├── controller/    AuthController, TopicoController
├── dto/           dados de cadastro, listagem e atualização
├── model/         Topico, Usuario
├── repository/    TopicoRepository, UsuarioRepository
└── security/      TokenService, SecurityFilter, SecurityConfigurations
```

## Limitações conhecidas

- Autenticação incompleta: o JWT é emitido, mas não é lido nem validado nas requisições, e a senha não é conferida.
- `GET /topicos` devolve todos os registros, sem paginação.
- Erros de regra de negócio viram `RuntimeException` e respondem 500, sem mensagem estruturada.
- `spring.jpa.show-sql=true` deixa o SQL no log; em produção isso deveria ficar desligado.

## Licença

MIT. Veja [LICENSE](LICENSE).

---

Autor: Gilvam Oliveira — [LinkedIn](https://www.linkedin.com/in/gilvam-oliveira/)
