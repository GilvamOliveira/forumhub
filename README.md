ForumHub API
---

API REST desenvolvida em Java com Spring Boot para gerenciamento de tópicos de um fórum.
Este projeto foi desenvolvido como parte do programa Oracle Next Education (ONE), uma iniciativa educacional da Oracle em parceria com a Alura, que tem como objetivo formar novos desenvolvedores nas áreas de programação, tecnologia e inovação.

**Estudo de caso:** [contexto, decisões técnicas e próximos passos](CASE_STUDY.md).

----------

 *Tecnologias Utilizadas*

Java 17

Spring Boot

Spring Security (configuração em evolução)

JWT (emissão de token)

Spring Data JPA

Hibernate

MySQL

Maven

---

*Banco de Dados*

A aplicação utiliza MySQL para persistência dos dados.

O acesso ao banco é realizado utilizando:

Spring Data JPA

Hibernate ORM

As entidades são mapeadas para tabelas usando anotações do JPA.

---

*Configuração*

As credenciais não ficam no código. Defina as variáveis de ambiente antes de executar:

DB_URL (opcional, padrão: jdbc:mysql://localhost:3306/challengehub)

DB_USERNAME (opcional, padrão: root)

DB_PASSWORD (obrigatória)

JWT_SECRET (obrigatória)

Exemplo no PowerShell:

$env:DB_PASSWORD="sua-senha"

$env:JWT_SECRET="uma-chave-longa-e-aleatoria"

mvn spring-boot:run

---

Autor: Gilvam Oliveira · [LinkedIn](https://www.linkedin.com/in/gilvam-oliveira/) · [GitHub](https://github.com/GilvamOliveira)
