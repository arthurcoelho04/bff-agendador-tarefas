# BFF — Agendador de Tarefas

Backend For Frontend (BFF) desenvolvido em **Java e Spring Boot**, responsável pela integração entre os microsserviços de usuários, tarefas e notificações do Sistema de Agendamento de Tarefas.

## Funcionalidades

- **Gerenciamento de Usuários:** Centralização das operações de cadastro, consulta e autenticação.
- **Gerenciamento de Tarefas:** Cadastro, consulta, atualização e exclusão de tarefas.
- **Integração entre Microsserviços:** Comunicação entre APIs utilizando OpenFeign.
- **Agendamento Automático:** Verificação periódica das tarefas utilizando Cron.
- **Envio de Notificações:** Integração com o serviço responsável pelo envio de e-mails.
- **Autenticação JWT:** Encaminhamento de tokens para operações protegidas.
- **Tratamento de Exceções:** Gerenciamento centralizado de erros.

## Tecnologias Utilizadas

- **Java 21:** Linguagem de programação.
- **Spring Boot:** Desenvolvimento da API REST.
- **Spring Cloud OpenFeign:** Comunicação entre microsserviços.
- **Spring Scheduling (Cron):** Execução automática de tarefas.
- **Springdoc OpenAPI / Swagger:** Documentação dos endpoints.
- **Docker:** Conteinerização dos serviços.
- **Gradle:** Gerenciamento de dependências.

## Como Executar

1. Clone ou baixe o repositório.
2. Configure os endereços dos microsserviços.
3. Inicie os serviços de usuários, tarefas e notificações.
4. Execute o BFF com `./gradlew bootRun`.
5. A aplicação estará disponível em `http://localhost:8083`.

## Documentação da API

Após iniciar a aplicação, acesse:

`http://localhost:8083/swagger-ui/index.html`

## Projeto Principal

Este BFF integra o **Sistema de Agendamento de Tarefas**, desenvolvido com arquitetura de microsserviços em Java e Spring Boot.
