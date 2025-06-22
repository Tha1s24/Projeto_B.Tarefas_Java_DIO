# Projeto_B.Tarefas_Java_DIO

# 🗂️ Board de Tarefas

Projeto Java para gerenciamento de tarefas com persistência em banco de dados MySQL e interface no terminal.

---

## 🚀 Tecnologias

- Java 17+
- JDBC (MySQL)
- MySQL 8
- Maven

---

## 📁 Estrutura do Projeto

---

board-tarefas-java/
├── src/
│ ├── main/
│ │ ├── java/br/com/board/
│ │ │ ├── controller/ → Lógica de entrada e menus
│ │ │ ├── model/ → Classe de domínio: Tarefa
│ │ │ ├── repository/ → Interface e implementação JDBC
│ │ │ ├── service/ → Regras de negócio
│ │ │ ├── util/ → Conexão com banco
│ │ │ └── Main.java → Ponto de entrada
│ │ └── resources/
│ │ └── application.properties (opcional)
├── schema.sql → Script de criação do banco
├── pom.xml → Configuração Maven
└── README.md → Este arquivo

---

## 🧑‍💻 Funcionalidades

- ✅ Criar nova tarefa
- 📋 Listar todas as tarefas
- ✏️ Atualizar título, descrição e status
- ❌ Deletar tarefa

---

## 🛠️ Requisitos

- JDK 17 ou superior
- MySQL Server
- Maven 3.8+

---

## 🗄️ Configuração do Banco

---

```sql
-- Terminal MySQL
source schema.sql;

---

## ⚙️ Configuração do Projeto

---


- Opção 1: Hardcoded em Conexao.java

---
``` java
private static final String URL = "jdbc:mysql://localhost:3306/board_tarefas";
private static final String USUARIO = "root";
private static final String SENHA = "senha";

---

- Opção 2: Usando application.properties (recomendado)

---

src/main/resources/application.properties:

---
``` java
db.url=jdbc:mysql://localhost:3306/board_tarefas
db.username=root
db.password=senha

---

Altere Conexao.java para carregar propriedades dinamicamente (já implementado no projeto, se desejar).

---

📌 Notas

---

- Os dados são persistidos diretamente no banco MySQL.

- O menu é exibido no terminal com operações CRUD.
