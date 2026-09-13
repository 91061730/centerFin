# CenterFin - Sistema de Gestão Financeira Pessoal 💼🏦

O **CenterFin** é uma aplicação web corporativa voltada para o controle financeiro pessoal, gerenciamento de investimentos, receitas, despesas e metas de orçamento. Desenvolvida sob a arquitetura moderna do **Java 21 (Jakarta EE)**, a aplicação adota o padrão de projeto **MVC (Model-View-Controller)** com abstração de dados via **DAO Pattern** e autenticação segura com criptografia.

---

## 🏗️ Arquitetura e Estrutura do Projeto

O projeto segue uma divisão rigorosa de responsabilidades por camadas:

```
br.com.fiap.centerfin/
├── controller/         # Servlets para controle de requisições HTTP (Login, Despesas, Receitas, etc.)
├── model/              # Entidades de domínio (Usuário, Receita, Despesa, Investimento, Objetivos)
├── dao/                # Interfaces de acesso ao banco de dados e gerenciador de conexões
│   └── impl/           # Implementações concretas de DAO para Oracle Database
├── factory/            # Factory Pattern (DaoFactory) para desacoplamento de instâncias
├── bo/                 # Business Objects (Regras de negócio e envio de e-mails)
├── filter/             # Filtros de segurança e controle de sessão (LoginFilter)
├── util/               # Utilitários de segurança (Criptografia de senhas)
├── exception/          # Exceções customizadas da aplicação (DBException, EmailException)
└── teste/              # Classes de teste unitário e de integração dos DAOs
```

---

## 📦 Tech Stack

* **Linguagem**: Java 21 (LTS).
* **Camada Web**: Jakarta Servlets & JSP (JSTL).
* **Persistência**: Oracle Database via JDBC nativo (`ojdbc11`).
* **Segurança**: Criptografia em camada utilitária (`CriptografiaUtils`) + Interceptação de sessão com `LoginFilter`.
* **Serviços**: Integração com serviços de e-mail via Jakarta Mail / Angus Mail.
* **Design Patterns**: MVC, DAO, Factory Method, Singleton (ConnectionManager).
* **Gerenciador de Build**: Apache Maven (`.war`).

---

## ⚙️ Pré-requisitos

* **JDK 21** ou superior configurado no ambiente.
* **Apache Maven 3.8+**.
* **Apache Tomcat 10+** (ou outro Web Container compatível com Jakarta EE 10 / Servlet 6.0).
* Instância ativa de banco de dados **Oracle Database**.

---

## 🚀 Como Executar o Projeto

### 1. Clonar o Repositório

```bash
git clone https://github.com/91061730/centerFin.git
cd centerFin
```

### 2. Configurar a Conexão com o Banco de Dados

Edite as credenciais do banco de dados na classe de gerenciamento de conexão:
`src/main/java/br/com/fiap/centerfin/dao/ConnectionManager.java`

```java
// Ajuste os parâmetros de URL, Usuário e Senha da sua instância Oracle
String url = "jdbc:oracle:thin:@localhost:1521:xe";
```

### 3. Compilar e Gerar o Pacote `.war`

Execute o comando Maven para baixar as dependências e gerar o artefato:

```bash
mvn clean package
```

O arquivo compilado `centerFin.war` será gerado dentro da pasta `target/`.

### 4. Implantação (Deploy)

1. Mova o arquivo `target/centerFin.war` para a pasta `webapps/` do seu Apache Tomcat 10+.
2. Inicie o Tomcat.
3. Acesse a aplicação no seu navegador: `http://localhost:8080/centerFin`.

---

## 🛡️ Principais Funcionalidades

* **Gestão de Acesso**: Cadastro e login de usuários com autenticação criptografada e proteção por filtro de sessão.
* **Controle Financeiro**: Lançamento e monitoramento de **Receitas**, **Despesas** e **Transações**.
* **Investimentos & Metas**: Registro de investimentos e acompanhamento de **Objetivos Financeiros**.
* **Notificações**: Envio assíncrono de e-mails transacionais (`EmailBo`).

---

Desenvolvido por **Alexandre Coelho dos Santos Brito**  
🔗 GitHub: [91061730](https://github.com/91061730)